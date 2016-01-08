package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import cinema.controllers.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ClienteCria extends JPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField nomeField;
	private JTextField codigoField;
	private JTextField cpfField;


	public ClienteCria(){
		setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(366, 105, 180, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setBounds(330, 107, 35, 14);
		add(lblNewLabel);
		
		codigoField = new JTextField();
		codigoField.setColumns(10);
		codigoField.setBounds(366, 130, 35, 20);
		add(codigoField);
		
		JLabel lblNome = new JLabel("CODIGO");
		lblNome.setBounds(319, 133, 46, 14);
		add(lblNome);
		
		cpfField = new JTextField();
		cpfField.setColumns(10);
		cpfField.setBounds(366, 154, 180, 20);
		add(cpfField);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(339, 157, 26, 14);
		add(lblCpf);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController.create(nomeField.getText(), cpfField.getText(), codigoField.getText());
				JOptionPane.showMessageDialog(null, "Cliente criado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCriar.setBounds(398, 185, 89, 23);
		add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarCliente.setBounds(366, 64, 151, 14);
		add(lblCadastrarCliente);
		
	}
}
