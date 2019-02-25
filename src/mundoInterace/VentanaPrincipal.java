package mundoInterace;

import java.awt.EventQueue;

import javax.swing.JFrame;

import VentaInterface.VentanaCompra;
import equipajeInterface.VentanaEquipaje;
import mundo.CaribeAirlines;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaPrincipal implements ActionListener{

	private JFrame frame;
	private JButton btnAdministrador,btnCliente,btnConsultas,btnEmbarqueEquipaje  ;
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
	 * @throws Exception 
	 */
	public VentanaPrincipal() throws Exception {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 524);
		frame.getContentPane().setLayout(null);
		
		aerolinea = new CaribeAirlines();
		ImageIcon imagen = new ImageIcon("images/logo.jpg");
		File a = new File("src/images/logop.jpg");
		String arc = a.getAbsolutePath();
		System.out.println(arc);
		
		JLabel n = new JLabel(new ImageIcon(arc));
		n.setBounds(12, 12, 976, 398);
		frame.getContentPane().add(n);
		
		
		btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.setBounds(69, 422, 214, 43);
		btnAdministrador.addActionListener(this);
		frame.getContentPane().add(btnAdministrador);
		
		btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(this);
		btnCliente.setBounds(519, 422, 214, 43);
		frame.getContentPane().add(btnCliente);
		
		btnConsultas = new JButton("CONSULTAS");
		btnConsultas.setBounds(745, 422, 214, 43);
		btnConsultas.addActionListener(this);
		frame.getContentPane().add(btnConsultas);
		
		btnEmbarqueEquipaje = new JButton("EMBARQUE  EQUIPAJE\n");
		btnEmbarqueEquipaje.setBounds(295, 422, 214, 43);
		btnEmbarqueEquipaje.addActionListener(this);
		frame.getContentPane().add(btnEmbarqueEquipaje);
		
		
		
		
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
		
		if (e.getSource()==btnConsultas) {
			VentanaConsultas vc = new VentanaConsultas(aerolinea);
		}
		if (e.getSource() == btnEmbarqueEquipaje) {
			VentanaEquipaje ve = new VentanaEquipaje();
			ve.setVisible(true);
		}
		
	}
}
