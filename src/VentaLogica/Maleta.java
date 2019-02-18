package VentaLogica;

public class Maleta {
	private String miCompra;	
	private String dimensiones;
	private double peso;

	public Maleta(String dimensiones, double peso) {
		super();
		this.dimensiones = dimensiones;
		this.peso = peso;
	}

	public String getDimenciones() {
		return dimensiones;
	}

	public void setDimenciones(String dimenciones) {
		this.dimensiones = dimenciones;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
