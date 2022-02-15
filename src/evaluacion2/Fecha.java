package evaluacion2;

import java.io.Serializable;
import java.util.Objects;

public class Fecha implements Comparable<Fecha>,Serializable{

	private static final long serialVersionUID = 5402725963046351341L;
	// defino la clase Fecha
	// Propiedades
	private int dia;
	private int mes;
	private int año;
	// Constructores
	// Constructor por defecto
	public Fecha(){
		this.dia = 1;
		this.mes = 1;
		this.año = 2020;
	}
	// Constructor copia
	public Fecha(Fecha f){
		this.dia = f.dia;
		this.mes = f.mes;
		this.año = f.año;
	}
	// Constructores personalizados
	public Fecha(int d,int m,int a){
		this.dia = d;
		this.mes = m;
		this.año = a;
	}
	// Obtener o Cambiar Valores de las Propiedades
	// Getters and Setters
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	// toString
	@Override
	public String toString() {
		return (dia + "/" + mes + "/" + año);
	}
	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(año, dia, mes);
	}
	// equals	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return año == other.año && dia == other.dia && mes == other.mes;
	}
	// compareTo
	@Override
	public int compareTo(Fecha other) {
		// Comparo las Propiedades
		if(this.año > other.año) {
			return 1;
		}
		else if(this.año < other.año) {
			return -1;
		}
		else {
			// si el año es igual
			if(this.mes > other.mes) {
				return 1;
			}
			else if(this.mes < other.mes) {
				return -1;
			}
			else {
				// si el mes es igual
				if(this.dia > other.dia) {
					return 1;
				}
				else if(this.dia < other.dia) {
					return -1;
				}
			}
		}
		// si las fechas son iguales
		return 0;
	}
}
