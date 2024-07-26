

public class CalculadoraAvanzada {

    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public static double opuesto(double numero) {
        return -numero;
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        double base = 2;
        double exponente = 3;
        int numero = 4;

        System.out.println("Potencia: " + potencia(base, exponente));
        System.out.println("Opuesto: " + opuesto(numero));
        System.out.println("Factorial de " + numero + ": " + factorial(numero));
    }
}
