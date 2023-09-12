
package Entidades;

public class Inscripcion {
	
	private int idInscripcion;
	private int idAlumno;
	private int idMateria;
	private double nota;

	public Inscripcion() {
	}

	public Inscripcion(int idAlumno, int idMateria, double nota) {
		this.idAlumno = idAlumno;
		this.idMateria = idMateria;
		this.nota = nota;
	}
	

	public Inscripcion(int idInscripcion, int idAlumno, int idMateria, double nota) {
		this.idInscripcion = idInscripcion;
		this.idAlumno = idAlumno;
		this.idMateria = idMateria;
		this.nota = nota;
	}
	

	public Inscripcion(double nota) {
		this.nota = nota;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	  @Override
    public String toString() {		
		return "Alumno{" + ", idInscripcion=" +idInscripcion+ ", idAlumno=" + idAlumno +" , idMateria=" +idMateria+ " , nota=" + nota + '}';
    }
    
}
