package Desafio1;
import java.util.*;
public class Gerente extends Empleado{
    private double bono;

    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono =bono;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario()+bono;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Bono: "+bono);
        System.out.println("Salario total: "+ calcularSalario());
    }
}
