package evaluacion2;

public class Alumno extends Persona {

	private static final long serialVersionUID = -6018785689808326431L;
	// defino la clase Alumno
	// Propiedades
	private String grupo;

	// Constructores
	// Constructor por defecto
	public Alumno(){
		// construyo la parte de Persona
		super();
		// construyo la parte de Alumno
		this.grupo = "1DW3";
	}
	// Constructor copia
	public Alumno(Alumno a){
		// construyo la parte de Persona
		super(a);
		// construyo la parte de Alumno
		this.grupo = a.grupo;
	}	
	// Constructores personalizados
	public Alumno(Persona p, String g){
		// construyo la parte de Persona
		super(p);
		// construyo la parte de Alumno
		this.grupo = g;		
	}
	public Alumno(Persona p){
		// construyo la parte de Persona
		super(p);
		// construyo la parte de Alumno
		this.grupo = "1DW3";		
	}	
	
	// Obtener o Cambiar Valores de las Propiedades
	// Getters and Setters
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}	
	
	// toString
	@Override
	public String toString() {
		String cadena;
		// obtengo el String de Persona
		cadena = super.toString();
		// le añado el String de Alumno
		cadena = cadena + " " + grupo;
		return(cadena);
		//return (super.toString()+" " + grupo);
	}
}
