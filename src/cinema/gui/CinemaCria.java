package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.controllers.*;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CinemaCria extends JPanel{

	private JFrame frame;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField ruaField;
	private JTextField numeroField;
	private JTextField codField;
	private JTextField telefoneField;
	private JButton btnCadastrar;
	private JLabel lblCadastrarCinema;
	
	public CinemaCria() {
		setLayout(null);
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(186, 61, 46, 14);
		add(lblCodigo);
		
		codigoField = new JTextField();
		codigoField.setBounds(232, 58, 40, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(186, 86, 46, 14);
		add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(232, 86, 200, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(186, 115, 46, 14);
		add(lblCidade);
		
		cidadeField = new JTextField();
		cidadeField.setBounds(232, 111, 86, 20);
		add(cidadeField);
		cidadeField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(186, 140, 46, 14);
		add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(232, 137, 86, 20);
		add(bairroField);
		bairroField.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(186, 165, 46, 14);
		add(lblRua);
		
		ruaField = new JTextField();
		ruaField.setBounds(232, 165, 208, 20);
		add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(186, 197, 46, 14);
		add(lblNumero);
		
		numeroField = new JTextField();
		numeroField.setBounds(232, 194, 46, 20);
		add(numeroField);
		numeroField.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaController.create(bairroField.getText(), cidadeField.getText(), codigoField.getText(), nomeField.getText(), numeroField.getText(), ruaField.getText());
				JOptionPane.showMessageDialog(null, "Cinema criado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.setBounds(232, 222, 115, 23);
		add(btnCadastrar);
		btnCadastrar.setBorder(new RoundedBorder(5));
		
		lblCadastrarCinema = new JLabel("Cadastrar Cinema");
		lblCadastrarCinema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarCinema.setBounds(196, 27, 151, 14);
		add(lblCadastrarCinema);
	}

}
