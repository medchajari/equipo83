
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
				
			
			}
			
			
		} catch (Exception e) {
		}
		
	}
    
    
}
