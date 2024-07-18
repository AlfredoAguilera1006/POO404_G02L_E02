package tienda;
import java.util.Scanner;
public class tienda {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el color de la bolita (roja, verde o blanca): ");
            String colorBolita = scanner.nextLine().toLowerCase();
            System.out.print("Ingresa el valor: ");
            double valor = scanner.nextDouble();


            switch (colorBolita) {
                case "roja":
                    aplicarDescuento(valor, 0.10);
                    break;
                case "verde":
                    aplicarDescuento(valor, 0.05);
                    break;
                case "blanca":
                    System.out.println("No tiene descuento. ¡Gracias por participar!");
                    break;
                default:
                    System.out.println("Color de bolita no válido.");
            }
        }

        public static void aplicarDescuento(double valor, double porcentajeDescuento) {
            double descuento = valor * porcentajeDescuento;
            double valorConDescuento = valor - descuento;
            System.out.println("Descuento aplicado: $" + descuento);
            System.out.println("Precio con descuento: $" + valorConDescuento);
        }
    }


