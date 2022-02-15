package evaluacion2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FicheroTextoBufferLectura {

	public static void main(String[] args) {
		// muestra el contenido de un fichero de texto de nombre prueba.txt por pantalla 
		// usando un buffer de lectura
		File archivo;
		FileReader fr;
		BufferedReader br;
		
		try {
			// abro el fichero
			archivo = new File ("prueba.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			// leo lo que tenga que leer linea a linea
			String linea;
			while((linea=br.readLine())!=null){
				System.out.println(linea);
			}
			// cierro el fichero
			br.close();
			fr.close();
		
		} catch (IOException e) {
			System.out.println("Se ha producido un error");
		}
	}

}
