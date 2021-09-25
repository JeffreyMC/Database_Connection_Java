
package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Jeffrey
 */
public class Conexion {
    
    public Conexion(){
        Connection con = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/login";
            String user = "root";
            String pass = "";
            
            //establecer conexión con la base de datos
            con = DriverManager.getConnection(url, user, pass);
            
            if(con != null){
                System.out.println("Se estableció la conexión a la base de datos\n");
            }
            
            //consulta a la base de datos
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario");
            
            while(rs.next()){
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("Nombre");
                String password = rs.getString("Password");
                
                System.out.println("ID: " + id + "\nNombre: " + nombre + "\nContraseña: " + password);
                System.out.println("\n*******************************************");
            }
        }catch(Exception e){
            System.out.println("Ocurrió el error: " + e);
        }
    }
}
