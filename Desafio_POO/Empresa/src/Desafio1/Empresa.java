package Desafio1;

public class Empresa {
    public static void main(String[] args){
        Empleado empleado=new Empleado("Juan", 389.53);
        Gerente gerente=new Gerente("Pepito", 389.53, 135);
        Desarrollador desarrollador=new Desarrollador("Maria",389.53, "Java");

        System.out.println("Empleado: ");
        empleado.mostrarInfo();
        System.out.println("Salario: "+empleado.calcularSalario());

        System.out.println("\nGerente:");
        gerente.mostrarInfo();
        System.out.println("Salario: "+ gerente.calcularSalario());

        System.out.println("\nDesarrollador:");
        desarrollador.mostrarInfo();
        System.out.println("Salario: "+ desarrollador.calcularSalario());
    }
}
