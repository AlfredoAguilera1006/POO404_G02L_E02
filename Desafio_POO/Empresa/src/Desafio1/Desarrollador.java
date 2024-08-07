package Desafio1;
import java.util.*;
public class Desarrollador extends Empleado {
    private String lenguaje;


    public Desarrollador(String nombre, double salarioBase,String lenguaje) {
        super(nombre, salarioBase);
        this.lenguaje = lenguaje;
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Lenguaje: "+ lenguaje);
    }
}
