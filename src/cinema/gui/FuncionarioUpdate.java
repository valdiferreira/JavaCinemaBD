package cinema.gui;



import cinema.dominio.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import cinema.controllers.*;

import javax.swing.ImageIcon;

import java.awt.Font;

@SuppressWarnings("serial")
public class FuncionarioUpdate {

	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField nctField;
	private JTextField senhaField;
	private JTextField ruaField;
	private JTextField bairroField;
	private JTextField numeroField;
	private JTextField cod_cinemaField;

	public FuncionarioUpdate(Funcionario funcionario) {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(284, 40, 46, 14);
		add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(340, 37, 204, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(284, 71, 46, 14);
		add(lblCpf);
		
		cpfField = new JTextField();
		cpfField.setEditable(false);
		cpfField.setBounds(341, 68, 109, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		JLabel lblNCarteiraDe = new JLabel("N\u00BA Carteira de Trabalho");
		lblNCarteiraDe.setBounds(193, 101, 148, 14);
		add(lblNCarteiraDe);
		
		nctField = new JTextField();
		nctField.setBounds(342, 98, 148, 20);
		add(nctField);
		nctField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(284, 131, 46, 14);
		add(lblSenha);
		
		senhaField = new JTextField();
		senhaField.setBounds(340, 128, 86, 20);
		add(senhaField);
		senhaField.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(284, 163, 46, 14);
		add(lblRua);
		
		ruaField = new JTextField();
		ruaField.setBounds(340, 160, 204, 20);
		add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(284, 194, 46, 14);
		add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(340, 191, 110, 20);
		add(bairroField);
		bairroField.setColumns(10);
		
		numeroField = new JTextField();
		numeroField.setBounds(340, 223, 46, 20);
		add(numeroField);
		numeroField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(284, 226, 46, 14);
		add(lblNumero);
		
		JLabel lblCodigoDoCinema = new JLabel("Codigo do Cinema");
		lblCodigoDoCinema.setBounds(213, 257, 117, 14);
		add(lblCodigoDoCinema);
		
		cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(340, 254, 86, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		bairroField.setText(funcionario.getBairro());
		cod_cinemaField.setText(funcionario.getCod_cinema());
		cpfField.setText(funcionario.getCpf());
		nctField.setText(funcionario.getNct());
		nomeField.setText(funcionario.getNome());
		numeroField.setText(funcionario.getNumero());
		ruaField.setText(funcionario.getRua());
		senhaField.setText(funcionario.getSenha());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon("img/atualizar.png"));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario.setBairro(bairroField.getText());
				funcionario.setCod_cinema(cod_cinemaField.getText());
				funcionario.setCpf(cpfField.getText());
				funcionario.setNct(nctField.getText());
				funcionario.setNome(nomeField.getText());
				funcionario.setNumero(numeroField.getText());
				funcionario.setRua(ruaField.getText());
				funcionario.setSenha(senhaField.getText());
				FuncionarioController.update(funcionario);
				JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAtualizar.setBounds(302, 282, 89, 23);
		add(btnAtualizar);
		btnAtualizar.setBorder(new RoundedBorder(5));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon("img/delete.png"));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioController.delete(cpfField.getText());
				JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(401, 282, 89, 23);
		add(btnDeletar);
		btnDeletar.setBorder(new RoundedBorder(5));
		
		JLabel lblInformaesDoFuncionrio = new JLabel("Informa\u00E7\u00F5es do Funcion\u00E1rio");
		lblInformaesDoFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDoFuncionrio.setBounds(302, 11, 242, 14);
		add(lblInformaesDoFuncionrio);
		
	}
}
