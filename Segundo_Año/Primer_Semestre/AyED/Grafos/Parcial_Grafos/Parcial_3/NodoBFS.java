package Grafos.Parcial_Grafos.Parcial_3;

public class NodoBFS {
    private int distancia;
    private int indice;

    public NodoBFS(int indice, int distancia) {
        this.indice = indice;
        this.distancia = distancia;
    }

    public int getIndice() {
        return indice;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
