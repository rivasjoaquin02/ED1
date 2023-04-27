public class ArbolExpresion {
    protected ComponenteExp root;
    protected ArbolExpresion izq;
    protected ArbolExpresion der;

    public ArbolExpresion(ComponenteExp root) {
        this.root = root;
        this.izq = null;
        this.der = null;
    }

    public ArbolExpresion(ComponenteExp root, ArbolExpresion izq, ArbolExpresion der) {
        this.root = root;
        this.izq = izq;
        this.der = der;
    }

    public double evaluar() {
        return evaluar(this);
    }

    private double evaluar(ArbolExpresion node) {
        if (node.root instanceof Operando operando)
            return operando.getValor();
        if (node.root instanceof Operador operador)
            return operador.getTipo(
                    evaluar(node.izq),
                    evaluar(node.der)
            );

        return 0.0;
    }

    public boolean esHoja() {
        return izq == null && der == null;
    }
}
