package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EmbarqueLogica.Embarque;
import mundo.CaribeAirlines;

public class VentanaEquipaje extends JFrame {

	private JPanel contentPane;
	private JInternalFrame ventanaEncolar, ventanaMantenimiento, ventanaAsignarMaletas, ventanaEmbarqueAvion;

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
		setBounds(0, 0, 1400, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Embarque miEmbarque = new Embarque((new Date()).toString());

		ventanaEmbarqueAvion = new EmbarqueAvion(this);
		ventanaEmbarqueAvion.setVisible(true);
		contentPane.add(ventanaEmbarqueAvion);
		
		ventanaEncolar = new EncolarCarros(this);
		ventanaEncolar.setVisible(true);
		contentPane.add(ventanaEncolar);

		ventanaMantenimiento = new Mantenimiento(this);
		ventanaMantenimiento.setVisible(true);
		contentPane.add(ventanaMantenimiento);

		ventanaAsignarMaletas = new AsignarMaletas(this);
		ventanaAsignarMaletas.setVisible(true);
		contentPane.add(ventanaAsignarMaletas);
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

	public JInternalFrame getVentanaAsignarMaletas() {
		return ventanaAsignarMaletas;
	}

	public void setVentanaAsignarMaletas(JInternalFrame ventanaAsignarMaletas) {
		this.ventanaAsignarMaletas = ventanaAsignarMaletas;
	}

}
