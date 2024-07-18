package ejemplo9modificado;
import java.util.Scanner;
public class ejemplo9modificado {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int numEmpleados;

            // Leer el número de empleados
            do {
                System.out.print("Ingresa el número de empleados: ");
                numEmpleados = scanner.nextInt();
                if (numEmpleados < 0) {
                    System.out.println("Error: No se permiten valores negativos.");
                }
            } while (numEmpleados < 0);

            int[] sueldos = new int[numEmpleados];
            int sumaSueldos = 0;

            // Leer los sueldos de los empleados
            for (int i = 0; i < numEmpleados; i++) {
                System.out.print("Ingresa el sueldo del empleado " + (i + 1) + ": ");
                sueldos[i] = scanner.nextInt();
                if (sueldos[i] < 0) {
                    System.out.println("Error: No se permiten valores negativos.");
                    i--; // Repetir la lectura para el mismo empleado
                } else {
                    sumaSueldos += sueldos[i];
                }
            }

            System.out.println("La suma de los sueldos es: " + sumaSueldos);
        }
    }


