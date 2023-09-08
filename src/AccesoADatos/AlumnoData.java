
package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AlumnoData {    
    
    private Connection con = null;
    
    //Construcctor de conexion
    public AlumnoData(){        
        con=Conexion.getConexion();    
    }
    
    //metodos
    public void guardarAlumno(Alumno alumno){
        //consulta para insertar datos
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUE(?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
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
    
    public void modificarAlumno(Alumno alumno){
    //consulta actualizar datos     
    // TABLA(alumno) MODIFICAR      SET: LOS DATOS A MODIFICAR                     WHERE: Condicion
    String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? WHERE idAlumno = ?";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            
            int exito = ps.executeUpdate();
            if(exito==1){
                 JOptionPane.showMessageDialog(null, "Alumno modificado Exitosamente.");
            }
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Alumno.");
        }
    
    }
    
    public void eliminarAlumno (int id){
                                        //modificamos el estado del alumno a 0
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado Exitosamente.");
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla alumno.");
        }
        
    }
    
}
