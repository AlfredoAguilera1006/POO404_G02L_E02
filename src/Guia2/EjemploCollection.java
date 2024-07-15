package Guia2;
import java.util.ArrayList;
import java.util.Collection;
public class EjemploCollection {
    public static void main(String[] args) {
        Collection listaMarcasCoches = new ArrayList<String>();
        Collection
        listaMarcasCoches.add("Audi");
        listaMarcasCoches.add("Porsche");
        listaMarcasCoches.add("Aston Martin");
        listaMarcasCoches.add("Ferrari");
        listaMarcasCoches.add("Mercedes");
        listaMarcasCoches.add("Seat");
        System.out.println("Número elementos antes de eliminar: " +
                listaMarcasCoches.size() ) ;
        System.out.println ("Elementos: " +listaMarcasCoches.toString() ) ;
        listaMarcasCoches.remove ("Seat");
        listaMarcasCoches.remove ("Mercedes");
        System.out.println("Número elementos después de eliminar Seat y Mercedes:" +
                listaMarcasCoches.size() ) ;
        System.out.println("Elementos: " + listaMarcasCoches.toString () );
    }
}
