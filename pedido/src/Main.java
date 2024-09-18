
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> menu = List.of("Plato 1", "Plato 2", "Plato 3");
        List<String> selectedDishes = new ArrayList<>();
        List<String> comments = new ArrayList<>();

        System.out.println("Menú:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        System.out.println("Seleccione los platos a ordenar (ingrese el número, 0 para finalizar):");
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 0) break;
            if (choice > 0 && choice <= menu.size()) {
                selectedDishes.add(menu.get(choice - 1));
                System.out.println("Ingrese un comentario para " + menu.get(choice - 1) + ":");
                scanner.nextLine();  // Consume newline
                comments.add(scanner.nextLine());
            } else {
                System.out.println("Selección inválida, intente de nuevo.");
            }
        }

        System.out.println("Resumen del pedido:");
        for (int i = 0; i < selectedDishes.size(); i++) {
            System.out.println(selectedDishes.get(i) + " - Comentario: " + comments.get(i));
        }

        System.out.println("Ingrese la forma de pago:");
        String paymentMethod = scanner.nextLine();
        System.out.println("Forma de pago: " + paymentMethod);
    }
}
