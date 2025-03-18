public class Patient {

    private String hospital;
    private String name;
    private int edad;
    private int id;

    public Patient (String hospital, String name, int edad, int id) {
        this.hospital = hospital;
        this.name = name;
        this.edad = edad;
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
