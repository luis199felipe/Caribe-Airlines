package aeronavesInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import mundo.CaribeAirlines;

import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;

import java.awt.Color;

public class VentanaAeronave extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tableAeronaves, tableDatos, tableSillasEjecutiva, tableSillasEconomica;
	private JButton btnTripulacion, btnSillas, btnFlota;
	private JTextArea textAreaTripulacion;
	private DefaultTableModel modeloSillasEjecutiva, modeloSillasEconomica;
	private String idTipoAeronave;
	private boolean verTripulacion, verSillas, verFlota;
	private CaribeAirlines miAerolinea;
	
	private static final int X = 10;
	private static final int Y = 48;
	private static final int WIDTH = 290;
	private static final int HEIGHT = 355;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAeronave frame = new VentanaAeronave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaAeronave() {
		miAerolinea = new CaribeAirlines();
		List<TipoAeronave> misAeronaves = miAerolinea.getMisAeronaves();
		
		verTripulacion = false;
		verSillas = false;
		verFlota = false;
		
		setTitle("Aeronaves");
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableAeronaves = new JTable(1, misAeronaves.size());
		tableAeronaves.setEnabled(false);
		tableAeronaves.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableAeronaves.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableAeronaves.setRowHeight(23);
		tableAeronaves.setBounds(10, 11, 414, 23);
		tableAeronaves.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						int column = tableAeronaves.columnAtPoint(e.getPoint());
						int row = tableAeronaves.rowAtPoint(e.getPoint());
						
						tableDatos.setVisible(true);
						textAreaTripulacion.setVisible(false);
						
						btnFlota.setVisible(true);
						btnSillas.setVisible(true);
						btnTripulacion.setVisible(true);
						
						String[][] datos = miAerolinea.llenarTablaDeDatosAeronave(column);
						for (int i = 0; i < tableDatos.getRowCount(); i++) {
							for (int j = 0; j < tableDatos.getColumnCount(); j++) {
								tableDatos.setValueAt(datos[i][j], i, j);
							}
						}
					
					}
				});
		
		contentPane.add(tableAeronaves);
		
		for (int i = 0; i < tableAeronaves.getRowCount(); i++) {
			for (int j = 0; j < tableAeronaves.getColumnCount(); j++) {
				
				DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
				alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				tableAeronaves.getColumnModel().getColumn(j).setCellRenderer(alinear);
				
				String tipo = misAeronaves.get(j).getAtributos().get("Marca") + " " + misAeronaves.get(j).getAtributos().get("Linea");
				tableAeronaves.setValueAt(tipo, i, j);
			}
		}
		
		btnTripulacion = new JButton("Ver Tripulaci\u00F3n");
		btnTripulacion.addActionListener(this);
		btnTripulacion.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnTripulacion.setBounds(310, 161, 114, 23);
		contentPane.add(btnTripulacion);
		
		btnSillas = new JButton("Ver Sillas");
		btnSillas.addActionListener(this);
		btnSillas.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnSillas.setBounds(310, 195, 114, 23);
		contentPane.add(btnSillas);
		
		btnFlota = new JButton("Ver Flota");
		btnFlota.addActionListener(this);
		btnFlota.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnFlota.setBounds(310, 227, 114, 23);
		contentPane.add(btnFlota);
		
		btnFlota.setVisible(false);
		btnSillas.setVisible(false);
		btnTripulacion.setVisible(false);
		
		tableDatos = new JTable(misAeronaves.get(0).getAtributos().size(), 2);//fila,columna
		tableDatos.setBounds(X, Y, WIDTH, HEIGHT);
		contentPane.add(tableDatos);
		tableDatos.setShowGrid(false);
		tableDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableDatos.setBorder(null);
		tableDatos.setEnabled(false);
		tableDatos.setRowHeight(HEIGHT / misAeronaves.get(0).getAtributos().size());
		tableDatos.getColumnModel().getColumn(0).setPreferredWidth(130);
		tableDatos.getColumnModel().getColumn(1).setPreferredWidth(160);
		
		textAreaTripulacion = new JTextArea();
		textAreaTripulacion.setEditable(false);
		contentPane.add(textAreaTripulacion);
		textAreaTripulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaTripulacion.setBounds(X, Y, WIDTH, HEIGHT);
		
	}
	public void verSillas() {
		int pos = miAerolinea.encontrarPosiciontipoAeronave(idTipoAeronave);
		DistribucionSillas ubicacionSillas = miAerolinea.getMisAeronaves().get(pos).getUbicacionSillas();
		
		String[][] sillasEjecutiva = ubicacionSillas.getDistribucionEjecutiva();
		String[][] sillasEconomica = ubicacionSillas.getDistribucionEconomica();
		
		int filaTotal = sillasEjecutiva.length + sillasEconomica.length;
		
		int espacio = HEIGHT - (filaTotal*(HEIGHT/filaTotal));
		
		if(verSillas == false) {
			tableSillasEjecutiva = new JTable(sillasEjecutiva.length, sillasEjecutiva[0].length);
			tableSillasEconomica = new JTable(sillasEconomica.length, sillasEconomica[0].length);
		}else {
			DefaultTableModel modeloEjecutiva = (DefaultTableModel)tableSillasEjecutiva.getModel(); 
			modeloEjecutiva.setRowCount(sillasEjecutiva.length);
			modeloEjecutiva.setColumnCount(sillasEjecutiva[0].length);
			
			DefaultTableModel modeloEconomica = (DefaultTableModel)tableSillasEconomica.getModel(); 
			modeloEconomica.setRowCount(sillasEconomica.length);
			modeloEconomica.setColumnCount(sillasEconomica[0].length);
		}
		
		tableSillasEjecutiva.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableSillasEjecutiva.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableSillasEjecutiva.setEnabled(false);
		tableSillasEjecutiva.setShowGrid(true);
		tableSillasEjecutiva.setBounds(X, Y, WIDTH, sillasEjecutiva.length*(HEIGHT/filaTotal));
		tableSillasEjecutiva.setRowHeight(HEIGHT / filaTotal);
		contentPane.add(tableSillasEjecutiva);
		
		for (int i = 0; i < tableSillasEjecutiva.getRowCount(); i++) {
			for (int j = 0; j < tableSillasEjecutiva.getColumnCount(); j++) {
				
				if(!sillasEjecutiva[i][j].equals("pasillo")) {
					DefaultTableCellRenderer conBordes = new DefaultTableCellRenderer();
					conBordes.setBorder(new LineBorder(Color.BLUE));
					tableSillasEjecutiva.setValueAt(sillasEjecutiva[i][j], i, j);
					tableSillasEjecutiva.getColumnModel().getColumn(j).setCellRenderer(conBordes);
				}else {
					tableSillasEjecutiva.setValueAt("", i, j);
				}
				
				DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
				alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				tableSillasEjecutiva.getColumnModel().getColumn(j).setCellRenderer(alinear);
			}
		}
		
		tableSillasEconomica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableSillasEconomica.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableSillasEconomica.setEnabled(false);
		tableSillasEconomica.setShowGrid(true);
		tableSillasEconomica.setBounds(X, Y + sillasEjecutiva.length*(HEIGHT/filaTotal) + espacio, WIDTH, sillasEconomica.length*(HEIGHT/filaTotal));
		tableSillasEconomica.setRowHeight(HEIGHT / filaTotal);
		contentPane.add(tableSillasEconomica);
		
		for (int i = 0; i < tableSillasEconomica.getRowCount(); i++) {
			for (int j = 0; j < tableSillasEconomica.getColumnCount(); j++) {
				
				if(!sillasEconomica[i][j].equals("pasillo")) {
					DefaultTableCellRenderer conBordes = new DefaultTableCellRenderer();
					conBordes.setBorder(new LineBorder(new Color(0, 0, 0)));
					tableSillasEconomica.setValueAt(sillasEconomica[i][j], i, j);
					tableSillasEconomica.getColumnModel().getColumn(j).setCellRenderer(conBordes);
				}else {
					tableSillasEconomica.setValueAt("", i, j);
				}
				
				DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
				alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				tableSillasEconomica.getColumnModel().getColumn(j).setCellRenderer(alinear);
			}
		}
		
		verSillas = true;
	}
	
	public void actionPerformed(ActionEvent e) {
		idTipoAeronave = (String) tableDatos.getValueAt(5, 1);
		
		if (e.getSource() == btnTripulacion) {
			tableDatos.setVisible(false);
			textAreaTripulacion.setVisible(true);
			tableSillasEjecutiva.setVisible(false);
			tableSillasEconomica.setVisible(false);
		}
		if (e.getSource() == btnSillas) {
			tableDatos.setVisible(false);
			textAreaTripulacion.setVisible(false);
			verSillas();
		}
		if (e.getSource() == btnFlota) {
			tableDatos.setVisible(false);
			textAreaTripulacion.setVisible(false);
			tableSillasEjecutiva.setVisible(false);
			tableSillasEconomica.setVisible(false);
		}
	}
}
