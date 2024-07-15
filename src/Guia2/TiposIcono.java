package Guia2;
import javax.swing.JOptionPane;
public class TiposIcono {
    public static void main(String[] args) {
// TODO code application logic here
//default title and icon
        JOptionPane.showMessageDialog(null, "Informacion", "Mensaje De Informacion", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Advertencia", "Mensaje de Advertencia", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Error", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Sin Icono", "Mensaje de Texto Plano", JOptionPane.PLAIN_MESSAGE);
    }
}
