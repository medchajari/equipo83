
package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class AlumnoData {    
    
    private Connection con = null;
    
    //Construcctor de conexion
    public AlumnoData(){        
        con=Conexion.getConexion();    
    }
    
    //metodo
    public void guardarAlumno(Alumno alumno){
    
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUE(?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
            
            //ejecutamos, enviamos los datos
            ps.executeUpdate();
            
            //obtener la clave
            ResultSet rs = ps.getGeneratedKeys();
            
            //si se pudo agregar setamos el id
            if(rs.next()){
                
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Alumno guardado exitosamente.");
            
            }
            ps.close();
            
            
            //si nos equivocamos en algun datos nos muestra este error
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Alumno.");
        }
    
    }
    
    
}
