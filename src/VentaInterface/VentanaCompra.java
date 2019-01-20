package VentaInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import VentaLogica.Compra;
import javax.swing.JTextPane;


public class VentanaCompra implements ActionListener{

	private JFrame frame;
	
	
	private ButtonGroup BGModalidad,BGClase;
	private JComboBox<String> comboBoxCiudadDestino,comboBoxCiudadOrigen,comboBoxFechaSalida,comboBoxFechaRegreso;
	private JLabel lblFechaDeRegreso; 
	private JRadioButton RadioButtonIdaYRegreso,RadioButtonSoloIda,rdbtnEconomica,rdbtnEjecutiva;
	
	
	private Compra miCompra;
	
	

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
		frame.setBounds(100, 100, 339, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 301, 221);
		frame.getContentPane().add(tabbedPane);
		
		miCompra = new Compra();		
		HashSet<String> ciudades = miCompra.getCiudades();
		

		
		
		//PANEL MODALIDAD********************************************************************************************
		JPanel panelMod = new JPanel();
		tabbedPane.addTab("Modalidad", null, panelMod, null);
		panelMod.setLayout(null);
		
		BGModalidad = new ButtonGroup();
		
		RadioButtonIdaYRegreso = new JRadioButton("Ida y regreso");
		RadioButtonIdaYRegreso.setBounds(6, 32, 109, 23);
		BGModalidad.add(RadioButtonIdaYRegreso);
		RadioButtonIdaYRegreso.addActionListener(this);
		panelMod.add(RadioButtonIdaYRegreso);
				
		RadioButtonSoloIda = new JRadioButton("Solo ida");
		RadioButtonSoloIda.setBounds(6, 58, 109, 23);
		BGModalidad.add(RadioButtonSoloIda);
		RadioButtonSoloIda.addActionListener(this);
		panelMod.add(RadioButtonSoloIda);
		
		JLabel lblEscojaSuModalidad = new JLabel("Escoja su modalidad de viaje:");
		lblEscojaSuModalidad.setBounds(10, 11, 289, 14);
		panelMod.add(lblEscojaSuModalidad);
		
		
		
		
		// PANEL CIUDAD********************************************************************************************
		JPanel panelCiudad = new JPanel();
		tabbedPane.addTab("Ciudad", null, panelCiudad, null);
		panelCiudad.setLayout(null);
		
		JLabel lblCiudadOrigen = new JLabel("Ciudad Origen");
		lblCiudadOrigen.setBounds(10, 36, 97, 17);
		panelCiudad.add(lblCiudadOrigen);
		
		comboBoxCiudadOrigen = new JComboBox();
		comboBoxCiudadOrigen.setBounds(110, 34, 169, 20);
		panelCiudad.add(comboBoxCiudadOrigen);
		
		
		JLabel lblCiudadDestino = new JLabel("Ciudad Destino");
		lblCiudadDestino.setBounds(10, 83, 97, 14);
		panelCiudad.add(lblCiudadDestino);
		
		comboBoxCiudadDestino = new JComboBox();
		comboBoxCiudadDestino.setBounds(110, 80, 169, 20);
		Iterator<String> it = ciudades.iterator();
		
		while (it.hasNext()) {
			String c = it.next();
			comboBoxCiudadDestino.addItem(c);
			comboBoxCiudadOrigen.addItem(c);
		}
		comboBoxCiudadDestino.setSelectedIndex(1);
		comboBoxCiudadDestino.addActionListener(this);
		comboBoxCiudadOrigen.addActionListener(this);
		panelCiudad.add(comboBoxCiudadDestino);
		
		JLabel lblEscojaLaCiudad = new JLabel("Escoja la ciudad de origen y para donde se dirige.");
		lblEscojaLaCiudad.setBounds(10, 11, 281, 14);
		panelCiudad.add(lblEscojaLaCiudad);
		
		JTextPane txtpnTengaEnCuenta = new JTextPane();
		txtpnTengaEnCuenta.setText("Tenga en cuenta de que para vuelos nacionales tendr\u00E1 un coste adicional del 0.8% e internacional del 0.97%");
		txtpnTengaEnCuenta.setBounds(10, 121, 269, 60);
		panelCiudad.add(txtpnTengaEnCuenta);
		
		
		
		//PANEL CLASE y CANTIDAD DE PERSONAS********************************************************************************************
		JPanel panelClase = new JPanel();
		tabbedPane.addTab("Clase del servicio", null, panelClase, null);
		panelClase.setLayout(null);
		
		BGClase =new ButtonGroup();
		
		rdbtnEconomica = new JRadioButton("Economica");
		rdbtnEconomica.setBounds(10, 35, 109, 23);
		BGClase.add(rdbtnEconomica);
		panelClase.add(rdbtnEconomica);
		
		rdbtnEjecutiva = new JRadioButton("Ejecutiva");
		rdbtnEjecutiva.setBounds(10, 61, 109, 23);
		BGClase.add(rdbtnEjecutiva);
		panelClase.add(rdbtnEjecutiva);
		
		JLabel lblEscojaLaClase = new JLabel("Escoja la clase preferente del viaje.");
		lblEscojaLaClase.setBounds(10, 11, 241, 14);
		panelClase.add(lblEscojaLaClase);
		
		
		
		//PANEL FECHAS********************************************************************************************
		JPanel panelFechas = new JPanel();
		tabbedPane.addTab("Fechas", null, panelFechas, null);
		panelFechas.setLayout(null);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida (DD/MM/AAAA)");
		lblFechaDeSalida.setBounds(10, 11, 161, 14);
		panelFechas.add(lblFechaDeSalida);
		
		lblFechaDeRegreso = new JLabel("Fecha de regreso (DD/MM/AAAA)");
		lblFechaDeRegreso.setBounds(10, 67, 161, 14);
		panelFechas.add(lblFechaDeRegreso);
		
		comboBoxFechaSalida = new JComboBox();
		comboBoxFechaSalida.setBounds(10, 36, 147, 20);
		panelFechas.add(comboBoxFechaSalida);
		
		comboBoxFechaRegreso = new JComboBox();
		comboBoxFechaRegreso.setBounds(10, 92, 147, 20);
		panelFechas.add(comboBoxFechaRegreso);
		
		JLabel label = new JLabel("Cantidad de personas");
		label.setBounds(10, 136, 109, 14);
		panelFechas.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(142, 133, 29, 20);
		panelFechas.add(spinner);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==RadioButtonSoloIda) {
			comboBoxFechaRegreso.hide();
			lblFechaDeRegreso.hide();
		}
		if(e.getSource()==RadioButtonIdaYRegreso) {
			comboBoxFechaRegreso.show();
			lblFechaDeRegreso.show();
		}
		
		if (e.getSource() == comboBoxCiudadOrigen) {
			if (!comboBoxCiudadOrigen.getSelectedItem().equals("CDMX")) {
				comboBoxCiudadDestino.setSelectedIndex(0);
				comboBoxCiudadDestino.disable();
			}else {
				comboBoxCiudadDestino.enable();
				comboBoxCiudadDestino.setSelectedIndex(1);
			}
		}
		
		if (e.getSource()==comboBoxCiudadDestino) {
			
			List<String> fechasSalida = miCompra.getFechasDeCiudad(String.valueOf(comboBoxCiudadDestino.getSelectedItem()));			
			Iterator<String> it = fechasSalida.iterator();
			while (it.hasNext()) {
				String f = it.next();
				comboBoxFechaSalida.addItem(f);
				comboBoxFechaRegreso.addItem(f);
			}
		}
	}
}
