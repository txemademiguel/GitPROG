package evaluacion2;

public class AlumnoMain {

	public static void main(String[] args) {
		// pruebo la clase Alumno
		// Constructores
		// Constructor por defecto
		Alumno a1 = new Alumno();
		System.out.println(a1);
		// Constructor copia
		Alumno a2 = new Alumno(a1);
		System.out.println(a2);
		// Constructores personalizados
		Alumno a3 = new Alumno(new Persona("3","Nombre3","Apellidos3"),"2DW3");
		System.out.println(a3);
		Alumno a4 = new Alumno(new Persona("4","Nombre4","Apellidos4",new Fecha(20,12,2021)),"3DW3");
		System.out.println(a4);
		Alumno a5 = new Alumno(new Persona("5","Nombre5","Apellidos5",new Fecha(20,12,2021)));
		System.out.println(a5);

		// Obtener o Cambiar Valores de las Propiedades
		// Getters and Setters
		a1.setDni("1");
		a1.setNombre("Nombre1");
		a1.setApellidos("Apellidos1");
		a1.setGrupo("2DW3");
		System.out.println(a1);
		// equals
		a1.setDni("3");
		if(a1.equals(a3)) {
			// si a1 y a3 son iguales
			System.out.println(a1 + " y "+a3+" son iguales");
		}
		else {
			// si a1 y a3 NO son iguales
			System.out.println(a1 + " y "+a3+" NO son iguales");
		}
		// compareTo
		a1.setDni("5");
		if(a1.compareTo(a3) > 0) {
			// si a1 > a3
			System.out.println(a1 + " es mayor que "+a3);
		}
		else if(a1.compareTo(a3) < 0) {
			// si a1 <a3
			System.out.println(a1 + " es menor que "+a3);
		}
		else {
			System.out.println(a1 + " es igual que "+a3);
		}
	}
}
