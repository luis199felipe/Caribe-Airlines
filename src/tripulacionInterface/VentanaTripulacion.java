package tripulacionInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mundo.CaribeAirlines;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaTripulacion extends JInternalFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox comboBox;
	private JScrollPane scrollPaneRegistro;
	private JTable tableTripulaciones, tableRegistro;
	private JButton btnCrear, btnEliminar;
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
	
	public VentanaTripulacion() {
		miAerolinea = new CaribeAirlines();
		
		filtro = "Todo";
		
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
						
						String[][] datos = new String[3][0];
						
						if(column == 0) {
							tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Piloto", "Copiloto", "Auxiliares"}));
							tableRegistro.getColumnModel().getColumn(0).setPreferredWidth(118);
							tableRegistro.getColumnModel().getColumn(1).setPreferredWidth(118);
							tableRegistro.getColumnModel().getColumn(2).setPreferredWidth(118);
							tableRegistro.setRowHeight(150);
							
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
						lblTitulo.setText(""+tableTripulaciones.getValueAt(0, column));
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
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(X, 38, WIDTH, 21);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblTitulo);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		btnCrear.setVisible(false);
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnCrear.setBounds(250, 477, 114, 23);
		contentPane.add(btnCrear);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setVisible(false);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, LETRA_BUTTON));
		btnEliminar.setBounds(10, 477, 114, 23);
		contentPane.add(btnEliminar);
		
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
		scrollPaneRegistro.setBounds(X, Y, WIDTH, HEIGHT);
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
		String[][] datos = new String[0][0];
		if(posOpcion == 0) {
			if(filtro.equals("Todo")) {
				datos = miAerolinea.llenarTablaDeDatosTripulaciones();
			}else {
				datos = miAerolinea.filtrarTripulacion("Nacional");
			}
		}
		if(posOpcion == 1) {
			if(filtro.equals("Todo")) {
				datos = miAerolinea.llenarTablaDeDatosTripulantes();
			}else {
				datos = new String[10][10];
			}
		}
		
		DefaultTableModel modeloRegistro = (DefaultTableModel)tableRegistro.getModel(); 
		modeloRegistro.setRowCount(datos.length);
		
		for (int i = 0; i < tableRegistro.getRowCount(); i++) {
			for (int j = 0; j < tableRegistro.getColumnCount(); j++) {
				tableRegistro.setValueAt(datos[i][j], i, j);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox) {
			filtro = String.valueOf(comboBox.getSelectedItem());
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
