package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EmbarqueLogica.Carro;
import EmbarqueLogica.Embarque;
import VentaLogica.Maleta;
import VentaLogica.MaletaEmbarque;
import mundo.CaribeAirlines;

public class AsignarMaletas extends JInternalFrame  implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JLabel lblCarro ;
	private Embarque miEmbarque;
	private JComboBox comboBoxCarrosEncolados;
	private Carro miCarro;
	private JButton btnActualizar,add,btnEnviarCarro ; 
	private JComboBox comboBoxMaletas;
	private VentanaEquipaje miVentanaEquipaje; 

	public AsignarMaletas(VentanaEquipaje miVentanaEquipaje) {
		this.miVentanaEquipaje = miVentanaEquipaje;
		miEmbarque = this.miVentanaEquipaje.getMiEmbarque();

		setTitle("Asignar maletas");
		setBounds(0, 220, 380, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Maleta", "Peso"
			}
		));
		table.setBounds(10, 108, 343, 264);
		contentPane.add(table);

		comboBoxMaletas= new JComboBox();
		comboBoxMaletas.setBounds(20, 74, 243, 23);
		contentPane.add(comboBoxMaletas);

		add = new JButton("+");
		add.setBounds(273, 74, 80, 23);
		add.addActionListener(this);
		contentPane.add(add);

		JLabel lblAgregarMaletas = new JLabel("Agregar maletas:");
		lblAgregarMaletas.setBounds(20, 42, 144, 20);
		contentPane.add(lblAgregarMaletas);

		lblCarro = new JLabel("Carro        #");
		lblCarro.setBounds(20, 15, 115, 15);
		contentPane.add(lblCarro);
		
		btnEnviarCarro = new JButton("Enviar carro");
		btnEnviarCarro.setBounds(178, 386, 175, 23);
		contentPane.add(btnEnviarCarro);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(236, 10, 117, 25);
		btnActualizar.addActionListener(this);
		contentPane.add(btnActualizar);
		
	}
	
	private void actualizarMismaletas() {
		ArrayList<MaletaEmbarque> m = miEmbarque.getMisMaletas();
		System.out.println("Tamano de las maleta "+m.size());
		for (int i = 0; i < m.size(); i++) { // i < CarrosDisponibles.length
			comboBoxMaletas.addItem( "Id:"+m.get(i).getIdMaleta()+", peso:"+m.get(i).getPeso()); 
		}
		
	}

	public void setCarro() {
		miCarro = miEmbarque.getCarrosEncolados().desencolar();
		lblCarro.setText("Carro #"+miCarro.getIdCarro());
		//System.out.println(miEmbarque.getCarrosEncolados().getPrimero().getValorNodo());

		EncolarCarros n = (EncolarCarros) miVentanaEquipaje.getVentanaEncolar();
		n.llenarTablaColaCarros();
		
	}
	private int pesoTotalCarro=0;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (btnActualizar==e.getSource()) {
			if (!miEmbarque.getCarrosEncolados().estaVacia()) {
				setCarro();
				actualizarMismaletas();
			}else {
				JOptionPane.showMessageDialog(null, "No hay carros para asignar maletas");
			}
		}
		
		if (add == e.getSource()) {
			String maletica = (String) comboBoxMaletas.getSelectedItem();
			int pos = comboBoxMaletas.getSelectedIndex();
			Double peso = Double.parseDouble(maletica.split(":")[2]);
			if (peso +pesoTotalCarro<=500) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				comboBoxMaletas.removeItemAt(pos);
				String[] s = {maletica.split(":")[1].split(",")[0],peso+""};
				pesoTotalCarro+=peso;
				modelo.addRow(s);
			}else {
				JOptionPane.showMessageDialog(null, "La maleta que desea ingrear supera la capacidad maxima del carro 500 y tiene "+pesoTotalCarro	);
				JOptionPane.showMessageDialog(null, "Escoja una maleta de menor tamanio o actualice el carro"	);
			}
		}
		if (btnEnviarCarro==e.getSource()) {
			if (pesoTotalCarro==0) {
				JOptionPane.showMessageDialog(null, "No hay carro cargado para enviar");
			}else {
				pesoTotalCarro=0;
				miVentanaEquipaje.getVentanaEmbarqueAvion().setVisible(true);
			}
		}
	}
	
	
}
