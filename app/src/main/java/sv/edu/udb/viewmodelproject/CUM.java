package sv.edu.udb.viewmodelproject;

public class CUM {
    private String CarnetE;
    private String NombreE;
    private String ApellidoE;
    private String CarreraE;
    private String Año;

    public CUM(){

    }
    public CUM(String CarnetE,String nombreE,String ApellidoE,String CarreraE,String Año){
        this.CarnetE=CarnetE;
        this.NombreE=nombreE;
        this.ApellidoE=ApellidoE;
        this.CarreraE=CarreraE;
        this.Año=Año;
    }

    public String getCarnetE() {
        return CarnetE;
    }

    public void setCarnetE(String carnetE) {
        CarnetE = carnetE;
    }

    public String getNombreE() {
        return NombreE;
    }

    public void setNombreE(String nombreE) {
        NombreE = nombreE;
    }

    public String getApellidoE() {
        return ApellidoE;
    }

    public void setApellidoE(String apellidoE) {
        ApellidoE = apellidoE;
    }

    public String getCarreraE() {
        return CarreraE;
    }

    public void setCarreraE(String carreraE) {
        CarreraE = carreraE;
    }

    public String getAño() {
        return Año;
    }

    public void setAño(String año) {
        Año = año;
    }
}
