package aeronavesInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import mundo.CaribeAirlines;

import javax.swing.JTable;
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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import aeronaveLogica.TipoAeronave;

import java.awt.Color;

public class VentanaAeronave extends JFrame{

	private JPanel contentPane;
	private JTable tableAeronaves;
	private JTable tableDatos;

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
		CaribeAirlines miAerolinea = new CaribeAirlines();
		List<TipoAeronave> misAeronaves = miAerolinea.getMisAeronaves();
		
		setTitle("TiposAeronaves");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableDatos = new JTable(misAeronaves.get(0).getAtributos().size(), 2);//fila,columna
		tableDatos.setShowGrid(false);
		tableDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableDatos.setBorder(null);
		tableDatos.setEnabled(false);
		tableDatos.setRowHeight(202 / misAeronaves.get(0).getAtributos().size());
		tableDatos.getColumnModel().getColumn(0).setPreferredWidth(140);
		tableDatos.getColumnModel().getColumn(1).setPreferredWidth(178);
		tableDatos.setBounds(10, 48, 318, 202);
		contentPane.add(tableDatos);
		
		tableAeronaves = new JTable(1, misAeronaves.size());//fila,columna
		tableAeronaves.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableAeronaves.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableAeronaves.setEnabled(false);
		tableAeronaves.setRowHeight(23);
		tableAeronaves.setBounds(10, 11, 414, 23);
		tableAeronaves.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						int opcion = tableAeronaves.columnAtPoint(e.getPoint());
						
						String[][] datos = miAerolinea.llenarTablaDeDatosAeronave(opcion);
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
				
				DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
				Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				tableAeronaves.getColumnModel().getColumn(j).setCellRenderer(Alinear);
				
				String tipo = misAeronaves.get(j).getAtributos().get("Marca") + " " + misAeronaves.get(j).getAtributos().get("Linea");
				tableAeronaves.setValueAt(tipo, i, j);
			}
		}
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(335, 193, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnFlota = new JButton("Ver Flota");
		btnFlota.setBounds(338, 159, 89, 23);
		contentPane.add(btnFlota);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
	}
}
