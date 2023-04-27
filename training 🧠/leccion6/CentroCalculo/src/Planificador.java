import java.util.*;

public class Planificador {
    protected List<Tarea> tareas;
    protected Queue <Programa> programas;
    protected List<Ordenador> ordenadores;

    public Planificador() {
        tareas = new ArrayList<>();
        programas = new LinkedList<>();
        ordenadores = new ArrayList<>();
    }

    public void addPrograma(Programa p){
        programas.add(p);
    }
    public void addOrdenador(Ordenador o){
        ordenadores.add(o);
    }

    public void CrearTarea(){
        Tarea tarea = null;
        while (!programas.isEmpty()){
            Programa p = programas.peek();

            for (Ordenador oi: ordenadores){
                String ordenadorOS = oi.getSistOperativo();
                int ordenadorProcLibres = oi.cantProcesadores - oi.getProcesadoresEnUso();

                // tienen el mismo OS y hay procesadores libres
                if (p.getSistOperativo().equals(ordenadorOS) &&
                        ( p.getCantProcesadores() <= ordenadorProcLibres)) {
                    oi.setProcesadoresEnUso(oi.procesadoresEnUso + p.getCantProcesadores());
                    tarea = new Tarea(oi, p);
                    programas.poll();
                    tareas.add(tarea);
                    return;
                }
            }
            // no se pudo crear tarea
            programas.add(programas.poll());
        }
    }

    public double TiempoEstimado(){
        double total = 0d;

        for (Tarea ti: tareas)
            total += ti.programa.getTiempoEjec();

        return total;
    }

    public void EjecutarPrimero(String sistOperativo) throws IllegalArgumentException {
        if (sistOperativo == null || sistOperativo.isEmpty())
            throw new IllegalArgumentException("El sistema operativo no puede ser nulo o vacío");

        Queue <Programa> newList = new LinkedList<>();
        Iterator <Programa> iterador = programas.iterator();
        while (iterador.hasNext()){
            Programa programa = iterador.next();
            if (!programa.getSistOperativo().equals(sistOperativo)) {
                iterador.remove();
                newList.add(programa);
            }
        }
        programas.addAll(newList);
    }

    public void EjecutarPrimeroSecuenciales(){
        Queue <Programa> newList = new LinkedList<>();
        Iterator <Programa> iterador = programas.iterator();
        while (iterador.hasNext()){
            Programa programa = iterador.next();
            if (!(programa.cantProcesadores == 1)) {
                iterador.remove();
                newList.add(programa);
            }
        }
        programas.addAll(newList);
    }

    public int ProcesadoresLibres(String idOrdenador){
        for (Ordenador oi: ordenadores)
            if (oi.id.equals(idOrdenador))
                return oi.getCantProcesadores() - oi.getProcesadoresEnUso();

        return 0;
    }
}
