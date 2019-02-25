package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.CaribeAirlines;

public class VentanaEquipaje extends JFrame {

	private JPanel contentPane;
	private JInternalFrame ventanaEncolar, ventanaMantenimiento;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipaje frame = new VentanaEquipaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaEquipaje() {
		setTitle("Embarque de equipaje");
		setBounds(0, 0, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ventanaEncolar = new EncolarCarros(this);
		ventanaEncolar.setVisible(true);
		contentPane.add(ventanaEncolar);
		
		ventanaMantenimiento = new Mantenimiento(this);
		ventanaMantenimiento.setVisible(false);
		contentPane.add(ventanaMantenimiento);
	}

	public JInternalFrame getVentanaEncolar() {
		return ventanaEncolar;
	}

	public void setVentanaEncolar(JInternalFrame ventanaEncolar) {
		this.ventanaEncolar = ventanaEncolar;
	}

	public JInternalFrame getVentanaMantenimiento() {
		return ventanaMantenimiento;
	}

	public void setVentanaMantenimiento(JInternalFrame ventanaMantenimiento) {
		this.ventanaMantenimiento = ventanaMantenimiento;
	}
	
}
