package suficiencia;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class ArbolInvitados {
    protected String nombre;
    protected List<ArbolInvitados> invitados;

    public ArbolInvitados(String nombre) {
        this.nombre = nombre;
        this.invitados = new LinkedList<>();
    }

    public ArbolInvitados(String nombre, List<ArbolInvitados> invitados) {
        this.nombre = nombre;
        this.invitados = invitados;
    }

    public double puntaje(){
        return puntaje(this);
    }

    private double puntaje(ArbolInvitados node){
        double ans = 0;

        for (ArbolInvitados child: node.invitados)
            ans += (puntaje(child)*0.1) + 1;

        return ans;
    }


    public static void main(String[] args) {
        ArbolInvitados leafX = new ArbolInvitados("X");
        ArbolInvitados leafY = new ArbolInvitados("Y");
        ArbolInvitados leafZ = new ArbolInvitados("Z");
        ArbolInvitados N = new ArbolInvitados("N", Arrays.asList(leafX, leafY));
        ArbolInvitados D = new ArbolInvitados("D", List.of(leafZ));
        ArbolInvitados A = new ArbolInvitados("A");
        ArbolInvitados root = new ArbolInvitados("J", Arrays.asList(N, D, A));

        System.out.println(root.puntaje());
    }
}
