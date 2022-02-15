package evaluacion2;

import java.util.Scanner;

public class LeerEnteroString {

	public static void main(String[] args) {
		// lee un String por teclado
		// lo convierte a entero y 
		// lo muestra por pantalla
		String valor;
		int n;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		// leo valor
		System.out.println("Introduce un numero entero: ");
		valor = teclado.nextLine();
		// lo convierto a entero
		n = Integer.parseInt(valor);
		
		// lo muestra por pantalla
		System.out.println("El valor de la variable es " + n);
		
		// libero la memoria de teclado
		teclado.close();
	}
}
