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

	public AsignarMaletas() {
		setTitle("Asignar maletas");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 42, 119, 20);
		contentPane.add(comboBox);

		JButton btnAcceptar = new JButton("Aceptar");
		btnAcceptar.setBounds(306, 41, 132, 23);
		contentPane.add(btnAcceptar);

		JLabel lblSeleccioneElVuelo = new JLabel("Seleccione el vuelo:");
		lblSeleccioneElVuelo.setBounds(12, 45, 144, 14);
		contentPane.add(lblSeleccioneElVuelo);

		table = new JTable();
		table.setBounds(10, 108, 414, 142);
		contentPane.add(table);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(164, 76, 186, 20);
		contentPane.add(comboBox_1);

		JButton button = new JButton("+");
		button.setBounds(374, 73, 64, 23);
		contentPane.add(button);

		JLabel lblAgregarMaletas = new JLabel("Agregar maletas:");
		lblAgregarMaletas.setBounds(10, 76, 144, 20);
		contentPane.add(lblAgregarMaletas);

		JLabel lblCarro = new JLabel("Carro #01");
		lblCarro.setBounds(12, 12, 70, 15);
		contentPane.add(lblCarro);
	}

}
