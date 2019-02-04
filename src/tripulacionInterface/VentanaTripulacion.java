package tripulacionInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mundo.CaribeAirlines;
import tripulacionLogica.Tripulacion;
import tripulacionLogica.Tripulante;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaTripulacion extends JInternalFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox comboBox;
	private JScrollPane scrollPaneRegistro;
	private JTable tableTripulaciones, tableRegistro;
	private JButton btnCrear, btnEliminar, btnMasDetalles, btnVolver;
	private JLabel lblTitulo;
	private String filtro;
	private int posOpcion, posRegistro;
	private CaribeAirlines miAerolinea;

	private static final int X = 10;
	private static final int Y = 65;
	private static final int WIDTH = 354;
	private static final int HEIGHT = 405;
	private static final int LETRA = 14;
	private static final int LETRA_BUTTON = 10;
	private static final int ROW_HEIGHT = 35;
	private JLabel lblPiloto;
	private JLabel lblCopiloto;
	private JLabel lblTipotripulacion;
	private JLabel lblAuxiliar;
	private JTable tablaTripulantesAgregados;
	
	public VentanaTripulacion() {
		miAerolinea = new CaribeAirlines();
		
		filtro = "Todo";
		posRegistro = -1;
		
		setTitle("Tripulaciones");
		setBounds(390, 0, 390, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableTripulaciones = new JTable(1, 2);
		tableTripulaciones.setEnabled(false);
		tableTripulaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTripulaciones.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		tableTripulaciones.setRowHeight(23);
		tableTripulaciones.setBounds(10, 11, WIDTH, 21);
		tableTripulaciones.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int column = tableTripulaciones.columnAtPoint(e.getPoint());
						obtenerPosOpcion(column);
						
						btnCrear.setVisible(true);
						btnEliminar.setVisible(true);
						btnMasDetalles.setVisible(true);
						
						posRegistro = -1;
						
						filtro = "Todo";
						
						String[][] datos = new String[3][0];
						
						if(column == 0) {
							tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Piloto", "Copiloto", "Auxiliares"}));
							tableRegistro.getColumnModel().getColumn(0).setPreferredWidth(118);
							tableRegistro.getColumnModel().getColumn(1).setPreferredWidth(118);
							tableRegistro.getColumnModel().getColumn(2).setPreferredWidth(118);
							tableRegistro.setRowHeight(130);
							
							comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todo", "Nacional", "Internacional"}));
							
							datos = miAerolinea.llenarTablaDeDatosTripulaciones();
							
						}
						if(column == 1) {
							tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nombre", "Id", "Cargo"}));
							tableRegistro.getColumnModel().getColumn(0).setPreferredWidth(157);
							tableRegistro.getColumnModel().getColumn(1).setPreferredWidth(117);
							tableRegistro.getColumnModel().getColumn(2).setPreferredWidth(80);
							tableRegistro.setRowHeight(ROW_HEIGHT);
							
							comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todo", "Piloto", "Copiloto", "Auxiliar"}));
							
							datos = miAerolinea.llenarTablaDeDatosTripulantes();
							
						}
						
						DefaultTableModel modeloRegistro = (DefaultTableModel)tableRegistro.getModel(); 
						modeloRegistro.setRowCount(datos.length);
						
						for (int i = 0; i < tableRegistro.getRowCount(); i++) {
							for (int j = 0; j < tableRegistro.getColumnCount(); j++) {
								tableRegistro.setValueAt(datos[i][j], i, j);
							}
						}
						
						comboBox.setVisible(true);
						scrollPaneRegistro.setVisible(true);
						lblTitulo.setText("Registro de "+tableTripulaciones.getValueAt(0, column));
					}
				});
		
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
		
		tableTripulaciones.getColumnModel().getColumn(0).setCellRenderer(alinear);
		tableTripulaciones.getColumnModel().getColumn(1).setCellRenderer(alinear);
		
		tableTripulaciones.setValueAt("Tripulaciones", 0, 0);
		tableTripulaciones.setValueAt("Tripulantes", 0, 1);
		
		contentPane.add(tableTripulaciones);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 38, 247, 21);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblTitulo);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		btnCrear.setVisible(false);
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnCrear.setBounds(131, 477, 113, 23);
		contentPane.add(btnCrear);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setVisible(false);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnEliminar.setBounds(10, 477, 113, 23);
		contentPane.add(btnEliminar);
		
		btnMasDetalles = new JButton("mas Detalles");
		btnMasDetalles.addActionListener(this);
		btnMasDetalles.setVisible(false);
		btnMasDetalles.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnMasDetalles.setBounds(251, 477, 113, 23);
		contentPane.add(btnMasDetalles);
		
		btnVolver = new JButton("volver");
		btnVolver.addActionListener(this);
		btnVolver.setVisible(false);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnVolver.setBounds(251, 477, 113, 23);
		contentPane.add(btnVolver);

		tableRegistro = new JTable(0,3);
		tableRegistro.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tableRegistro.setBorder(null);
		tableRegistro.setEnabled(false);
		tableRegistro.setShowGrid(true);
		tableRegistro.setRowHeight(ROW_HEIGHT);
		tableRegistro.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int row = tableRegistro.rowAtPoint(e.getPoint());
						obtenerPosRegistro(row);
					}
				});
		
		scrollPaneRegistro = new JScrollPane();
		scrollPaneRegistro.setBounds(X, 65, WIDTH, HEIGHT);
		scrollPaneRegistro.setViewportView(tableRegistro);
		scrollPaneRegistro.setVisible(false);
		contentPane.add(scrollPaneRegistro);
		
		
		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setVisible(false);
		comboBox.setBounds(267, 38, 97, 21);
		contentPane.add(comboBox);
		
	}
	
	public void verRegistroFiltrado() {
		btnCrear.setVisible(true);
		btnEliminar.setVisible(true);
		btnMasDetalles.setVisible(true);
		btnVolver.setVisible(false);
		
		String[][] datos = new String[0][0];
		if(posOpcion == 0) {
			tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Piloto", "Copiloto", "Auxiliares"}));
			tableRegistro.setRowHeight(130);
			
			if(filtro.equals("Todo")) {
			
				datos = miAerolinea.llenarTablaDeDatosTripulaciones();
			}else {
				datos = miAerolinea.filtrarTripulacion(""+comboBox.getSelectedItem());
			}
		}
		if(posOpcion == 1) {
			tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nombre", "Id", "Cargo"}));
			tableRegistro.setRowHeight(ROW_HEIGHT);
			
			if(filtro.equals("Todo")) {
				datos = miAerolinea.llenarTablaDeDatosTripulantes();
			}else {
				datos = miAerolinea.filtrarTripulante(""+comboBox.getSelectedItem());
			}
		}
		
		try {
			DefaultTableModel modeloRegistro = (DefaultTableModel)tableRegistro.getModel(); 
			modeloRegistro.setRowCount(datos.length);
			modeloRegistro.setColumnCount(datos[0].length);
		} catch (Exception e) {
			System.out.println("Tabla vacia");
		}
		
		
		for (int i = 0; i < tableRegistro.getRowCount(); i++) {
			for (int j = 0; j < tableRegistro.getColumnCount(); j++) {
				tableRegistro.setValueAt(datos[i][j], i, j);
			}
		}
	}
	
	public void verMasDetalles() {
		if(posRegistro != -1) {
			comboBox.setVisible(false);
			btnMasDetalles.setVisible(false);
			btnEliminar.setVisible(false);
			btnCrear.setVisible(false);
			btnVolver.setVisible(true);
			
			tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Detalles", "Informacion"}));
			tableRegistro.setRowHeight(ROW_HEIGHT);
			
			String[][] datos = new String[0][0];
			if(posOpcion == 0) {
				Tripulacion miTripulacion = null;
				
				if(filtro.equals("Todo")) {
					miTripulacion = miAerolinea.getMisTripulaciones().get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulacion(miTripulacion);
				}else {
					List<Tripulacion> misTripulaciones = miAerolinea.obtenerListadoFiltroTripulaciones(""+comboBox.getSelectedItem());
					miTripulacion = misTripulaciones.get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulacion(miTripulacion);
				}
			}
			if(posOpcion == 1) {
				Tripulante miTripulante = null;
				
				if(filtro.equals("Todo")) {
					miTripulante = miAerolinea.getMisTripulantes().get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulante(miTripulante);
				}else {
					List<Tripulante> misTripulantes = miAerolinea.obtenerListadoFiltroTripulantes(""+comboBox.getSelectedItem());
					miTripulante = misTripulantes.get(posRegistro);
					datos = miAerolinea.llenarTablaDeDatosMasDetallesTripulante(miTripulante);
				}
			}
			
			DefaultTableModel modeloRegistro = (DefaultTableModel)tableRegistro.getModel();
			modeloRegistro.setColumnCount(datos[0].length);
			modeloRegistro.setRowCount(datos.length);
			
			for (int i = 0; i < tableRegistro.getRowCount(); i++) {
				for (int j = 0; j < tableRegistro.getColumnCount(); j++) {
					tableRegistro.setValueAt(datos[i][j], i, j);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "seleccione un registro");
		}
	}
	
	public void eliminar() {
		if(posRegistro != -1) {
			
			if(posOpcion == 0) {
				Tripulacion miTripulacion = null;
				
				if(filtro.equals("Todo")) {
					miTripulacion = miAerolinea.getMisTripulaciones().get(posRegistro);
				}else {
					List<Tripulacion> misTripulaciones = miAerolinea.obtenerListadoFiltroTripulaciones(""+comboBox.getSelectedItem());
					miTripulacion = misTripulaciones.get(posRegistro);
				}
				
				miAerolinea.eliminarPorIdTripulacion(miTripulacion.getMiTripulacion().get("IdTripulacion"));
				JOptionPane.showMessageDialog(null, "Tripulacion Correctamente Eliminada");
			}
			if(posOpcion == 1) {
				Tripulante miTripulante = null;
				
				if(filtro.equals("Todo")) {
					miTripulante = miAerolinea.getMisTripulantes().get(posRegistro);
				}else {
					List<Tripulante> misTripulantes = miAerolinea.obtenerListadoFiltroTripulantes(""+comboBox.getSelectedItem());
					miTripulante = misTripulantes.get(posRegistro);	
				}
				
				miAerolinea.eliminarPorIdTripulante(miTripulante.getAtributos().get("Identificacion"));
				JOptionPane.showMessageDialog(null, "Tripulante Correctamente Eliminado");
			}
			
			verRegistroFiltrado();
			
			posRegistro = -1;
		}else {
			JOptionPane.showMessageDialog(null, "seleccione un registro");
		}
	}
	
	public void crearTripulacion() {
		btnEliminar.setVisible(false);
		btnMasDetalles.setVisible(false);
		comboBox.setVisible(false);
		scrollPaneRegistro.setVisible(false);

		lblTipotripulacion = new JLabel("TipoTripulacion");
		lblTipotripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblTipotripulacion.setBounds(10, 105, 120, 21);
		contentPane.add(lblTipotripulacion);

		lblPiloto = new JLabel("Piloto");
		lblPiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblPiloto.setBounds(10, 137, 120, 21);
		contentPane.add(lblPiloto);
		
		lblCopiloto = new JLabel("Copiloto");
		lblCopiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblCopiloto.setBounds(10, 169, 120, 21);
		contentPane.add(lblCopiloto);
		
		lblAuxiliar = new JLabel("Auxiliar");
		lblAuxiliar.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		lblAuxiliar.setBounds(10, 201, 120, 21);
		contentPane.add(lblAuxiliar);
		
		JButton btnTipoTripulacion = new JButton("Agg");
		btnTipoTripulacion.addActionListener(this);
		btnTipoTripulacion.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnTipoTripulacion.setBounds(313, 104, 51, 23);
		contentPane.add(btnTipoTripulacion);
		
		JButton btnPiloto = new JButton("Agg");
		btnPiloto.addActionListener(this);
		btnPiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnPiloto.setBounds(313, 139, 51, 23);
		contentPane.add(btnPiloto);
		
		JButton btnCopiloto = new JButton("Agg");
		btnCopiloto.addActionListener(this);
		btnCopiloto.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnCopiloto.setBounds(313, 168, 51, 23);
		contentPane.add(btnCopiloto);
		
		JButton btnAuxiliar = new JButton("Agg");
		btnAuxiliar.addActionListener(this);
		btnAuxiliar.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnAuxiliar.setBounds(313, 200, 51, 23);
		contentPane.add(btnAuxiliar);
		
		JComboBox comboBoxTipoTripulacion = new JComboBox();
		comboBoxTipoTripulacion.addActionListener(this);
		comboBoxTipoTripulacion.setBounds(131, 105, 172, 21);
		contentPane.add(comboBoxTipoTripulacion);
		
		JComboBox comboBoxPiloto = new JComboBox();
		comboBoxPiloto.addActionListener(this);
		comboBoxPiloto.setBounds(131, 139, 172, 21);
		contentPane.add(comboBoxPiloto);
		
		JComboBox comboBoxCopiloto = new JComboBox();
		comboBoxCopiloto.addActionListener(this);
		comboBoxCopiloto.setBounds(131, 171, 172, 20);
		contentPane.add(comboBoxCopiloto);
		
		JComboBox comboBoxAuxiliar = new JComboBox();
		comboBoxAuxiliar.addActionListener(this);
		comboBoxAuxiliar.setBounds(131, 203, 172, 20);
		contentPane.add(comboBoxAuxiliar);
		
		tablaTripulantesAgregados = new JTable();
		tablaTripulantesAgregados.setBounds(10, 234, 354, 235);
		contentPane.add(tablaTripulantesAgregados);
	}
	
	public void crearTripulante() {
		btnEliminar.setVisible(false);
		btnMasDetalles.setVisible(false);
		comboBox.setVisible(false);
		scrollPaneRegistro.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox) {
			filtro = String.valueOf(comboBox.getSelectedItem());
			verRegistroFiltrado();
		}
		if(e.getSource() == btnEliminar) {
			eliminar();
		}
		if(e.getSource() == btnCrear) {
			if(posOpcion == 0) {
				crearTripulacion();
			}else {
				crearTripulante();
			}
		}
		if(e.getSource() == btnMasDetalles) {
			verMasDetalles();
		}
		if(e.getSource() == btnVolver) {
			posRegistro = -1;
			comboBox.setVisible(true);
			verRegistroFiltrado();
		}
	}
	
	public void obtenerPosOpcion(int pos) {
		posOpcion = pos;
	}
	
	public void obtenerPosRegistro(int pos) {
		posRegistro = pos;
	}
}