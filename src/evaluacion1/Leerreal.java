package evaluacion1;

import java.util.Scanner;

public class Leerreal {

	public static void main(String[] args) {
		// lee un número real por teclado y 
		// lo muestra por pantalla
		double d;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		// leo d
		System.out.println("Introduce un numero real: ");
		d = teclado.nextDouble();
		
		// libero la memoria de teclado
		teclado.close();
		
		// lo muestra por pantalla
		System.out.println("El valor de la variable es " + d);
	}

}
