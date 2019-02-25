package equipajeInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class AsignarMaletas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarMaletas frame = new AsignarMaletas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AsignarMaletas() {
		setTitle("Asignar maletas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 8, 109, 20);
		contentPane.add(comboBox);
		
		JButton btnAcceptar = new JButton("Acceptar");
		btnAcceptar.setBounds(299, 7, 125, 23);
		contentPane.add(btnAcceptar);
		
		JLabel lblSeleccioneElVuelo = new JLabel("Seleccione el vuelo:");
		lblSeleccioneElVuelo.setBounds(10, 11, 144, 14);
		contentPane.add(lblSeleccioneElVuelo);
		
		table = new JTable();
		table.setBounds(10, 119, 414, 131);
		contentPane.add(table);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(164, 42, 186, 20);
		contentPane.add(comboBox_1);
		
		JButton button = new JButton("+");
		button.setBounds(360, 41, 64, 23);
		contentPane.add(button);
		
		JLabel lblAgregarMaletas = new JLabel("Agregar maletas:");
		lblAgregarMaletas.setBounds(10, 36, 114, 20);
		contentPane.add(lblAgregarMaletas);
	}
}
