package VentaLogica;

public class Tarjeta {
	private String miClienteID;
	private String tipo;
	private double cupo;
	private String numero;
	private String fecha;
	private String codigo;

	public Tarjeta(String tipo, double cupo,String clie,String num,String fech,String cod) {
		miClienteID = clie;
		this.tipo = tipo;
		this.cupo = cupo;
		numero =num;
		fecha = fech;
		codigo = cod;
	}
	

	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getMiClienteID() {
		return miClienteID;
	}


	public void setMiClienteID(String miClienteID) {
		this.miClienteID = miClienteID;
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
