package evaluacion2;

import java.util.Objects;

public class Rectangulo extends Figura {
	// defino la clase Rectangulo
	// Propiedades
	protected double ancho;
	protected double alto;
	
	// Constructores
	// Constructor por defecto
	public Rectangulo(){
		// construyo la parte de Figura
		super();
		// construyo la parte de Rectangulo
		this.ancho = 1.0;
		this.alto = 1.0;
	}
	
	// Constructor copia
	public Rectangulo(Rectangulo r){
		// construyo la parte de Figura
		super(r);
		// construyo la parte de Rectangulo
		this.ancho = r.ancho;
		this.alto = r.alto;
	}
	// Constructores personalizados
	public Rectangulo(double an, double al){
		// construyo la parte de Figura
		super();
		// construyo la parte de Rectangulo
		this.ancho = an;
		this.alto = al;				
	}
	public Rectangulo(int x,int y,double an, double al){
		// construyo la parte de Figura
		super(x,y);
		// construyo la parte de Rectangulo
		this.ancho = an;
		this.alto = al;		
	}	
	// area
	@Override
	public double area() {
		// calculo el area
		return (ancho*alto);
	}
	// toString
	@Override
	public String toString() {
		return ("Rectangulo - X:"+x+" Y:"+y+" Ancho:"+ancho+" Alto:"+alto);
	}
	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(alto, ancho);
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
		Rectangulo other = (Rectangulo) obj;
		return (super.equals(other) && Double.doubleToLongBits(alto) == Double.doubleToLongBits(other.alto)
				&& Double.doubleToLongBits(ancho) == Double.doubleToLongBits(other.ancho));
	}

	// compareTo
	public int compareTo(Rectangulo other) {
		// Comparo las Propiedades
		// calculo el area
		Double a1 = this.area();
		Double a2 = other.area();
		return (a1.compareTo(a2));
	}
}
