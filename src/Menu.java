import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Menu {
    private LinkedList list = new LinkedList();
    private int id = 0;
    private Scanner input = new Scanner(System.in);
    private String[] hospitals = {"Hospital1", "Hospital2", "Hospital3"};

    private String chooseHospital() {
        int option = 1;
        System.out.println("Elige un hospital");
        System.out.println("[1] Hospital 1");
        System.out.println("[2] Hospital 2");
        System.out.println("[3] Hospital 3");

        try {
            option = input.nextInt();
        } catch (Exception e) {
            System.out.println("Eligiendo por defecto el hospital 1");
        }

        if (option > 3 && option < 1) {
            return hospitals[0];
        }
        return hospitals[option -1];
    }

    private void addPatient(){
        String name;
        String hospital;
        int edad;

        System.out.println(ColoresConsola.CYAN + "Menú de pacientes" + ColoresConsola.RESET);
        System.out.println("Coloca el nombre del paciente");
        name = input.next();
        System.out.println("Coloca la edad del paciente");
        edad = input.nextInt();
        hospital = chooseHospital();

        Patient patient = new Patient(hospital, name,edad, id);
        id ++;

        list.addPatientToStart(patient);
        System.out.println("Paciente creado con id " + patient.getId());
    }

    private void deletePatient() {
        int idPatient = 0;
        System.out.println("Coloca el id del paciente a eliminar");
        idPatient = input.nextInt();
        list.deletePatient(idPatient);
        System.out.println("Paciente eliminado");
    }

    private void searchPatient() {
        int idPatient = 0;
        System.out.println("Coloca el id del paciente a consultar");
        idPatient = input.nextInt();
        Patient patient = list.getPatient(idPatient);
        System.out.println("Nombre del paciente " + patient.getName());
        System.out.println("Hospital del paciente + " + patient.getHospital());
        System.out.println("ID del paciente " + patient.getId());
        System.out.println("Edad del paciente: " + patient.getEdad());
    }

    private void searchAllPatients() {
        int count = 0;
        for (int i = 0; i < list.getLenght(); i++) {
            Patient patient = list.getPatient(count);
            System.out.println("Paciente " + patient.getName());
            System.out.println("ID: " + patient.getId());
            System.out.println("Hospital: " + patient.getHospital());
            count ++;
        }
    }

    public void startMenu() {
    int option = 0;
        do {
            System.out.println(ColoresConsola.CYAN + "Sistema de pacientes iniciado" + ColoresConsola.RESET);
            System.out.println(ColoresConsola.PURPLE + "Elige la opción de tu preferencia [n] \n" + ColoresConsola.RESET);

            System.out.println(ColoresConsola.YELLOW + "[1] " + ColoresConsola.RESET + "Agregar paciente");
            System.out.println(ColoresConsola.YELLOW + "[2] " + ColoresConsola.RESET + "Eliminar paciente");
            System.out.println(ColoresConsola.YELLOW + "[3] " + ColoresConsola.RESET + "Consultar paciente");
            System.out.println(ColoresConsola.YELLOW + "[4] " + ColoresConsola.RESET + "Consultar todos los pacientes");
            System.out.println(ColoresConsola.RED + "[5] " + ColoresConsola.RESET + "Salir del programa\n");

            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println(ColoresConsola.RED + "[X] " + ColoresConsola.RESET + "Ingresa un número del menú.");;
            }

            switch (option) {
                case 1 -> addPatient();
                case 2 -> deletePatient();
                case 3 -> searchPatient();
                case 4 -> searchAllPatients();
                case 5 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Coloca un número dentro de las opciones del menú");
            }

        } while (option != 5);
    }


}
