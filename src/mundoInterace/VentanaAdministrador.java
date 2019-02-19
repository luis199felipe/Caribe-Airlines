package mundoInterace;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aeronaveInterface.VentanaAeronave;
import mundo.CaribeAirlines;
import tripulacionInterface.VentanaTripulacion;
import vueloInterface.VentanaVuelo;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;


	public VentanaAdministrador(CaribeAirlines miAerolinea) {
		setTitle("Caribe Airlines");
		
		setBounds(0, 0, 1200, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame ventanaAeronave = new VentanaAeronave(miAerolinea);
		ventanaAeronave.setVisible(true);
		contentPane.add(ventanaAeronave);
		
		JInternalFrame ventanaTripulacion = new VentanaTripulacion(miAerolinea);
		ventanaTripulacion.setVisible(true);
		contentPane.add(ventanaTripulacion);
		
		JInternalFrame ventanaVuelo = new VentanaVuelo(miAerolinea);
		ventanaVuelo.setVisible(true);
		contentPane.add(ventanaVuelo);
	}
}
