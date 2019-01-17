package VentaLogica;

import java.util.Calendar;

public class Compra {

	private String tipoClase;
	private double valor;
	private double subtotal;
	private double total;
	private Calendar fechaSalida;
	private Calendar fechaIngreso;

	public Compra(String tipoClase, double valor, double subtotal, double total, Calendar fechaSalida,
			Calendar fechaIngreso) {
		this.tipoClase = tipoClase;
		this.valor = valor;
		this.subtotal = subtotal;
		this.total = total;
		this.fechaSalida = fechaSalida;
		this.fechaIngreso = fechaIngreso;
	}

	public String getTipoClase() {
		return tipoClase;
	}

	public void setTipoClase(String tipoClase) {
		this.tipoClase = tipoClase;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
