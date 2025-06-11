package Grafos.Parcial_Grafos.Parcial_2;

public class NodoBFS {
    private int indice;
    private int distancia;

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
