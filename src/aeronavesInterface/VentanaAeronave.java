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
	private JButton btnSillas, btnFlota;
	private JTextArea textAreaTripulacion;
	private JLabel lblTitulo;
	private String idTipoAeronave;
	private boolean verSillas, verFlota;
	private CaribeAirlines miAerolinea;
	
	private static final int X = 10;
	private static final int Y = 65;
	private static final int WIDTH = 314;
	private static final int HEIGHT = 405;

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
		
		verSillas = false;
		verFlota = false;
		
		setTitle("Aeronaves");
		setBounds(100, 100, 350, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableAeronaves = new JTable(1, misAeronaves.size());
		tableAeronaves.setEnabled(false);
		tableAeronaves.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableAeronaves.setFont(new Font("Tahoma", Font.BOLD, 12));
		tableAeronaves.setRowHeight(23);
		tableAeronaves.setBounds(10, 11, 314, 20);
		tableAeronaves.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						if(verSillas == true) {
							tableSillasEconomica.setVisible(false);
							tableSillasEjecutiva.setVisible(false);
						}

						int column = tableAeronaves.columnAtPoint(e.getPoint());
						int row = tableAeronaves.rowAtPoint(e.getPoint());
						
						tableDatos.setVisible(true);
						
						btnFlota.setVisible(true);
						btnSillas.setVisible(true);
						
						String[][] datos = miAerolinea.llenarTablaDeDatosAeronave(column);
						for (int i = 0; i < tableDatos.getRowCount(); i++) {
							for (int j = 0; j < tableDatos.getColumnCount(); j++) {
								tableDatos.setValueAt(datos[i][j], i, j);
							}
						}
						lblTitulo.setText(datos[4][1] + " " + datos[6][1]);
					
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
		
		btnSillas = new JButton("Ver Sillas");
		btnSillas.addActionListener(this);
		btnSillas.setVisible(false);
		btnSillas.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnSillas.setBounds(210, 477, 114, 23);
		contentPane.add(btnSillas);
		
		btnFlota = new JButton("Ver Flota");
		btnFlota.addActionListener(this);
		btnFlota.setVisible(false);
		btnFlota.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnFlota.setBounds(10, 477, 114, 23);
		contentPane.add(btnFlota);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 38, 314, 20);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblTitulo);
		
		tableDatos = new JTable(misAeronaves.get(0).getAtributos().size(), 2);//fila,columna
		tableDatos.setBounds(X, Y, WIDTH, HEIGHT);
		contentPane.add(tableDatos);
		tableDatos.setShowGrid(false);
		tableDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableDatos.setBorder(null);
		tableDatos.setEnabled(false);
		tableDatos.setRowHeight(HEIGHT/misAeronaves.get(0).getAtributos().size());
		tableDatos.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableDatos.getColumnModel().getColumn(1).setPreferredWidth(170);
		
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
		tableSillasEjecutiva.setRowHeight(HEIGHT/filaTotal);
		contentPane.add(tableSillasEjecutiva);
		
		for (int i = 0; i < tableSillasEjecutiva.getRowCount(); i++) {
			for (int j = 0; j < tableSillasEjecutiva.getColumnCount(); j++) {
				
				if(!sillasEjecutiva[i][j].equals("pasillo")) {
					tableSillasEjecutiva.setValueAt(sillasEjecutiva[i][j], i, j);
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
		tableSillasEconomica.setRowHeight(HEIGHT/filaTotal);
		contentPane.add(tableSillasEconomica);
		
		for (int i = 0; i < tableSillasEconomica.getRowCount(); i++) {
			for (int j = 0; j < tableSillasEconomica.getColumnCount(); j++) {
				
				if(!sillasEconomica[i][j].equals("pasillo")) {
					tableSillasEconomica.setValueAt(sillasEconomica[i][j], i, j);
				}else {
					tableSillasEconomica.setValueAt("", i, j);
				}
				
				DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
				alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				tableSillasEconomica.getColumnModel().getColumn(j).setCellRenderer(alinear);
			}
		}
		

		tableSillasEconomica.setVisible(true);
		tableSillasEjecutiva.setVisible(true);
		verSillas = true;
	}
	
	public void actionPerformed(ActionEvent e) {
		idTipoAeronave = (String) tableDatos.getValueAt(5, 1);
		if (e.getSource() == btnSillas) {
			tableDatos.setVisible(false);
			verSillas();
		}
		if (e.getSource() == btnFlota) {
			tableDatos.setVisible(false);
			System.out.println(miAerolinea.getMisAeronaves().get(0).getFlotaDeAeronaves().get(0).getRegistro().get(0).getAtributos().get("Ida o Regreso"));
		}
	}
}
