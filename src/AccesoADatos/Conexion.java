/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
	
	private static final String url="jdbc:mariadb://localhost/";
	private static final String db="equipo83";
	private static final String usuario="root";
	private static final String password="";
	private static Connection conexion;
	
	private Conexion(){}
	
	public static Connection getConexion(){
	
		if(conexion==null){
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conexion = DriverManager.getConnection(url+db,usuario,password);
				
                                JOptionPane.showMessageDialog(null,"Conectado correctamente.");
				
			} catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(null,"Error al cargar los driver.");
			} catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null,"Error al conectarse a la Base de Datos.");
                    }
		}
                return conexion;
	}
	
}
