import java.util.List;

public class ArbolGenealogico {
    protected Persona root;
    protected dynamic_array <ArbolGenealogico> children;

    public ArbolGenealogico() {
        children = new dynamic_array<>();
    }

    public int cantPersonasConOjosDistintos(){
        return cantPersonasConOjosDistintos(this);
    }

    private int cantPersonasConOjosDistintos(ArbolGenealogico node){
        if (node.children == null)
            return 0;

        int ans=0;
        for (ArbolGenealogico child: children){
            if (!child.root.color_ojos.equals(node.root.color_ojos))
                ans++;
            ans += cantPersonasConOjosDistintos(child);
        }
        return ans;
    }



}
