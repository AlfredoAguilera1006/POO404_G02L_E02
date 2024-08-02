package Guía3;
import javax.swing.JOptionPane;
public class Empleado {
    private String nombre;
    private String apellido;

    public void mostrarDatos(){
        JOptionPane.showConfirmDialog(null,nombre+" "+apellido);
    }

    public void ingresoDatos(){
        nombre=JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido=JOptionPane.showInputDialog("Ingrese el apellido");
    }

    static class Profesor extends Empleado{
        int sueldo;
        public void mostrar2(){
            mostrarDatos();
            JOptionPane.showMessageDialog(null, sueldo);
        }
        public void ingreso2(){
            ingresoDatos();
            String s=JOptionPane.showInputDialog("Ingrese el sueldo");
            sueldo=Integer.parseInt(s);
        }
    }
}
