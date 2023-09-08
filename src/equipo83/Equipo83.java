
package equipo83;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import Entidades.Alumno;
import java.sql.Connection;
import java.time.LocalDate;


public class Equipo83 {

	
	public static void main(String[] args) {
		Connection con=Conexion.getConexion();
                
                Alumno Juan=new Alumno(33011644,"Perez","Juan", LocalDate.of(1987, 5, 15), true);
                AlumnoData alu = new AlumnoData();
                alu.guardarAlumno(Juan);
	}
	
}
