package sv.edu.udb.viewmodelproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class adminSQLiteOpenHelper extends SQLiteOpenHelper {

    public adminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Materias(codMateria text primary key,NombreMateria text,uv int)");
        db.execSQL("create table Estudiantes(Carnet text primary key,Nombre text,Apellido text,Carrera text,Año text)");
        db.execSQL("Create table Notas(IdNota int primary key,carnet text,codMateria text,uv int, nota int,uvAlcanzada int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
