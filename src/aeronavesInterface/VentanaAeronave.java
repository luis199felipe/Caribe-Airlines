package aeronavesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.CaribeAirlines;
import rutaLogica.Ruta;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import aeronaveLogica.Aeronave;
import aeronaveLogica.DistribucionSillas;
import aeronaveLogica.TipoAeronave;

import java.awt.Color;
import javax.swing.JScrollPane;

public class VentanaAeronave extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JScrollPane scrollPaneRegistro, scrollPaneMasDetalles;
	private JTable tableAeronaves, tableDatos, tableSillasEjecutiva, tableSillasEconomica, tableFlota, tableRegistro, tableMasDetalles;
	private JButton btnSillas, btnFlota, btnMasDetalles;
	private JLabel lblTitulo, lblRegistro ;
	private boolean verSillas, verFlota, verMasDetalles;
	private int posTipoAerolinea, posAeronave, posRuta;
	private CaribeAirlines miAerolinea;
	
	private static final int X = 10;
	private static final int Y = 65;
	private static final int WIDTH = 314;
	private static final int HEIGHT = 405;
	private static final int LETRA = 14;
	private static final int ROW_HEIGHT = 35;

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
		verMasDetalles = false;
		posRuta = -1;
		
		setTitle("Aeronaves");
		setBounds(100, 100, 350, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableAeronaves = new JTable(1, misAeronaves.size());
		tableAeronaves.setEnabled(false);
		tableAeronaves.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableAeronaves.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		tableAeronaves.setRowHeight(23);
		tableAeronaves.setBounds(10, 11, 314, 21);
		tableAeronaves.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						if(verSillas == true) {
							tableSillasEconomica.setVisible(false);
							tableSillasEjecutiva.setVisible(false);
						}
						if(verFlota == true) {
							tableFlota.setVisible(false);
							lblRegistro.setVisible(false);
							tableRegistro.setVisible(false);
							scrollPaneRegistro.setVisible(false);
							btnMasDetalles.setVisible(false);
						}
						if(verMasDetalles == true) {
							posRuta = -1;
							tableMasDetalles.setVisible(false);
							scrollPaneMasDetalles.setVisible(false);
						}

						int column = tableAeronaves.columnAtPoint(e.getPoint());
						obtenerPosTipoAeronave(column);
						
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

		btnMasDetalles = new JButton("mas Detalles");
		btnMasDetalles.addActionListener(this);
		btnMasDetalles.setVisible(false);
		btnMasDetalles.setBounds(210, 443, 114, 23);
		btnMasDetalles.setFont(new Font("Tahoma", Font.BOLD, 9));
		contentPane.add(btnMasDetalles);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 38, 314, 21);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		contentPane.add(lblTitulo);
		
		tableDatos = new JTable(misAeronaves.get(0).getAtributos().size(), 2);//fila,columna
		tableDatos.setBounds(X, Y, WIDTH, HEIGHT);
		tableDatos.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tableDatos.setBorder(null);
		tableDatos.setEnabled(false);
		tableDatos.setShowGrid(false);
		tableDatos.setRowHeight(HEIGHT/misAeronaves.get(0).getAtributos().size());
		tableDatos.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableDatos.getColumnModel().getColumn(1).setPreferredWidth(170);
		contentPane.add(tableDatos);
		
	}
	
	public void verMasDetalles() {
		if(posRuta != -1) {
			if(verFlota == true) {
				tableRegistro.setVisible(false);
				scrollPaneRegistro.setVisible(false);
				btnMasDetalles.setVisible(false);
			}
			
			Ruta miRuta = miAerolinea.getMisAeronaves().get(posTipoAerolinea).getFlotaDeAeronaves().get(posAeronave).getRegistro().get(posRuta);
			String[][] datos = miAerolinea.llenarTablaDeMasDetalles(miRuta);
			
			tableMasDetalles = new JTable();
			tableMasDetalles.setModel(new DefaultTableModel(new Object[datos.length][2],new String[] {"Detalles","Informacion"}));
			tableMasDetalles.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
			tableMasDetalles.setBorder(null);
			tableMasDetalles.setEnabled(false);
			tableMasDetalles.setShowGrid(true);
			tableMasDetalles.setRowHeight(ROW_HEIGHT);
			tableMasDetalles.getColumnModel().getColumn(0).setPreferredWidth(120);
			tableMasDetalles.getColumnModel().getColumn(1).setPreferredWidth(170);
			
			for (int i = 0; i < tableMasDetalles.getRowCount(); i++) {
				for (int j = 0; j < tableMasDetalles.getColumnCount(); j++) {
					tableMasDetalles.setValueAt(datos[i][j], i, j);
				}
			}
			
			scrollPaneMasDetalles = new JScrollPane();
			scrollPaneMasDetalles.setBounds(X, Y+50, WIDTH, HEIGHT-50);
			scrollPaneMasDetalles.setViewportView(tableMasDetalles);
			contentPane.add(scrollPaneMasDetalles);
			
			btnMasDetalles.setVisible(false);
			verMasDetalles = true;
		}else {
			JOptionPane.showMessageDialog(null, "seleccione una ruta");
		}
	}

	public void verFlota() {
		
		if(verSillas == true) {
			tableSillasEconomica.setVisible(false);
			tableSillasEjecutiva.setVisible(false);
		}
		if(verMasDetalles == true) {
			posRuta = -1;
			tableMasDetalles.setVisible(false);
			scrollPaneMasDetalles.setVisible(false);
		}
		
		List<Aeronave> miFlota = miAerolinea.getMisAeronaves().get(posTipoAerolinea).getFlotaDeAeronaves();
		
		if(verFlota == false) {
		tableFlota = new JTable(1, miFlota.size());
		lblRegistro = new JLabel();
		}else {
			DefaultTableModel modeloFlota = (DefaultTableModel)tableFlota.getModel(); 
			modeloFlota.setColumnCount(miFlota.size());
			lblRegistro.setText("");
		}
		
		for (int i = 0; i < tableFlota.getRowCount(); i++) {
			for (int j = 0; j < tableFlota.getColumnCount(); j++) {

				DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
				alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				tableFlota.getColumnModel().getColumn(j).setCellRenderer(alinear);
				
				tableFlota.setValueAt(miFlota.get(j).getMatricula(), i, j);
			}
		}
		
		tableRegistro = new JTable(0,0);
		tableRegistro.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		tableRegistro.setBorder(null);
		tableRegistro.setEnabled(false);
		tableRegistro.setShowGrid(true);
		tableRegistro.setRowHeight(ROW_HEIGHT);
		tableRegistro.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int row = tableRegistro.rowAtPoint(e.getPoint());
						obtenerPosRuta(row);
					}
				});
		scrollPaneRegistro = new JScrollPane();
		scrollPaneRegistro.setBounds(X, Y+50, WIDTH, HEIGHT-50-30);
		scrollPaneRegistro.setViewportView(tableRegistro);
		contentPane.add(scrollPaneRegistro);
		
		lblRegistro.setBounds(10, 90, 314, 21);
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, LETRA));
		contentPane.add(lblRegistro);
		
		tableFlota.setEnabled(false);
		tableFlota.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableFlota.setFont(new Font("Tahoma", Font.BOLD, LETRA));
		tableFlota.setRowHeight(23);
		tableFlota.setShowGrid(true);
		tableFlota.setBounds(X, Y, WIDTH, 21);
		tableFlota.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						if(verMasDetalles == true) {
							posRuta = -1;
							tableMasDetalles.setVisible(false);
							scrollPaneMasDetalles.setVisible(false);
						}
						
						int column = tableFlota.columnAtPoint(e.getPoint());
						obtenerPosAveronave(column);

						lblRegistro.setVisible(true);
						tableRegistro.setVisible(true);
						scrollPaneRegistro.setVisible(true);
						btnMasDetalles.setVisible(true);
						
						List<Ruta> miRegistro = miFlota.get(posAeronave).getRegistro();
						
						tableRegistro.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Fecha", "Origen", "Destino", "HoraSalida"}));
						
						DefaultTableModel modeloRegistro = (DefaultTableModel)tableRegistro.getModel(); 
						modeloRegistro.setRowCount(miRegistro.size());
						
						List<List<String>> datosMostrar = new ArrayList<>();
						
						for (int i = 0; i < miRegistro.size(); i++) {
							List<String> elemento = new ArrayList<>();
							elemento.add(miRegistro.get(i).getAtributos().get("Fecha"));
							elemento.add(miRegistro.get(i).getAtributos().get("Origen"));
							elemento.add(miRegistro.get(i).getAtributos().get("Destino"));
							elemento.add(miRegistro.get(i).getAtributos().get("HoraSalida"));
							datosMostrar.add(elemento);
						}
						
						for (int i = 0; i < tableRegistro.getRowCount(); i++) {
							for (int j = 0; j < tableRegistro.getColumnCount(); j++) {
								tableRegistro.setValueAt(datosMostrar.get(i).get(j), i, j);
							}
						}
						
						lblRegistro.setText("Registro Rutas Aeronave " + miFlota.get(column).getMatricula());
						
					}
				});
		contentPane.add(tableFlota);

		tableFlota.setVisible(true);
		lblRegistro.setVisible(false);
		tableRegistro.setVisible(false);
		scrollPaneRegistro.setVisible(false);
		btnMasDetalles.setVisible(false);
		verFlota = true;
	}
	
	public void verSillas() {
		
		if(verFlota == true) {
			tableFlota.setVisible(false);
			lblRegistro.setVisible(false);
			tableRegistro.setVisible(false);
			scrollPaneRegistro.setVisible(false);
			btnMasDetalles.setVisible(false);
		}
		if(verMasDetalles == true) {
			posRuta = -1;
			tableMasDetalles.setVisible(false);
			scrollPaneMasDetalles.setVisible(false);
		}
		
		DistribucionSillas ubicacionSillas = miAerolinea.getMisAeronaves().get(posTipoAerolinea).getUbicacionSillas();
		
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
		if (e.getSource() == btnSillas) {
			tableDatos.setVisible(false);
			verSillas();
		}
		if (e.getSource() == btnFlota) {
			tableDatos.setVisible(false);
			verFlota();
		}
		if (e.getSource() == btnMasDetalles) {
			tableDatos.setVisible(false);
			verMasDetalles();
		}
	}

	public void obtenerPosTipoAeronave(int pos) {
		posTipoAerolinea = pos;
	}
	
	public void obtenerPosRuta(int pos) {
		posRuta = pos;
	}
	
	public void obtenerPosAveronave(int pos) {
		posAeronave = pos;
	}
}
