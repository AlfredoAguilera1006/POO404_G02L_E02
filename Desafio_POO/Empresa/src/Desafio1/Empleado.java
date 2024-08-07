package Desafio1;
import java.util.*;
public class Empleado{
    private String nombre;
    private double salarioBase;
    public Empleado (String nombre, double salarioBase){
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    public double calcularSalario(){
        return salarioBase;
    }
    public void mostrarInfo(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("Salario: "+ salarioBase);
    }
}
