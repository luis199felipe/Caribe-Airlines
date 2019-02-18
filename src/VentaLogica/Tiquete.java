package VentaLogica;

import java.util.ArrayList;
import java.util.List;

import vueloLogica.Vuelo;

public class Tiquete {
	private String idMiCliente;
	private String clase;
	private Vuelo vueloIda;
	private Vuelo vueloRegreso;
	private List<Maleta> misMaletas;
	private double total;
	
	public Tiquete() {
		this.idMiCliente = "";
		this.clase = "";
		this.vueloIda = null;
		this.vueloRegreso = null;
		this.misMaletas = new ArrayList<>();
		this.total = 0;
	}
	
	public Tiquete(String idMiCliente, String clase, Vuelo vueloIda, Vuelo vueloRegreso, List<Maleta> misMaletas,
			double total) {
		this.idMiCliente = idMiCliente;
		this.clase = clase;
		this.vueloIda = vueloIda;
		this.vueloRegreso = vueloRegreso;
		this.misMaletas = misMaletas;
		this.total = total;
	}
	
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Vuelo getVueloIda() {
		return vueloIda;
	}

	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}

	public Vuelo getVueloRegreso() {
		return vueloRegreso;
	}

	public void setVueloRegreso(Vuelo vueloRegreso) {
		this.vueloRegreso = vueloRegreso;
	}

	public List<Maleta> getMisMaletas() {
		return misMaletas;
	}

	public void setMisMaletas(List<Maleta> misMaletas) {
		this.misMaletas = misMaletas;
	}

	
	
	public String getIdMiCliente() {
		return idMiCliente;
	}
	public void setIdMiCliente(String idMiCliente) {
		this.idMiCliente = idMiCliente;
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

	public void agregarMaleta(Maleta m) {
		misMaletas.add(m);		
	}
		
}