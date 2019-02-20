package tripulacionInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelListener;

import mundo.CaribeAirlines;
import tripulacionLogica.Tripulacion;
import tripulacionLogica.Tripulante;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;

public class VentanaTripulacion extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox comboBoxRegistro, comboBoxTipoTripulacion, comboBoxPiloto, comboBoxCopiloto, comboBoxAuxiliar, comboBoxCargo;
	private JScrollPane scrollPaneRegistro, scrollPaneMasDetalles, scrollPaneTripulantesAgregados;
	private JTable tablaTripulaciones, tablaRegistro, tablaTripulantesAgregados, tablaMasDetalles;
	private JButton btnCrear, btnEliminar, btnMasDetalles, btnVolver, btnTipoTripulacion, btnPiloto, btnCopiloto,
			btnAuxiliar, btnVolverTripulacion, btnGuardarTripulacion, btnVolverTripulante, btnGuardarTripulante;
	private JLabel lblTitulo, lblTituloCrearTripulacion, lblPiloto, lblCopiloto, lblTipotripulacion, lblAuxiliar;
	private JLabel lblTituloCrearTripulante, lblCargo, lblIdentificacion, lblNombre, lblDireccion, lblCorreo, lblFechaNacimiento, lblEstudios;
	private JTextField txtIdentificacion, txtNombre, txtDireccion, txtCorreo, txtFechaNacimiento, txtEstudios;
	private String filtroRegistro;
	private int posOpcion, posRegistro;

	private CaribeAirlines miAerolinea;
	private List<Tripulante> miTripulacionAgregada;

	private static final int X = 10;
	private static final int Y = 65;
	private static final int WIDTH_TRIPULACION = 112;
	private static final int WIDTH = 354;
	private static final int HEIGHT = 405;
	private static final int LETRA = 14;
	private static final int LETRA_BUTTON = 10;
	private static final int ROW_HEIGHT = 35;
	private static final int LBL_HEIGHT = 21;
 
	public VentanaTripulacion(CaribeAirlines miAerolinea) {
		this.miAerolinea = miAerolinea;
		miTripulacionAgregada = new ArrayList<>();

		filtroRegistro = "Todo";
		posRegistro = -1;

		setTitle("Tripulaciones");
		setBounds(390, 0, 390, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tablaTripulaciones = new JTable(1, 2);
		tablaTripulaciones.setEnabled(false);
		tablaTripulaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaTripulaciones.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		tablaTripulaciones.setRowHeight(23);
		tablaTripulaciones.setBounds(X, 11, WIDTH, 21);
		tablaTripulaciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				posRegistro = -1;

				filtroRegistro = "Todo";

				int column = tablaTripulaciones.columnAtPoint(e.getPoint());
				obtenerPosOpcion(column);

				String[][] datos = new String[3][0];

				if (column == 0) {
					tablaRegistro.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "", "Piloto", "Copiloto", "Auxiliares" }));
					tablaRegistro.getColumnModel().getColumn(0).setPreferredWidth(WIDTH - 3 * WIDTH_TRIPULACION);
					tablaRegistro.getColumnModel().getColumn(1).setPreferredWidth(WIDTH_TRIPULACION);
					tablaRegistro.getColumnModel().getColumn(2).setPreferredWidth(WIDTH_TRIPULACION);
					tablaRegistro.getColumnModel().getColumn(3).setPreferredWidth(WIDTH_TRIPULACION);
					tablaRegistro.setRowHeight(130);

					comboBoxRegistro
							.setModel(new DefaultComboBoxModel(new String[] { "Todo", "Nacional", "Internacional" }));

					datos = miAerolinea.llenarTablaDeDatosTripulaciones();

				}
				if (column == 1) {
					tablaRegistro.setModel(
							new DefaultTableModel(new Object[][] {}, new String[] { "", "Nombre", "Id", "Cargo" }));
					tablaRegistro.getColumnModel().getColumn(0).setPreferredWidth(18);
					tablaRegistro.getColumnModel().getColumn(1).setPreferredWidth(157);
					tablaRegistro.getColumnModel().getColumn(2).setPreferredWidth(117);
					tablaRegistro.getColumnModel().getColumn(3).setPreferredWidth(80);
					tablaRegistro.setRowHeight(ROW_HEIGHT);

					comboBoxRegistro.setModel(
							new DefaultComboBoxModel(new String[] { "Todo", "Piloto", "Copiloto", "Auxiliar" }));

					datos = miAerolinea.llenarTablaDeDatosTripulantes();

				}

				DefaultTableModel modeloRegistro = (DefaultTableModel) tablaRegistro.getModel();
				modeloRegistro.setRowCount(datos.length);

				for (int i = 0; i < tablaRegistro.getRowCount(); i++) {
					for (int j = 1; j < tablaRegistro.getColumnCount(); j++) {
						tablaRegistro.setValueAt(datos[i][j - 1], i, j);
					}
				}

				lblTitulo.setText("Registro de " + tablaTripulaciones.getValueAt(0, column));

				verTablaTripulacionTripulante(true);
				verCreartripulante(false);
				verCreartripulacion(true);
				verMasDetalles(false);
				verRegistro(true);

			}
		});

		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);// .LEFT .RIGHT .CENTER

		tablaTripulaciones.getColumnModel().getColumn(0).setCellRenderer(alinear);
		tablaTripulaciones.getColumnModel().getColumn(1).setCellRenderer(alinear);

		tablaTripulaciones.setValueAt("Tripulaciones", 0, 0);
		tablaTripulaciones.setValueAt("Tripulantes", 0, 1);

		contentPane.add(tablaTripulaciones);

		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 38, 247, LBL_HEIGHT);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblTitulo);

		lblTituloCrearTripulacion = new JLabel("Crear Tripulacion");
		lblTituloCrearTripulacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCrearTripulacion.setBounds(X, 11, WIDTH, LBL_HEIGHT);
		lblTituloCrearTripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblTituloCrearTripulacion);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnCrear.setBounds(131, 477, 113, 23);
		contentPane.add(btnCrear);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnEliminar.setBounds(10, 477, 113, 23);
		contentPane.add(btnEliminar);

		btnMasDetalles = new JButton("mas Detalles");
		btnMasDetalles.addActionListener(this);
		btnMasDetalles.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnMasDetalles.setBounds(251, 477, 113, 23);
		contentPane.add(btnMasDetalles);

		btnVolver = new JButton("volver");
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnVolver.setBounds(251, 477, 113, 23);
		contentPane.add(btnVolver);

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

		comboBoxRegistro = new JComboBox();
		comboBoxRegistro.addActionListener(this);
		comboBoxRegistro.setBounds(267, 38, 97, 21);
		contentPane.add(comboBoxRegistro);

		tablaMasDetalles = new JTable(0, 2);
		tablaMasDetalles.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tablaMasDetalles.setBorder(null);
		tablaMasDetalles.setEnabled(false);
		tablaMasDetalles.setRowHeight(ROW_HEIGHT);

		scrollPaneMasDetalles = new JScrollPane();
		scrollPaneMasDetalles.setBounds(X, 65, WIDTH, HEIGHT);
		scrollPaneMasDetalles.setViewportView(tablaMasDetalles);
		contentPane.add(scrollPaneMasDetalles);

		lblTipotripulacion = new JLabel("TipoTripulacion");
		lblTipotripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblTipotripulacion.setBounds(10, 65, 120, LBL_HEIGHT);
		contentPane.add(lblTipotripulacion);

		lblPiloto = new JLabel("Piloto");
		lblPiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblPiloto.setBounds(10, 97, 120, LBL_HEIGHT);
		contentPane.add(lblPiloto);

		lblCopiloto = new JLabel("Copiloto");
		lblCopiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblCopiloto.setBounds(10, 129, 120, LBL_HEIGHT);
		contentPane.add(lblCopiloto);

		lblAuxiliar = new JLabel("Auxiliar");
		lblAuxiliar.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblAuxiliar.setBounds(10, 161, 120, LBL_HEIGHT);
		contentPane.add(lblAuxiliar);

		btnTipoTripulacion = new JButton("+");
		btnTipoTripulacion.addActionListener(this);
		btnTipoTripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnTipoTripulacion.setBounds(313, 65, 51, LBL_HEIGHT);
		contentPane.add(btnTipoTripulacion);

		btnPiloto = new JButton("+");
		btnPiloto.addActionListener(this);
		btnPiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnPiloto.setBounds(313, 97, 51, LBL_HEIGHT);
		contentPane.add(btnPiloto);

		btnCopiloto = new JButton("+");
		btnCopiloto.addActionListener(this);
		btnCopiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnCopiloto.setBounds(313, 129, 51, LBL_HEIGHT);
		contentPane.add(btnCopiloto);

		btnAuxiliar = new JButton("+");
		btnAuxiliar.addActionListener(this);
		btnAuxiliar.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnAuxiliar.setBounds(313, 161, 51, LBL_HEIGHT);
		contentPane.add(btnAuxiliar);

		btnVolverTripulacion = new JButton("Volver");
		btnVolverTripulacion.addActionListener(this);
		btnVolverTripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnVolverTripulacion.setBounds(10, 477, 113, 23);
		contentPane.add(btnVolverTripulacion);

		btnGuardarTripulacion = new JButton("Guardar");
		btnGuardarTripulacion.addActionListener(this);
		btnGuardarTripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnGuardarTripulacion.setBounds(251, 477, 113, 23);
		contentPane.add(btnGuardarTripulacion);

		comboBoxTipoTripulacion = new JComboBox();
		comboBoxTipoTripulacion.addActionListener(this);
		comboBoxTipoTripulacion.setBounds(131, 65, 172, LBL_HEIGHT);
		contentPane.add(comboBoxTipoTripulacion);

		comboBoxPiloto = new JComboBox();
		comboBoxPiloto.addActionListener(this);
		comboBoxPiloto.setBounds(131, 97, 172, LBL_HEIGHT);
		contentPane.add(comboBoxPiloto);

		comboBoxCopiloto = new JComboBox();
		comboBoxCopiloto.addActionListener(this);
		comboBoxCopiloto.setBounds(131, 129, 172, LBL_HEIGHT);
		contentPane.add(comboBoxCopiloto);

		comboBoxAuxiliar = new JComboBox();
		comboBoxAuxiliar.addActionListener(this);
		comboBoxAuxiliar.setBounds(131, 161, 172, LBL_HEIGHT);
		contentPane.add(comboBoxAuxiliar);

		tablaTripulantesAgregados = new JTable(0, 3);
		tablaTripulantesAgregados.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tablaTripulantesAgregados.setBorder(null);
		tablaTripulantesAgregados.setEnabled(false);
		tablaTripulantesAgregados.setShowGrid(true);
		tablaTripulantesAgregados.setRowHeight(ROW_HEIGHT);

		tablaTripulantesAgregados.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Identificacion", "Cargo" }));

		scrollPaneTripulantesAgregados = new JScrollPane();
		scrollPaneTripulantesAgregados.setBounds(X, 192, WIDTH, 275);
		scrollPaneTripulantesAgregados.setViewportView(tablaTripulantesAgregados);
		contentPane.add(scrollPaneTripulantesAgregados);
		
		lblTituloCrearTripulante = new JLabel("Crear Tripulante");
		lblTituloCrearTripulante.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCrearTripulante.setBounds(X, 11, WIDTH, LBL_HEIGHT);
		lblTituloCrearTripulante.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblTituloCrearTripulante);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblCargo.setBounds(X, 45, 100, LBL_HEIGHT);
		contentPane.add(lblCargo);

		lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblIdentificacion.setBounds(X, 77, 100, LBL_HEIGHT);
		contentPane.add(lblIdentificacion);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblNombre.setBounds(X, 109, 100, LBL_HEIGHT);
		contentPane.add(lblNombre);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblDireccion.setBounds(X, 141, 100, LBL_HEIGHT);
		contentPane.add(lblDireccion);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblCorreo.setBounds(X, 173, 100, LBL_HEIGHT);
		contentPane.add(lblCorreo);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblFechaNacimiento.setBounds(X, 206, 150, LBL_HEIGHT);
		contentPane.add(lblFechaNacimiento);

		lblEstudios = new JLabel("Estudios");
		lblEstudios.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblEstudios.setBounds(X, 237, 100, LBL_HEIGHT);
		contentPane.add(lblEstudios);
		
		comboBoxCargo = new JComboBox();
		comboBoxCargo.addActionListener(this);
		comboBoxCargo.setBounds(X+200, 45, 150, LBL_HEIGHT);
		contentPane.add(comboBoxCargo);
		
		txtIdentificacion = new JTextField("");
		txtIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		txtIdentificacion.setBounds(X+200, 77, 150, LBL_HEIGHT);
		contentPane.add(txtIdentificacion);
		
		txtNombre = new JTextField("");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		txtNombre.setBounds(X+200, 109, 150, LBL_HEIGHT);
		contentPane.add(txtNombre);
		
		txtDireccion = new JTextField("");
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		txtDireccion.setBounds(X+200, 141, 150, LBL_HEIGHT);
		contentPane.add(txtDireccion);
		
		txtCorreo = new JTextField("");
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		txtCorreo.setBounds(X+200, 173, 150, LBL_HEIGHT);
		contentPane.add(txtCorreo);
		
		txtFechaNacimiento = new JTextField("");
		txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		txtFechaNacimiento.setBounds(X+200, 206, 150, LBL_HEIGHT);
		contentPane.add(txtFechaNacimiento);

		txtEstudios = new JTextField("");
		txtEstudios.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		txtEstudios.setBounds(X+200, 237, 150, LBL_HEIGHT);
		contentPane.add(txtEstudios);
		
		btnVolverTripulante = new JButton("Volver");
		btnVolverTripulante.addActionListener(this);
		btnVolverTripulante.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnVolverTripulante.setBounds(10, 477, 113, 23);
		contentPane.add(btnVolverTripulante);

		btnGuardarTripulante = new JButton("Guardar");
		btnGuardarTripulante.addActionListener(this);
		btnGuardarTripulante.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnGuardarTripulante.setBounds(251, 477, 113, 23);
		contentPane.add(btnGuardarTripulante);
		
		verTablaTripulacionTripulante(true);
		verCreartripulante(false);
		verCreartripulacion(false);
		verMasDetalles(false);
		verRegistro(false);

	}

	public void verRegistroFiltrado() {

		posRegistro = -1;

		String[][] datos = new String[3][0];

		if (posOpcion == 0) {

			if (filtroRegistro.equals("Todo")) {
				datos = miAerolinea.llenarTablaDeDatosTripulaciones();
			} else {

				datos = miAerolinea.filtrarTripulacion(filtroRegistro);
			}

			tablaRegistro.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "", "Piloto", "Copiloto", "Auxiliares" }));
			tablaRegistro.getColumnModel().getColumn(0).setPreferredWidth(WIDTH - 3 * WIDTH_TRIPULACION);
			tablaRegistro.getColumnModel().getColumn(1).setPreferredWidth(WIDTH_TRIPULACION);
			tablaRegistro.getColumnModel().getColumn(2).setPreferredWidth(WIDTH_TRIPULACION);
			tablaRegistro.getColumnModel().getColumn(3).setPreferredWidth(WIDTH_TRIPULACION);
			tablaRegistro.setRowHeight(130);

		}

		if (posOpcion == 1) {

			if (filtroRegistro.equals("Todo")) {
				datos = miAerolinea.llenarTablaDeDatosTripulantes();
			} else {
				datos = miAerolinea.filtrarTripulante(filtroRegistro);
			}

			tablaRegistro
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "", "Nombre", "Id", "Cargo" }));
			tablaRegistro.getColumnModel().getColumn(0).setPreferredWidth(18);
			tablaRegistro.getColumnModel().getColumn(1).setPreferredWidth(157);
			tablaRegistro.getColumnModel().getColumn(2).setPreferredWidth(117);
			tablaRegistro.getColumnModel().getColumn(3).setPreferredWidth(80);
			tablaRegistro.setRowHeight(ROW_HEIGHT);

		}

		DefaultTableModel modeloRegistro = (DefaultTableModel) tablaRegistro.getModel();
		modeloRegistro.setRowCount(datos.length);

		for (int i = 0; i < tablaRegistro.getRowCount(); i++) {
			for (int j = 1; j < tablaRegistro.getColumnCount(); j++) {
				tablaRegistro.setValueAt(datos[i][j - 1], i, j);
			}
		}
		verTablaTripulacionTripulante(true);
		verCreartripulante(false);
		verCreartripulacion(false);
		verMasDetalles(false);
		verRegistro(true);

	}

	public void verMasDetalles() {
		if (posRegistro != -1) {

			String[][] datos = new String[0][0];
			if (posOpcion == 0) {
				Tripulacion miTripulacion = null;

				if (filtroRegistro.equals("Todo")) {
					miTripulacion = miAerolinea.getMisTripulaciones().get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulacion(miTripulacion);
				} else {
					List<Tripulacion> misTripulaciones = miAerolinea
							.obtenerListadoFiltroTripulaciones("" + comboBoxRegistro.getSelectedItem());
					miTripulacion = misTripulaciones.get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulacion(miTripulacion);
				}
			}
			if (posOpcion == 1) {
				Tripulante miTripulante = null;

				if (filtroRegistro.equals("Todo")) {
					miTripulante = miAerolinea.getMisTripulantes().get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulante(miTripulante);
				} else {
					List<Tripulante> misTripulantes = miAerolinea
							.obtenerListadoFiltroTripulantes("" + comboBoxRegistro.getSelectedItem());
					miTripulante = misTripulantes.get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulante(miTripulante);
				}
			}

			tablaMasDetalles
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Detalles", "Informacion" }));
			DefaultTableModel modeloRegistro = (DefaultTableModel) tablaMasDetalles.getModel();
			modeloRegistro.setColumnCount(datos[0].length);
			modeloRegistro.setRowCount(datos.length);

			for (int i = 0; i < tablaMasDetalles.getRowCount(); i++) {
				for (int j = 0; j < tablaMasDetalles.getColumnCount(); j++) {
					tablaMasDetalles.setValueAt(datos[i][j], i, j);
				}
			}
			
			verTablaTripulacionTripulante(true);
			verCreartripulante(false);
			verCreartripulacion(false);
			verMasDetalles(true);
			verRegistro(false);

		} else {
			JOptionPane.showMessageDialog(null, "seleccione un registro");

		}
	}

	public void eliminar() {
		if (posRegistro != -1) {

			if (posOpcion == 0) {
				Tripulacion miTripulacion = null;

				if (filtroRegistro.equals("Todo")) {
					miTripulacion = miAerolinea.getMisTripulaciones().get(posRegistro);
				} else {
					List<Tripulacion> misTripulaciones = miAerolinea
							.obtenerListadoFiltroTripulaciones("" + comboBoxRegistro.getSelectedItem());
					miTripulacion = misTripulaciones.get(posRegistro);
				}

				miAerolinea.eliminarPorIdTripulacion(miTripulacion.getMiTripulacion().get("IdTripulacion"));
				JOptionPane.showMessageDialog(null, "Tripulacion Correctamente Eliminada");
			}
			if (posOpcion == 1) {
				Tripulante miTripulante = null;

				if (filtroRegistro.equals("Todo")) {
					miTripulante = miAerolinea.getMisTripulantes().get(posRegistro);
				} else {
					List<Tripulante> misTripulantes = miAerolinea
							.obtenerListadoFiltroTripulantes("" + comboBoxRegistro.getSelectedItem());
					miTripulante = misTripulantes.get(posRegistro);
				}

				miAerolinea.eliminarPorIdTripulante(miTripulante.getAtributos().get("Identificacion"));
				JOptionPane.showMessageDialog(null, "Tripulante Correctamente Eliminado");
			}

			verRegistroFiltrado();

			posRegistro = -1;

		} else {
			JOptionPane.showMessageDialog(null, "seleccione un registro");
		}
	}

	private int rowTablaCrearTripulacion;
	
	public void crearTripulacion() {

		rowTablaCrearTripulacion = 0;
		DefaultTableModel modeloRegistro = (DefaultTableModel) tablaTripulantesAgregados.getModel();
		modeloRegistro.setColumnCount(3);
		modeloRegistro.setRowCount(0);

		List<Tripulante> pilotos = miAerolinea.obtenerListadoFiltroTripulantes("Piloto");
		List<Tripulante> copilotos = miAerolinea.obtenerListadoFiltroTripulantes("Copiloto");
		List<Tripulante> auxiliares = miAerolinea.obtenerListadoFiltroTripulantes("Auxiliar");

		comboBoxTipoTripulacion.addItem("");
		comboBoxTipoTripulacion.addItem("Nacional");
		comboBoxTipoTripulacion.addItem("Internacional");

		comboBoxPiloto.addItem("");
		comboBoxCopiloto.addItem("");
		comboBoxAuxiliar.addItem("");

		for (int i = 0; i < pilotos.size(); i++) {
			comboBoxPiloto.addItem(pilotos.get(i).getAtributos().get("Nombre"));
		}

		for (int i = 0; i < copilotos.size(); i++) {
			comboBoxCopiloto.addItem(copilotos.get(i).getAtributos().get("Nombre"));
		}

		for (int i = 0; i < auxiliares.size(); i++) {
			comboBoxAuxiliar.addItem(auxiliares.get(i).getAtributos().get("Nombre"));
		}
		
		if (comboBoxTipoTripulacion.getSelectedItem().equals("")) {
			
			btnTipoTripulacion.setEnabled(true);
			comboBoxTipoTripulacion.setEnabled(true);

			btnPiloto.setEnabled(false);
			btnCopiloto.setEnabled(false);
			btnAuxiliar.setEnabled(false);
			comboBoxPiloto.setEnabled(false);
			comboBoxCopiloto.setEnabled(false);
			comboBoxAuxiliar.setEnabled(false);

		}

		btnTipoTripulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!comboBoxTipoTripulacion.getSelectedItem().equals("")) {
					btnTipoTripulacion.setEnabled(false);
					comboBoxTipoTripulacion.setEnabled(false);

					btnPiloto.setEnabled(true);
					btnCopiloto.setEnabled(true);
					btnAuxiliar.setEnabled(true);
					comboBoxPiloto.setEnabled(true);
					comboBoxCopiloto.setEnabled(true);
					comboBoxAuxiliar.setEnabled(true);
				}
			}
		});

		btnPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tripulante miPiloto = null;
				int piloto = miAerolinea.contarCantidadDeTripulantesDeMismoCargoEnUnaTripulacion("piloto",
						miTripulacionAgregada);
				if (comboBoxPiloto.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Seleccione un piloto");
				}
				if (piloto == 1 && !comboBoxPiloto.getSelectedItem().equals("")) {
					int respuesta = JOptionPane.showConfirmDialog(null, "Ya agrego un piloto\n¿Desea cambiarlo?");
					if (respuesta == 0) {
						for (int i = 0; i < miTripulacionAgregada.size(); i++) {
							if (miTripulacionAgregada.get(i).getAtributos().get("Cargo").equalsIgnoreCase("piloto")) {
								miTripulacionAgregada.remove(i);
								rowTablaCrearTripulacion--;
								modeloRegistro.setRowCount(miTripulacionAgregada.size());
								for (int j = 0; j < tablaTripulantesAgregados.getRowCount(); j++) {
									tablaTripulantesAgregados.setValueAt(
											miTripulacionAgregada.get(j).getAtributos().get("Nombre"), j, 0);
									tablaTripulantesAgregados.setValueAt(
											miTripulacionAgregada.get(j).getAtributos().get("Identificacion"), j, 1);
									tablaTripulantesAgregados
											.setValueAt(miTripulacionAgregada.get(j).getAtributos().get("Cargo"), j, 2);
								}
								piloto = 0;
							}
						}
					}
				}
				for (int i = 0; i < pilotos.size() && piloto == 0
						&& !comboBoxPiloto.getSelectedItem().equals(""); i++) {

					if (pilotos.get(i).getAtributos().get("Nombre").equals(comboBoxPiloto.getSelectedItem())) {
						miPiloto = pilotos.get(i);
						miTripulacionAgregada.add(miPiloto);
						modeloRegistro.setRowCount(miTripulacionAgregada.size());
						tablaTripulantesAgregados.setValueAt(pilotos.get(i).getAtributos().get("Nombre"),
								rowTablaCrearTripulacion, 0);
						tablaTripulantesAgregados.setValueAt(pilotos.get(i).getAtributos().get("Identificacion"),
								rowTablaCrearTripulacion, 1);
						tablaTripulantesAgregados.setValueAt(pilotos.get(i).getAtributos().get("Cargo"),
								rowTablaCrearTripulacion, 2);
						rowTablaCrearTripulacion++;

					}
				}
			}
		});
		
		btnCopiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tripulante miCopiloto = null;
				int copiloto = miAerolinea.contarCantidadDeTripulantesDeMismoCargoEnUnaTripulacion("copiloto",
						miTripulacionAgregada);
				if (comboBoxCopiloto.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Seleccione un copiloto");
				}
				if (copiloto == 1 && !comboBoxCopiloto.getSelectedItem().equals("")) {
					int respuesta = JOptionPane.showConfirmDialog(null, "Ya agrego un copiloto\n¿Desea cambiarlo?");
					if (respuesta == 0) {
						for (int i = 0; i < miTripulacionAgregada.size(); i++) {
							if (miTripulacionAgregada.get(i).getAtributos().get("Cargo").equalsIgnoreCase("copiloto")) {
								miTripulacionAgregada.remove(i);
								rowTablaCrearTripulacion--;
								modeloRegistro.setRowCount(miTripulacionAgregada.size());
								for (int j = 0; j < tablaTripulantesAgregados.getRowCount(); j++) {
									tablaTripulantesAgregados.setValueAt(
											miTripulacionAgregada.get(j).getAtributos().get("Nombre"), j, 0);
									tablaTripulantesAgregados.setValueAt(
											miTripulacionAgregada.get(j).getAtributos().get("Identificacion"), j, 1);
									tablaTripulantesAgregados
											.setValueAt(miTripulacionAgregada.get(j).getAtributos().get("Cargo"), j, 2);
								}
								copiloto = 0;
							}
						}
					}
				}
				for (int i = 0; i < copilotos.size() && copiloto == 0
						&& !comboBoxCopiloto.getSelectedItem().equals(""); i++) {
					if (copilotos.get(i).getAtributos().get("Nombre").equals(comboBoxCopiloto.getSelectedItem())) {
						miCopiloto = copilotos.get(i);
						miTripulacionAgregada.add(miCopiloto);
						modeloRegistro.setRowCount(miTripulacionAgregada.size());
						tablaTripulantesAgregados.setValueAt(copilotos.get(i).getAtributos().get("Nombre"),
								rowTablaCrearTripulacion, 0);
						tablaTripulantesAgregados.setValueAt(copilotos.get(i).getAtributos().get("Identificacion"),
								rowTablaCrearTripulacion, 1);
						tablaTripulantesAgregados.setValueAt(copilotos.get(i).getAtributos().get("Cargo"),
								rowTablaCrearTripulacion, 2);
						rowTablaCrearTripulacion++;
					}
				}
			}
		});

		btnAuxiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tripulante miAuxiliar = null;
				int auxiliar = miAerolinea.contarCantidadDeTripulantesDeMismoCargoEnUnaTripulacion("auxiliar",
						miTripulacionAgregada);
				if (comboBoxAuxiliar.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Seleccione un auxiliar");
				}
				int tipo = comboBoxTipoTripulacion.getSelectedIndex();
				int valor = 0;
				if (tipo == 1) {// viaje nacional
					valor = 3;
				} else if (tipo == 2) {// viaje internacional
					valor = 7;
				}
				if (auxiliar == valor && !comboBoxAuxiliar.getSelectedItem().equals("")) {
					int respuesta = JOptionPane.showConfirmDialog(null,
							"Ya agrego " + auxiliar + " auxiliares\n¿Desea cambiar alguno?");
					if (respuesta == 0) {
						String identificacion = JOptionPane.showInputDialog(null,
								"Ingrese Identificacion del auxiliar que desea eliminar");
						for (int i = 0; i < miTripulacionAgregada.size(); i++) {
							if (miTripulacionAgregada.get(i).getAtributos().get("Cargo").equalsIgnoreCase("auxiliar")
									&& miTripulacionAgregada.get(i).getAtributos().get("Identificacion")
											.equalsIgnoreCase(identificacion)) {
								miTripulacionAgregada.remove(i);
								rowTablaCrearTripulacion--;
								modeloRegistro.setRowCount(miTripulacionAgregada.size());
								for (int j = 0; j < tablaTripulantesAgregados.getRowCount(); j++) {
									tablaTripulantesAgregados.setValueAt(
											miTripulacionAgregada.get(j).getAtributos().get("Nombre"), j, 0);
									tablaTripulantesAgregados.setValueAt(
											miTripulacionAgregada.get(j).getAtributos().get("Identificacion"), j, 1);
									tablaTripulantesAgregados
											.setValueAt(miTripulacionAgregada.get(j).getAtributos().get("Cargo"), j, 2);
								}
								auxiliar--;
							}
						}
					}
				}
				for (int i = 0; i < auxiliares.size() && auxiliar < valor
						&& !comboBoxAuxiliar.getSelectedItem().equals(""); i++) {
					if (auxiliares.get(i).getAtributos().get("Nombre").equals(comboBoxAuxiliar.getSelectedItem())) {
						miAuxiliar = auxiliares.get(i);
						miTripulacionAgregada.add(miAuxiliar);
						modeloRegistro.setRowCount(miTripulacionAgregada.size());
						tablaTripulantesAgregados.setValueAt(auxiliares.get(i).getAtributos().get("Nombre"),
								rowTablaCrearTripulacion, 0);
						tablaTripulantesAgregados.setValueAt(auxiliares.get(i).getAtributos().get("Identificacion"),
								rowTablaCrearTripulacion, 1);
						tablaTripulantesAgregados.setValueAt(auxiliares.get(i).getAtributos().get("Cargo"),
								rowTablaCrearTripulacion, 2);
						rowTablaCrearTripulacion++;
					}
				}
			}
		});

		btnGuardarTripulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean tripulacion = miAerolinea.crearTripulacion(miTripulacionAgregada,
						(String) comboBoxTipoTripulacion.getSelectedItem());
				if (tripulacion == true) {
					JOptionPane.showMessageDialog(null, "Creado");
					verRegistroFiltrado();
					miTripulacionAgregada.clear();
					
					comboBoxTipoTripulacion.removeAllItems();
					comboBoxPiloto.removeAllItems();
					comboBoxCopiloto.removeAllItems();
					comboBoxAuxiliar.removeAllItems();
				} else {
					JOptionPane.showMessageDialog(null, "Faltan tripulantes por agregar");
				}
			}
		});
		
		btnVolverTripulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verRegistroFiltrado();
				miTripulacionAgregada.clear();

				comboBoxTipoTripulacion.removeAllItems();
				comboBoxPiloto.removeAllItems();
				comboBoxCopiloto.removeAllItems();
				comboBoxAuxiliar.removeAllItems();
			}
		});

		verTablaTripulacionTripulante(false);
		verCreartripulante(false);
		verCreartripulacion(true);
		verMasDetalles(false);
		verRegistro(false);
	}

	public void crearTripulante() {
		
		comboBoxCargo.addItem("");
		comboBoxCargo.addItem("Piloto");
		comboBoxCargo.addItem("Copiloto");
		comboBoxCargo.addItem("Auxiliar");

		btnGuardarTripulante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean cargo = !comboBoxCargo.getSelectedItem().equals("");
				boolean identificacion = !txtIdentificacion.getText().equals("");
				boolean nombre = !txtNombre.getText().equals("");
				boolean direccion = !txtDireccion.getText().equals("");
				boolean correo = !txtCorreo.getText().equals("");
				boolean fechaNacimiento = !txtFechaNacimiento.getText().equals("");
				boolean estudios = !txtEstudios.getText().equals("");
				
				if(cargo && identificacion && nombre && direccion && correo && fechaNacimiento && estudios) {
					
					Tripulante miTripulante = new Tripulante(String.valueOf(comboBoxCargo.getSelectedItem()), 
								txtIdentificacion.getText(), txtNombre.getText(), txtDireccion.getText(),
								txtCorreo.getText(), txtFechaNacimiento.getText(), txtEstudios.getText());
					
					boolean tripulante = miAerolinea.crearTripulante(miTripulante);
					if (tripulante == true) {
						JOptionPane.showMessageDialog(null, "Creado");
						verRegistroFiltrado();
						comboBoxCargo.removeAllItems();
						txtIdentificacion.setText("");
						txtNombre.setText("");
						txtDireccion.setText("");
						txtCorreo.setText("");
						txtFechaNacimiento.setText("");
						txtEstudios.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null, "Error al verificar:\nIdentificacion asociada a un\ntripulante ya creado");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Aun hay campos vacios");
				}
			}
		});
		verTablaTripulacionTripulante(false);
		verCreartripulante(true);
		verCreartripulacion(false);
		verMasDetalles(false);
		verRegistro(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBoxRegistro) {
			filtroRegistro = String.valueOf(comboBoxRegistro.getSelectedItem());
			verRegistroFiltrado();
		}
		if (e.getSource() == btnEliminar) {
			eliminar();
		}
		if (e.getSource() == btnCrear) {
			if (posOpcion == 0) {
				crearTripulacion();
			} else {
				crearTripulante();
			}
		}
		if (e.getSource() == btnMasDetalles) {
			verMasDetalles();
		}
		if (e.getSource() == btnVolver) {
			posRegistro = -1;
			verRegistroFiltrado();
		}
	}

	public void verTablaTripulacionTripulante(boolean opcion) {
		tablaTripulaciones.setVisible(opcion);
	}

	public void verRegistro(boolean opcion) {
		btnCrear.setVisible(opcion);
		btnEliminar.setVisible(opcion);
		btnMasDetalles.setVisible(opcion);

		lblTitulo.setVisible(opcion);
		tablaRegistro.setVisible(opcion);
		comboBoxRegistro.setVisible(opcion);
		scrollPaneRegistro.setVisible(opcion);
	}

	public void verMasDetalles(boolean opcion) {
		btnVolver.setVisible(opcion);
		tablaMasDetalles.setVisible(opcion);
		scrollPaneMasDetalles.setVisible(opcion);
	}
	
	public void verCreartripulante(boolean opcion) {
		lblTituloCrearTripulante.setVisible(opcion);
		
		lblCargo.setVisible(opcion);
		lblIdentificacion.setVisible(opcion);
		lblNombre.setVisible(opcion);
		lblDireccion.setVisible(opcion);
		lblCorreo.setVisible(opcion);
		lblFechaNacimiento.setVisible(opcion);
		lblEstudios.setVisible(opcion);
		
		comboBoxCargo.setVisible(opcion);
		txtIdentificacion.setVisible(opcion);
		txtNombre.setVisible(opcion);
		txtDireccion.setVisible(opcion);
		txtCorreo.setVisible(opcion);
		txtFechaNacimiento.setVisible(opcion);
		txtEstudios.setVisible(opcion);
		
		btnVolverTripulante.setVisible(opcion);
		btnGuardarTripulante.setVisible(opcion);
	}
	
	public void verCreartripulacion(boolean opcion) {
		lblTituloCrearTripulacion.setVisible(opcion);
		
		comboBoxPiloto.setVisible(opcion);
		comboBoxCopiloto.setVisible(opcion);
		comboBoxAuxiliar.setVisible(opcion);
		comboBoxTipoTripulacion.setVisible(opcion);

		lblPiloto.setVisible(opcion);
		lblCopiloto.setVisible(opcion);
		lblAuxiliar.setVisible(opcion);
		lblTipotripulacion.setVisible(opcion);

		btnPiloto.setVisible(opcion);
		btnCopiloto.setVisible(opcion);
		btnAuxiliar.setVisible(opcion);
		btnTipoTripulacion.setVisible(opcion);

		tablaTripulantesAgregados.setVisible(opcion);
		scrollPaneTripulantesAgregados.setVisible(opcion);
		
		btnVolverTripulacion.setVisible(opcion);
		btnGuardarTripulacion.setVisible(opcion);
	}

	public void obtenerPosOpcion(int pos) {
		posOpcion = pos;
	}

	public void obtenerPosRegistro(int pos) {
		posRegistro = pos;
	}
}