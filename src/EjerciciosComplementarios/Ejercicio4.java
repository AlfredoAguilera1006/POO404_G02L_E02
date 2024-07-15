package EjerciciosComplementarios;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {
    private Map<String, Alumno> alumnos;
    private Scanner scanner;

    public Ejercicio4() { // Constructor
        this.alumnos = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Ingreso de estudiante");
            System.out.println("2. Ver estudiante");
            System.out.println("3. Buscar Estudiante");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarEstudiante();
                    break;
                case 2:
                    verEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    System.out.println("Adiós!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void ingresarEstudiante() {
        System.out.print("Ingrese el carnet del estudiante: ");
        String carnet = scanner.next();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.next();

        Alumno alumno = new Alumno(carnet, nombre, apellido);
        alumnos.put(carnet, alumno);
        System.out.println("Estudiante ingresado con éxito!");
    }

    private void verEstudiantes() {
        System.out.println("Lista de estudiantes:");
        for (Alumno alumno : alumnos.values()) {
            System.out.println(alumno.toString());
        }
    }

    private void buscarEstudiante() {
        System.out.print("Ingrese el carnet del estudiante a buscar: ");
        String carnet = scanner.next();
        Alumno alumno = alumnos.get(carnet);
        if (alumno!= null) {
            System.out.println("Estudiante encontrado:");
            System.out.println(alumno.toString());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public static void main(String[] args) {
        Ejercicio4 gestor = new Ejercicio4(); // Instanciar la clase Ejercicio4
        gestor.run();
    }
}

class Alumno {
    private String carnet;
    private String nombre;
    private String apellido;

    public Alumno(String carnet, String nombre, String apellido) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Carnet: " + carnet + ", Nombre: " + nombre + ", Apellido: " + apellido;
    }
}