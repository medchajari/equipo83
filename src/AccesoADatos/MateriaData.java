/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MeD Servicios Inf
 */
public class MateriaData {
	 private Connection con = null;


public MateriaData(){        
        con=Conexion.getConexion();    
    }

  public void guardarMateria(Materia materia){
        //consulta para insertar datos
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUE(?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
                        
            //ejecutamos, enviamos los datos
            ps.executeUpdate();
            
            //obtener la clave
            ResultSet rs = ps.getGeneratedKeys();
            
            //si se pudo agregar setamos el id
            if(rs.next()){
                
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia guardada exitosamente.");
            
            }
            ps.close();
            
            
            //si nos equivocamos en algun datos nos muestra este error
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Materia.");
        }
    
    }

 //eliminarMateria
    public void eliminarMateria (int id){
                                        //modificamos el estado del alumno a 0
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada Exitosamente.");
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla materia.");
        }
        
    }
  
 public Materia buscarMateriaPorId(int id){
        String sql = "SELECT nombre, anio FROM materia WHERE idMateria = ? AND estado = 1";
//        String sql = "SELECT nombre, anio FROM materia WHERE idMateria = ? AND estado = 1";        
    Materia materia = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            materia = new Materia();
            materia.setIdMateria(id);
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materia.setActivo(true);
        } else {
            JOptionPane.showMessageDialog(null, "La materia no existe.");
        }

        ps.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de materia: " + e.getMessage());
    }
	
    return materia;
    }
 
    public void modificarMateria(Materia materia){
    //consulta actualizar datos     
    // TABLA(materia) MODIFICAR      SET: LOS DATOS A MODIFICAR                     WHERE: Condicion
    String sql = "UPDATE materia SET idMateria=?, nombre=?, anio=? WHERE idMateria = ?";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getAnio());            
            ps.setBoolean(4, materia.isActivo());
            
            
            int exito = ps.executeUpdate();
            if(exito==1){
                 JOptionPane.showMessageDialog(null, "Materia modificada Exitosamente.");
            }
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al tratar de acceder a la tabla Materia.");
        }
    
    }


}