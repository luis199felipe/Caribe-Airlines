package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mundo.CaribeAirlines;

public class AsignarMaletas extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;

	private VentanaEquipaje miVentanaEquipaje; 

	public AsignarMaletas(VentanaEquipaje miVentanaEquipaje) {
		this.miVentanaEquipaje = miVentanaEquipaje;
		
		setTitle("Asignar maletas");
		setBounds(0, 220, 380, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 41, 130, 23);
		contentPane.add(comboBox);

		JButton btnAcceptar = new JButton("Aceptar");
		btnAcceptar.setBounds(273, 41, 80, 23);
		contentPane.add(btnAcceptar);

		JLabel lblSeleccioneElVuelo = new JLabel("Seleccione el vuelo:");
		lblSeleccioneElVuelo.setBounds(12, 45, 144, 14);
		contentPane.add(lblSeleccioneElVuelo);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Maleta", "Peso"
			}
		));
		table.setBounds(10, 108, 343, 264);
		contentPane.add(table);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(133, 74, 130, 23);
		contentPane.add(comboBox_1);

		JButton button = new JButton("+");
		button.setBounds(273, 74, 80, 23);
		contentPane.add(button);

		JLabel lblAgregarMaletas = new JLabel("Agregar maletas:");
		lblAgregarMaletas.setBounds(10, 76, 144, 20);
		contentPane.add(lblAgregarMaletas);

		JLabel lblCarro = new JLabel("Carro #01");
		lblCarro.setBounds(12, 12, 70, 15);
		contentPane.add(lblCarro);
		
		JButton btnEnviarCarro = new JButton("Enviar carro");
		btnEnviarCarro.setBounds(245, 386, 108, 23);
		contentPane.add(btnEnviarCarro);
	}
}
