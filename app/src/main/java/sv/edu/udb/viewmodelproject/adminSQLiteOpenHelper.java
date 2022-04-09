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
        db.execSQL("Create table Notas(IdNota integer primary key autoincrement,Carnet text,codMateria text,uv int, nota real,uvAlcanzada real,FOREIGN KEY(Carnet) References Estudiantes(Carnet))");
        cargarDatosMateria(db);
    }

    private void cargarDatosMateria(SQLiteDatabase db) {
        db.execSQL("INSERT INTO Materias values('CAD501','Calculo Diferencial',4)");
        db.execSQL("INSERT INTO Materias values('CAI501','Calculo Integral',4)");
        db.execSQL("INSERT INTO Materias values('CVV501','Calculo de Varias Variables',4)");
        db.execSQL("INSERT INTO Materias values('ESA501','Estadistica Aplicada',4)");
        db.execSQL("INSERT INTO Materias values('CDP501','Cinematica y Dinamica de Particulas',4)");
        db.execSQL("INSERT INTO Materias values('EYM501','Electricidad y Magnetismo',4)");
        db.execSQL("INSERT INTO Materias values('OFC501','OSCILACIONES FLUIDOS Y CALOR',4)");
        db.execSQL("INSERT INTO Materias values('QUG501','QUIMICA GENERAL',4)");
        db.execSQL("INSERT INTO Materias values('AVM','ALGEBRA VECTORIAL Y MATRICES',3)");
        db.execSQL("INSERT INTO Materias values('PRE104','PROGRAMACION ESTRUCTURADA',4)");
        db.execSQL("INSERT INTO Materias values('AEE106','ANALISIS Y EVALUACION ECONOMICA',4)");
        db.execSQL("INSERT INTO Materias values('DDP106','DIRECCION DE PROYECTOS',4)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
