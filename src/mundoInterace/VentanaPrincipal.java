package mundoInterace;

import java.awt.EventQueue;

import javax.swing.JFrame;

import VentaInterface.VentanaCompra;
import mundo.CaribeAirlines;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaPrincipal implements ActionListener{

	private JFrame frame;
	private JButton btnAdministrador,btnCliente;
	private CaribeAirlines aerolinea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 524);
		frame.getContentPane().setLayout(null);
		
		aerolinea = new CaribeAirlines();
		ImageIcon imagen = new ImageIcon("images/logo.jpg");
		JLabel n = new JLabel(new ImageIcon("/home/pipe/Proyecto/Caribe-Airlines/src/images/logop.jpg"));
		n.setBounds(12, 12, 976, 398);
		frame.getContentPane().add(n);
		
		
		btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.setBounds(297, 403, 214, 43);
		btnAdministrador.addActionListener(this);
		frame.getContentPane().add(btnAdministrador);
		
		btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(this);
		btnCliente.setBounds(524, 403, 214, 43);
		frame.getContentPane().add(btnCliente);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAdministrador) {
			VentanaAdministrador vAdmin = new VentanaAdministrador(aerolinea);
			vAdmin.setVisible(true);
		}
		
		if (e.getSource() == btnCliente) {
			VentanaCompra vCliente = new VentanaCompra(aerolinea);
					}
	}
}
