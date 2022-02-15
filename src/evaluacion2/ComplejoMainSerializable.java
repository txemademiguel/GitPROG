package evaluacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ComplejoMainSerializable {

	public static void main(String[] args) {
		// crea un objeto de la clase Complejo y lo guarda en el fichero complejos.dat. 
		// Después lee los datos del complejo desde complejos.dat y 
		// muestra el valor del complejo leído por pantalla.
		Complejo c1 = new Complejo(1,4);
		Complejo c2 = new Complejo(2,3);
		Complejo c3 = new Complejo(3,5);
		// guardo el complejo en complejos.dat
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			// abro el fichero
			fos = new FileOutputStream("complejos.dat");
			oos = new ObjectOutputStream (fos);
			// lo grabo
			oos.writeObject(c1);
			oos.writeObject(c2);
			oos.writeObject(c3);
			// cierro el fichero
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// leo el contenido de complejos.dat
		FileInputStream fis;
		ObjectInputStream ois;
		Complejo c = new Complejo();
		try {
			// abro el fichero
			fis = new FileInputStream("complejos.dat");
			ois = new ObjectInputStream(fis);
			
			// leo todo el contenido
			while(fis.available() > 0) {
				c = (Complejo) ois.readObject(); // convierte los bytes leídos en un objeto de la clase Complejo
				// lo muestro por pantalla
				System.out.println("Complejo Leido: "+c);
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
