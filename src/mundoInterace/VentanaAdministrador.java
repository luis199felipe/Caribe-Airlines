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

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;


	public VentanaAdministrador(CaribeAirlines ae) {
		setTitle("Caribe Airlines");
		
		setBounds(0, 0, 800, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame ventanaAeronave = new VentanaAeronave(ae);
		ventanaAeronave.setVisible(true);
		contentPane.add(ventanaAeronave);
		
		JInternalFrame ventanaTripulacion = new VentanaTripulacion();
		ventanaTripulacion.setVisible(true);
		contentPane.add(ventanaTripulacion);
	}
}
