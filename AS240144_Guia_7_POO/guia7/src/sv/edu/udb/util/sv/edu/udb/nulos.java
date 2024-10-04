package sv.edu.udb.util.sv.edu.udb;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.util.Conexion;
public class nulos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        Conexion con = new Conexion();
        String sql1 = "insert into empleados values(7,'','Torres',null)";
//
        con.setQuery(sql1);

        String sql = "select nombres from empleados ";
        ResultSet rs ;

        con.setRs(sql);
        rs= con.getRs();

        String nombre;

        while (rs.next()){
            nombre=rs.getString(1);

            if (nombre == null){
                System.out.println("Nombre 'Null': " + nombre);
            }else if(nombre.equals("")){
                System.out.println("Nombre Vacio: " + nombre);
            }else{
                System.out.println("Nombre Con Datos: " + nombre);
            }


        }
        con.cerrarConexion();
    }
}
