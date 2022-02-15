package evaluacion2;

import java.util.Objects;

public abstract class Figura implements Comparable<Figura> {
	// defino la clase Figura
	// Propiedades
	protected int x;
	protected int y;

	// Constructores
	// Constructor por defecto	
	public Figura(){
		this.x = 0;
		this.y = 0;
	}

	// Constructor copia
	public Figura(Figura f) {
		this.x = f.x;
		this.y = f.y;
	}
	
	// Constructor personalizado	
	public Figura(int x, int y) {
		this.x=x;
		this.y=y;
	}

	// metodo abstract area
	public abstract double area();
	
	// toString
	@Override
	public String toString() {
		return ("Figura - X:"+x+" Y:"+y);
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
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
		// Comparo las Propiedades
		Figura other = (Figura) obj;
		return x == other.x && y == other.y;
	}
	// compareTo
	@Override
	public int compareTo(Figura o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
