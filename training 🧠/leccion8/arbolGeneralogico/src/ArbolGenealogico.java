import java.util.ArrayList;
import java.util.List;

public class ArbolGenealogico {
    protected Persona root;
    protected List<ArbolGenealogico> subArbol;

    public ArbolGenealogico(Persona root) {
        this.root = root;
        this.subArbol = new ArrayList<>();
    }

    public ArbolGenealogico(Persona root, List<ArbolGenealogico> subArbol) {
        this.root = root;
        this.subArbol = subArbol;
    }


    public int CantidadPersonasConOjosDistintos() {
        return CantidadPersonasConOjosDistintos(this);
    }

    private int CantidadPersonasConOjosDistintos(ArbolGenealogico node) {
        int cant = 0;
        if (node.subArbol != null) {
            for (ArbolGenealogico child : node.subArbol) {
                cant += CantidadPersonasConOjosDistintos(child);
                if (!child.root.color_ojos.equals(node.root.color_ojos))
                    cant++;
            }
        }
        return cant;
    }

    public List<Persona> listaPersonasConOjosDeUnColor(String color) {
        return listaPersonasConOjosDeUnColor(this, color);
    }

    private List<Persona> listaPersonasConOjosDeUnColor(ArbolGenealogico node, String color) {
        List<Persona> ans = new ArrayList<>();
        if (node.root.color_ojos.equals(color))
            ans.add(node.root);

        if (node.subArbol != null) {
            for (ArbolGenealogico child : node.subArbol)
                ans.addAll(listaPersonasConOjosDeUnColor(child, color));
        }
        return ans;
    }

    public int Descendencia() {
        return Descendencia(this);
    }

    private int Descendencia(ArbolGenealogico node) {

        int ans = 1;
        if (node.subArbol != null){
            for (ArbolGenealogico child: node.subArbol)
                if (child.root.color_ojos.equals(node.root.color_ojos))
                    ans = Math.max(ans, Descendencia(child) + 1);
        }
        return ans;
    }
}
