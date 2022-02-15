package evaluacion2;

import java.util.Objects;

public class Asignatura implements Comparable<Asignatura>{
	// defino la clase Asignatura
	// Propiedades
	private String codigo;
	private String descripcion;
	private double nota;
	// Constructores
	// Constructor por defecto
	Asignatura(){
		this.codigo = "CX";
		this.descripcion = "Sin descripcion";
		this.nota = 0.0;
	}
	
	// Constructor copia	
	Asignatura(Asignatura a){
		this.codigo = a.codigo;
		this.descripcion = a.descripcion;
		this.nota = a.nota;
	}

	// Constructores personalizados	
	public Asignatura(String c, String d, double n) {
		this.codigo = c;
		this.descripcion = d;
		this.nota = n;
	}
	
	// Obtener o Cambiar Valores de las Propiedades
	// Getters and Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	// toString
	@Override
	public String toString() {
		return (codigo + " - " + nota);
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, nota);
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// si es el mismo objeto
			return true;
		if (obj == null)
			// si el objeto obj no esta creado
			return false;
		if (getClass() != obj.getClass())
			// si el objeto obj es de otra Clase diferente
			return false;
		// Comparo las Propiedades
		Asignatura other = (Asignatura) obj;
		
		return (this.codigo.equals(other.codigo) && this.nota == other.nota);
	}

	// compareTo
	@Override
	public int compareTo(Asignatura other) {
		// Comparo las Propiedades
		// Comparo el codigo
		int comparacion;
		comparacion = this.codigo.compareTo(other.codigo);
		if(comparacion == 0) {
			// si el codigo es igual
			// comparo la nota
			Double n1 = this.nota;
			Double n2 = other.nota;
			comparacion = n1.compareTo(n2);
		}
		return (comparacion);
	}
}
