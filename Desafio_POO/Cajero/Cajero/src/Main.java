import java.io.*;
import java.util.*;
import javax.swing.*;

public class Main {
    private static Map<Integer, Double> cuentas = new HashMap<>();
    public static void main(String[] args) {

        if (!verificarArchivo("cuentas.txt")) {
            mostrarMensaje("El archivo cuentas.txt no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cargarCuentas();
        mostrarContenidoArchivo("cuentas.txt");

        mostrarMensaje("Inserta tu Tarjeta", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);

        String cuentaStr = solicitarEntrada("Número de cuenta?", "Entrada");
        if (cuentaStr == null) {
            return;
        }

        int cuenta = convertirACuenta(cuentaStr);
        if (cuenta == -1 || !cuentas.containsKey(cuenta)) {
            mostrarMensaje("Cuenta no encontrada o número de cuenta inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        while (true) {
            String opcionSeleccionada = mostrarOpciones();
            if (opcionSeleccionada == null) {
                continue;
            }

            switch (opcionSeleccionada) {
                case "1. Consulta tu saldo":
                    consultarSaldo(cuenta);
                    break;
                case "2. Retiros":
                    realizarRetiro(cuenta);
                    break;
                case "3. Consignaciones":
                    realizarConsignacion(cuenta);
                    break;
                case "4. Transferencias":
                    realizarTransferencia(cuenta);
                    break;
                case "5. Salir":
                    guardarCuentas();
                    mostrarContenidoArchivo("cuentas.txt");
                    mostrarMensaje("Gracias por usar el cajero automático.");
                    return;
                default:
                    mostrarMensaje("Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean verificarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    private static void mostrarContenidoArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            StringBuilder contenido = new StringBuilder("Contenido del archivo " + nombreArchivo + ":\n");
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            mostrarMensaje(contenido.toString());
        } catch (IOException e) {
            mostrarMensaje("Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void cargarCuentas() {
        try (BufferedReader br = new BufferedReader(new FileReader("cuentas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#")) continue;
                String[] partes = linea.split(",");
                int cuenta = Integer.parseInt(partes[0]);
                double saldo = Double.parseDouble(partes[1]);
                cuentas.put(cuenta, saldo);
            }
        } catch (IOException e) {
            mostrarMensaje("Error al cargar las cuentas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void guardarCuentas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuentas.txt"))) {
            bw.write("#Cuenta,Saldo en Dolares\n");
            for (Map.Entry<Integer, Double> entry : cuentas.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            mostrarMensaje("Error al guardar las cuentas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultarSaldo(int cuenta) {
        mostrarMensaje("Saldo actual: $" + cuentas.get(cuenta));
    }

    private static void realizarRetiro(int cuenta) {
        String montoStr = solicitarEntrada("Ingrese el monto a retirar:", "Retiros");
        if (montoStr == null) {
            return;
        }

        double monto = convertirAMonto(montoStr);
        if (monto == -1) {
            mostrarMensaje("Monto inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cuentas.get(cuenta) >= monto) {
            cuentas.put(cuenta, cuentas.get(cuenta) - monto);
            mostrarMensaje("Retiro exitoso. Saldo actual: $" + cuentas.get(cuenta));
        } else {
            mostrarMensaje("Saldo insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void realizarConsignacion(int cuenta) {
        String montoStr = solicitarEntrada("Ingrese el monto a consignar:", "Consignaciones");
        if (montoStr == null) {
            return;
        }

        double monto = convertirAMonto(montoStr);
        if (monto == -1) {
            mostrarMensaje("Monto inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cuentas.put(cuenta, cuentas.get(cuenta) + monto);
        mostrarMensaje("Consignación exitosa. Saldo actual: $" + cuentas.get(cuenta));
    }

    private static void realizarTransferencia(int cuenta) {
        String cuentaDestinoStr = solicitarEntrada("Ingrese el número de cuenta destino:", "Transferencias");
        if (cuentaDestinoStr == null) {
            return;
        }

        int cuentaDestino = convertirACuenta(cuentaDestinoStr);
        if (cuentaDestino == -1 || !cuentas.containsKey(cuentaDestino)) {
            mostrarMensaje("Cuenta destino no encontrada o número de cuenta destino inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String montoStr = solicitarEntrada("Ingrese el monto a transferir:", "Transferencias");
        if (montoStr == null) {
            return;
        }

        double monto = convertirAMonto(montoStr);
        if (monto == -1) {
            mostrarMensaje("Monto inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cuentas.get(cuenta) >= monto) {
            cuentas.put(cuenta, cuentas.get(cuenta) - monto);
            cuentas.put(cuentaDestino, cuentas.get(cuentaDestino) + monto);
            mostrarMensaje("Transferencia exitosa. Saldo actual: $" + cuentas.get(cuenta));
        } else {
            mostrarMensaje("Saldo insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

    private static String solicitarEntrada(String mensaje, String titulo) {
        return JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    private static String mostrarOpciones() {
        String[] opciones = {
                "1. Consulta tu saldo",
                "2. Retiros",
                "3. Consignaciones",
                "4. Transferencias",
                "5. Salir"
        };
        return (String) JOptionPane.showInputDialog(null, "Opciones:", "Entrada", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
    }

    private static int convertirACuenta(String cuentaStr) {
        try {
            return Integer.parseInt(cuentaStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double convertirAMonto(String montoStr) {
        try {
            return Double.parseDouble(montoStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
       }