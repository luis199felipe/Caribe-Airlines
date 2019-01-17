package VentaLogica;

public class Maleta {
	private String dimenciones;
	private double peso;

	public Maleta(String dimenciones, double peso) {
		super();
		this.dimenciones = dimenciones;
		this.peso = peso;
	}

	public String getDimenciones() {
		return dimenciones;
	}

	public void setDimenciones(String dimenciones) {
		this.dimenciones = dimenciones;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
