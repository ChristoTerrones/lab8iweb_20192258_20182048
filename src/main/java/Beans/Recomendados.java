package Beans;

public class Recomendados {

    private int idCancion;
    private String nombreCancion;
    private String banda;

    public Recomendados(int idCancion, String nombreCancion, String banda) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.banda = banda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
}
