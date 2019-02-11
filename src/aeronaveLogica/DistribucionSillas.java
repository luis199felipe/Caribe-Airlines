package aeronaveLogica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DistribucionSillas implements Serializable{
	private String[][] distribucionEjecutiva;
	private String[][] distribucionEconomica;
	private List<String> numeracionColEjecutiva;
	private List<String> numeracionColEconomica;
	
	//Constructors
	//tipoAeronave:
	//   0 = AirbusA320,	1 = AirbusA330,		2 = Boeing787
	
	public DistribucionSillas(int tipoAeronave,int sillasEjecutiva, int sillasEconomica) {
		distribucionEjecutiva(tipoAeronave, sillasEjecutiva);
		distribucionEconomica(tipoAeronave, sillasEconomica);
	}
	//Methods
	public int numerarColEjecutiva(int tipoAeronave) {
		int espacio = 0;
		numeracionColEjecutiva = new ArrayList<>();
		switch (tipoAeronave) {
		case 0:
			numeracionColEjecutiva.add("A");
			numeracionColEjecutiva.add("C");
			numeracionColEjecutiva.add(" ");
			numeracionColEjecutiva.add("D");
			numeracionColEjecutiva.add("F");
			espacio = 1;
			break;
		case 1:
			numeracionColEjecutiva.add("A");
			numeracionColEjecutiva.add("C");
			numeracionColEjecutiva.add(" ");
			numeracionColEjecutiva.add("D");
			numeracionColEjecutiva.add("F");
			numeracionColEjecutiva.add(" ");
			numeracionColEjecutiva.add("H");
			numeracionColEjecutiva.add("K");
			espacio = 2;
			break;
		case 2:
			numeracionColEjecutiva.add("A");
			numeracionColEjecutiva.add("B");
			numeracionColEjecutiva.add(" ");
			numeracionColEjecutiva.add("D");
			numeracionColEjecutiva.add("E");
			numeracionColEjecutiva.add(" ");
			numeracionColEjecutiva.add("L");
			numeracionColEjecutiva.add("K");
			espacio = 2;
			break;

		default:
			break;
		}
		return espacio;
	}
	
	public int numerarColEconomica(int tipoAeronave) {
		int espacio = 0;
		numeracionColEconomica = new ArrayList<>();
		switch (tipoAeronave) {
		case 0:
			numeracionColEconomica.add("A");
			numeracionColEconomica.add("B");
			numeracionColEconomica.add("C");
			numeracionColEconomica.add(" ");
			numeracionColEconomica.add("D");
			numeracionColEconomica.add("E");
			numeracionColEconomica.add("F");
			espacio = 1;
			break;
		case 1:
			numeracionColEconomica.add("A");
			numeracionColEconomica.add("C");
			numeracionColEconomica.add(" ");
			numeracionColEconomica.add("D");
			numeracionColEconomica.add("E");
			numeracionColEconomica.add("F");
			numeracionColEconomica.add("G");
			numeracionColEconomica.add(" ");
			numeracionColEconomica.add("H");
			numeracionColEconomica.add("K");
			espacio = 2;
			break;
		case 2:
			numeracionColEconomica.add("A");
			numeracionColEconomica.add("B");
			numeracionColEconomica.add("C");
			numeracionColEconomica.add(" ");
			numeracionColEconomica.add("D");
			numeracionColEconomica.add("E");
			numeracionColEconomica.add("F");
			numeracionColEconomica.add(" ");
			numeracionColEconomica.add("J");
			numeracionColEconomica.add("K");
			numeracionColEconomica.add("L");
			espacio = 2;
			break;

		default:
			break;
		}
		return espacio;
	}
	
	public void distribucionEjecutiva(int tipoAeronave, int sillasEjecutiva) {
		
		int contador = 0;
		double espacio = numerarColEjecutiva(tipoAeronave);
		
		int row = (int) Math.ceil(sillasEjecutiva / (numeracionColEjecutiva.size() - espacio));
		int column = numeracionColEjecutiva.size();
		
		distribucionEjecutiva = new String[row][column];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(!numeracionColEjecutiva.get(j).equals(" ") && contador < sillasEjecutiva) {
					distribucionEjecutiva[i][j] = numeracionColEjecutiva.get(j) + (i+1);
					contador++;
				}else {
					distribucionEjecutiva[i][j] = "pasillo";
				}
			}
		}
		
	}
	
	public void distribucionEconomica(int tipoAeronave, int sillasEconomica) {
		
		int contador = 0;
		double espacio = numerarColEconomica(tipoAeronave);
		
		int row = (int) Math.ceil(sillasEconomica / (numeracionColEconomica.size() - espacio));
		int column = numeracionColEconomica.size();
		
		distribucionEconomica = new String[row][column];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(!numeracionColEconomica.get(j).equals(" ") && contador < sillasEconomica) {
					distribucionEconomica[i][j] = numeracionColEconomica.get(j) + (i+1);
					contador++;
				}else {
					distribucionEconomica[i][j] = "pasillo";
				}
			}
		}
		
	}
	
	//Getter & Setter
	public String[][] getDistribucionEjecutiva() {
		return distribucionEjecutiva;
	}
	public void setDistribucionEjecutiva(String[][] distribucionEjecutiva) {
		this.distribucionEjecutiva = distribucionEjecutiva;
	}
	public String[][] getDistribucionEconomica() {
		return distribucionEconomica;
	}
	public void setDistribucionEconomica(String[][] distribucionEconomica) {
		this.distribucionEconomica = distribucionEconomica;
	}
	public List<String> getNumeracionColEjecutiva() {
		return numeracionColEjecutiva;
	}
	public void setNumeracionColEjecutiva(List<String> numeracionColEjecutiva) {
		this.numeracionColEjecutiva = numeracionColEjecutiva;
	}
	public List<String> getNumeracionColEconomica() {
		return numeracionColEconomica;
	}
	public void setNumeracionColEconomica(List<String> numeracionColEconomica) {
		this.numeracionColEconomica = numeracionColEconomica;
	}
}
