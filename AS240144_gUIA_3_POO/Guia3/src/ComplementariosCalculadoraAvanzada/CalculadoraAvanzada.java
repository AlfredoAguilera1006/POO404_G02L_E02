package ComplementariosCalculadoraAvanzada;

public class CalculadoraAvanzada {
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double opuesto(double numero) {
        return -numero;
    }

    public long factorial(int numero) {
        if (numero < 0) {
            throw new ArithmeticException("No se puede calcular el factorial de un número negativo");
        }
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
