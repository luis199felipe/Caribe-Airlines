package VentaLogica;

public class Tiquete {
	private String idMiCliente;
	private String modalidad;
	private String fechaSalida;
	private String fechaRegreso;
	private String clase;
	private double total;
	
	
	public Tiquete() {
		this.idMiCliente = null;
		this.modalidad = null;
		this.clase = null;
		this.total = 0;
		this.fechaSalida = null;
		this.fechaRegreso = null;
	}
	
	
	public String getIdMiCliente() {
		return idMiCliente;
	}
	public void setIdMiCliente(String idMiCliente) {
		this.idMiCliente = idMiCliente;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	public String getTipoClase() {
		return clase;
	}
	public void setTipoClase(String tipoClase) {
		this.clase = tipoClase;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getFechaIngreso() {
		return fechaRegreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaRegreso = fechaIngreso;
	}
	
	
}