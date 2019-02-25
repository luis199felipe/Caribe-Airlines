package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EmbarqueAvion extends JInternalFrame {

	private JPanel contentPane;

	private VentanaEquipaje miVentanaEquipaje; 
	private JTable table;
	private JTable table_1;
	
	public EmbarqueAvion(VentanaEquipaje miVentanaEquipaje) {
		this.miVentanaEquipaje = miVentanaEquipaje;
		
		setTitle("Asignar maletas");
		setBounds(380, 220, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 11, 564, 28);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_1.setBounds(10, 65, 310, 344);
		contentPane.add(table_1);
		
		JLabel lblCapacidadDeCarga = new JLabel("Capacidad de carga N");
		lblCapacidadDeCarga.setBounds(348, 112, 179, 14);
		contentPane.add(lblCapacidadDeCarga);
		
		JButton btnDesembarcar = new JButton("Desembarcar");
		btnDesembarcar.setBounds(439, 50, 135, 23);
		contentPane.add(btnDesembarcar);
	}
}
