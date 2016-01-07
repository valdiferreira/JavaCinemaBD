package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.controllers.*;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionarioCria extends JPanel {

	private JFrame frame;

	public FuncionarioCria() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(284, 14, 46, 14);
		add(lblNome);
		
		JTextField nomeField = new JTextField();
		nomeField.setBounds(340, 11, 204, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(284, 45, 46, 14);
		add(lblCpf);
		
		JTextField cpfField = new JTextField();
		cpfField.setBounds(341, 42, 109, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		JLabel lblNCarteiraDe = new JLabel("N\u00BA Carteira de Trabalho");
		lblNCarteiraDe.setBounds(193, 75, 148, 14);
		add(lblNCarteiraDe);
		
		JTextField nctField = new JTextField();
		nctField.setBounds(342, 72, 148, 20);
		add(nctField);
		nctField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(284, 105, 46, 14);
		add(lblSenha);
		
		JTextField senhaField = new JTextField();
		senhaField.setBounds(340, 102, 86, 20);
		add(senhaField);
		senhaField.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(284, 137, 46, 14);
		add(lblRua);
		
		JTextField ruaField = new JTextField();
		ruaField.setBounds(340, 134, 204, 20);
		add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(284, 168, 46, 14);
		add(lblBairro);
		
		JTextField bairroField = new JTextField();
		bairroField.setBounds(340, 165, 110, 20);
		add(bairroField);
		bairroField.setColumns(10);
		
		JTextField numeroField = new JTextField();
		numeroField.setBounds(340, 197, 46, 20);
		add(numeroField);
		numeroField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(284, 200, 46, 14);
		add(lblNumero);
		
		JLabel lblCodigoDoCinema = new JLabel("Codigo do Cinema");
		lblCodigoDoCinema.setBounds(213, 231, 117, 14);
		add(lblCodigoDoCinema);
		
		JTextField cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(340, 228, 86, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioController.create(nomeField.getText(), cpfField.getText(), nctField.getText(), ruaField.getText(), bairroField.getText(), numeroField.getText(), cod_cinemaField.getText(), senhaField.getText());
				JOptionPane.showMessageDialog(null, "Funcionario criado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(337, 267, 102, 23);
		add(btnCadastrar);
		
		
	}
}
