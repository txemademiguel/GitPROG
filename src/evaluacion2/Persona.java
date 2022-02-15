package evaluacion2;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Comparable<Persona>,Serializable{
	
	private static final long serialVersionUID = 7081890516038337567L;
	// defino la clase Persona
	// Propiedades
	private String dni;
	private String nombre;
	private String apellidos;
	private Fecha fechanacimiento;
	
	// Constructores
	// Constructor por defecto
	public Persona(){
		this.dni = "";
		this.nombre = "";
		this.apellidos = "";
		this.fechanacimiento = new Fecha();
	}

	// Constructor copia
	public Persona(Persona p){
		this.dni = p.dni;
		this.nombre = p.nombre;
		this.apellidos = p.apellidos;
		this.fechanacimiento = new Fecha(p.fechanacimiento);
	}

	// Constructores personalizados
	public Persona(String d,String n, String a){
		this.dni = d;
		this.nombre = n;
		this.apellidos = a;
		this.fechanacimiento = new Fecha();
	}
	
	public Persona(String d,String n, String a, Fecha f){
		this.dni = d;
		this.nombre = n;
		this.apellidos = a;
		this.fechanacimiento = new Fecha(f);
	}
	
	// Getters and Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Fecha getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Fecha fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	// toString
	@Override
	public String toString() {
		return (dni + " " + nombre + " " + apellidos + " " + fechanacimiento);
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, dni, fechanacimiento, nombre);
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
		// SOLO comparo el dni
		Persona other = (Persona) obj;
		return (this.dni.equals(other.dni));
	}

	// compareTo
	@Override
	public int compareTo(Persona other) {
		// Comparo las Propiedades
		// SOLO comparo el dni
		return (this.dni.compareTo(other.dni));
	}
}
