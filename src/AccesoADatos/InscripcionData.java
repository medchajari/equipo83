
package AccesoADatos;

import Entidades.Inscripcion;
import Entidades.Materia;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class InscripcionData {
	
	private Connection con = null;
    
    //Construcctor de conexion
	public InscripcionData(){        
        con=Conexion.getConexion();    
    }
    
    
	public List <Materia> obtenerMateriasCursadas(int id){
		List<Materia> materias = new ArrayList<Materia>();
		
		try {
			String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;";
			
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Materia materia;
			while(rs.next()){
			
				materia = new Materia();
				materia.setIdMateria(rs.getInt("idMateria"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAnio(rs.getInt("año"));
				materias.add(materia);
			}
			ps.close();			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"error al obtener Incripciones" + e.getMessage());	
		}
		return materias;
		
	}
	
	
	 public void inscribir(Inscripcion inscripcion){
        //consulta para insertar datos
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUE(?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getIdAlumno());	    
            ps.setInt(2, inscripcion.getIdMateria());
            ps.setDouble(3, inscripcion.getNota());
	    ps.setInt(4, inscripcion.getIdInscripcion());
            
            //ejecutamos, enviamos los datos
            ps.executeUpdate();
            
            //obtener la clave
            ResultSet rs = ps.getGeneratedKeys();
            
            //si se pudo agregar setamos el id
            if(rs.next()){
                
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Incsripcion aceptada.");
            
            }
            ps.close();
            
            
            //si nos equivocamos en algun datos nos muestra este error
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Inscripcion.");
        }
    
    }
	 
	  public void eliminarInscripcion(int idInscripcion) {
    // Consulta para eliminar una inscripción por su ID
    String sql = "DELETE FROM inscripcion WHERE idInscripcion = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idInscripcion);
        
        // Ejecutar la consulta para eliminar la inscripción
        int exito = ps.executeUpdate();
        
        if (exito > 0) {
            JOptionPane.showMessageDialog(null, "Inscripción eliminada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una inscripción con el ID.");
        }
        
        ps.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Inscripcion.");
    }
}
    
    
}
