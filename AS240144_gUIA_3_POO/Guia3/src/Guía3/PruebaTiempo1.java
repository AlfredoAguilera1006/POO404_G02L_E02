package Guía3;
import javax.swing.JOptionPane;
public class PruebaTiempo1 {
    public static void main(String args[]){
        Tiempo1 tiempo = new Tiempo1();
        String salida = "La hora universal inicial es: " +
                tiempo.aStrinUniversal() + "\nLa hora estándar inicial es: " +
                tiempo.aStringEstandar();
                tiempo.establecerHora(13, 27, 6);
                salida+="\n\nLa hora universal despúes de establecerHora es: "+ tiempo.aStrinUniversal()+
                        "\nLa hora estándar después de establecerHora es: "+ tiempo.aStringEstandar();
                tiempo.establecerHora(99, 99, 99);
                salida+="\nHora universal: "+tiempo.aStrinUniversal()+
                        "\nHora estandar: "+tiempo.aStringEstandar();
                JOptionPane.showMessageDialog(null, salida, "Prueba de la clase Tiempo1", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
    }
}
