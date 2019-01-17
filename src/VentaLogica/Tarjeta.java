package VentaLogica;

public class Tarjeta {
	private String tipo;
	private double cupo;

	public Tarjeta(String tipo, double cupo) {
		this.tipo = tipo;
		this.cupo = cupo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCupo() {
		return cupo;
	}

	public void setCupo(double cupo) {
		this.cupo = cupo;
	}

}
