package evaluacion2;

public class AsignaturaMain {

	public static void main(String[] args) {
		// pruebo la clase Asignatura
		// Constructores
		// Constructor por defecto
		Asignatura a1 = new Asignatura();
		System.out.println(a1);
		
		// Constructor copia
		Asignatura a2 = new Asignatura(a1);
		System.out.println(a2);
		
		// Constructores personalizados
		Asignatura a3 = new Asignatura("PROG","Programacion",8.0);
		System.out.println(a3);
		// equals
		// a1.setCodigo("AGBD");
		if(a1.equals(a2)) {
			// si a1 y a2 son iguales
			System.out.println(a1 + " y "+a2+" son iguales");
		}
		else {
			// si a1 y a2 NO son iguales
			System.out.println(a1 + " y "+a2+" NO son iguales");
		}
		// compareTo
		if(a1.compareTo(a2) > 0) {
			// si a1 > a2
			System.out.println(a1 + " es mayor que "+a2);
		}
		else if(a1.compareTo(a2) < 0) {
			// si a1 < a2
			System.out.println(a1 + " es menor que "+a2);
		}
		else {
			System.out.println(a1 + " es igual que "+a2);
		}
	}

}
