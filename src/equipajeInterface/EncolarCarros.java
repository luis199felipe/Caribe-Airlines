package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mundo.CaribeAirlines;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EncolarCarros extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tablaColaCarros, tablaCarrosEspera;
	private JButton btnAsignar, btnAgregar;
	private JComboBox comboBoxAgregarCarro;
	
	private VentanaEquipaje miVentanaEquipaje;

	private static final int X = 10;
	private static final int WIDTH = 660;

	public EncolarCarros(VentanaEquipaje miVentanaEquipaje) {
		this.miVentanaEquipaje = miVentanaEquipaje;
		setTitle("Cola de Carros");
		setBounds(0, 0, 700, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tablaColaCarros = new JTable();
		tablaColaCarros.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09", "pos 08",
				"pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		tablaColaCarros.setEnabled(false);
		tablaColaCarros.setRowHeight(29);
		tablaColaCarros.setBounds(X, 11, WIDTH, 28);
		contentPane.add(tablaColaCarros);

		tablaCarrosEspera = new JTable();
		tablaCarrosEspera.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09", "pos 08",
				"pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		tablaCarrosEspera.setEnabled(false);
		tablaCarrosEspera.setRowHeight(29);
		tablaCarrosEspera.setBounds(X, 84, WIDTH, 84);
		contentPane.add(tablaCarrosEspera);

		comboBoxAgregarCarro = new JComboBox();
		comboBoxAgregarCarro.setBounds(10, 50, 90, 23);
		contentPane.add(comboBoxAgregarCarro);

		btnAsignar = new JButton("Asignar equipaje");
		btnAsignar.addActionListener(this);
		btnAsignar.setBounds(535, 50, 135, 23);
		contentPane.add(btnAsignar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(110, 50, 90, 23);
		contentPane.add(btnAgregar);

		llenarTablaColaCarros();
		llenarTablaCarrosEspera();
		llenarComboBoxCarros();

	}

	public void llenarComboBoxCarros() {

		// String CarrosDisponibles[] = obtenercarros();
		for (int i = 0; i < 10; i++) { // i < CarrosDisponibles.length
			comboBoxAgregarCarro.addItem(i); // carrosDisponibles[i]
		}
	}

	public void llenarTablaCarrosEspera() {

		DefaultTableModel modeloCarrosEspera = (DefaultTableModel) tablaCarrosEspera.getModel();

		// String carrosEspera[] = obtenerCarros();
		int rowEspera = 3; // Math.ceil(carroEspera.length/10.0);
		int posEspera = 0;
		modeloCarrosEspera.setRowCount(rowEspera);
		for (int i = 0; i < tablaCarrosEspera.getRowCount(); i++) {
			for (int j = 0; j < tablaCarrosEspera.getColumnCount(); j++) {
				if (16 > posEspera) { // carrosEspera.length > posEspera
					tablaCarrosEspera.setValueAt(posEspera, i, j); // carros[posEspera];
					posEspera++;
				}
			}
		}
	}

	public void llenarTablaColaCarros() {
		DefaultTableModel modeloCarros = (DefaultTableModel) tablaColaCarros.getModel();
		modeloCarros.setRowCount(1);

		// String carros[] = obtenerCarros();
		int posCarros = 0;
		for (int i = tablaColaCarros.getColumnCount() - 1; i >= 0; i--) {
			if (5 > posCarros) { // carros.length > pos
				tablaColaCarros.setValueAt(posCarros, 0, i); // carros[pos];
				posCarros++;
			}
		}

		tablaColaCarros.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int column = tablaColaCarros.columnAtPoint(e.getPoint());
				int pos = tablaColaCarros.getColumnCount() - 1 - column;
				String carro = String.valueOf(tablaColaCarros.getValueAt(0, column));
				if(!carro.equals("null")) {
					int confirmacion = JOptionPane.showConfirmDialog(null, "Desea enviar el carro "+ carro +" a mantenimiento");
					if(confirmacion == 0) {
						System.out.println("entro");
						miVentanaEquipaje.getVentanaMantenimiento().setVisible(true);
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese un carro, selecciono un lugar vacio");
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			// String carrosEncolados[] = obtenerCarros();
			// (carrosEncolados.legth < 10)
			if (true) { // se envia a tablaColaCarros

				// Agregar a carros[] en la logica getcarros(comboBox.getItem);
				// Eliminar carro agregado del carrosDisponibles[] en la logica de carros
				// setCarros();

				comboBoxAgregarCarro.removeAllItems();

				llenarTablaColaCarros();
				llenarComboBoxCarros();

			} else { // se envia a tablaCarrosEspera

				// Agregar a carros[] en la logica getcarros(comboBox.getItem);
				// Eliminar carro agregado del carrosDisponibles[] en la logica de carros
				// setCarros();

				comboBoxAgregarCarro.removeAllItems();

				llenarTablaCarrosEspera();
				llenarComboBoxCarros();

			}
		}
		if (e.getSource() == btnAsignar) {

		}
	}
}
