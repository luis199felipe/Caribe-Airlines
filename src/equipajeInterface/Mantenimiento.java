package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Mantenimiento extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tablaCarrosMovidos, tablaCarrosMantenimiento;
	private JButton btnMover, btnRegresar;

	private VentanaEquipaje miVentanaEquipaje;
	
	private static final int X = 10;
	private static final int WIDTH = 614;

	public Mantenimiento(VentanaEquipaje miVentanaEquipaje) {
		this.miVentanaEquipaje = miVentanaEquipaje;
		setTitle("Manteniento");
		setBounds(700, 0, 650, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tablaCarrosMovidos = new JTable();
		tablaCarrosMovidos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09",
				"pos 08", "pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		tablaCarrosMovidos.setEnabled(false);
		tablaCarrosMovidos.setRowHeight(29);
		tablaCarrosMovidos.setBounds(10, 11, WIDTH, 28);
		contentPane.add(tablaCarrosMovidos);

		tablaCarrosMantenimiento = new JTable();
		tablaCarrosMantenimiento.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09",
				"pos 08", "pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		tablaCarrosMantenimiento.setEnabled(false);
		tablaCarrosMantenimiento.setRowHeight(29);
		tablaCarrosMantenimiento.setBounds(X, 84, WIDTH, 84);
		contentPane.add(tablaCarrosMantenimiento);

		btnMover = new JButton("Mover uno a uno ");
		btnMover.addActionListener(this);
		btnMover.setBounds(10, 50, 170, 23);
		contentPane.add(btnMover);

		btnRegresar = new JButton("Regresar uno a uno ");
		btnRegresar.addActionListener(this);
		btnRegresar.setBounds(384, 50, 240, 23);
		contentPane.add(btnRegresar);
		
		llenarTablaCarrosMovidos();
		//llenarTablaCarrosEnMantenimiento();
	}
	
//	public void llenarTablaCarrosEnMantenimiento() {
//
//		DefaultTableModel modeloCarrosMantenimiento = (DefaultTableModel) tablaCarrosMantenimiento.getModel();
//
//		// String carrosMantenimiento[] = obtenerCarros();
//		int rowEspera = 3; // Math.ceil(carroEspera.length/10.0);
//		int posEspera = 0;
//		modeloCarrosMantenimiento.setRowCount(rowEspera);
//		for (int i = 0; i < tablaCarrosMantenimiento.getRowCount(); i++) {
//			for (int j = 0; j < tablaCarrosMantenimiento.getColumnCount(); j++) {
//				if (16 > posEspera) { // carrosMantenimiento.length > posEspera
//					tablaCarrosMantenimiento.setValueAt(posEspera, i, j); // carrosMantenimiento[posEspera];
//					posEspera++;
//				}
//			}
//		}
//	}

	public void llenarTablaCarrosMovidos() {
		DefaultTableModel modeloCarros = (DefaultTableModel) tablaCarrosMovidos.getModel();
		modeloCarros.setRowCount(1);

		// String carrosMovidos[] = obtenerCarros();
		int posCarros = 0;
		for (int i = tablaCarrosMovidos.getColumnCount() - 1; i >= 0; i--) {
			if (5 > posCarros) { // carrosMovidos.length > pos
				tablaCarrosMovidos.setValueAt(posCarros, 0, i); // carrosMovidos[pos];
				posCarros++;
			}
		}
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
