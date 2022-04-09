package sv.edu.udb.viewmodelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class CumCalculateScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cum_calculate_screen);
    }
    public void guardarEstudiante(View view){
        Intent in=new Intent(CumCalculateScreen.this,GuardarEstudiantes.class);
        startActivity(in);
    }
    public void guardarNotas(View view){
        Intent in=new Intent(CumCalculateScreen.this,GuardarNotas.class);
        startActivity(in);
    }
    public void registroAcademico(View view){
        Intent in=new Intent(CumCalculateScreen.this,RegistroAcademico.class);
        startActivity(in);
    }

}