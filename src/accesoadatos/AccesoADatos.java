 package accesoadatos;
 
import accesoadatos.modelo.Alumno;
import accesoadatos.modelo.AlumnoData;
import accesoadatos.modelo.Conexion;
import java.time.LocalDate;
import java.time.Month;
 
 
public class AccesoADatos {
 
    //aca arranca la aplicación
    public static void main(String[] args) {
       Conexion con = new Conexion();
     AlumnoData ad= new AlumnoData(con); 
        
     Alumno alumno1 = new Alumno("Maria Romero", LocalDate.of(2018,11,2),false);
     ad.guardarAlumno(alumno1);
     
     ad.guardarAlumno( alumno1);
     for(Alumno it : ad.obtenerAlumnos()){
         System.out.println("ID"+ it.getId());
         System.out.println("Nombre"+ it.getNombre());
     }
    }
}
       
 
   
    
    
    
