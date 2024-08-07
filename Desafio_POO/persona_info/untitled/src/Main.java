import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Solicitar nombre
        String nombreCompleto = JOptionPane.showInputDialog("Introduce tu nombre (nombre y apellido):");
        String[] nombrePartes = nombreCompleto.split(" ");
        String nombre = nombrePartes[0];
        String apellido = nombrePartes[1];

        // Solicitar sexo
        String sexo = JOptionPane.showInputDialog("Introduce tu sexo (Masculino/Femenino):");

        // Solicitar fecha de nacimiento
        String fechaNacimientoStr = JOptionPane.showInputDialog("Introduce tu fecha de nacimiento (dd-mm-aaaa):");

        // Validar y convertir fecha de nacimiento
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formatoFecha.parse(fechaNacimientoStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto.");
            return;
        }

        // Calcular edad
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        if (hoy.get(Calendar.DAY_OF_YEAR) < fechaNac.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        // Saludo personalizado
        if (edad > 30) {
            if (edad >= 40) {
                JOptionPane.showMessageDialog(null, "Buenos días Sr(a) " + apellido);
            } else {
                JOptionPane.showMessageDialog(null, "Buenos días Mr./Ms. " + apellido);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hola amigo " + nombre);
        }

        // Verificar si el año de nacimiento es bisiesto
        int anioNacimiento = fechaNac.get(Calendar.YEAR);
        boolean esBisiesto = (anioNacimiento % 4 == 0 && anioNacimiento % 100 != 0) || (anioNacimiento % 400 == 0);
        if (esBisiesto) {
            JOptionPane.showMessageDialog(null, "Naciste en un año bisiesto.");
        }

        // Día de la semana de nacimiento
        String[] diasSemana = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        int diaSemana = fechaNac.get(Calendar.DAY_OF_WEEK);
        JOptionPane.showMessageDialog(null, "Naciste un " + diasSemana[diaSemana - 1]);
    }
}
