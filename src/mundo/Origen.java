package mundo;

import java.util.ArrayList;
import java.util.List;

import VentaLogica.Cliente;
import VentaLogica.Maleta;
import VentaLogica.Tarjeta;
import VentaLogica.Tiquete;
import aeronaveData.DatosAeronave;
import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;
import tripulacionLogica.Tripulacion;
import tripulacionLogica.Tripulante;
import vueloData.DatosRuta;
import vueloLogica.Ruta;
import vueloLogica.Vuelo;

public class Origen {
	private CaribeAirlines aerolinea;
	
	public Origen(CaribeAirlines aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	public void RegistroVuelos () {
		
		List<Aeronave> misAeronaves = aerolinea.getMisAeronaves();
		List<Tripulacion> misTripulaciones = aerolinea.getMisTripulaciones();
		List<Vuelo> misVuelos = aerolinea.getMisVuelos();
		
		for (int i = 0; i < misAeronaves.size(); i++) {
			String matriculaAeronave = misAeronaves.get(i).getMatricula();
			for (int j = 0; j < misVuelos.size(); j++) {
				String matriculaVueloAeronave = misVuelos.get(j).getMiAeronave().getMatricula();
				if(matriculaAeronave.equals(matriculaVueloAeronave)) {
					misAeronaves.get(i).getRegistro().add(misVuelos.get(j));
				}
			}
		}
		
		for (int i = 0; i < misTripulaciones.size(); i++) {
			String idTripulacion = misTripulaciones.get(i).getMiTripulacion().get("IdTripulacion");
			for (int j = 0; j < misVuelos.size(); j++) {
				String idVueloTripulacion = misVuelos.get(j).getMiTripulacion().getMiTripulacion().get("IdTripulacion");
				if(idTripulacion.equals(idVueloTripulacion)) {
					misTripulaciones.get(i).getMisVuelos().add(misVuelos.get(j));
				}
			}
		}
			
		aerolinea.setMisAeronaves(misAeronaves);
		
	}
	
	public void crearMisRutas () {
		Ruta ruta01 = new Ruta("CDMX", "Monterrey", "2:45", "Nacional");
		Ruta ruta02 = new Ruta("CDMX", "Cancun", "3:12", "Nacional");
		Ruta ruta03 = new Ruta("CDMX", "Buenos Aires", "9:05", "Internacional");
		Ruta ruta04 = new Ruta("CDMX", "Los Angeles", "3:25", "Internacional");
		Ruta ruta05 = new Ruta("CDMX", "Bogota", "3:45", "Internacional");
		Ruta ruta06 = new Ruta("CDMX", "Panama", "2:55", "Internacional");
	
		Ruta ruta07 = new Ruta("Monterrey", "CDMX", "2:45", "Nacional");
		Ruta ruta08 = new Ruta("Cancun", "CDMX", "3:12", "Nacional");
		Ruta ruta09 = new Ruta("Buenos Aires", "CDMX", "9:05", "Internacional");
		Ruta ruta10 = new Ruta("Los Angeles", "CDMX", "3:25", "Internacional");
		Ruta ruta11 = new Ruta("Bogota", "CDMX", "3:45", "Internacional");
		Ruta ruta12 = new Ruta("Panama", "CDMX", "2:55", "Internacional");
		
		List<Ruta> misRutas = new ArrayList<>();
		
		misRutas.add(ruta01);	misRutas.add(ruta02);
		misRutas.add(ruta03);	misRutas.add(ruta04);
		misRutas.add(ruta05);	misRutas.add(ruta06);
		misRutas.add(ruta07);	misRutas.add(ruta08);
		misRutas.add(ruta09);	misRutas.add(ruta10);
		misRutas.add(ruta11);	misRutas.add(ruta12);
		
		aerolinea.setMisRutas(misRutas);
	}
	
	public void crearMisVuelos () {
		
		List<Aeronave> misAeronaves = aerolinea.getMisAeronaves();
		List<Tripulacion> misTripulaciones = aerolinea.getMisTripulaciones();
		List<Ruta> misRutas = aerolinea.getMisRutas();

		Vuelo vuelo01 = new Vuelo("1", "25/02/2019", "06:00", "3", misRutas.get(0), misTripulaciones.get(0), misAeronaves.get(0));
		Vuelo vuelo02 = new Vuelo("2", "02/01/2019", "08:00", "3", misRutas.get(1), misTripulaciones.get(1), misAeronaves.get(1));
		Vuelo vuelo03 = new Vuelo("3", "03/01/2019", "23:30", "3", misRutas.get(2), misTripulaciones.get(2), misAeronaves.get(2));
		Vuelo vuelo04 = new Vuelo("4", "20/02/2019", "09:45", "3", misRutas.get(3), misTripulaciones.get(3), misAeronaves.get(3));
		Vuelo vuelo05 = new Vuelo("5", "05/01/2019", "13:30", "3", misRutas.get(4), misTripulaciones.get(4), misAeronaves.get(4));
		Vuelo vuelo06 = new Vuelo("6", "06/01/2019", "14:45", "3", misRutas.get(5), misTripulaciones.get(5), misAeronaves.get(5));

		Vuelo vuelo07 = new Vuelo("7", "26/02/2019", "11:45", "3", misRutas.get(6), misTripulaciones.get(0), misAeronaves.get(0));
		Vuelo vuelo08 = new Vuelo("8", "02/01/2019", "14:12", "3", misRutas.get(7), misTripulaciones.get(1), misAeronaves.get(1));
		Vuelo vuelo09 = new Vuelo("9", "03/01/2019", "11:35", "3", misRutas.get(8), misTripulaciones.get(2), misAeronaves.get(2));
		Vuelo vuelo10 = new Vuelo("10", "28/02/2019", "16:10", "3", misRutas.get(9), misTripulaciones.get(3), misAeronaves.get(3));
		Vuelo vuelo11 = new Vuelo("11", "05/02/2019", "20:15", "3", misRutas.get(10), misTripulaciones.get(4), misAeronaves.get(4));
		Vuelo vuelo12 = new Vuelo("12", "06/01/2019", "20:40", "3", misRutas.get(11), misTripulaciones.get(5), misAeronaves.get(5));
		
		List<Vuelo> misVuelos = new ArrayList<>();
		
		misVuelos.add(vuelo01);		misVuelos.add(vuelo02);
		misVuelos.add(vuelo03);		misVuelos.add(vuelo04);
		misVuelos.add(vuelo05);		misVuelos.add(vuelo06);
		misVuelos.add(vuelo07);		misVuelos.add(vuelo08);
		misVuelos.add(vuelo09);		misVuelos.add(vuelo10);
		misVuelos.add(vuelo11);		misVuelos.add(vuelo12);
		
		aerolinea.setMisVuelos(misVuelos);
	}

	

	public void crearMisTripulaciones() {
		
		List<Tripulante> misTripulantes = aerolinea.getMisTripulantes();
		
		List<Tripulante> pilotos = new ArrayList<>();
		List<Tripulante> copilotos = new ArrayList<>();
		List<Tripulante> auxiliares = new ArrayList<>();
		
		for (int i = 0; i < misTripulantes.size(); i++) {
			String tripulante = misTripulantes.get(i).getAtributos().get("Cargo");
			switch (tripulante) {
			case "piloto":		pilotos.add(misTripulantes.get(i));		break;
			case "copiloto":	copilotos.add(misTripulantes.get(i));	break;
			case "auxiliar":	auxiliares.add(misTripulantes.get(i));	break;
			default: System.out.println("ERROR, en identificar tipo de tripulante");	break;
			}
		}
		
		List<Tripulante> nacional1 = new ArrayList<>();
		nacional1.add(auxiliares.get(3));
		nacional1.add(auxiliares.get(4));
		nacional1.add(auxiliares.get(5));
		
		List<Tripulante> nacional2 = new ArrayList<>();
		nacional2.add(auxiliares.get(0));
		nacional2.add(auxiliares.get(1));
		nacional2.add(auxiliares.get(2));
		
		List<Tripulante> internacional1 = new ArrayList<>();
		internacional1.add(auxiliares.get(0));
		internacional1.add(auxiliares.get(1));
		internacional1.add(auxiliares.get(2));
		internacional1.add(auxiliares.get(3));
		internacional1.add(auxiliares.get(4));
		internacional1.add(auxiliares.get(5));
		internacional1.add(auxiliares.get(6));
		
		List<Tripulante> internacional2 = new ArrayList<>();
		internacional2.add(auxiliares.get(7));
		internacional2.add(auxiliares.get(8));
		internacional2.add(auxiliares.get(9));
		internacional2.add(auxiliares.get(10));
		internacional2.add(auxiliares.get(11));
		internacional2.add(auxiliares.get(12));
		internacional2.add(auxiliares.get(13));
		
		Tripulacion tripulacion1 = new Tripulacion("1", pilotos.get(0), copilotos.get(0), nacional1, "Nacional");
		Tripulacion tripulacion2 = new Tripulacion("2", pilotos.get(1), copilotos.get(1), nacional2, "Nacional");
		Tripulacion tripulacion3 = new Tripulacion("3", pilotos.get(0), copilotos.get(1), internacional1, "Internacional");
		Tripulacion tripulacion4 = new Tripulacion("4", pilotos.get(1), copilotos.get(0), internacional2, "Internacional");
		Tripulacion tripulacion5 = new Tripulacion("5", pilotos.get(0), copilotos.get(0), internacional1, "Internacional");
		Tripulacion tripulacion6 = new Tripulacion("6", pilotos.get(1), copilotos.get(1), internacional2, "Internacional");
		
		List<Tripulacion> misTripulaciones = new ArrayList<>();
		
		misTripulaciones.add(tripulacion1);		misTripulaciones.add(tripulacion2);
		misTripulaciones.add(tripulacion3);		misTripulaciones.add(tripulacion4);
		misTripulaciones.add(tripulacion5);		misTripulaciones.add(tripulacion6);
		
		aerolinea.setMisTripulaciones(misTripulaciones);
		
	}
	
	public void crearMisTipoAeronave() {
		
		DistribucionSillas ubicacionSillasAirbus_A320 = new DistribucionSillas(0, 12, 138);
		DistribucionSillas ubicacionSillasAirbus_A330 = new DistribucionSillas(1, 30, 222);
		DistribucionSillas ubicacionSillasBoeing_787 = new DistribucionSillas(2, 28, 222);
		
		TipoAeronave airbus_A320 = new TipoAeronave("air001", "Nacional", "Airbus", "A320",
				"19000 kg", "<html>150 asientos: 12 Ejecutivos" + "<br>" + "138 Economicos</html>", 
				ubicacionSillasAirbus_A320);
		
		TipoAeronave airbus_A330 = new TipoAeronave("air002", "Internacional", "Airbus", "A330",
				"52000 kg", "<html>252 asientos: 30 Ejecutivos" + "<br>" + "222 Economicos</html>",
				ubicacionSillasAirbus_A330);
		
		TipoAeronave boeing_787 = new TipoAeronave("air003", "Internacional", "Boeing", "787",
				"50000 kg", "<html>250 asientos: 28 Ejecutivos" + "<br>" + "222 Economicos</html>",
				ubicacionSillasBoeing_787);
		
		List<TipoAeronave> misTipoAeronave = new ArrayList<>();
		misTipoAeronave.add(airbus_A320);
		misTipoAeronave.add(airbus_A330);
		misTipoAeronave.add(boeing_787);
		
		aerolinea.setMisTipoAeronave(misTipoAeronave);
		
	}
	
	public void crearMisAviones() {
		
		List<TipoAeronave> tipoAeronave = aerolinea.getMisTipoAeronave();
		Aeronave uno = new Aeronave("CMDX", tipoAeronave.get(0), "Av001", true);
		Aeronave dos = new Aeronave("CMDX", tipoAeronave.get(0), "Av002", true);
		Aeronave tres = new Aeronave("CMDX", tipoAeronave.get(1), "Av003", true);
		Aeronave cuatro = new Aeronave("CMDX", tipoAeronave.get(1), "Av004", true);
		Aeronave cinco = new Aeronave("CMDX",  tipoAeronave.get(2), "Av005", true);	
		Aeronave seis = new Aeronave("CMDX", tipoAeronave.get(2), "Av006", true);
		
		List<Aeronave> misAeronaves = new ArrayList<>();
		misAeronaves.add(uno);		misAeronaves.add(dos);
		misAeronaves.add(tres);		misAeronaves.add(cuatro);
		misAeronaves.add(cinco);	misAeronaves.add(seis);
		
		
		aerolinea.setMisAeronaves(misAeronaves);
	}
	
public void crearMisTripulantes() {
		
		List<Tripulante> misTripulantes = new ArrayList<>();
		
		Tripulante tripulante01 = new Tripulante("piloto", "41897", "Carlos Trejos", "<html>Barrio Bosques<br>calle 02 casa 05</html>", "carlost@gmail.com", "03/10/1975", "Curso de aviaci�n");
		Tripulante tripulante02 = new Tripulante("piloto", "51567", "Jhon Castaneda", "<html>Barrio Paz<br>calle 04 casa 51</html>", "jhonc@gmail.com", "13/06/1973", "Curso de aviaci�n");
		Tripulante tripulante03 = new Tripulante("copiloto", "78499", "Jorge Montes", "<html>Barrio Real<br>calle 08 casa 21</html>", "jorgem@gmail.com", "24/06/1984", "Curso de aviaci�n");
		Tripulante tripulante04 = new Tripulante("copiloto", "82355", "Luis Jimenez", "<html>Barrio Rojas<br>calle 05 casa 03</html>", "luisj@gmail.com", "09/04/1985", "Curso de aviaci�n");
		Tripulante tripulante05 = new Tripulante("auxiliar", "26707", "Luisa Belen", "<html>Barrio Randal<br>calle 01 casa 12</html>", "luisab@gmail.com", "22/02/1990", "Curso de azafata");
		Tripulante tripulante06 = new Tripulante("auxiliar", "90131", "Maria Rosales", "<html>Barrio Proveer<br>calle 08 casa 01</html>", "mariar@gmail.com", "12/05/1993", "Curso de azafata");
		Tripulante tripulante07 = new Tripulante("auxiliar", "82336", "Veronica Ruiz", "<html>Barrio Pinos<br>calle 02 casa 10</html>", "veronicar@gmail.com", "01/08/1987", "Curso de azafata");
		Tripulante tripulante08 = new Tripulante("auxiliar", "63247", "Valeria Mendoza", "<html>Barrio Prado<br>calle 23 casa 15</html>", "valentinam@gmail.com", "10/11/1991", "Curso de azafata");
		Tripulante tripulante09 = new Tripulante("auxiliar", "10945", "Ana Maria Lopez", "<html>Barrio Calera<br>calle 23 casa 02</html>", "anamarial@gmail.com", "30/01/1989", "Curso de azafata");
		Tripulante tripulante10 = new Tripulante("auxiliar", "86578", "Alejandra Viera", "<html>Barrio Renacer<br>calle 11 casa 14</html>", "alejandrav@gmail.com", "20/03/1982", "Curso de azafata");
		Tripulante tripulante11 = new Tripulante("auxiliar", "13456", "Esperanza Loaiza", "<html>Barrio Cruzada<br>calle 20 casa 17</html>", "esperanzal@gmail.com", "29/07/1991", "Curso de azafata");
		Tripulante tripulante12 = new Tripulante("auxiliar", "19832", "Amalia Vera", "<html>Barrio Primavera<br>calle 02 casa 12</html>", "amaliav@gmail.com", "15/07/1992", "Curso de azafata");
		Tripulante tripulante13 = new Tripulante("auxiliar", "80931", "Mariana Ross", "<html>Barrio Sol<br>calle 08 casa 03</html>", "marianar@gmail.com", "01/06/1993", "Curso de azafata");
		Tripulante tripulante14 = new Tripulante("auxiliar", "81498", "Linda Rojas", "<html>Barrio Boreal<br>calle 02 casa 18</html>", "lindar@gmail.com", "11/04/1987", "Curso de azafata");
		Tripulante tripulante15 = new Tripulante("auxiliar", "63125", "Valery Espitia", "<html>Barrio Cocora<br>calle 12 casa 15</html>", "valerye@gmail.com", "16/01/1991", "Curso de azafata");
		Tripulante tripulante16 = new Tripulante("auxiliar", "19868", "Ana Marcela Luz", "<html>Barrio Canada<br>calle 32 casa 12</html>", "anamarcelal@gmail.com", "08/09/1989", "Curso de azafata");
		Tripulante tripulante17 = new Tripulante("auxiliar", "88653", "Alejandra Cortes", "<html>Barrio Villa<br>calle 15 casa 43</html>", "alejandrac@gmail.com", "02/07/1982", "Curso de azafata");
		Tripulante tripulante18 = new Tripulante("auxiliar", "13646", "Lucia Tejada", "<html>Barrio Hore calle<br>25 casa 66</html>", "luciat@gmail.com", "30/12/1991", "Curso de azafata");

		misTripulantes.add(tripulante01);	misTripulantes.add(tripulante02);
		misTripulantes.add(tripulante03);	misTripulantes.add(tripulante04);
		misTripulantes.add(tripulante05);	misTripulantes.add(tripulante06);
		misTripulantes.add(tripulante07);	misTripulantes.add(tripulante08);
		misTripulantes.add(tripulante09);	misTripulantes.add(tripulante10);
		misTripulantes.add(tripulante11);	misTripulantes.add(tripulante12);
		misTripulantes.add(tripulante13);	misTripulantes.add(tripulante14);
		misTripulantes.add(tripulante15);	misTripulantes.add(tripulante16);
		misTripulantes.add(tripulante17);	misTripulantes.add(tripulante18);
		
		aerolinea.setMisTripulantes(misTripulantes);
	
	}
	
	public void crearMisClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente c1 = new Cliente("12345678", "Andres", "Garcia", "Mz 20 # 10", "andres@gmail.com", "14/12/1990");
		Cliente c2 = new Cliente("1234132342", "Julio", "Padilla", "Torre Alhambra", "julio@gmail.com", "10/10/1989");
		Cliente c3 = new Cliente("679567956", "Juan", "Ariza", "Armenia", "ja@gmail.com", "29/11/1993");
		Cliente c4 = new Cliente("568456755", "Fernando", "Cortazar", "Cali", "fercor@gmail.com", "01/09/1970");
		Cliente c5 = new Cliente("434566342", "Angela", "Rios", "Bogotá", "angela@gmail.com", "12/12/1976");
		Cliente c6 = new Cliente("345645684", "Luis", "Ramirez", "Cra 25 # 2 1", "luis@gmail.com", "16/10/1999");
		Cliente c7 = new Cliente("547563468", "Santiago", "Gonzales", "Tolima", "santi@gmail.com", "13/05/1990");
		Cliente c8 = new Cliente("54763425", "Jorge", "Arias", "Bogotá", "jorAr@gmail.com", "04/02/1960");
		Cliente c9 = new Cliente("87654321", "Jhon", "Perez", "Pereira", "jperez@gmail.com", "17/12/1950");
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		clientes.add(c5);
		clientes.add(c6);
		clientes.add(c7);
		clientes.add(c8);
		clientes.add(c9);
		
		aerolinea.setMisClientes(clientes);
	}
	
