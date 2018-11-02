
package accesoadatos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private String url="jdbc:mysql://localhost/prueba";
    private String usuario="root";
    private String password=""; 
    private Connection con = null;
    
    
    public Conexion() {
        try {
           //cargamos drivers en memoria 
            Class.forName("org.mariadb.jdbc.Driver");
            //creamos la connexion
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    public Connection getConexion(){
        try {
            if(con == null){
                con= DriverManager.getConnection(url +
                 "?useLegacydattimeCode=false&serverTimezone=UTC" +
                 "&user="+usuario + "&password=" + password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
        
   
   
