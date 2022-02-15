package examen2;

import java.io.Serializable;


public class Coche implements Comparable<Coche>, Serializable{

	//Examen de Txema De Miguel
	private static final long serialVersionUID = 202203030L;
	private String marca;
	private String modelo;
	private double precio;
	private int stock;
	
	// constructor por defecto
	Coche(){
		this.marca ="Marca X";
		this.modelo = "Modelo X";
		this.precio = 1.0;
		this.stock = 1;
	}
	
	// constructores personalizados
	Coche(String ma,String mo,double p,int s){
		this.marca = ma;
		this.modelo = mo;
		this.precio = p;
		this.stock = s;
	}
	
	// constructor copia
	Coche(Coche p){
		this.marca = p.marca;
		this.modelo = p.modelo;
		this.precio = p.precio;
		this.stock = p.stock;
	}

	// Getters and Setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// toString
	@Override
	public String toString() {
		double valorCoche = this.precio * this.stock;
		return ("Marca: " + this.marca + " - Modelo: " + this.modelo + " - Precio: " + this.precio + " - Stock: " + this.stock + " - Valor Coche: " + valorCoche);
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + stock;
		return result;
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
		Coche other = (Coche) obj;
		// comparo marca y modelo como un String
		return (this.marca.equals(other.marca) && this.modelo.equals(other.modelo));
	}

	//compareTo
	@Override
	public int compareTo(Coche p) {
		// comparar marca y modelo como String
		// en ascendente
		int comparacion = 0;
		comparacion = this.marca.compareTo(p.marca);
		if (comparacion == 0) {
			// si la marca es igual
			// comparo el modelo
			comparacion = this.modelo.compareTo(p.modelo);
		}
		return(comparacion);
	}
}
