package cinema.gui;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cinema.controllers.*;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FuncionarioCria {


	public FuncionarioCria() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(279, 57, 46, 14);
		add(lblNome);
		
		JTextField nomeField = new JTextField();
		nomeField.setBounds(335, 54, 204, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(279, 85, 46, 14);
		add(lblCpf);
		
		JTextField cpfField = new JTextField();
		cpfField.setBounds(336, 82, 109, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		JLabel lblNCarteiraDe = new JLabel("N\u00BA Carteira de Trabalho");
		lblNCarteiraDe.setBounds(187, 113, 148, 14);
		add(lblNCarteiraDe);
		
		JTextField nctField = new JTextField();
		nctField.setBounds(336, 110, 148, 20);
		add(nctField);
		nctField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(280, 141, 46, 14);
		add(lblSenha);
		
		JTextField senhaField = new JTextField();
		senhaField.setBounds(336, 138, 86, 20);
		add(senhaField);
		senhaField.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(279, 169, 46, 14);
		add(lblRua);
		
		JTextField ruaField = new JTextField();
		ruaField.setBounds(335, 166, 204, 20);
		add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(279, 197, 46, 14);
		add(lblBairro);
		
		JTextField bairroField = new JTextField();
		bairroField.setBounds(335, 194, 110, 20);
		add(bairroField);
		bairroField.setColumns(10);
		
		JTextField numeroField = new JTextField();
		numeroField.setBounds(336, 225, 46, 20);
		add(numeroField);
		numeroField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(280, 228, 46, 14);
		add(lblNumero);
		
		JLabel lblCodigoDoCinema = new JLabel("Codigo do Cinema");
		lblCodigoDoCinema.setBounds(217, 256, 109, 14);
		add(lblCodigoDoCinema);
		
		JTextField cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(336, 253, 86, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioController.create(nomeField.getText(), cpfField.getText(), nctField.getText(), ruaField.getText(), bairroField.getText(), numeroField.getText(), cod_cinemaField.getText(), senhaField.getText());
				JOptionPane.showMessageDialog(null, "Funcionario criado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(332, 284, 102, 23);
		add(btnCadastrar);
		btnCadastrar.setBorder(new RoundedBorder(5));
		
		JLabel lblCadastrarFuncionrios = new JLabel("Cadastrar Funcion\u00E1rios");
		lblCadastrarFuncionrios.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarFuncionrios.setBounds(295, 11, 203, 14);
		add(lblCadastrarFuncionrios);
		
	}
}
