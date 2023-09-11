
package equipo83;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import Entidades.Alumno;
import java.sql.Connection;


public class Equipo83 {

	
	public static void main(String[] args) {
		Connection con=Conexion.getConexion();
                
//                Alumno Juan=new Alumno(33011644,"Perez","Juan", LocalDate.of(1987, 5, 15), true);
//                AlumnoData alu = new AlumnoData();
//                alu.guardarAlumno(Juan);
//                alu.eliminarAlumno(1);
                    AlumnoData alu = new AlumnoData();
                    for(Alumno alumno:alu.listarAlumnos()){
                        System.out.println("Numero de Dni: "+alumno.getDni());
                        System.out.println(alumno.getApellido() + " " + alumno.getNombre());
                        
                        System.out.println("Nacido el: " + alumno.getFechaNacimiento());
			    System.out.println("-------------------------");
                    }
	}
	
}
