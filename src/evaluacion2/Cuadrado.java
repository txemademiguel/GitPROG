package evaluacion2;

public final class Cuadrado extends Rectangulo {
	// defino la clase Cuadrado
	// Propiedades NO HACE FALTA las hereda de Rectangulo
	// Constructores
	// Constructor por defecto
	public Cuadrado(){
		// construyo la parte de Rectangulo
		super();
	}
	// Constructor copia
	public Cuadrado(Cuadrado c){
		// construyo la parte de Rectangulo
		super(c);
	}
	// Constructores personalizados
	public Cuadrado(double lado){
		// construyo la parte de Rectangulo
		super(lado,lado);
	}
	public Cuadrado(int x, int y,double lado){
		// construyo la parte de Rectangulo
		super(x,y,lado,lado);
	}
	@Override
	public String toString() {
		return ("Cuadrado - X:"+x+" Y:"+y+" Lado:"+ancho);
	}
	
}
