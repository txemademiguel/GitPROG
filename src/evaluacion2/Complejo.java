package evaluacion2;

import java.io.Serializable;
import java.util.Objects;

public class Complejo implements Comparable<Complejo>,Serializable{

	private static final long serialVersionUID = 6149818732657281070L;

	// defino la clase Complejo
	// Propiedades
	private double real;
	private double imaginaria;
	
	// Constructores
	// Constructor por defecto
	public Complejo(){
		this.real = 0.0;
		this.imaginaria = 0.0;
	}
	// Constructor copia
	public Complejo(Complejo c){
		this.real = c.real;
		this.imaginaria = c.imaginaria;
	}
	// Constructores personalizados
	public Complejo(double r,double i){
		this.real = r;
		this.imaginaria = i;
	}
	public Complejo(double r){
		this.real = r;
		this.imaginaria = 0.0;
	}
	// Obtener o Cambiar Valores de las Propiedades
	// Getters and Setters
	public double getReal() {
		return real;
	}
	public void setReal(double real) {
		this.real = real;
	}
	public double getImaginaria() {
		return imaginaria;
	}
	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}
	// toString
	@Override
	public String toString() {
		return (real + " + " + imaginaria + "i");
	}
	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(imaginaria, real);
	}
	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		return (Double.doubleToLongBits(imaginaria) == Double.doubleToLongBits(other.imaginaria)
				&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real));
	}
	// compareTo
	@Override
	public int compareTo(Complejo other) {
		// Comparo las Propiedades
		if(this.real > other.real) {
			return 1;
		}
		else if(this.real < other.real) {
			return -1;
		}
		else {
			// si la parte real es igual
			// comparo la parte imaginaria
			if(this.imaginaria > other.imaginaria) {
				return 1;
			}
			else if(this.imaginaria < other.imaginaria) {
				return -1;
			}
		}
		// si los Complejos son iguales
		return 0;
	}
}
