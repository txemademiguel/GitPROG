package evaluacion2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerEnteroException {

	public static void main(String[] args) {
		
		// lee un número entero por teclado y 
		// lo muestra por pantalla
		int n;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		try {
			// leo n
			System.out.println("Introduce un numero entero: ");
			n = teclado.nextInt();
			// lo muestra por pantalla
			System.out.println("El valor de la variable es " + n);
		}
		catch (InputMismatchException e) {
			System.out.println("Se ha producido un error al leer el numero");
		}
		// libero la memoria de teclado
		teclado.close();
	}
}
