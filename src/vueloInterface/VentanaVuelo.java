package vueloInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import aeronaveInterface.VentanaAeronave;
import mundo.CaribeAirlines;
import tripulacionLogica.Tripulacion;
import tripulacionLogica.Tripulante;
import vueloLogica.Vuelo;

public class VentanaVuelo extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCrear, btnMasDetalles, btnVolver;
	private JLabel lblRegistro;
	private JTable tablaVuelos, tablaRegistro, tablaMasDetalles;
	private JScrollPane scrollPaneRegistro, scrollPaneMasDetalles;

	private int posOpcion, posRegistro;

	private CaribeAirlines miAerolinea;

	private static final int X = 10;
	private static final int Y = 65;
	private static final int WIDTH_VUElO = 112;
	private static final int WIDTH = 354;
	private static final int HEIGHT = 405;
	private static final int LETRA = 14;
	private static final int LETRA_BUTTON = 10;
	private static final int ROW_HEIGHT = 35;
	private static final int LBL_HEIGHT = 21;

	public VentanaVuelo(CaribeAirlines miAerolinea) {
		
		this.miAerolinea = miAerolinea;

		setTitle("Vuelos");
		setBounds(780, 0, 390, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tablaVuelos = new JTable(1, 2);
		tablaVuelos.setEnabled(false);
		tablaVuelos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaVuelos.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		tablaVuelos.setRowHeight(23);
		tablaVuelos.setBounds(X, 11, WIDTH, 21);

		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);// .LEFT .RIGHT .CENTER

		tablaVuelos.getColumnModel().getColumn(0).setCellRenderer(alinear);
		tablaVuelos.getColumnModel().getColumn(1).setCellRenderer(alinear);

		tablaVuelos.setValueAt("Nacional", 0, 0);
		tablaVuelos.setValueAt("Internacional", 0, 1);

		tablaVuelos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				posRegistro = -1;
				
				int column = tablaVuelos.columnAtPoint(e.getPoint());
				obtenerOpcionTablaPrincipal(column);

				tablaRegistro.setModel(
						new DefaultTableModel(new Object[][] {}, new String[] { "", "Fecha", "Origen", "Destino" }));
				tablaRegistro.getColumnModel().getColumn(0).setPreferredWidth(WIDTH - 3 * WIDTH_VUElO);
				tablaRegistro.getColumnModel().getColumn(1).setPreferredWidth(WIDTH_VUElO);
				tablaRegistro.getColumnModel().getColumn(2).setPreferredWidth(WIDTH_VUElO);
				tablaRegistro.getColumnModel().getColumn(3).setPreferredWidth(WIDTH_VUElO);
				tablaRegistro.setRowHeight(ROW_HEIGHT);

				String[][] datos = new String[0][4];
				datos = miAerolinea.llenarTablaDeDatosVuelo(posOpcion);// 0 nacional 1 internacional

				DefaultTableModel modeloRegistro = (DefaultTableModel) tablaRegistro.getModel();
				modeloRegistro.setRowCount(datos.length);

				for (int i = 0; i < tablaRegistro.getRowCount(); i++) {
					for (int j = 1; j < tablaRegistro.getColumnCount(); j++) {
						tablaRegistro.setValueAt(datos[i][j - 1], i, j);
					}
				}
				
				lblRegistro.setText("Registro de vuelos " + tablaVuelos.getValueAt(0, column) + "es");

				verTablaPrincipal(true);
				verMasDetalles(false);
				verRegistro(true);
			}
		});

		contentPane.add(tablaVuelos);
		
		lblRegistro = new JLabel("");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(10, 38, 354, 21);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblRegistro);

		tablaRegistro = new JTable(0, 3);
		tablaRegistro.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tablaRegistro.setBorder(null);
		tablaRegistro.setEnabled(false);
		tablaRegistro.setShowGrid(true);
		tablaRegistro.setRowHeight(ROW_HEIGHT);
		tablaRegistro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				for (int i = 0; i < tablaRegistro.getRowCount(); i++) {
					tablaRegistro.setValueAt("", i, 0);
				}

				int row = tablaRegistro.rowAtPoint(e.getPoint());
				obtenerPosRegistro(row);

				DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
				alinear.setHorizontalAlignment(SwingConstants.CENTER);// .LEFT .RIGHT .CENTER

				tablaRegistro.getColumnModel().getColumn(0).setCellRenderer(alinear);

				tablaRegistro.setValueAt("*", row, 0);
			}

		});
		

		scrollPaneRegistro = new JScrollPane();
		scrollPaneRegistro.setBounds(X, 65, WIDTH, HEIGHT);
		scrollPaneRegistro.setViewportView(tablaRegistro);
		contentPane.add(scrollPaneRegistro);

		btnMasDetalles = new JButton("mas Detalles");
		btnMasDetalles.addActionListener(this);
		btnMasDetalles.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnMasDetalles.setBounds(251, 477, 113, 23);
		contentPane.add(btnMasDetalles);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnCrear.setBounds(131, 477, 113, 23);
		contentPane.add(btnCrear);
		
		btnVolver = new JButton("volver");
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnVolver.setBounds(251, 477, 113, 23);
		contentPane.add(btnVolver);

		tablaMasDetalles = new JTable(0, 2);
		tablaMasDetalles.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tablaMasDetalles.setBorder(null);
		tablaMasDetalles.setEnabled(false);
		tablaMasDetalles.setRowHeight(ROW_HEIGHT);

		scrollPaneMasDetalles = new JScrollPane();
		scrollPaneMasDetalles.setBounds(X, 65, WIDTH, HEIGHT);
		scrollPaneMasDetalles.setViewportView(tablaMasDetalles);
		contentPane.add(scrollPaneMasDetalles);

		verTablaPrincipal(true);
		verMasDetalles(false);
		verRegistro(false);
	}

	private void obtenerPosRegistro(int row) {
		posRegistro = row;
	}

	private void obtenerOpcionTablaPrincipal(int column) {
		posOpcion = column;
	}

	public void verTablaPrincipal(boolean opcion) {
		tablaVuelos.setVisible(opcion);
	}

	public void verRegistro(boolean opcion) {
		lblRegistro.setVisible(opcion);
		
		tablaRegistro.setVisible(opcion);
		scrollPaneRegistro.setVisible(opcion);
		
		btnCrear.setVisible(opcion);
		btnMasDetalles.setVisible(opcion);
	}

	public void verMasDetalles(boolean opcion) {
		btnVolver.setVisible(opcion);
		tablaMasDetalles.setVisible(opcion);
		scrollPaneMasDetalles.setVisible(opcion);
	}

	public void verMasDetalles() {
		if (posRegistro != -1) {

			String[][] datos = new String[0][0];
			String tipoVuelo = "";
			List<Vuelo> misVuelos = new ArrayList<>();
			if (posOpcion == 0) {
				tipoVuelo = "Nacional";
			}
			if (posOpcion == 1) {
				tipoVuelo = "Internacional";
			}
			for (int i = 0; i < miAerolinea.getMisVuelos().size(); i++) {
				if (miAerolinea.getMisVuelos().get(i).getMiRuta().getAtributos().get("Tipo vuelo")
						.equalsIgnoreCase(tipoVuelo)) {
					misVuelos.add(miAerolinea.getMisVuelos().get(i));
				}
			}
			Vuelo miVuelo = misVuelos.get(posRegistro);
			datos = miAerolinea.llenarTablaDeMasDetalles(miVuelo);

			tablaMasDetalles
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Detalles", "Informacion" }));
			DefaultTableModel modeloRegistro = (DefaultTableModel) tablaMasDetalles.getModel();
			modeloRegistro.setColumnCount(datos[0].length);
			modeloRegistro.setRowCount(1+datos.length);

			tablaMasDetalles.setValueAt("Avion", 0, 0);
			tablaMasDetalles.setValueAt(miVuelo.getMiAeronave().getMatricula(), 0, 1);
			
			for (int i = 1; i < tablaMasDetalles.getRowCount(); i++) {
				for (int j = 0; j < tablaMasDetalles.getColumnCount(); j++) {
					tablaMasDetalles.setValueAt(datos[i-1][j], i, j);
				}
			}

			verTablaPrincipal(true);
			verMasDetalles(true);
			verRegistro(false);

		} else {
			JOptionPane.showMessageDialog(null, "seleccione un registro");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrear) {
			if (posOpcion == 0) {
			} else {
			}
		}
		if (e.getSource() == btnMasDetalles) {
			verMasDetalles();
		}
		if (e.getSource() == btnVolver) {
			
			for (int i = 0; i < tablaRegistro.getRowCount(); i++) {
				tablaRegistro.setValueAt("", i, 0);
			}

			posRegistro = -1;
			verRegistro(true);
			verMasDetalles(false);
		}
	}

}
