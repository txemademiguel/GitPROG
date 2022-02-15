package evaluacion2;

import java.util.ArrayList;

public class FiguraMain {

	public static void main(String[] args) {
		// pruebo la clase Rectangulo
		// Constructores
		// Constructor por defecto
		Rectangulo r1 = new Rectangulo();
		System.out.println("Area del rectángulo "+r1.area());
		// Constructor copia
		Rectangulo r2 = new Rectangulo(r1);
		System.out.println("Area del rectángulo "+r2.area());
		// Constructores personalizados
		Rectangulo r3 = new Rectangulo(5.0,3.0);
		System.out.println("Area del rectángulo "+r3.area());
		Rectangulo r4 = new Rectangulo(1,1,2.0,4.0);
		System.out.println("Area del rectángulo "+r4.area());
		
		// pruebo la clase Circulo
		// Constructores
		// Constructor por defecto
		Circulo c1 = new Circulo();
		System.out.println("Area del Circulo "+c1.area());
		// Constructor copia
		Circulo c2 = new Circulo(c1);
		System.out.println("Area del Circulo "+c2.area());
		// Constructores personalizados
		Circulo c3 = new Circulo(5.0);
		System.out.println("Area del Circulo "+c3.area());
		Circulo c4 = new Circulo(1,1,2.0);
		System.out.println("Area del Circulo "+c4.area());
		
		// pruebo la clase Cuadrado
		// Constructores
		// Constructor por defecto
		Cuadrado cu1 = new Cuadrado();
		System.out.println("Area del Cuadrado "+cu1.area());
		// Constructor copia
		Cuadrado cu2 = new Cuadrado(cu1);
		System.out.println("Area del Cuadrado "+cu2.area());
		// Constructores personalizados
		Cuadrado cu3 = new Cuadrado(5.0);
		System.out.println("Area del Cuadrado "+cu3.area());
		Cuadrado cu4 = new Cuadrado(1,1,2.0);
		System.out.println("Area del Cuadrado "+cu4.area());
		
		// pruebo toString
		System.out.println(r4);
		System.out.println(c4);
		System.out.println(cu4);
		
		// arrayListFiguras
		ArrayList<Figura> arrayListFiguras = new ArrayList<Figura>();
		arrayListFiguras.add(cu4);
		arrayListFiguras.add(c4);
		arrayListFiguras.add(r4);
		arrayListFiguras.add(cu3);
		
		// Polimorfismo
		// calculo el area de todas las Figuras del ArrayList
		for (int posicion=0; posicion < arrayListFiguras.size(); posicion ++){
			System.out.println("Área = " +arrayListFiguras.get(posicion).area());
			}
	}
}
