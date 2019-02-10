package VentaLogica;

public class Tiquete {
	private String categoria;
	private double valor;

	public Tiquete(String categoria, double valor) {
		this.categoria = categoria;
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
