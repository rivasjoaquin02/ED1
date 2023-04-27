public class Equipaje {
    protected int idVuelo;
    protected double peso;

    public Equipaje(int idVuelo, double peso) {
        this.idVuelo = idVuelo;
        this.peso = peso;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public double getPeso() {
        return peso;
    }
}
