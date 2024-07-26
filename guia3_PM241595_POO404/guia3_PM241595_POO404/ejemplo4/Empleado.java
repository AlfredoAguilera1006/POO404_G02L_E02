import javax.swing.JOptionPane;

public class Empleado {

    private String nombre;
    private String apellido;
    //Metodo que permite mostrar el contenido de los atributos
    public void mostrarDatos()
    {
        JOptionPane.showConfirmDialog(null,nombre +" "+apellido);
    }
    //Metodo que permite cambiar los datos de los atributos
    public void ingresoDatos()
    {
        nombre=JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido=JOptionPane.showInputDialog("Ingrese el Apellido");
    }
}




