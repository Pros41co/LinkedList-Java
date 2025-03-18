public class LinkedList {
    // Clase que representa a una estructura de datos: Lista Enlazada.

    private Nodo head = null; //
    private int lenght = 0;

    private class Nodo {
        /*
        Clase que representa a cada uno de los segmentos de la lista.

        Por defecto, esta clase recibe y almacena solo objetos de la clase paciente,
        almacenado en el atributo patient.

        En la creación de cada nodo se asigna al tributo next el valor de null, al momento
        de añadir el primer elemento en la lista enlazada.

         */
        public Nodo next = null;
        public Patient patient;

        public Nodo(Patient patient){
            this.patient = patient;
        }
    }

    public void addPatientToStart(Patient patient){
        Nodo nodo = new Nodo(patient);
        nodo.next = head;
        head = nodo;
        lenght++;
    }

    public void addPatientToEnd(Patient patient){
        Nodo nodo = new Nodo(patient);
        if (head == null){
            head = nodo;
        } else {
            Nodo currentNodo = head;
            while (currentNodo.next != null){
                currentNodo = currentNodo.next;
            }
            currentNodo.next = nodo;
        }
        lenght++;
    }

    public void addPatientPosition(int position, Patient patient){
        Nodo nodo = new Nodo(patient);
        if (head == null){
            head = nodo;
            lenght++;
        } else {
            Nodo currentNodo = head;
            int index = 0;
            while (currentNodo.next != null && index < position) {
                currentNodo = currentNodo.next;
                index ++;
            }
            nodo.next = currentNodo.next;
            currentNodo.next = nodo;
            lenght++;
        }
    }

    public Patient getPatient(int id) {

        if (head.patient.getId() == id) {
            return head.patient;
        }
        
        if (head != null) {
            Nodo currentNodo = head;
            while (currentNodo.next != null) {
                if (currentNodo.patient.getId() == id) {
                    return currentNodo.patient;
                }
                currentNodo = currentNodo.next;
            }

        }
        return null;
    }

    public void deletePatient(int id) {
        if (head == null) {
            return;
        }

        if (head.patient.getId() == id) {
            head = head.next;
            lenght--;
            return;
        }

        Nodo currentNodo = head;
        while (currentNodo.next != null) {
            if (currentNodo.next.patient.getId() == id) {
                Nodo tmpNodo = currentNodo.next;
                currentNodo.next = tmpNodo.next;
                tmpNodo.next = null;
                lenght--;
                break;
            } else {
                currentNodo = currentNodo.next;
            }
        }
    }

    public int getLenght() {
        return lenght;
    }
}
