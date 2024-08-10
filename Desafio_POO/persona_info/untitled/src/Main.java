import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String nombreCompleto = null;
        while (nombreCompleto == null || nombreCompleto.trim().isEmpty() || nombreCompleto.split(" ").length < 2) {
            nombreCompleto = JOptionPane.showInputDialog("Introduce tu nombre (nombre y apellido):");
            if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            } else if (nombreCompleto.split(" ").length < 2) {
                JOptionPane.showMessageDialog(null, "Debes introducir al menos un nombre y un apellido.");
            }
        }
        String[] nombrePartes = nombreCompleto.split(" ");
        String nombre = nombrePartes[0];
        String apellido = nombrePartes[1];

        String sexo = null;
        while (sexo == null || sexo.trim().isEmpty() ||
                (!sexo.equalsIgnoreCase("Masculino") && !sexo.equalsIgnoreCase("Femenino"))) {
            sexo = JOptionPane.showInputDialog("Introduce tu sexo (Masculino/Femenino):");
            if (sexo == null || sexo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El sexo no puede estar vacío.");
            } else if (!sexo.equalsIgnoreCase("Masculino") && !sexo.equalsIgnoreCase("Femenino")) {
                JOptionPane.showMessageDialog(null, "El sexo debe ser 'Masculino' o 'Femenino'.");
            }
        }

        String fechaNacimientoStr = null;
        Date fechaNacimiento = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        while (fechaNacimientoStr == null || fechaNacimientoStr.trim().isEmpty() || fechaNacimiento == null) {
            fechaNacimientoStr = JOptionPane.showInputDialog("Introduce tu fecha de nacimiento (dd-mm-aaaa):");
            if (fechaNacimientoStr == null || fechaNacimientoStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede estar vacía.");
            } else {
                try {
                    fechaNacimiento = formatoFecha.parse(fechaNacimientoStr);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto.");
                    fechaNacimiento = null;
                }
            }
        }

        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        if (hoy.get(Calendar.DAY_OF_YEAR) < fechaNac.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        if (edad > 30) {
            if (edad >= 40) {
                JOptionPane.showMessageDialog(null, "Buenos días Sr(a) " + apellido);
            } else {
                JOptionPane.showMessageDialog(null, "Buenos días Mr./Ms. " + apellido);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hola amigo " + nombre);
        }

        int anioNacimiento = fechaNac.get(Calendar.YEAR);
        boolean esBisiesto = (anioNacimiento % 4 == 0 && anioNacimiento % 100 != 0) || (anioNacimiento % 400 == 0);
        if (esBisiesto) {
            JOptionPane.showMessageDialog(null, "Naciste en un año bisiesto.");
        }

        String[] diasSemana = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        int diaSemana = fechaNac.get(Calendar.DAY_OF_WEEK);
        JOptionPane.showMessageDialog(null, "Naciste un " + diasSemana[diaSemana - 1]);
    }
}
