import java.util.LinkedList;
import java.util.Queue;

public class PuntoEmbarqueEquipajes {

    Queue <Equipaje> estera1;
    Queue <Equipaje> estera2;
    Queue <Equipaje> estera3;

    public PuntoEmbarqueEquipajes() {
        estera1 = new LinkedList<>();
        estera2 = new LinkedList<>();
        estera3 = new LinkedList<>();
    }

    public void addEstera1(Equipaje e) {
        estera1.add(e);
    }

    public void addEstera2(Equipaje e) {
        estera2.add(e);
    }


    public void addEstera3(Equipaje e) {
        estera3.add(e);
    }


    public int LlenarCarro(double capacidad) {

        int ans = 0;
        double pesoCarro = 0;

        while (!estera1.isEmpty() || !estera2.isEmpty() || !estera3.isEmpty()) {

            double e1 = 1000, e2 = 1000, e3 = 1000;
            
            e1 = estera1.peek() != null ? estera1.peek().getPeso() : e1;
            e2 = estera2.peek() != null ? estera2.peek().getPeso() : e2;
            e3 = estera3.peek() != null ? estera3.peek().getPeso() : e3;

            if (e1 <= e2 && e1 <= e3){
                pesoCarro += e1;
                estera1.remove();
            }

            else if (e2 <= e1 && e2 <= e3) {
                pesoCarro += e2;
                estera2.remove();
            }
            else {
                pesoCarro += e3;
                estera3.remove();
            }

            if (pesoCarro > capacidad) return ans;

            ans++;
        }
        return ans;
    }

}
