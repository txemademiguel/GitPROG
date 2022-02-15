package evaluacion1;

import java.util.Scanner;

public class Leerstring {

	public static void main(String[] args) {
		// lee un String por teclado y 
		// lo muestra por pantalla
		String s;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		// leo s
		System.out.println("Introduce un String: ");
		s = teclado.nextLine();
		
		// libero la memoria de teclado
		teclado.close();
		
		// lo muestra por pantalla
		System.out.println("El valor de la variable es " + s);
	}

}
