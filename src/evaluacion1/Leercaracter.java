package evaluacion1;

import java.util.Scanner;

public class Leercaracter {

	public static void main(String[] args) {
		// lee un caracter por teclado y 
		// lo muestra por pantalla
		char c;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		// leo s
		System.out.println("Introduce un caracter: ");
		c = teclado.nextLine().charAt(0);
		
		// libero la memoria de teclado
		teclado.close();
		
		// lo muestra por pantalla
		System.out.println("El valor de la variable es " + c);
	}

}
