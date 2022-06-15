package Beans;

public class Cancion {

    private int idCancion;
    private String nombreCancion;
    private String banda;

    public Cancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Cancion(String nombreCancion, String banda) {
        this.nombreCancion = nombreCancion;
        this.banda = banda;
    }


    public Cancion(int idCancion, String nombreCancion, String banda) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.banda = banda;
    }

    public Cancion(int idcancion, String nombrecancion) {
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
