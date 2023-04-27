public class Programa {
    protected int id;
    protected String sistOperativo;
    protected int cantProcesadores;
    protected double tiempoEjec;

    public Programa(int id, String sistOperativo, int cantProcesadores, double tiempoEjec) {
        this.id = id;
        this.sistOperativo = sistOperativo;
        this.cantProcesadores = cantProcesadores;
        this.tiempoEjec = tiempoEjec;
    }

    public String getSistOperativo() {
        return sistOperativo;
    }

    public int getCantProcesadores() {
        return cantProcesadores;
    }

    public double getTiempoEjec() {
        return tiempoEjec;
    }
}
