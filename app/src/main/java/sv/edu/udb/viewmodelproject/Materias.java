package sv.edu.udb.viewmodelproject;

public class Materias {
    private String CodMateria;
    private String NombreMateria;
    private String uv;

    public Materias(String codMateria, String nombreMateria,String uv ){
        this.CodMateria=codMateria;
        this.NombreMateria=nombreMateria;
        this.uv=uv;
    }
    public Materias(){

    }

    public String getCodMateria() {
        return CodMateria;
    }

    public void setCodMateria(String codMateria) {
        CodMateria = codMateria;
    }

    public String getNombreMateria() {
        return NombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        NombreMateria = nombreMateria;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }
}
