package evaluacion2;

import java.util.Objects;

public class Circulo extends Figura {
	// defino la clase Circulo
	// Propiedades
	protected double radio;

	// Constructores
	// Constructor por defecto
	public Circulo(){
		// construyo la parte de Figura
		super();
		// construyo la parte de Circulo
		this.radio = 1.0;
	}
	// Constructor copia
	public Circulo(Circulo c){
		// construyo la parte de Figura
		super(c);
		// construyo la parte de Circulo
		this.radio = c.radio;
	}
	// Constructores personalizados
	public Circulo(double r){
		// construyo la parte de Figura
		super();
		// construyo la parte de Circulo
		this.radio = r;
	}
	public Circulo(int x, int y, double r){
		// construyo la parte de Figura
		super(x,y);
		// construyo la parte de Circulo
		this.radio = r;
	}
	// area
	@Override
	public double area() {
		// calculo el area
		return (Math.PI*radio*radio);
	}
	// toString
	@Override
	public String toString() {
		return ("Circulo - X:"+x+" Y:"+y+" Radio:"+radio);
	}
	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(radio);
		return result;
	}
	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		// Comparo las Propiedades
		Circulo other = (Circulo) obj;
		return (super.equals(other) && Double.doubleToLongBits(radio) == Double.doubleToLongBits(other.radio));
	}
	
	//compareTo
	public int compareTo(Circulo other) {
		// Comparo las Propiedades
		Double r1 = this.radio;
		Double r2 = other.radio;
		return (r1.compareTo(r2));
	}
}
