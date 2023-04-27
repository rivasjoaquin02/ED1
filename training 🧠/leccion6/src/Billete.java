public class Billete {
    private String numeroSerie;
    private int denominacion;

    public Billete(int denominacion) {
        this.denominacion = denominacion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public int getDenominacion() {
        return denominacion;
    }
}
