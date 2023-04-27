public class Recoridos {
    class Nodo {
        int dato;
        Nodo izq;
        Nodo der;

        //Constructor
        public Nodo(int dato) {
            this.dato = dato;
            this.izq = null;
            this.der = null;
        }
    }

    //Clase para representar un árbol binario
    class Arbol {
        Nodo raiz;

        //Constructor
        public Arbol() {
            this.raiz = null;
        }

        //Método para recorrer el árbol en preorden
        public void preorden(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.dato + " "); //Visitar la raíz
                preorden(nodo.izq); //Recorrer el subárbol izquierdo
                preorden(nodo.der); //Recorrer el subárbol derecho
            }
        }

        //Método para recorrer el árbol en entreorden
        public void entreorden(Nodo nodo) {
            if (nodo != null) {
                entreorden(nodo.izq); //Recorrer el subárbol izquierdo
                System.out.print(nodo.dato + " "); //Visitar la raíz
                entreorden(nodo.der); //Recorrer el subárbol derecho
            }
        }

        //Método para recorrer el árbol en postorden
        public void postorden(Nodo nodo) {
            if (nodo != null) {
                postorden(nodo.izq); //Recorrer el subárbol izquierdo
                postorden(nodo.der); //Recorrer el subárbol derecho
                System.out.print(nodo.dato + " "); //Visitar la raíz
            }
        }
        //Método para recorrer el árbol en anchura
        public void anchura(Nodo nodo) {
            if (nodo != null) {
                Queue<Nodo> cola = new LinkedList<>(); //Crear una cola vacía
                cola.add(nodo); //Añadir la raíz a la cola
                while (!cola.isEmpty()) { //Mientras la cola no esté vacía
                    Nodo actual = cola.poll(); //Sacar el primer nodo de la cola
                    System.out.print(actual.dato + " "); //Visitar el nodo
                    if (actual.izq != null) { //Si tiene hijo izquierdo
                        cola.add(actual.izq); //Añadirlo a la cola
                    }
                    if (actual.der != null) { //Si tiene hijo derecho
                        cola.add(actual.der); //Añadirlo a la cola
                    }
                }
            }
        }
    }
}
