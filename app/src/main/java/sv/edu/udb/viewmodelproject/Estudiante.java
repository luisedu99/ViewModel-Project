package sv.edu.udb.viewmodelproject;

public class Estudiante {
    private String Carnet;

    public Estudiante(String Carnet){
        this.Carnet=Carnet;
    }
    public Estudiante(){

    }

    public String getCarnet() {
        return Carnet;
    }

    public void setCarnet(String carnet) {
        Carnet = carnet;
    }
}
