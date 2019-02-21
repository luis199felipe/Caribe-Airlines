package VentaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import aeronaveInterface.VentanaAeronave;
import mundo.CaribeAirlines;
import vueloLogica.Vuelo;

public class VentanaSilla {

	public JFrame frame;


	public VentanaSilla(CaribeAirlines c) {
		frame = new JFrame();
		CaribeAirlines cb = c;
		
		JInternalFrame ventanaAeronave = new VentanaAeronave(cb);
		ventanaAeronave.setVisible(true);
		frame.getContentPane().add(ventanaAeronave);
		frame.setBounds(100, 100, 426, 614);
		
	}

}
