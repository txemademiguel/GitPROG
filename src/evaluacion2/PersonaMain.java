package evaluacion2;

public class PersonaMain {

	public static void main(String[] args) {
		// pruebo la clase Racional
		// Constructores
		// Constructor por defecto
		Persona p1;
		p1 = new Persona();
		System.out.println(p1);
		// Constructor copia
		Persona p2;
		p2 = new Persona(p1);
		System.out.println(p2);
		// Constructores personalizados
		Persona p3;
		p3 = new Persona("3","N3","A3",new Fecha(9,12,2021));
		System.out.println(p3);
	}

}
