package Ejercicio_1;

import java.util.Scanner;

public class notadeunalumno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la nota del alumno: ");
        double nota = scanner.nextDouble();

        if (nota >= 7.0) {
            System.out.println("El alumno ha aprobado la materia.");
        } else if (nota >= 6.50 && nota <= 6.99){
            System.out.println("El alumno tiene la posibilidad de realizar un examen de suficiencia para aprobar.");
        } else {
            System.out.println("El alumno no ha aprobado la materia.");
        }
    }
}

