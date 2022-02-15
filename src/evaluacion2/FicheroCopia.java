package evaluacion2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroCopia {

	public static void main(String[] args) {
		// copia el fichero origen de nombre txurdi.png en el fichero destino de nombre txurdicopia.png. 
		// Para ello usa un array de tipo byte con 512 posiciones
		FileInputStream fis;
		BufferedInputStream bis;
		FileOutputStream fos;
		BufferedOutputStream bos;
		try {
			// abro el fichero origen para lectura
			fis = new FileInputStream("txurdi.png");
			bis = new BufferedInputStream(fis);
			// abro el fichero destino para escritura
			fos = new FileOutputStream("txurdicopia.png");
			bos = new BufferedOutputStream(fos);
			
			// leo todo el contenido del fichero origen
			// de 512 en 512 bytes
			int tamañobloque = 512;
			byte [] datos = new byte[tamañobloque];
			
			tamañobloque=bis.read(datos);
			while(tamañobloque != -1) {
				// mientras queden datos en el fichero origen
				// escribo los datos leidos en el fichero destino
				bos.write(datos,0,tamañobloque);
				// vuelvo a leer más datos
				tamañobloque=bis.read(datos);
			}
			
			// cierro el fichero destino
			bos.close();
			fos.close();
			// cierro el fichero origen
			bis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
