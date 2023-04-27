import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Bodega {
    protected Stack <Notebook> notebooks;
    protected Queue <Person> personQueue;
    protected List <Person> pending;

    public Bodega(Stack<Notebook> notebooks, Queue<Person> personQueue) {
        this.notebooks = notebooks;
        this.personQueue = personQueue;
        this.pending = new ArrayList<>();
    }

    public void deliverNotebooks() {

        while (!personQueue.isEmpty()) {
            Person person = personQueue.poll();
            int personID = person.CI;

            if (!findNotebook(personID))
                pending.add(person);
        }
    }

    private boolean findNotebook(int personID) {

        Stack <Notebook> notebookAux = new Stack<>();
        while (!notebooks.empty()) {
            Notebook notebook = notebooks.pop();
            int notebookID = notebook.getID();

            if (notebookID == personID) return true;
            notebookAux.add(notebook);
        }

        notebooks.addAll(notebookAux);
        return false;
    }
}
