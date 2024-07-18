package aplicacion;
import java.util.HashMap;
import java.util.Scanner;
public class aplicacion {
    private final HashMap<String, String> students = new HashMap<>();
        private final Scanner scanner = new Scanner(System.in);

        public void start() {
            int option;
            do {
                System.out.println("1. Ingreso de estudiante.");
                System.out.println("2. Ver estudiantes.");
                System.out.println("3. Buscar Estudiante.");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (option) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (option != 4);
        }

        private void addStudent() {
            System.out.print("Ingrese el Carnet del estudiante: ");
            String carnet = scanner.nextLine();
            System.out.print("Ingrese el nombre del estudiante: ");
            String name = scanner.nextLine();

            students.put(carnet, name);
            System.out.println("Estudiante agregado exitosamente!");
        }

        private void viewStudents() {
            if (students.isEmpty()) {
                System.out.println("No hay estudiantes registrados.");
            } else {
                students.forEach((carnet, name) ->
                        System.out.println("Carnet: " + carnet + ", Nombre: " + name));
            }
        }

        private void searchStudent() {
            System.out.print("Ingrese el Carnet del estudiante a buscar: ");
            String carnet = scanner.nextLine();

            if (students.containsKey(carnet)) {
                String name = students.get(carnet);
                System.out.println("Estudiante encontrado: Carnet - " + carnet + ", Nombre - " + name);
            } else {
                System.out.println("Estudiante no encontrado.");
            }
        }

        public static void main(String[] args) {
            aplicacion system = new aplicacion();
            system.start();
        }
    }


