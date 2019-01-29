package mundo;

import java.util.ArrayList;
import java.util.List;

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
		
		misRutas.add(ruta01);	misRutas.add(ruta07);
		misRutas.add(ruta02);	misRutas.add(ruta08);
		misRutas.add(ruta03);	misRutas.add(ruta09);
		misRutas.add(ruta04);	misRutas.add(ruta10);
		misRutas.add(ruta05);	misRutas.add(ruta11);
		misRutas.add(ruta06);	misRutas.add(ruta12);
		
		aerolinea.setMisRutas(misRutas);
	}
	
	public void crearMisVuelos () {
		
		List<Aeronave> misAeronaves = aerolinea.getMisAeronaves();
		List<Tripulacion> misTripulaciones = aerolinea.getMisTripulaciones();
		List<Ruta> misRutas = aerolinea.getMisRutas();
		
		
		 
	}

	public void crearMisTripulantes() {
		
		List<Tripulante> misTripulantes = new ArrayList<>();
		
		Tripulante tripulante01 = new Tripulante("piloto", "41897", "Carlos Trejos", "Barrio Bosques calle 2 casa 5", "carlost@gmail.com", "03/10/1975", "Curso de aviación");
		Tripulante tripulante02 = new Tripulante("piloto", "51567", "Jhon Castañeda", "Barrio Paz calle 4 casa 51", "jhonc@gmail.com", "13/06/1973", "Curso de aviación");
		Tripulante tripulante03 = new Tripulante("copiloto", "7899", "Jorge Montes", "Barrio Real calle 8 casa 21", "jorgem@gmail.com", "24/06/1984", "Curso de aviación");
		Tripulante tripulante04 = new Tripulante("copiloto", "8239", "Luis Jimenez", "Barrio Rojas calle 5 casa 3", "luisj@gmail.com", "09/04/1985", "Curso de aviación");
		Tripulante tripulante05 = new Tripulante("auxiliar", "26707", "Luisa Belen", "Barrio Randal calle 1 casa 12", "luisab@gmail.com", "22/02/1990", "Curso de azafata");
		Tripulante tripulante06 = new Tripulante("auxiliar", "90131", "Maria Rosales", "Barrio Proveer calle 8 casa 1", "mariar@gmail.com", "12/05/1993", "Curso de azafata");
		Tripulante tripulante07 = new Tripulante("auxiliar", "82336", "Veronica Ruiz", "Barrio Pinos calle 2 casa 10", "veronicar@gmail.com", "01/08/1987", "Curso de azafata");
		Tripulante tripulante08 = new Tripulante("auxiliar", "63247", "Valeria Mendoza", "Barrio Prado calle 23 casa 15", "valentinam@gmail.com", "10/11/1991", "Curso de azafata");
		Tripulante tripulante09 = new Tripulante("auxiliar", "10945", "Ana Maria Lopez", "Barrio calera calle 23 casa 2", "anamarial@gmail.com", "30/01/1989", "Curso de azafata");
		Tripulante tripulante10 = new Tripulante("auxiliar", "86578", "Alejandra Viera", "Barrio Renacer calle 11 casa 14", "alejandrav@gmail.com", "20/03/1982", "Curso de azafata");
		Tripulante tripulante11 = new Tripulante("auxiliar", "13456", "Esperanza Loaiza", "Barrio Cruzada calle 20 casa 17", "esperanzal@gmail.com", "29/07/1991", "Curso de azafata");
		Tripulante tripulante12 = new Tripulante("auxiliar", "26707", "Luisa Belen", "Barrio Randal calle 1 casa 12", "luisab@gmail.com", "22/02/1990", "Curso de azafata");
		Tripulante tripulante13 = new Tripulante("auxiliar", "90131", "Maria Rosales", "Barrio Proveer calle 8 casa 1", "mariar@gmail.com", "12/05/1993", "Curso de azafata");
		Tripulante tripulante14 = new Tripulante("auxiliar", "82336", "Veronica Ruiz", "Barrio Pinos calle 2 casa 10", "veronicar@gmail.com", "01/08/1987", "Curso de azafata");
		Tripulante tripulante15 = new Tripulante("auxiliar", "63247", "Valeria Mendoza", "Barrio Prado calle 23 casa 15", "valentinam@gmail.com", "10/11/1991", "Curso de azafata");
		Tripulante tripulante16 = new Tripulante("auxiliar", "10945", "Ana Maria Lopez", "Barrio calera calle 23 casa 2", "anamarial@gmail.com", "30/01/1989", "Curso de azafata");
		Tripulante tripulante17 = new Tripulante("auxiliar", "86578", "Alejandra Viera", "Barrio Renacer calle 11 casa 14", "alejandrav@gmail.com", "20/03/1982", "Curso de azafata");
		Tripulante tripulante18 = new Tripulante("auxiliar", "13456", "Esperanza Loaiza", "Barrio Cruzada calle 20 casa 17", "esperanzal@gmail.com", "29/07/1991", "Curso de azafata");

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

	public void crearMisTripulaciones() {
		
		List<Tripulante> misTripulantes = aerolinea.getMisTripulantes();
		
		List<Tripulante> pilotos = new ArrayList<>();
		List<Tripulante> copilotos = new ArrayList<>();
		List<Tripulante> auxiliares = new ArrayList<>();
		
		for (int i = 0; i < misTripulantes.size(); i++) {
			String tripulante = misTripulantes.get(i).getAtributos().get("Cargo");
			switch (tripulante) {
			case "piloto":	pilotos.add(misTripulantes.get(i));	break;
			case "copiloto":	copilotos.add(misTripulantes.get(i));	break;
			case "auxiliar":	auxiliares.add(misTripulantes.get(i));	break;
			default: System.out.println("ERROR, en identificar tipo de auxiliar");	break;
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
		
		Tripulacion tripulacion1 = new Tripulacion(pilotos.get(0), copilotos.get(0), nacional1, null);
		Tripulacion tripulacion2 = new Tripulacion(pilotos.get(1), copilotos.get(1), nacional2, null);
		Tripulacion tripulacion3 = new Tripulacion(pilotos.get(0), copilotos.get(1), internacional1, null);
		Tripulacion tripulacion4 = new Tripulacion(pilotos.get(1), copilotos.get(0), internacional2, null);
		Tripulacion tripulacion5 = new Tripulacion(pilotos.get(0), copilotos.get(0), internacional1, null);
		Tripulacion tripulacion6 = new Tripulacion(pilotos.get(1), copilotos.get(1), internacional2, null);
		
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
}
