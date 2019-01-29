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

public class Origen {
	private CaribeAirlines aerolinea;
	
	public Origen(CaribeAirlines aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	public void RegistroRutas () {
		
		List<Aeronave> misAeronaves = aerolinea.getMisAeronaves();
		List<Ruta> misRutas = aerolinea.getMisRutas();
		
		for (int i = 0; i < misAeronaves.size(); i++) {
			String matriculaAeronave = misAeronaves.get(i).getMatricula();
			for (int k = 0; k < misRutas.size(); k++) {
				String matriculaRutaAeronave = misRutas.get(k).getMiAeronave().getMatricula();
				if(matriculaAeronave.equals(matriculaRutaAeronave)) {
					misAeronaves.get(i).getRegistro().add(misRutas.get(k));
				}
			}
		}
			
		aerolinea.setMisAeronaves(misAeronaves);
		
	}
	
	public void crearMisRutas() {
		
		List<Aeronave> misAeronaves = aerolinea.getMisAeronaves();
		
		List<Tripulacion> misTripulaciones = aerolinea.getMisTripulaciones();
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Ruta ruta1 = new Ruta("01/01/2019", "CDMX", "Monterrey", "Ida", "2:45", "6:00", "8:45", "3", "Nacional", misTripulaciones.get(0), misAeronaves.get(0));
		Ruta ruta2 = new Ruta("01/01/2019", "Monterrey", "CDMX", "Regreso", "2:45", "11:45", "14:30", "3", "Nacional", misTripulaciones.get(0), misAeronaves.get(0));
		Ruta ruta3 = new Ruta("02/01/2019", "CDMX", "Cancun", "Ida", "3:12", "8:00", "11:12", "3", "Nacional", misTripulaciones.get(1), misAeronaves.get(1));
		Ruta ruta4 = new Ruta("02/01/2019", "Cancun", "CDMX", "Regreso", "3:12", "14:12", "17:24", "3", "Nacional", misTripulaciones.get(1), misAeronaves.get(1));
		Ruta ruta13 = new Ruta("03/01/2019", "CDMX", "Monterrey", "Ida", "2:45", "6:00", "8:45", "3", "Nacional", misTripulaciones.get(0), misAeronaves.get(1));
		Ruta ruta14 = new Ruta("03/01/2019", "Monterrey", "CDMX", "Regreso", "2:45", "11:45", "14:30", "3", "Nacional", misTripulaciones.get(0), misAeronaves.get(1));
		Ruta ruta15 = new Ruta("04/01/2019", "CDMX", "Cancun", "Ida", "3:12", "8:00", "11:12", "3", "Nacional", misTripulaciones.get(1), misAeronaves.get(0));
		Ruta ruta16 = new Ruta("04/01/2019", "Cancun", "CDMX", "Regreso", "3:12", "14:12", "17:24", "3", "Nacional", misTripulaciones.get(1), misAeronaves.get(0));
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Ruta ruta5 = new Ruta("03/01/2019", "CDMX", "BuenosAires", "Ida", "9:05", "23:30", "8:35", "3", "Internacional", misTripulaciones.get(2), misAeronaves.get(2));
		Ruta ruta6 = new Ruta("04/01/2019", "BuenosAires", "CDMX", "Regreso", "9:05", "11:35", "20:40", "3", "Internacional", misTripulaciones.get(2), misAeronaves.get(2));
		Ruta ruta7 = new Ruta("05/01/2019", "CDMX", "LosAngeles", "Ida", "3:25", "9:45", "13:10", "3", "Internacional", misTripulaciones.get(3), misAeronaves.get(3));
		Ruta ruta8 = new Ruta("05/01/2019", "LosAngeles", "CDMX", "Regreso", "3:25", "16:10", "19:35", "3", "Internacional", misTripulaciones.get(3), misAeronaves.get(3));
		Ruta ruta17 = new Ruta("06/01/2019", "CDMX", "BuenosAires", "Ida", "9:05", "23:30", "8:35", "3", "Internacional", misTripulaciones.get(2), misAeronaves.get(3));
		Ruta ruta18 = new Ruta("06/01/2019", "BuenosAires", "CDMX", "Regreso", "9:05", "11:35", "20:40", "3", "Internacional", misTripulaciones.get(2), misAeronaves.get(3));
		Ruta ruta19 = new Ruta("07/01/2019", "CDMX", "LosAngeles", "Ida", "3:25", "9:45", "13:10", "3", "Internacional", misTripulaciones.get(3), misAeronaves.get(2));
		Ruta ruta20 = new Ruta("07/01/2019", "LosAngeles", "CDMX", "Regreso", "3:25", "16:10", "19:35", "3", "Internacional", misTripulaciones.get(3), misAeronaves.get(2));
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Ruta ruta9 = new Ruta("06/01/2019", "CDMX", "Bogota", "Ida", "3:45", "13:30", "17:15", "3", "Internacional", misTripulaciones.get(4), misAeronaves.get(4));
		Ruta ruta10 = new Ruta("06/01/2019", "Bogota", "CDMX", "Regreso", "3:45", "20:15", "00:00", "3", "Internacional", misTripulaciones.get(4), misAeronaves.get(4));
		Ruta ruta11 = new Ruta("07/01/2019", "CDMX", "Panama", "Ida", "2:55", "14:45", "17:40", "3", "Internacional", misTripulaciones.get(5), misAeronaves.get(5));
		Ruta ruta12 = new Ruta("07/01/2019", "Panama", "CDMX", "Regreso", "2:55", "20:40", "23:35", "3", "Internacional", misTripulaciones.get(5), misAeronaves.get(5));
		Ruta ruta21 = new Ruta("08/01/2019", "CDMX", "Bogota", "Ida", "3:45", "13:30", "17:15", "3", "Internacional", misTripulaciones.get(4), misAeronaves.get(5));
		Ruta ruta22 = new Ruta("08/01/2019", "Bogota", "CDMX", "Regreso", "3:45", "20:15", "00:00", "3", "Internacional", misTripulaciones.get(4), misAeronaves.get(5));
		Ruta ruta23 = new Ruta("09/01/2019", "CDMX", "Panama", "Ida", "2:55", "14:45", "17:40", "3", "Internacional", misTripulaciones.get(5), misAeronaves.get(4));
		Ruta ruta24 = new Ruta("09/01/2019", "Panama", "CDMX", "Regreso", "2:55", "20:40", "23:35", "3", "Internacional", misTripulaciones.get(5), misAeronaves.get(4));
		
		List<Ruta> misRutas = new ArrayList<>();
		
		misRutas.add(ruta1);
		misRutas.add(ruta2);
		misRutas.add(ruta3);
		misRutas.add(ruta4);
		misRutas.add(ruta5);
		misRutas.add(ruta6);
		misRutas.add(ruta7);
		misRutas.add(ruta8);
		misRutas.add(ruta9);
		misRutas.add(ruta10);
		misRutas.add(ruta11);
		misRutas.add(ruta12);
		misRutas.add(ruta13);
		misRutas.add(ruta14);
		misRutas.add(ruta15);
		misRutas.add(ruta16);
		misRutas.add(ruta17);
		misRutas.add(ruta18);
		misRutas.add(ruta19);
		misRutas.add(ruta20);
		misRutas.add(ruta21);
		misRutas.add(ruta22);
		misRutas.add(ruta23);
		misRutas.add(ruta24);
		
		aerolinea.setMisRutas(misRutas);
		
	}

	public void crearMisTripulantes() {
		
		List<Tripulante> misTripulantes = new ArrayList<>();
		
		Tripulante tripulante1 = new Tripulante("piloto", "41897", "Carlos Trejos", "Barrio Bosques calle 2 casa 5", "carlost@gmail.com", "03/10/1975", "Curso de aviación");
		Tripulante tripulante2 = new Tripulante("piloto", "51567", "Jhon Castañeda", "Barrio Paz calle 4 casa 51", "jhonc@gmail.com", "13/06/1973", "Curso de aviación");
		Tripulante tripulante3 = new Tripulante("copiloto", "7899", "Jorge Montes", "Barrio Real calle 8 casa 21", "jorgem@gmail.com", "24/06/1984", "Curso de aviación");
		Tripulante tripulante4 = new Tripulante("copiloto", "8239", "Luis Jimenez", "Barrio Rojas calle 5 casa 3", "luisj@gmail.com", "09/04/1985", "Curso de aviación");
		Tripulante tripulante5 = new Tripulante("auxiliar", "26707", "Luisa Belen", "Barrio Randal calle 1 casa 12", "luisab@gmail.com", "22/02/1990", "Curso de azafata");
		Tripulante tripulante6 = new Tripulante("auxiliar", "90131", "Maria Rosales", "Barrio Proveer calle 8 casa 1", "mariar@gmail.com", "12/05/1993", "Curso de azafata");
		Tripulante tripulante7 = new Tripulante("auxiliar", "82336", "Veronica Ruiz", "Barrio Pinos calle 2 casa 10", "veronicar@gmail.com", "01/08/1987", "Curso de azafata");
		Tripulante tripulante8 = new Tripulante("auxiliar", "63247", "Valeria Mendoza", "Barrio Prado calle 23 casa 15", "valentinam@gmail.com", "10/11/1991", "Curso de azafata");
		Tripulante tripulante9 = new Tripulante("auxiliar", "10945", "Ana Maria Lopez", "Barrio calera calle 23 casa 2", "anamarial@gmail.com", "30/01/1989", "Curso de azafata");
		Tripulante tripulante10 = new Tripulante("auxiliar", "86578", "Alejandra Viera", "Barrio Renacer calle 11 casa 14", "alejandrav@gmail.com", "20/03/1982", "Curso de azafata");
		Tripulante tripulante11 = new Tripulante("auxiliar", "13456", "Esperanza Loaiza", "Barrio Cruzada calle 20 casa 17", "esperanzal@gmail.com", "29/07/1991", "Curso de azafata");
		Tripulante tripulante12 = new Tripulante("auxiliar", "26707", "Luisa Belen", "Barrio Randal calle 1 casa 12", "luisab@gmail.com", "22/02/1990", "Curso de azafata");
		Tripulante tripulante13 = new Tripulante("auxiliar", "90131", "Maria Rosales", "Barrio Proveer calle 8 casa 1", "mariar@gmail.com", "12/05/1993", "Curso de azafata");
		Tripulante tripulante14 = new Tripulante("auxiliar", "82336", "Veronica Ruiz", "Barrio Pinos calle 2 casa 10", "veronicar@gmail.com", "01/08/1987", "Curso de azafata");
		Tripulante tripulante15 = new Tripulante("auxiliar", "63247", "Valeria Mendoza", "Barrio Prado calle 23 casa 15", "valentinam@gmail.com", "10/11/1991", "Curso de azafata");
		Tripulante tripulante16 = new Tripulante("auxiliar", "10945", "Ana Maria Lopez", "Barrio calera calle 23 casa 2", "anamarial@gmail.com", "30/01/1989", "Curso de azafata");
		Tripulante tripulante17 = new Tripulante("auxiliar", "86578", "Alejandra Viera", "Barrio Renacer calle 11 casa 14", "alejandrav@gmail.com", "20/03/1982", "Curso de azafata");
		Tripulante tripulante18 = new Tripulante("auxiliar", "13456", "Esperanza Loaiza", "Barrio Cruzada calle 20 casa 17", "esperanzal@gmail.com", "29/07/1991", "Curso de azafata");

		misTripulantes.add(tripulante1);	misTripulantes.add(tripulante2);
		misTripulantes.add(tripulante3);	misTripulantes.add(tripulante4);
		misTripulantes.add(tripulante5);	misTripulantes.add(tripulante6);
		misTripulantes.add(tripulante7);	misTripulantes.add(tripulante8);
		misTripulantes.add(tripulante9);	misTripulantes.add(tripulante10);
		misTripulantes.add(tripulante11);	misTripulantes.add(tripulante12);
		misTripulantes.add(tripulante13);	misTripulantes.add(tripulante14);
		misTripulantes.add(tripulante15);	misTripulantes.add(tripulante16);
		misTripulantes.add(tripulante17);	misTripulantes.add(tripulante18);
		
		aerolinea.setMisTripulantes(misTripulantes);
	
	}

	public void crearTripulaciones() {
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
		misTripulaciones.add(tripulacion1);
		misTripulaciones.add(tripulacion2);
		misTripulaciones.add(tripulacion3);
		misTripulaciones.add(tripulacion4);
		misTripulaciones.add(tripulacion5);
		misTripulaciones.add(tripulacion6);
		
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
		misAeronaves.add(uno);
		misAeronaves.add(dos);
		misAeronaves.add(tres);
		misAeronaves.add(cuatro);
		misAeronaves.add(cinco);
		misAeronaves.add(seis);
		
		
		aerolinea.setMisAeronaves(misAeronaves);
	
	}
}
