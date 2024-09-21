import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private JPanel mainPanel;
    private JTable menuTable;
    private JButton addButton;
    private JButton finalizeButton;
    private JTextArea commentsTextArea;
    private JComboBox<String> paymentComboBox;
    private JLabel historyLabel;
    private JTabbedPane tabbedPane;
    private JPanel orderPanel;
    private JPanel historyPanel;
    private JPanel historyTable;

    private List<String> selectedDishes = new ArrayList<>();
    private List<String> comments = new ArrayList<>();

    public Pedido() {


        // Inicializar el menú
        String[] columnNames = {"Plato"};
        String[][] data = {
                {"Pollo asado  "},
                {"Carne asada "},
                {"Chiles rellenos  "},
                {"Carne de cerdo asada "},
                {"Pacaya rellena "}
        };

        menuTable.setModel(new DefaultTableModel(data, columnNames));

        try {
            // Establece la conexión (reemplaza con tus propios detalles de conexión)
            String url = "jdbc:mysql://localhost:3306/poodesafio";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }




        // Añadir opciones de pago
        paymentComboBox.addItem("Tarjeta de Crédito");
        paymentComboBox.addItem("PayPal");
        paymentComboBox.addItem("Efectivo");

        // Manejar el evento del botón "Agregar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = menuTable.getSelectedRow();
                if (selectedRow != -1) {
                    String dish = (String) menuTable.getValueAt(selectedRow, 0);
                    selectedDishes.add(dish);
                    comments.add(commentsTextArea.getText());
                    commentsTextArea.setText("");
                    updateHistory();
                }
            }
        });

        // Manejar el evento del botón "Finalizar"
        finalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paymentMethod = (String) paymentComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(mainPanel, "Pedido finalizado con pago: " + paymentMethod);
            }
        });
    }

    private void updateHistory() {
        StringBuilder history = new StringBuilder("<html>");
        for (int i = 0; i < selectedDishes.size(); i++) {
            history.append(selectedDishes.get(i)).append(" - Comentario: ").append(comments.get(i)).append("<br>");
        }
        history.append("</html>");
        historyLabel.setText(history.toString());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PurchaseForm");
        frame.setContentPane(new Pedido().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
