package mundo;

import java.util.ArrayList;
import java.util.List;

import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;
import aeronavesData.DatosAeronave;
import rutaData.DatosRuta;
import rutaLogica.Ruta;
import rutaLogica.Tripulacion;
import rutaLogica.Tripulante;

public class Origen {
	
	public Origen() {
		
	}
	public void crearMisRutas(List<Ruta> misRutas,DatosRuta datosRuta, List<TipoAeronave> misAeronaves) {
		
		Tripulante piloto1 = new Tripulante("piloto", "41897", "Carlos Trejos", "Barrio esmeralda calle 2 casa 5", "carlost@gmail.com", "03/10/1975", "Curso de aviación");
		Tripulante piloto2 = new Tripulante("piloto", "51567", "Jhon Castañeda", "Barrio Paz calle 4 casa 51", "jhonc@gmail.com", "13/06/1973", "Curso de aviación");
		Tripulante copiloto1 = new Tripulante("copiloto", "7899", "Jorge Montes", "Barrio Real calle 8 casa 21", "jorgem@gmail.com", "24/06/1984", "Curso de aviación");
		Tripulante copiloto2 = new Tripulante("copiloto", "8239", "Luis Jimenez", "Barrio Rojas calle 5 casa 3", "luisj@gmail.com", "09/04/1985", "Curso de aviación");
		Tripulante aux1 = new Tripulante("auxiliar", "26707", "Luisa Belen", "Barrio Randal calle 1 casa 12", "luisab@gmail.com", "22/02/1990", "Curso de azafata");
		Tripulante aux2 = new Tripulante("auxiliar", "90131", "Maria Rosales", "Barrio Proveer calle 8 casa 1", "mariar@gmail.com", "12/05/1993", "Curso de azafata");
		Tripulante aux3 = new Tripulante("auxiliar", "82336", "Veronica Ruiz", "Barrio Pinos calle 2 casa 10", "veronicar@gmail.com", "01/08/1987", "Curso de azafata");
		Tripulante aux4 = new Tripulante("auxiliar", "63247", "Valeria Mendoza", "Barrio Prado calle 23 casa 15", "valentinam@gmail.com", "10/11/1991", "Curso de azafata");
		Tripulante aux5 = new Tripulante("auxiliar", "10945", "Ana Lopez", "Barrio calera calle 23 casa 2", "lopeza@gmail.com", "30/01/1989", "Curso de azafata");
		Tripulante aux6 = new Tripulante("auxiliar", "86578", "Alejandra Viera", "Barrio Renacer calle 11 casa 14", "alejandrav@gmail.com", "20/03/1982", "Curso de azafata");
		Tripulante aux7 = new Tripulante("auxiliar", "13456", "Esperanza Loaiza", "Barrio Cruzada calle 20 casa 17", "esperanzal@gmail.com", "29/07/1991", "Curso de azafata");

		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Aeronave miAeronave1 = misAeronaves.get(0).getFlotaDeAeronaves().get(0);
		Aeronave miAeronave2 = misAeronaves.get(0).getFlotaDeAeronaves().get(1);
		
		List<Tripulante> auxiliares1 = new ArrayList<>();
		auxiliares1.add(aux1);
		auxiliares1.add(aux2);
		auxiliares1.add(aux3);
		
		List<Tripulante> auxiliares2 = new ArrayList<>();
		auxiliares2.add(aux4);
		auxiliares2.add(aux5);
		auxiliares2.add(aux6);
		
		Tripulacion miTripulacion1 = new Tripulacion(piloto1, copiloto1, auxiliares1);
		Tripulacion miTripulacion2 = new Tripulacion(piloto2, copiloto2, auxiliares2);
		
		Ruta ruta1 = new Ruta("01/01/2019", "CDMX", "Monterrey", "Ida", "2:45", "6:00", "8:45", "3", miTripulacion1, miAeronave1);
		Ruta ruta2 = new Ruta("01/01/2019", "Monterrey", "CDMX", "Regreso", "2:45", "11:45", "14:30", "3", miTripulacion1, miAeronave1);
		Ruta ruta3 = new Ruta("02/01/2019", "CDMX", "Cancun", "Ida", "3:12", "8:00", "11:12", "3", miTripulacion2, miAeronave2);
		Ruta ruta4 = new Ruta("02/01/2019", "Cancun", "CDMX", "Regreso", "3:12", "14:12", "17:24", "3", miTripulacion2, miAeronave2);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Aeronave miAeronave3 = misAeronaves.get(1).getFlotaDeAeronaves().get(0);
		Aeronave miAeronave4 = misAeronaves.get(1).getFlotaDeAeronaves().get(1);
		
		List<Tripulante> auxiliares3 = new ArrayList<>();
		auxiliares3.add(aux1);
		auxiliares3.add(aux2);
		auxiliares3.add(aux3);
		auxiliares3.add(aux4);
		auxiliares3.add(aux5);
		auxiliares3.add(aux6);
		auxiliares3.add(aux7);
		
		Tripulacion miTripulacion3 = new Tripulacion(piloto1, copiloto1, auxiliares3);
		Tripulacion miTripulacion4 = new Tripulacion(piloto2, copiloto2, auxiliares3);
		
		Ruta ruta5 = new Ruta("03/01/2019", "CDMX", "BuenosAires", "Ida", "9:05", "23:30", "8:35", "3", miTripulacion3, miAeronave3);
		Ruta ruta6 = new Ruta("04/01/2019", "BuenosAires", "CDMX", "Regreso", "9:05", "11:35", "20:40", "3", miTripulacion3, miAeronave3);
		Ruta ruta7 = new Ruta("05/01/2019", "CDMX", "LosAngeles", "Ida", "3:25", "9:45", "13:10", "3", miTripulacion4, miAeronave4);
		Ruta ruta8 = new Ruta("05/01/2019", "LosAngeles", "CDMX", "Regreso", "3:25", "16:10", "19:35", "3", miTripulacion4, miAeronave4);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Aeronave miAeronave5 = misAeronaves.get(2).getFlotaDeAeronaves().get(0);
		Aeronave miAeronave6 = misAeronaves.get(2).getFlotaDeAeronaves().get(1);
		
		Tripulacion miTripulacion5 = new Tripulacion(piloto2, copiloto1, auxiliares3);
		Tripulacion miTripulacion6 = new Tripulacion(piloto1, copiloto2, auxiliares3);
		
		Ruta ruta9 = new Ruta("06/01/2019", "CDMX", "Bogota", "Ida", "3:45", "13:30", "17:15", "3", miTripulacion5, miAeronave3);
		Ruta ruta10 = new Ruta("06/01/2019", "Bogota", "CDMX", "Regreso", "3:45", "20:15", "00:00", "3", miTripulacion5, miAeronave3);
		Ruta ruta11 = new Ruta("06/01/2019", "CDMX", "Panama", "Ida", "2:55", "14:45", "17:40", "3", miTripulacion6, miAeronave4);
		Ruta ruta12 = new Ruta("06/01/2019", "Panama", "CDMX", "Regreso", "2:55", "20:40", "23:35", "3", miTripulacion6, miAeronave4);
		
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
		datosRuta.serializacionOut(misRutas);
	}
	public void crearMisAviones(List<TipoAeronave> misAeronaves,DatosAeronave datosAeronaves) {
		
		Aeronave uno = new Aeronave("CMDX", "air001", "Av001", "", true);
		Aeronave dos = new Aeronave("CMDX", "air001", "Av002", "", true);
		
		List<Aeronave> flotaDeAeronavesAirbus_A320 = new ArrayList<>();
		flotaDeAeronavesAirbus_A320.add(uno);
		flotaDeAeronavesAirbus_A320.add(dos);
		
		DistribucionSillas ubicacionSillasAirbus_A320 = new DistribucionSillas(0, 12, 138);
		
		TipoAeronave Airbus_A320 = new TipoAeronave("air001", "Nacional", "Airbus", "A320",
				"19000 kg", "<html>150 asientos: 12 Ejecutivos" + "<br>" + "138 Economicos</html>",
				flotaDeAeronavesAirbus_A320, ubicacionSillasAirbus_A320);
	
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		Aeronave tres = new Aeronave("CMDX", "air002", "Av003", "", true);
		Aeronave cuatro = new Aeronave("CMDX", "air002", "Av004", "", true);
		
		List<Aeronave> flotaDeAeronavesAirbus_A330 = new ArrayList<>();
		flotaDeAeronavesAirbus_A330.add(tres);
		flotaDeAeronavesAirbus_A330.add(cuatro);
		
		DistribucionSillas ubicacionSillasAirbus_A330 = new DistribucionSillas(1, 30, 222);
		
		TipoAeronave Airbus_A330 = new TipoAeronave("air002", "Internacional", "Airbus", "A330",
				"52000 kg", "<html>252 asientos: 30 Ejecutivos" + "<br>" + "222 Economicos</html>",
				flotaDeAeronavesAirbus_A330, ubicacionSillasAirbus_A330);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
	
		Aeronave cinco = new Aeronave("CMDX", "air003", "Av005", "", true);	
		Aeronave seis = new Aeronave("CMDX", "air003", "Av006", "", true);
		
		List<Aeronave> flotaDeAeronavesBoeing_787 = new ArrayList<>();
		flotaDeAeronavesBoeing_787.add(cinco);
		flotaDeAeronavesBoeing_787.add(seis);
		
		DistribucionSillas ubicacionSillasBoeing_787 = new DistribucionSillas(2, 28, 222);
		
		TipoAeronave Boeing_787 = new TipoAeronave("air003", "Internacional", "Boeing", "787",
				"50000 kg", "<html>250 asientos: 28 Ejecutivos" + "<br>" + "222 Economicos</html>",
				flotaDeAeronavesBoeing_787, ubicacionSillasBoeing_787);

		/////////////////////////////////////////////////////////////////////////////////////////////
		
		misAeronaves.add(Airbus_A320);
		misAeronaves.add(Airbus_A330);
		misAeronaves.add(Boeing_787);
		
		datosAeronaves.serializacionOut(misAeronaves);
		
	}
}
