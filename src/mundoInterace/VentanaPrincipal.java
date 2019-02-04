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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setTitle("Caribe Airlines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame ventanaAeronave = new VentanaAeronave();
		ventanaAeronave.setVisible(true);
		contentPane.add(ventanaAeronave);
		
		JInternalFrame ventanaTripulacion = new VentanaTripulacion();
		ventanaTripulacion.setVisible(true);
		contentPane.add(ventanaTripulacion);
	}
}
