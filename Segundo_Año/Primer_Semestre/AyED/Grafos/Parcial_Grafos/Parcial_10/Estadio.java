package Grafos.Parcial_Grafos.Parcial_10;

public class Estadio {

    private String nombreEstadio;
    private String nombreCiudad;

    public Estadio(String ne, String nc) {
        this.nombreEstadio = ne;
        this.nombreCiudad = nc;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
