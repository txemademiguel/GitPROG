package evaluacion2;

import java.util.Objects;

public class Racional implements Comparable<Racional>{
	// defino la clase Racional
	// Propiedades
	private int numerador;
	private int denominador;
	
	// Constructores
	// Constructor por defecto
	public Racional(){
		this.numerador=0;
		this.denominador=1;
	}
	// Constructor copia
	public Racional(Racional r) {
		this.numerador = r.numerador;
		this.denominador = r.denominador;
	}

	// Constructores personalizados
	public Racional(int n, int d){
		this.numerador = n;
		if(d != 0) {
			this.denominador = d;
		}
		else {
			this.denominador = 1;
		}
	}
	
	public Racional(int n) {
		this.numerador = n;
		this.denominador = 1;
	}
	
	// Obtener o Cambiar Valores de las Propiedades
	// Getters and Setters
	public int getNumerador() {
		return numerador;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	public void setDenominador(int denominador) {
		if(denominador != 0) {
			// si denominador no es 0
			this.denominador = denominador;
		}
	}
	
	// toString
	@Override
	public String toString() {
		return (numerador + "/" + denominador);
	}
	
	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(denominador, numerador);
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
		Racional other = (Racional) obj;
		if(this.numerador * other.denominador == this.denominador * other.numerador) {
			// si son iguales
			return true;
		}
		// si NO son iguales
		return false;
	}
	
	// compareTo
	/* basic
	@Override
	public int compareTo(Racional other) {
		// Comparo las Propiedades
		if(this.numerador * other.denominador > this.denominador * other.numerador) {
			// si el primero es mayor
			return 1;
		}
		else if(this.numerador * other.denominador < this.denominador * other.numerador) {
			// si el primero es menor
			return -1;
		}
		// si son iguales
		return 0;
	}
	*/
	/* basic 2 
	@Override
	public int compareTo(Racional other) {
		// Comparo las Propiedades
		int n1 = this.numerador * other.denominador;
		int n2 = this.denominador * other.numerador;
		if(n1 > n2) {
			// si el primero es mayor
			return 1;
		}
		else if(n1 < n2) {
			// si el primero es menor
			return -1;
		}
		// si son iguales
		return 0;
	}
	*/
	/* pro */
	@Override
	public int compareTo(Racional other) {
		// Comparo las Propiedades
		Integer n1 = this.numerador * other.denominador;
		Integer n2 = this.denominador * other.numerador;
		return (n1.compareTo(n2));
	}
}
