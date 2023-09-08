
package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;


public class AlumnoData {    
    
    private Connection con = null;
    
    //Construcctor
    public AlumnoData(){        
        con=Conexion.getConexion();    
    }
    
    public void guardarAlumno(Alumno alumno){
    
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUE(?,?,?,?,?)";
    
    }
    
    
}
