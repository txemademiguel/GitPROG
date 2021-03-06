package evaluacion2;

import java.util.Scanner;

public class LeerRealRobusto {

	public static void main(String[] args) {
		// lee un String por teclado
		// lo convierte a entero y 
		// lo muestra por pantalla
		String valor="";
		double n=0.0;
		// defino un objeto de la clase Scanner
		Scanner teclado;
		// creo un nuevo objeto de la clase Scanner
		teclado = new Scanner(System.in);
		
		try {
			// leo valor
			System.out.println("Introduce un numero real: ");
			valor = teclado.nextLine();
			// lo convierto a entero
			n = Double.parseDouble(valor);
		}
		catch (NumberFormatException e) {
			// si se produce una excepci?n intenta corregir el error 
			// sustituyendo los valores ?l? por 1, y ?O? y ?o? por 0. 
			// Cualquier otro car?cter es ignorado.
			char caracter;
			String valorcorrecto = "";
			boolean separadordecimal = false;
			for(int posicion=0;posicion<valor.length();posicion++) {
				// compruebo si es un digito valido
				caracter = valor.charAt(posicion);
				if(Character.isDigit(caracter)) {
					// si es un digito
					// lo a?ado a valorcorrecto
					valorcorrecto = valorcorrecto + caracter;
				}
				else if (caracter == 'l') {
					// si es 'l'
					valorcorrecto = valorcorrecto + 1;
				}
				else if (caracter == 'o' || caracter == 'O') {
					// si es 'o' u 'O'
					valorcorrecto = valorcorrecto + 0;
				}
				else if ((caracter == ',' || caracter == '.') && (separadordecimal == false)) {
					// si es un separador decimal
					valorcorrecto = valorcorrecto + '.';
					separadordecimal = true;
				}
			}
			if(valorcorrecto.length()>0) {
				// si valorcorrecto contiene algun caracter
				// convierto a entero valorcorrecto
				n = Double.parseDouble(valorcorrecto);
			}
		}
		// libero la memoria de teclado
		teclado.close();
		
		// lo muestra por pantalla
		System.out.println("El valor de la variable es " + n);
	}
}
