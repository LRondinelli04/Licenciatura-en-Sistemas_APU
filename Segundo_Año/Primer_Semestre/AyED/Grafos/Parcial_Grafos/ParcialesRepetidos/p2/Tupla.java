package Grafos.Parcial_Grafos.ParcialesRepetidos.p2;

public class Tupla {
    private int cantidad;
    private boolean popular;

    public Tupla(int cantidad, boolean popular) {
        this.cantidad = cantidad;
        this.popular = popular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }
}
