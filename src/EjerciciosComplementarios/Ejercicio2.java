package EjerciciosComplementarios;
import java.util.Random;
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese el monto de la compra: ");
        double montoCompra = scanner.nextDouble();

        System.out.println("¡Sacude la bolita!");
        String colorBolita = sacarBolita(random);

        double descuento = 0;
        String mensaje = "";

        switch (colorBolita) {
            case "roja":
                descuento = montoCompra * 0.10;
                mensaje = "¡Felicidades! Has ganado un 10% de descuento.";
                break;
            case "verde":
                descuento = montoCompra * 0.05;
                mensaje = "¡Bien hecho! Has ganado un 5% de descuento.";
                break;
            case "blanca":
                mensaje = "Gracias por participar. No hay descuento esta vez.";
                break;
        }

        double montoFinal = montoCompra - descuento;

        System.out.println(mensaje);
        System.out.printf("Monto final: $%.2f%n", montoFinal);
    }

    private static String sacarBolita(Random random) {
        int numero = random.nextInt(3);
        switch (numero) {
            case 0:
                return "roja";
            case 1:
                return "verde";
            case 2:
                return "blanca";
            default:
                return "";
        }
    }
}
