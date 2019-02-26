package VentaLogica;

public class MaletaEmbarque {
	private String miCompra;	
	private String dimensiones;
	private String idMaleta;
	public String getMiCompra() {
		return miCompra;
	}

	public void setMiCompra(String miCompra) {
		this.miCompra = miCompra;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getIdMaleta() {
		return idMaleta;
	}

	public void setIdMaleta(String idMaleta) {
		this.idMaleta = idMaleta;
	}

	private double peso;

	public MaletaEmbarque(String id,String dimensiones, double peso) {
		idMaleta = id;
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
