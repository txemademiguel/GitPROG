package evaluacion2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheroHola {

	public static void main(String[] args) {
		// escribe el mensaje “Hola Mundo” en un fichero de texto de nombre prueba.txt
		FileWriter fichero;
		PrintWriter pw;
		BufferedWriter bw;

		try {
			// abro el fichero
			fichero = new FileWriter("prueba.txt");
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
			
			// escribo lo que tenga que escribir
			bw.write("Hola Mundo.");
			bw.newLine();
			
			// cierro el fichero
			bw.close();
			pw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Se ha producido un error");
		}
	}
}
