import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Login {
    private JPanel Login;
    private JTextField txtUsuario;
    private JTextField txtContraseña;
    private JButton btnIngresar;

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/poodesafio";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "null"; // Cambia esto a la contraseña correcta o usa "null"


    public Login() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Usuario = txtUsuario.getText();
                String Contraseña = txtContraseña.getText();


                if (verificarCredenciales(Usuario, Contraseña)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                    // Aquí puedes redirigir al usuario a otra ventana o realizar otras acciones
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas. Verifica los campos.");
                }
            }
        });
    }



    private boolean verificarCredenciales(String Usuario, String Contraseña) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM cliente WHERE Usuario = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Usuario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("Contraseña");
                return storedPassword == null || storedPassword.equals(Contraseña);
            }
            return false; // Usuario no encontrado
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new Login().Login);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}


