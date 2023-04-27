public class Tarea {
    protected Ordenador ordenador;
    protected Programa programa;

    public Tarea(Ordenador ordenador, Programa programa) {
        this.ordenador = ordenador;
        this.programa = programa;
    }

    public Ordenador getOrdenador() {
        return ordenador;
    }

    public Programa getPrograma() {
        return programa;
    }
}
