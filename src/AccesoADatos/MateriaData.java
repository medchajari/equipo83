/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

 public Materia buscarMateria(int id){
        String sql = "SELECT nombre, anio FROM materia WHERE idMateria = ? AND estado = 1";
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
 



}