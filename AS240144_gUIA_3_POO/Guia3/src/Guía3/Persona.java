package Guía3;

import javax.swing.*;

public class Persona {
    private String nombre;
    private String apellido;
    private String edad;

    public Persona (){
        nombre = "Alfredo";
        apellido = "Aguilera";
        edad = "18";
    }

    public Persona(String nombre, String apellido, String edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }

    public void IngresoDatos(){
        nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
        apellido=JOptionPane.showInputDialog("Ingrese el apellido: ");
        edad=JOptionPane.showInputDialog("Ingrese la edad: ");
    }
    public void mostrarDatos(){
        System.out.println("Su nombre es: "+nombre);
        System.out.println("Su apellido es: "+apellido);
        System.out.println("Su edad es: "+edad);
        System.out.println("************************************");
    }

    public static void main(String args[]){
        Persona obj1=new Persona();
        Persona obj2=new Persona("Manuel", "Valdez", "25");
        obj1.mostrarDatos();
        obj1.IngresoDatos();
        obj1.IngresoDatos();
        obj2.mostrarDatos();
        obj1.apellido="Sanchez";
        obj1.mostrarDatos();
    }
}
