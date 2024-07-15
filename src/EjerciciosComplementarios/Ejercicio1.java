package EjerciciosComplementarios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ejercicio1 {
    private JFrame ventana;
    private JTextField campoNota;
    private JLabel etiquetaResultado;

    public Ejercicio1() {
        ventana = new JFrame("Nota del Alumno");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        JLabel etiquetaNota = new JLabel("Ingrese la nota del alumno:");
        campoNota = new JTextField(10);

        JButton botonCalcular = new JButton("Calcular");
        botonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularNota();
            }
        });

        etiquetaResultado = new JLabel("");

        ventana.add(etiquetaNota);
        ventana.add(campoNota);
        ventana.add(botonCalcular);
        ventana.add(etiquetaResultado);

        ventana.pack();
        ventana.setVisible(true);
    }

    private void calcularNota() {
        try {
            double nota = Double.parseDouble(campoNota.getText());
            if (nota >= 7.0) {
                etiquetaResultado.setText("El alumno aprobó la materia.");
            } else if (nota >= 6.5 && nota < 7.0) {
                etiquetaResultado.setText("El alumno tiene la posibilidad de realizar un examen de suficiencia para aprobar.");
            } else {
                etiquetaResultado.setText("El alumno no aprobó la materia.");
            }
        } catch (NumberFormatException e) {
            etiquetaResultado.setText("Error: ingrese una nota válida.");
        }
    }

    public static void main(String[] args) {
        new Ejercicio1();
    }
}
