package VentaLogica;

public class MaletaEmbarque {
	private String miCompra;	
	private String dimensiones;
	private double peso;

	public MaletaEmbarque(String dimensiones, double peso) {
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
