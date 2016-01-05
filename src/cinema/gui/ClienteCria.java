package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import cinema.controllers.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteCria extends JPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField nomeField;
	private JTextField codigoField;
	private JTextField cpfField;


	public ClienteCria(){
		setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(366, 102, 180, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setBounds(291, 105, 46, 14);
		add(lblNewLabel);
		
		codigoField = new JTextField();
		codigoField.setColumns(10);
		codigoField.setBounds(366, 133, 35, 20);
		add(codigoField);
		
		JLabel lblNome = new JLabel("CODIGO");
		lblNome.setBounds(291, 136, 46, 14);
		add(lblNome);
		
		cpfField = new JTextField();
		cpfField.setColumns(10);
		cpfField.setBounds(366, 164, 180, 20);
		add(cpfField);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(291, 167, 46, 14);
		add(lblCpf);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController.create(nomeField.getText(), cpfField.getText(), codigoField.getText());
			}
		});
		btnCriar.setBounds(418, 205, 89, 23);
		add(btnCriar);
		
	}

}
