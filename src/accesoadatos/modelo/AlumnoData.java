 package accesoadatos.modelo;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 

public class AlumnoData {
   private Connection con;
   
   public AlumnoData(Conexion conexion){
      con= conexion.getConexion();
   }
   public void guardarAlumno(Alumno alumno){
       try {
           String sql = "INSERT INTO alumno(nombre,fecNac,activo)VALUES( ?, ?, ?);";
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,alumno.getNombre());
           ps.setDate(2, Date.valueOf(alumno.getFecNac()));
           ps.setBoolean(3,alumno.isActivo());
           //ejecutamos las sentencias
           int filas = ps.executeUpdate();
                   
           
           //me devuelve las claves/llaves generadas 
           ResultSet rs = ps.getGeneratedKeys();
           
           if(rs.next())
            alumno.setId(rs.getInt("id"));
           else{
               System.out.println("no se pudo obtener el id de alumno");
           }
           ps.close();
               
                 
           } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void eliminarAlumno(int id){
       String sql = "DELETE alumno WHERE id = ? ;";
       PreparedStatement ps;
       try {
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1,id);
           ps.executeUpdate();
           ps.close();
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
   public void modificarAlumno(Alumno alumno){
       try {
           String sql = "UPDATE alumno SET nombre = ?, fecNac = ?, "
                   + "activo = ? WHERE id = ?;";
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,alumno.getNombre());
           ps.setDate(2, Date.valueOf(alumno.getFecNac()));
           ps.setBoolean(3,alumno.isActivo());
           ps.setInt(4,alumno.getId());
           
           ps.executeUpdate();
            ps.close();
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
   
   public Alumno buscarAlumno(int id){
      Alumno alumno = null;
       try {
           
           
           String sql ="SELECT * FROM alumno WHERE id = ?;";
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1,id);
           
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
               alumno = new Alumno();
               alumno.setId(rs.getInt("id"));
               alumno.setNombre(rs.getString("nombre"));
               alumno.setFecNac(rs.getDate("fecNac").toLocalDate());
               alumno.setActivo(rs.getBoolean("activo"));
            ps.close();
           }
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return alumno;
       
   }
   public List<Alumno> obtenerAlumnos() {
        
            List<Alumno> alumnos = new ArrayList<Alumno> ();
            
        try{    
            String sql ="SELECT * FROM alumno;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Alumno alumno;
            while (rs.next()){
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecNac(rs.getDate("fecNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;    
}
}

 
