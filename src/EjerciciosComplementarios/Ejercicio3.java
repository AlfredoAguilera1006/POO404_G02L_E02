package EjerciciosComplementarios;
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();

        double[] sueldos = new double[numEmpleados];

        for (int i = 0; i < numEmpleados; i++) {
            boolean valido = false;
            double sueldo = 0;
            while (!valido) {
                System.out.print("Ingrese el sueldo del empleado " + (i + 1) + ": ");
                sueldo = scanner.nextDouble();
                if (sueldo >= 0) {
                    valido = true;
                } else {
                    System.out.println("Error: el sueldo no puede ser negativo. Intente de nuevo.");
                }
            }
            sueldos[i] = sueldo;
        }

        double sumaSueldos = 0;
        for (double sueldo : sueldos) {
            sumaSueldos += sueldo;
        }

        System.out.println("La suma de los sueldos es: " + sumaSueldos);
    }
}
