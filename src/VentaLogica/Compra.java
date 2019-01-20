package VentaLogica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import mundo.CaribeAirlines;
import rutaLogica.Ruta;


public class Compra {

	private double idCompra;
	private String tipoClase;
	private double valor;
	private double subtotal;
	private double total;
	private Calendar fechaSalida;
	private Calendar fechaIngreso;
	
	private List<Ruta> misRutas;
	
	
	public Compra() {//Aqui la aerolinea se recibe por parametro. Por ahora creo uno para no entrar a editar la interfaz principal.
		CaribeAirlines aerolinea = new CaribeAirlines();
		misRutas = aerolinea.getMisRutas();
	}
	
	
	public HashSet<String> getCiudades(){
		HashSet<String> ciudades = new HashSet();
		
		for (int i = 0; i < misRutas.size(); i++) {
			//System.out.println(misRutas.get(i).getAtributos().get("Destino"));
			ciudades.add(misRutas.get(i).getAtributos().get("Destino"));
		}
		
		return ciudades;	
	}
	
	public List<String> getFechasDeCiudad(String ciudad) {
		List<String> fechas = new ArrayList();
		
		for (int i = 0; i < misRutas.size(); i++) {
			if (misRutas.get(i).getAtributos().get("Destino").equals(ciudad)) {
				fechas.add(misRutas.get(i).getAtributos().get("Fecha")+"//"+misRutas.get(i).getAtributos().get("HoraSalida")+"//"+misRutas.get(i).getAtributos().get("HoraLLegada"));
			}
		}		
		return fechas;
	}


	

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
