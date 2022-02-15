package evaluacion2;

import java.util.Scanner;

public class LeerEntero {

	public static void main(String[] args) {
		// lee un número entero por teclado y 
		// lo muestra por pantalla
		int n;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		// leo n
		System.out.println("Introduce un numero entero: ");
		n = teclado.nextInt();
		
		// libero la memoria de teclado
		teclado.close();
		
		// lo muestra por pantalla
		System.out.println("El valor de la variable es " + n);
	}

}
