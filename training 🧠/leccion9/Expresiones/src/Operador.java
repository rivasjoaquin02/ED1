public class Operador implements ComponenteExp {
    protected Character tipo;

    public Operador(Character tipo) {
        this.tipo = tipo;
    }

    public double getTipo(double op1, double op2) {
        return switch (tipo) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> op1 / op2;
            default -> 0;
        };
    }
}
