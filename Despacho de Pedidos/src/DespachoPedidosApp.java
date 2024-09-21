import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DespachoPedidosApp {
    private List<Pedido> listaPedidos;

    public DespachoPedidosApp() {
        listaPedidos = new ArrayList<>();

        // Crear algunos pedidos de ejemplo (puedes cargarlos desde una base de datos o archivo)
        listaPedidos.add(new Pedido(1, "Aceptado", ""));
        listaPedidos.add(new Pedido(2, "En proceso", ""));
        listaPedidos.add(new Pedido(3, "Entregado al repartidor", ""));
        listaPedidos.add(new Pedido(4, "Entregado al cliente", ""));
    }

    public void mostrarInterfaz() {
        JFrame frame = new JFrame("Despacho de Pedidos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un JPanel para el formulario
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear una tabla para mostrar los pedidos
        String[] columnNames = {"Número de Pedido", "Estado", "Comentarios"};
        Object[][] data = new Object[listaPedidos.size()][3];
        for (int i = 0; i < listaPedidos.size(); i++) {
            Pedido pedido = listaPedidos.get(i);
            data[i][0] = pedido.getNumeroPedido();
            data[i][1] = pedido.getEstado();
            data[i][2] = pedido.getComentarios();
        }
        JTable table = new JTable(data, columnNames);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón para cambiar el estado del pedido seleccionado
        JButton cambiarEstadoButton = new JButton("Cambiar Estado");
        cambiarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String nuevoEstado = JOptionPane.showInputDialog(frame, "Nuevo estado:");
                    if (nuevoEstado != null) {
                        listaPedidos.get(selectedRow).setEstado(nuevoEstado);
                        // Actualizar la tabla
                        table.setValueAt(nuevoEstado, selectedRow, 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecciona un pedido primero.");
                }
            }
        });
        panel.add(cambiarEstadoButton, BorderLayout.SOUTH);

        // Área de texto para agregar comentarios
        JTextArea comentariosTextArea = new JTextArea(5, 20);
        panel.add(comentariosTextArea, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DespachoPedidosApp app = new DespachoPedidosApp();
            app.mostrarInterfaz();
        });
    }

    // Clase para representar un pedido
    private static class Pedido {
        private int numeroPedido;
        private String estado;
        private String comentarios;

        public Pedido(int numeroPedido, String estado, String comentarios) {
            this.numeroPedido = numeroPedido;
            this.estado = estado;
            this.comentarios = comentarios;
        }

        public int getNumeroPedido() {
            return numeroPedido;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getComentarios() {
            return comentarios;
        }
    }
}
