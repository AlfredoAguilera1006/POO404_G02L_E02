import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private JPanel Login;
    private JTextField txtUsuario;
    private JTextField txtContraseña;
    private JButton btnIngresar;

    public Login() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contraseña = txtContraseña.getText();

                if (validarUsuario(usuario) && validarContraseña(contraseña)) {
                    JOptionPane.showMessageDialog(null, "Datos válidos.");
                    // Proceder con el inicio de sesión
                } else {
                    JOptionPane.showMessageDialog(null, "Datos inválidos. Verifique los campos.");
                }
            }
        });
    }

    private boolean validarUsuario(String usuario) {
        // Verificar si el nombre de usuario empieza con una letra mayúscula
        if (usuario.isEmpty()) {
            return false;
        }
        return Character.isUpperCase(usuario.charAt(0));
    }

    private boolean validarContraseña(String contraseña) {
        // Verificar si la contraseña contiene exactamente 6 números
        if (contraseña.length() != 6) {
            return false;
        }

        String regex = "\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contraseña);
        return matcher.matches();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
