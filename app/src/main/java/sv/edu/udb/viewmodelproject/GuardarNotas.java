package sv.edu.udb.viewmodelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class GuardarNotas extends AppCompatActivity {

    private Spinner spCarnetN,spMateriaN;
    private TextView edCodigoM,edUVm,edUvGanadas;
    private EditText edNotasN;
    private Button btGuardarN,btCalcularUVs;
    ArrayList<String> carneEstudiante;
    ArrayList<Estudiante>estudianteList;
    ArrayList<String> spmateria;
    ArrayList<Materias>obmateria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_notas);
        spCarnetN=(Spinner) findViewById(R.id.spCarnet);
        spMateriaN=(Spinner) findViewById(R.id.spMateria);
       edCodigoM=(TextView) findViewById(R.id.CodMateria);
       edUVm=(TextView) findViewById(R.id.uvN);
       edNotasN=(EditText) findViewById(R.id.ednotaN);
       btGuardarN=(Button) findViewById(R.id.btGuardarNota);
       edUvGanadas=(TextView) findViewById(R.id.tvUVObtenidas);
       btCalcularUVs=(Button)findViewById(R.id.btCalcularUV);

       consultarCarnet();
       ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,carneEstudiante);
       spCarnetN.setAdapter(adaptador);

       consultarMateria();
        ArrayAdapter<CharSequence> adaptador2=new ArrayAdapter(this, android.R.layout.simple_spinner_item,spmateria);
        spMateriaN.setAdapter(adaptador2);
        spMateriaN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if(i!=0){
                edCodigoM.setText(obmateria.get(i-1).getCodMateria().toString());
                edUVm.setText(obmateria.get(i-1).getUv());
                }else{
                    edCodigoM.setText("");
                    edUVm.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void consultarMateria() {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase db=admin.getReadableDatabase();
        Materias mat=null;
        obmateria=new ArrayList<Materias>();
        Cursor cursor=db.rawQuery("Select * From Materias",null);
        while (cursor.moveToNext()){
            mat=new Materias();
            mat.setCodMateria(cursor.getString(0));
            mat.setNombreMateria(cursor.getString(1));
            mat.setUv(cursor.getString(2));
            obmateria.add(mat);
        }
        obtenermateria();
    }

    private void obtenermateria() {
        spmateria=new ArrayList<String>();
        spmateria.add("Seleccione");
        for(int i=0;i<obmateria.size();i++){
            spmateria.add(String.valueOf(obmateria.get(i).getNombreMateria()));
        }
    }

    private void consultarCarnet() {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase db=admin.getReadableDatabase();
        Estudiante estu=null;
        estudianteList=new ArrayList<Estudiante>();
        Cursor cursor=db.rawQuery("Select * From Estudiantes",null);
        while (cursor.moveToNext()){
            estu=new Estudiante();
            estu.setCarnet(cursor.getString(0));
            estudianteList.add(estu);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        carneEstudiante=new ArrayList<String>();
        carneEstudiante.add("Seleccione");
        for(int i=0;i<estudianteList.size();i++){
            carneEstudiante.add(String.valueOf(estudianteList.get(i).getCarnet()));
        }
    }

    public void CalcularUV(View view) {
        double nota= Double.parseDouble(edNotasN.getText().toString().trim());
        double uv=Double.parseDouble(edUVm.getText().toString().trim());
        double nxv=nota*uv;
        edUvGanadas.setText(String.valueOf(nxv));
    }
}