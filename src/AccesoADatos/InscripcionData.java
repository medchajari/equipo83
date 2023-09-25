
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class InscripcionData {
	
	private Connection con;
	private Conexion conexion;
	private AlumnoData  ad = new AlumnoData();
	private MateriaData md = new MateriaData();
	private PreparedStatement ps;
	
    
    //Construcctor de conexion
	public InscripcionData(){  
		
		
		
        try {
			this.conexion=conexion;
			this.con = conexion.getConexion();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al obtener conexion");
		}
  
    }
    
    
	public List <Materia> obtenerMateriasInscriptas(int idAlumno){
		List<Materia> materias = new ArrayList<Materia>();
		
		try {
			String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;";
			
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idAlumno);
			ResultSet rs = ps.executeQuery();
			Materia materia;
			while(rs.next()){
			
				materia = new Materia();
				materia.setIdMateria(rs.getInt("idMateria"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAnio(rs.getInt("anio"));
				materias.add(materia);
			}
			ps.close();			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"error al obtener Incripciones" + e.getMessage());	
		}
		return materias;
		
	}	
	
	public boolean guardarInscripcion(Inscripcion inscripcion){
        boolean insc=false;
        try {
	String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUE(?,?,?)";
        
        
            PreparedStatement ps = con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());	    
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, inscripcion.getNota());
            
            //ejecutamos, enviamos los datos
            ps.executeUpdate();
            
            //obtener la clave
            ResultSet rs = ps.getGeneratedKeys();
            
            //si se pudo agregar setamos el id
            if(rs.next()){
                
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
//                JOptionPane.showMessageDialog(null,"Incsripcion aceptada.");
            insc=true;
            } else {
		    JOptionPane.showMessageDialog(null,"No se pudo obtener el id luego de insertar un alumno.");
	    }
            ps.close();
            
            
            //si nos equivocamos en algun datos nos muestra este error
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(29)El alumno se ha inscripto");
        }
	return insc;
    }
 
	public List<Inscripcion> actualizarNota(int idAlumno, int idMateria, double nota){
		 List<Inscripcion> inscripciones = new ArrayList<>();
    try {
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, nota);
        ps.setInt(2, idAlumno);
        ps.setInt(3, idMateria);

        int filas = ps.executeUpdate();
        if (filas > 0) {
            JOptionPane.showMessageDialog(null, "Nota actualizada.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una inscripción con el ID de alumno y materia proporcionados.");
        }
        ps.close();

        // Aquí deberías obtener las inscripciones actualizadas, pero parece que no estás haciendo eso en tu código actual.

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + e.getMessage());
    }
    return inscripciones;
	 }
	 
	public void eliminarInscripcion(int idAlumno, int idMateria) {
    // Consulta para eliminar una inscripción por su ID
    String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria=?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);        
	ps.setInt(1, idAlumno);
	ps.setInt(2, idMateria);
        
        // Ejecutar la consulta para eliminar la inscripción
        int exito = ps.executeUpdate();
        
        if (exito > 0) {
            JOptionPane.showMessageDialog(null, "Inscripción eliminada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "(13)No se encontró una inscripción con el ID.");
        }
        
        ps.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Inscripcion.");
    }
}
	  
	public List<Inscripcion> obtenerInscripciones(Materia ma){
	  List<Inscripcion> inscripciones= new ArrayList<Inscripcion>();  
	  
	  
	   try {
		   String sql="SELECT * FROM inscripcion";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  Inscripcion inscripcion;
			  while (rs.next()) {			   
			   inscripcion =new Inscripcion();
			   inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
			   Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
			   inscripcion.setAlumno(alu);
			   
			   Materia mat=md.buscarMateria(rs.getInt("idMateria"));			   
			   inscripcion.setMateria(mat);
			   
			   inscripcion.setNota(rs.getDouble("nota"));
			   
			   inscripciones.add(inscripcion);
			   
			   
		   }
			  ps.close();
			  
		  } catch (SQLException e) {
			  JOptionPane.showMessageDialog(null, "erroe al acceder a la tabla inscripcion"+e.getMessage());
		  }
	   return inscripciones;
	  }
	
	public List<Materia> obtenerMateriasInscriptas(Alumno a){
	List<Materia> materias = new ArrayList<Materia>();
		
	Materia ma;
	String sql = "SELECT *FROM materia WHERE estado=1 AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getIdAlumno());
			ResultSet rs = ps.executeQuery();
			Materia materia;
			while(rs.next()){
			
				materia = new Materia();
				materia.setIdMateria(rs.getInt("idMateria"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAnio(rs.getInt("anio"));
				materias.add(materia);
			}
			ps.close();			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al obtener Inscripciones" + e.getMessage());	
		}
		return materias;
	
	}
	
	public List<Materia> obtenerMateriasNoInscriptas(int id){
	List<Materia> materiasNo = new ArrayList<Materia>();
		
	Materia ma;
	String sql = "SELECT *FROM materia WHERE estado=1 AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Materia materia;
			while(rs.next()){
			
				materia = new Materia();
				materia.setIdMateria(rs.getInt("idMateria"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAnio(rs.getInt("anio"));
				materiasNo.add(materia);
			}
			ps.close();			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al obtener Incripciones" + e.getMessage());	
		}
		return materiasNo;
	
	}
	
	public List<Inscripcion> obtenerMateriasNotas(Inscripcion id){
	List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		
	Inscripcion ins;
	String sql = "SELECT *FROM inscripcion WHERE estado=1 ";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id.getIdInscripcion());
			ResultSet rs = ps.executeQuery();
			Inscripcion insc;
			while(rs.next()){
			
				insc = new Inscripcion();
				insc.setIdInscripcion(rs.getInt("idInscripcion"));				
				insc.setNota(0);
				inscripciones.add(insc);
			}
			ps.close();			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"(11) error al obtener Inscripciones" + e.getMessage());	
		}
		return inscripciones;
	
	}
	  
	public List<Inscripcion> obtenerInscripcionesXMateria(int idMateria){
		  List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		try {
			  String sql = "SELECT * FROM inscripcion WHERE idMateria=?";
			  PreparedStatement ps = con.prepareStatement(sql);		  
			  
			  ps.setInt(1, idMateria);
			  ResultSet rs=ps.executeQuery();
			  
			  Inscripcion inscripcion;
			  while (rs.next()) {					  
			  		   
			   inscripcion =new Inscripcion();
			   inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
			   
			   Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
			   inscripcion.setAlumno(alu);
			   
			   Materia mat=md.buscarMateria(rs.getInt("idMateria"));			   
			   inscripcion.setMateria(mat);
			   
			   inscripcion.setNota(rs.getDouble("nota"));
			   
			   inscripciones.add(inscripcion);
		}
		ps.close();
			  } catch (SQLException ex) {
				  JOptionPane.showMessageDialog(null,"Error al obtener las inscripciones" +ex.getMessage());
			  }
		return inscripciones;
		  
	  }
	
	public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
     List<Inscripcion> inscripciones = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT idInscripcion, idMateria, nota FROM inscripcion WHERE idAlumno=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);

        rs = ps.executeQuery();
        while (rs.next()) {
            int idInscripcion = rs.getInt("idInscripcion");
            int idMateria = rs.getInt("idMateria");
            double nota = rs.getDouble("nota");

            // Obtener la materia y el alumno
            Materia materia = md.buscarMateria(idMateria);
            Alumno alumno = ad.buscarAlumno(idAlumno);

            // Crear una instancia de Inscripcion y agregar a la lista
            Inscripcion inscripcion = new Inscripcion(idInscripcion, materia, alumno, nota);
            inscripciones.add(inscripcion);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + e.getMessage());
    } finally {
        // Cerrar los recursos en un bloque finally
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
        }
    }

    return inscripciones;
}
	
	
    
    
}
