package VentaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class VentanaCompra {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCompra window = new VentanaCompra();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 395, 258);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelMod = new JPanel();
		tabbedPane.addTab("Modalidad", null, panelMod, null);
		panelMod.setLayout(null);
		
		JRadioButton rdbtnIdaYRegreso = new JRadioButton("Ida y regreso");
		rdbtnIdaYRegreso.setBounds(32, 69, 109, 23);
		panelMod.add(rdbtnIdaYRegreso);
		
		JRadioButton rdbtnSoloIda = new JRadioButton("Solo ida");
		rdbtnSoloIda.setBounds(32, 124, 109, 23);
		panelMod.add(rdbtnSoloIda);
		
		JPanel panelCiudad = new JPanel();
		tabbedPane.addTab("Ciudad", null, panelCiudad, null);
		panelCiudad.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 82, 169, 20);
		panelCiudad.add(comboBox);
		
		JLabel lblCiudadOrigen = new JLabel("Ciudad Origen");
		lblCiudadOrigen.setBounds(10, 82, 97, 17);
		panelCiudad.add(lblCiudadOrigen);
		
		JLabel lblCiudadDestino = new JLabel("Ciudad Destino");
		lblCiudadDestino.setBounds(10, 138, 97, 14);
		panelCiudad.add(lblCiudadDestino);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(144, 135, 169, 20);
		panelCiudad.add(comboBox_1);
		
		JPanel panelClase = new JPanel();
		tabbedPane.addTab("Clase del servicio", null, panelClase, null);
		panelClase.setLayout(null);
		
		JRadioButton rdbtnEconomica = new JRadioButton("Economica");
		rdbtnEconomica.setBounds(25, 30, 109, 23);
		panelClase.add(rdbtnEconomica);
		
		JRadioButton rdbtnEjecutiva = new JRadioButton("Ejecutiva");
		rdbtnEjecutiva.setBounds(25, 68, 109, 23);
		panelClase.add(rdbtnEjecutiva);
		
		JLabel lblCantidadDePersonas = new JLabel("Cantidad de personas");
		lblCantidadDePersonas.setBounds(25, 128, 109, 14);
		panelClase.add(lblCantidadDePersonas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(144, 125, 29, 20);
		panelClase.add(spinner);
		
		JPanel panelFechas = new JPanel();
		tabbedPane.addTab("Fechas", null, panelFechas, null);
		panelFechas.setLayout(null);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida (DD/MM/AA)");
		lblFechaDeSalida.setBounds(10, 60, 161, 14);
		panelFechas.add(lblFechaDeSalida);
		
		JLabel lblFechaDeRegreso = new JLabel("Fecha de regreso (DD/MM/AA)");
		lblFechaDeRegreso.setBounds(10, 133, 147, 14);
		panelFechas.add(lblFechaDeRegreso);
		
		textField = new JTextField();
		textField.setBounds(213, 57, 147, 20);
		panelFechas.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 130, 147, 20);
		panelFechas.add(textField_1);
	}
}