	public void crearTarjetasClientes() {
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		Tarjeta t1 = new Tarjeta("debito",5000000,"12345678", "12345678000","10/10","000");
		Tarjeta t2 = new Tarjeta("debito", 10000, "87654321","87654321000","10/10","000");
		Tarjeta t3 = new Tarjeta("credito", 1239821, "12345","12345000","10/10","000");
		Tarjeta t4 = new Tarjeta("debito",12412 , "1234","1234000","10/10","000");
		Tarjeta t5 = new Tarjeta("credito",1234123 , "123","123000","10/10","000");
		Tarjeta t6 = new Tarjeta("debito",436545 , "12","12000","10/10","000");
		
				
		tarjetas.add(t1);
		tarjetas.add(t2);
		tarjetas.add(t3);
		tarjetas.add(t4);
		tarjetas.add(t5);
		tarjetas.add(t6);
		
		System.out.println("crearTarjetas clien " + tarjetas.size() );
		aerolinea.setMisTarjetas(tarjetas);
		
	}
	
	public void crearMisTiquetes() {
		List<Tiquete> misTiquetes = new ArrayList<>();
		
		List<Maleta> m = new ArrayList<Maleta>();
		
		Maleta m1= new Maleta("10-10-12", 20);
		Maleta m2= new Maleta("10-22-12", 10);
		m.add(m1);
		m.add(m2);
		
		Tiquete tiq = new Tiquete("12345678","ecomomica",aerolinea.getMisVuelos().get(1),aerolinea.getMisVuelos().get(7),m,1300000);
		misTiquetes.add(tiq);
		
		
		aerolinea.setMisTiquetes(misTiquetes);
		
	}
	
	
	
}
