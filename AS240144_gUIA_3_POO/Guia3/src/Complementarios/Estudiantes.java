package Complementarios;

public class Estudiantes {
    private String nombre;
    private String apellido;
    private int edad;
    private String[] materias;

    public void Estudiante(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.materias = new String[5];
    }

    public void ingresarMaterias() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese la materia " + (i + 1) + ":");
            this.materias[i] = System.console().readLine();
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Edad: " + this.edad);
        System.out.println("Materias:");
        for (String materia : this.materias) {
            System.out.println(materia);
        }
    }
}
