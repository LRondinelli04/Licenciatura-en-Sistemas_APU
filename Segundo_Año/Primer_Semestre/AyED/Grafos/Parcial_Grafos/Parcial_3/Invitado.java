package Grafos.Parcial_Grafos.Parcial_3;

public class Invitado {

    private int numInvitados;
    private boolean popular;

    public Invitado(int numInvitados, boolean popular) {
        this.numInvitados = numInvitados;
        this.popular = popular;
    }

    public int getNumInvitados() {
        return numInvitados;
    }

    public void setNumInvitados(int numInvitados) {
        this.numInvitados = numInvitados;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }
}
