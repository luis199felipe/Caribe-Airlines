package vueloInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import mundo.CaribeAirlines;

public class VentanaVuelo extends JInternalFrame {

	private JPanel contentPane;
	private JTable tablaVuelos, tablaRegistro;
	private JScrollPane scrollPaneRegistro;
	
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
				int column = tablaVuelos.columnAtPoint(e.getPoint());
				obtenerOpcionTablaPrincipal(column);
				
				tablaRegistro.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "", "Fecha", "Origen", "Destino" }));
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
				
				verTablaPrincipal(true);
				verRegistro(true);
			}
		});
		
		contentPane.add(tablaVuelos);
		
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
		
		verTablaPrincipal(true);
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
		tablaRegistro.setVisible(opcion);
		scrollPaneRegistro.setVisible(opcion);
	}

}
