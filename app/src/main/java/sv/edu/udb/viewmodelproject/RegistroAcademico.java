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

public class RegistroAcademico extends AppCompatActivity {
    private TextView tvnombre,tvapellido,tvcarrera,tvaño,tvcum;
    private Spinner spcarnet;
    private Button btcum;

    ArrayList<String> spCarnetReg;
    ArrayList<CUM>obCum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_academico);

        spcarnet=(Spinner) findViewById(R.id.spRCarnet);
        tvnombre=(TextView) findViewById(R.id.tvNombreE);
        tvapellido=(TextView) findViewById(R.id.tvApellidoE);
        tvcarrera=(TextView) findViewById(R.id.tvCarreraE);
        tvaño=(TextView) findViewById(R.id.tvAñoE);
        tvcum=(TextView) findViewById(R.id.tvCumE);
        btcum=(Button) findViewById(R.id.btCalcularCUM);

        consultarEstudiante();
        ArrayAdapter<CharSequence> adaptador2=new ArrayAdapter(this, android.R.layout.simple_spinner_item,spCarnetReg);
        spcarnet.setAdapter(adaptador2);
        spcarnet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if(i!=0){
                    tvnombre.setText(obCum.get(i-1).getNombreE());
                    tvapellido.setText(obCum.get(i-1).getApellidoE());
                    tvcarrera.setText(obCum.get(i-1).getCarreraE());
                    tvaño.setText(obCum.get(i-1).getAño());
                }else{
                    tvnombre.setText("");
                    tvapellido.setText("");
                    tvcarrera.setText("");
                    tvaño.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //obtener datos del estudiante seleccionado en el spinner
    private void consultarEstudiante() {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase db=admin.getReadableDatabase();
        CUM cum=null;
        obCum=new ArrayList<CUM>();
        Cursor cursor=db.rawQuery("Select * From Estudiantes",null);
        while (cursor.moveToNext()){
            cum=new CUM();
            cum.setCarnetE(cursor.getString(0));
            cum.setNombreE(cursor.getString(1));
            cum.setApellidoE(cursor.getString(2));
            cum.setCarreraE(cursor.getString(3));
            cum.setAño(cursor.getString(4));
            obCum.add(cum);
        }
        obtenerEstudiante();
    }

    //Cargando el spinner
    private void obtenerEstudiante() {
        spCarnetReg=new ArrayList<String>();
        spCarnetReg.add("Seleccione");
        for(int i=0;i<obCum.size();i++){
            spCarnetReg.add(String.valueOf(obCum.get(i).getCarnetE()));
        }
    }

    //Obtener UV cursadas
    public String obtenerUVCursadas(){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String UVcursadas;

        String sQuery= "Select sum(uv) From Notas where Carnet= CS171609";

        Cursor cursor = bd.rawQuery(sQuery, null);

        if (cursor.moveToFirst()){
            UVcursadas = String.valueOf(cursor.getInt(0));
        }
        else{
            UVcursadas = "0";
        }
        cursor.close();
        bd.close();
        return UVcursadas;
    }

    //Obtener UV ganadas
    public String obtenerUVGanadas(){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String UVganadas;

        String sQuery= "Select sum(uvAlcanzada) From Notas where Carnet= CS171609";

        Cursor cursor = bd.rawQuery(sQuery, null);

        if (cursor.moveToFirst()){
            UVganadas = String.valueOf(cursor.getInt(0));
        }
        else{
            UVganadas = "0";
        }
        cursor.close();
        bd.close();
        return UVganadas;
    }
}