package sv.edu.udb.viewmodelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GuardarEstudiantes extends AppCompatActivity {
    private EditText gCarnet, gNombre,gApellido;
    private Button GuardarE;
    private Spinner gpCarrera,gpAño;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_estudiantes);

        gCarnet=(EditText) findViewById(R.id.edGuardarCarnet);
        gNombre=(EditText) findViewById(R.id.edGuardarNombre);
        gApellido=(EditText) findViewById(R.id.edGuardarApellido);
        gpCarrera=(Spinner) findViewById(R.id.spCarrera);
        String[] carrera={"Ing. CC de la computacion","Ing. Industrial","Ing. Mecatronica"};
        gpCarrera.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,carrera));
        GuardarE=(Button) findViewById(R.id.btGuardarEstudiante);
        gpAño=(Spinner) findViewById(R.id.spAño);
        String[] años={"1er año","2do año","3er año","4to año","5to año"};
        gpAño.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,años));
    }
    public void GuardarEstudiante(View v){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String carnetE=gCarnet.getText().toString();
        String nombreE=gNombre.getText().toString();
        String apellidoE=gApellido.getText().toString();
        String carreraE=gpCarrera.getSelectedItem().toString();
        String añoE=gpAño.getSelectedItem().toString();

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
            Toast.makeText(this, "Alumno ingresado con exito",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se Guardo correctamente" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}