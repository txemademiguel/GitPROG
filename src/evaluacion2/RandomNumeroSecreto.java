package evaluacion2;

import java.util.Random;
import java.util.Scanner;

public class RandomNumeroSecreto {

	public static void main(String[] args) {
		// genera un n�mero aleatorio entero entre 1 y 10 que el usuario deber� adivinar. 
		// Despu�s pide n�meros hasta que se acierte el n�mero. 
		// En cada intento mostrar� un mensaje indicando si lo ha acertado 
		// o si el n�mero que ha metido es menor o mayor que el n�mero secreto.
		// genero un n�mero aleatorio entero entre 1 y 10
		int numero;
		Random rnd = new Random();
		numero = ((int)(rnd.nextDouble()*100000.0))%10 + 1;
		
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		// leo n
		int n;
		System.out.println("Introduce un numero entero: ");
		n = teclado.nextInt();
		while(numero != n) {
			if(n > numero) {
				System.out.println("El numero "+n+" es mayor que el numero secreto");
			}
			else if(n < numero) {
				System.out.println("El numero "+n+" es menor que el numero secreto");
			}
			// leo n
			System.out.println("Introduce un numero entero: ");
			n = teclado.nextInt();
		}

		System.out.println("Zorionak!!! Has acertado el numero");
	
		// libero la memoria de teclado
		teclado.close();
		
	}
}
