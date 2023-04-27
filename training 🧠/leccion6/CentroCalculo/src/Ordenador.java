public class Ordenador {
    protected String id;
    protected String sistOperativo;
    protected int cantProcesadores;
    protected int procesadoresEnUso;

    public Ordenador(String id, String sistOperativo, int cantProcesadores, int procesadoresEnUso) {
        this.id = id;
        this.sistOperativo = sistOperativo;
        this.cantProcesadores = cantProcesadores;
        this.procesadoresEnUso = procesadoresEnUso;
    }

    public String getSistOperativo() {
        return sistOperativo;
    }

    public int getCantProcesadores() {
        return cantProcesadores;
    }

    public int getProcesadoresEnUso() {
        return procesadoresEnUso;
    }

    public void setProcesadoresEnUso(int procesadoresEnUso) {
        this.procesadoresEnUso = procesadoresEnUso;
    }
}
