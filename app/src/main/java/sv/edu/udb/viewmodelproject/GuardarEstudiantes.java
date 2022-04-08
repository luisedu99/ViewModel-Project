package sv.edu.udb.viewmodelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuardarEstudiantes extends AppCompatActivity {
    private EditText gCarnet, gNombre,gApellido,gCarrera, gAño;
    private Button GuardarE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_estudiantes);

        gCarnet=(EditText) findViewById(R.id.edGuardarCarnet);
        gNombre=(EditText) findViewById(R.id.edGuardarNombre);
        gApellido=(EditText) findViewById(R.id.edGuardarApellido);
        gCarrera=(EditText) findViewById(R.id.edGuardarCarrera);
        gAño=(EditText) findViewById(R.id.edGuardaranio);
        GuardarE=(Button) findViewById(R.id.btGuardarEstudiante);
    }
    public void GuardarEstudiante(View v){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String carnetE=gCarnet.getText().toString();
        String nombreE=gNombre.getText().toString();
        String apellidoE=gApellido.getText().toString();
        String carreraE=gCarrera.getText().toString();
        String añoE=gAño.getText().toString();

        ContentValues cv=new ContentValues();
        cv.put("Carnet",carnetE);
        cv.put("Nombre",nombreE);
        cv.put("Apellido",apellidoE);
        cv.put("Carrera",carreraE);
        cv.put("Año",añoE);
        try {
            bd.insertOrThrow("Estudiantes", null, cv);
            bd.close();
            gCarnet.setText("");
            gNombre.setText("");
            gApellido.setText("");
            gCarrera.setText("");
            gAño.setText("");
            Toast.makeText(this, "Alumno ingresado con exito",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se Guardo correctamente" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}