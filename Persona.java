public class Persona {
    protected String nombre;
    protected String color_ojos;

    public Persona(String nombre, String color_ojos) {
        this.nombre = nombre;
        this.color_ojos = color_ojos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor_ojos() {
        return color_ojos;
    }
}
