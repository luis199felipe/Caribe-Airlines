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

import EmbarqueLogica.Embarque;
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
	private JTable tablaColaCarros, tablaCarrosGaraje;
	private JButton btnAgregar;
	private JComboBox comboBoxAgregarCarro;

	private VentanaEquipaje miVentanaEquipaje;
	private Embarque miEmbarque;

	private static final int X = 10;
	private static final int WIDTH = 660;

	public EncolarCarros(VentanaEquipaje miVentanaEquipaje) {
		this.miVentanaEquipaje = miVentanaEquipaje;
		miEmbarque = miVentanaEquipaje.getMiEmbarque();

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

		tablaCarrosGaraje = new JTable();
		tablaCarrosGaraje.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09", "pos 08",
				"pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		tablaCarrosGaraje.setEnabled(false);
		tablaCarrosGaraje.setRowHeight(29);
		tablaCarrosGaraje.setBounds(X, 84, WIDTH, 84);
		contentPane.add(tablaCarrosGaraje);

		comboBoxAgregarCarro = new JComboBox();
		comboBoxAgregarCarro.setBounds(10, 50, 90, 23);
		contentPane.add(comboBoxAgregarCarro);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(110, 50, 167, 23);
		contentPane.add(btnAgregar);

		llenarTablaColaCarros();
		llenarTablaCarrosGaraje();
		llenarComboBoxCarros();

	}

	public void llenarComboBoxCarros() {
		comboBoxAgregarCarro.removeAllItems();
		String CarrosDisponibles[] = miEmbarque.obtenerCarrosGaraje();
		//System.out.println("El tamano es "+CarrosDisponibles.length);
		for (int i = 0; i < CarrosDisponibles.length; i++) { // i < CarrosDisponibles.length
			comboBoxAgregarCarro.addItem( CarrosDisponibles[i]); 
		}
	}

	public void llenarTablaCarrosGaraje() {
		tablaCarrosGaraje.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09", "pos 08",
				"pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		DefaultTableModel modeloCarrosGaraje = (DefaultTableModel) tablaCarrosGaraje.getModel();
		
		String carrosGaraje[] = miEmbarque.obtenerCarrosGaraje();
		int rowEspera = (int) Math.ceil(carrosGaraje.length/10.0);
		int posEspera = 0;
		modeloCarrosGaraje.setRowCount(rowEspera);
		for (int i = 0; i < tablaCarrosGaraje.getRowCount(); i++) {
			for (int j = 0; j < tablaCarrosGaraje.getColumnCount(); j++) {
				if (carrosGaraje.length > posEspera) { // 
					tablaCarrosGaraje.setValueAt(carrosGaraje[posEspera], i, j); // 
					posEspera++;
				}
			}
		}
	}

	public void llenarTablaColaCarros() {
		tablaColaCarros.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "pos 10", "pos 09", "pos 08",
				"pos 07", "pos 06", "pos 05", "pos 04", "pos 03", "pos 02", "pos 01" }));
		DefaultTableModel modeloCarros = (DefaultTableModel) tablaColaCarros.getModel();
		modeloCarros.setRowCount(1);

		String carros[] = miEmbarque.obtenerCarrosEncolados();
	
		int pos = 0;
		for (int i = tablaColaCarros.getColumnCount() - 1; i >= 0  ; i--) {
			if (carros.length > pos) { // carros.length > pos
				tablaColaCarros.setValueAt(carros[pos], 0, i); // carros[pos];
				pos++;
			}
		}

		tablaColaCarros.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int column = tablaColaCarros.columnAtPoint(e.getPoint());
				int pos = tablaColaCarros.getColumnCount() - 1 - column;
				String carro = String.valueOf(tablaColaCarros.getValueAt(0, column));
				if (!carro.equals("null")) {
					int confirmacion = JOptionPane.showConfirmDialog(null,"Desea enviar el carro " + carro + " a mantenimiento");
					if (confirmacion == 0) {						
						miVentanaEquipaje.getVentanaMantenimiento().setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese un carro, selecciono un lugar vacio");
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			String carrosEncolados[] = miEmbarque.obtenerCarrosEncolados();
			// (carrosEncolados.legth < 10)
			if (carrosEncolados.length < 10) { // se envia a tablaColaCarros

				// Agregar a carros[] en la logica getcarros(comboBox.getItem);
				// Eliminar carro agregado del carrosDisponibles[] en la logica de carros
				// setCarros();
				miEmbarque.encolarCarroEmbarque(comboBoxAgregarCarro.getSelectedItem().toString());
				
				llenarTablaColaCarros();
				llenarTablaCarrosGaraje();
				llenarComboBoxCarros();

			} else {

				JOptionPane.showMessageDialog(null,
						"Se lleno la cola de carros, por favor desencole para poder agregar mas.");

			}
		}
		
	}
}
