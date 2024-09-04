package sv.edu.udb.form;

import sv.edu.udb.Beans.PeronasBeans;
import sv.edu.udb.Datos.OcupacionesDatos;
import sv.edu.udb.Datos.PersonasDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Persona extends JFrame {
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JTextField txtId;
    private JComboBox CBoxSexo;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTel;
    private JLabel lblSexo;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTel;
    private JPanel pnlPersona;
    private JTable tblDatos;
    private JComboBox cmbOcupacion;
    private JTextField txtFechadeNacimiento;
    private JButton eliminarButton;
    DefaultTableModel modelo=null;
    PeronasBeans peronasBeans= null;
    PersonasDatos personasDatos= new PersonasDatos();
    OcupacionesDatos ocupacionesDatos= new OcupacionesDatos();


    public Persona(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(750, 600));
        this.setLocationRelativeTo(getParent());

        //Arreglo de objeto para inicializar con vacio la tabla
        Object [][] data = null;
        //Arreglo de String para crear los nombres de las columnas
        String[] columns={
                "Id", "Nombres", "Edad", "Telefono", "Sexo"
        };
        //Instancia del modelo
        modelo = personasDatos.selectPersona();
        tblDatos.setModel(modelo);
        cmbOcupacion.setModel(ocupacionesDatos.selectOcupaciones());

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDatos();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });

        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDato(e);
            }
        });
    }

    private void tblObtenerDato(MouseEvent e){
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());

        if ((fila > -1)&&(columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtEdad.setText(modelo.getValueAt(fila,2).toString());
            txtTel.setText(modelo.getValueAt(fila,3).toString());
            CBoxSexo.setSelectedItem(modelo.getValueAt(fila,4).toString());
        }
    }

    private void btnDatos(){
        String id;
        String nombre;
        String edad;
        String telefono;
        String sexo;

        id = txtId.getText();
        nombre = txtNombre.getText();
        edad = txtEdad.getText();
        telefono = txtTel.getText();
        sexo = CBoxSexo.getSelectedItem().toString();

        JOptionPane.showMessageDialog(null, "Datos obtenidos: \n ID: "+ id + "\n nombres: "+ nombre+"\n Edad: "+edad +"\n Telefono: "+telefono+"\n Sexo: "+ sexo);

        Object[] newRow={id ,
                nombre,
                edad,
                telefono,
                sexo};
        modelo.addRow(newRow);
    }

    private void btnLimpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTel.setText("");
        CBoxSexo.setSelectedIndex(0);
    }

    public static void main(String[]args){
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }

    private void btnObtenerDatos() {
        int id;
        String nombres;
        int edad;
        String telefono;
        String sexo;
        int idOcupacion;
        String fechaNacimiento;
        if (txtId.getText().isEmpty()){
            id = 0;
        }else{
            id = Integer.parseInt(txtId.getText());
        }
        nombres = txtNombre.getText();
        edad = Integer.parseInt(txtEdad.getText());
        telefono = txtTel.getText();
        sexo = CBoxSexo.getSelectedItem().toString();
        idOcupacion =
                OcupacionesDatos.getIdOcupacion(cmbOcupacion.getSelectedItem().toString());
        fechaNacimiento = txtFechadeNacimiento.getText();
        PeronasBeans = new PeronasBeans(id,nombres,edad,telefono,sexo,idOcupacion,fechaNacimiento);
        if(btnObtenerDatos.getText().equals("Guardar")) {
            PersonasDatos.insert(PeronasBeans);
        }else if (btnObtenerDatos.getText().equals("Editar")) {
            PersonasDatos.update(PeronasBeans);
        }
        modelo=PersonasDatos.selectPersona();
        tblDatos.setModel(modelo);
    }
    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTel.setText("");
        CBoxSexo.setSelectedIndex(0);
        cmbOcupacion.setSelectedIndex(0);
        txtFechadeNacimiento.setText("");
        btnObtenerDatos.setText("Guardar");
    }
    private void tblObtenerDato(MouseEvent e) {
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtEdad.setText(modelo.getValueAt(fila,2).toString());
            txtTel.setText(modelo.getValueAt(fila,3).toString());
            CBoxSexo.setSelectedItem(modelo.getValueAt(fila,4).toString());
            cmbOcupacion.setSelectedItem(modelo.getValueAt(fila,5).toString());
            txtFechadeNacimiento.setText(modelo.getValueAt(fila,6).toString());
            btnObtenerDatos.setText("Editar");
        }
    }


}