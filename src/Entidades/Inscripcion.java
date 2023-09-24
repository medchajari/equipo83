
package Entidades;

public class Inscripcion {
	
	private int idInscripcion;
	private Alumno alumno;
	private Materia materia;
	private double nota;

	public Inscripcion() {
	}

	public Inscripcion(Alumno alumno, Materia materia, double nota) {
		this.alumno = alumno;
		this.materia = materia;
		this.nota = nota;
	}

	public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota) {
		this.idInscripcion = idInscripcion;
		this.alumno = alumno;
		this.materia = materia;
		this.nota = nota;
	}
	
	public Inscripcion(Materia materia, Alumno alumno, int idInscripcion) {
        this.materia = materia;
        this.alumno = alumno;
        this.idInscripcion = idInscripcion;
    }

	public Inscripcion(int idInscripcion, Materia materia, Alumno alumno, double nota) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + this.idInscripcion;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Inscripcion other = (Inscripcion) obj;
		return this.idInscripcion == other.idInscripcion;
	}
	
	

	@Override
	public String toString() {
		return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + '}';
	}
	
	
	
	

	
    
}
