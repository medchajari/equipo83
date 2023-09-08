
package AccesoADatos;

import java.sql.Connection;


public class AlumnoData {    
    
    private Connection con = null;
    
    //Construcctor
    public AlumnoData(){
        con=Conexion.getConexion();
    
    }
    
    
}
