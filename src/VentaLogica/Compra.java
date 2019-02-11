package VentaLogica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import mundo.CaribeAirlines;
import vueloLogica.Ruta;


public class Compra {

	private double idCompra;
	private String tipoClase;
	private double total;
	private String fechaSalida;
	private String fechaIngreso;
	private CaribeAirlines aerolinea;
	private String idMiCliente;
	private List<Ruta> misRutas;
	
	
	public Compra() {//Aqui la aerolinea se recibe por parametro. Por ahora creo uno para no entrar a editar la interfaz principal.
		aerolinea = new CaribeAirlines();
		misRutas = aerolinea.getMisRutas();
	}
	
	
	public Cliente getCliente(String text) {
		return aerolinea.getClienteID(text);
		
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


	

	public Compra(String tipoClase, double total, String fechaSalida,
			String fechaIngreso) {
		this.tipoClase = tipoClase;
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
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public void agregraCliente(Cliente c) {
		aerolinea.agregarCliente(c);
	}


}
