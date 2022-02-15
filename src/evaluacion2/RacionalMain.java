package evaluacion2;

public class RacionalMain {

	public static void main(String[] args) {
		// pruebo la clase Racional
		// Constructores
		// Constructor por defecto
		Racional r1;
		r1 = new Racional(); // 0/1
		System.out.println(r1);
		// Constructor copia
		Racional r2;
		r2 = new Racional(r1); // 0/1
		r2.setNumerador(2); // 2/1
		System.out.println(r1);
		System.out.println(r2);
		// Constructores personalizados
		Racional r3;
		r3 = new Racional(3,4); // 3/4
		System.out.println(r3);
		Racional r4;
		r4 = new Racional(7); // 7/1
		System.out.println(r4);
		// Obtener o Cambiar Valores de las Propiedades
		// Getters and Setters 
		System.out.println("Numerador: " + r3.getNumerador());
		System.out.println("Denominador: " + r3.getDenominador());
		r4.setDenominador(0);
		System.out.println(r4);
		Racional r5;
		r5 = new Racional(3,0);
		System.out.println(r5);
		// equals
		Racional r6 = new Racional(6,8); // 6/8;
		if(r3.equals(r6)) {
			// si r3 y r6 son iguales
			System.out.println(r3 + " y "+r6+" son iguales");
		}
		else {
			// si r3 y r6 NO son iguales
			System.out.println(r3 + " y "+r6+" NO son iguales");
		}
		// compareTo
		r4.setNumerador(1);
		r4.setDenominador(2);
		if(r3.compareTo(r4) > 0) {
			// si r3 > r4
			System.out.println(r3 + " es mayor que "+r4);
		}
		else if(r3.compareTo(r4) < 0) {
			// si r3 < r4
			System.out.println(r3 + " es menor que "+r4);
		}
		else {
			System.out.println(r3 + " es igual que "+r4);
		}
	}
}
