package ComplementarioCalculadoraBasica;

public class CalculadoraBasica {
    public double suma(double numero1, double numero2) {
        return numero1 + numero2;
    }

    public double resta(double numero1, double numero2) {
        return numero1 - numero2;
    }

    public double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    public double division(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return numero1 / numero2;
    }
}
