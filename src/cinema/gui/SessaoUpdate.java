package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SessaoUpdate extends JPanel {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField cod_cinemaField;
	private JTextField cod_filmeField;
	private JTextField data_horaField;
	private JTextField numero_salaField;
	private JTextField qtd_publicoField;
	private JTextField cpfField;
	private JTextField funcaoField;
	private JTextField sessaoField;

	public SessaoUpdate(Sessao sessao) {
		setLayout(null);
		
		JLabel lblInformaesDaSessao = new JLabel("Informa\u00E7\u00F5es da Sess\u00E3o");
		lblInformaesDaSessao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDaSessao.setBounds(148, 42, 195, 14);
		add(lblInformaesDaSessao);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(148, 81, 46, 14);
		add(lblCodigo);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setBounds(204, 78, 35, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigoDoCinema = new JLabel("Codigo do Cinema");
		lblCodigoDoCinema.setBounds(92, 103, 102, 14);
		add(lblCodigoDoCinema);
		
		cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(204, 103, 35, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		cod_filmeField = new JTextField();
		cod_filmeField.setBounds(204, 128, 35, 20);
		add(cod_filmeField);
		cod_filmeField.setColumns(10);
		
		JLabel lblCodigoDoFilme = new JLabel("Codigo do Filme");
		lblCodigoDoFilme.setBounds(102, 131, 92, 14);
		add(lblCodigoDoFilme);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(159, 157, 35, 14);
		add(lblData);
		
		data_horaField = new JTextField();
		data_horaField.setBounds(204, 154, 86, 20);
		add(data_horaField);
		data_horaField.setColumns(10);
		
		JLabel lblNumeroDaSala = new JLabel("Numero da Sala");
		lblNumeroDaSala.setBounds(102, 179, 92, 14);
		add(lblNumeroDaSala);
		
		numero_salaField = new JTextField();
		numero_salaField.setBounds(204, 176, 35, 20);
		add(numero_salaField);
		numero_salaField.setColumns(10);
		
		qtd_publicoField = new JTextField();
		qtd_publicoField.setBounds(204, 200, 35, 20);
		add(qtd_publicoField);
		qtd_publicoField.setColumns(10);
		
		JLabel lblPublico = new JLabel("Publico");
		lblPublico.setBounds(148, 203, 46, 14);
		add(lblPublico);
		
		cod_cinemaField.setText(sessao.getCod_cinema());
		cod_filmeField.setText(sessao.getCod_filme());
		codigoField.setText(sessao.getCodigo());
		data_horaField.setText(sessao.getData_hora().substring(0,10));
		numero_salaField.setText(sessao.getNumero_sala());
		qtd_publicoField.setText(sessao.getQtd_publico());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sessao.setCod_cinema(cod_cinemaField.getText());
				sessao.setCod_filme(cod_filmeField.getText());
				sessao.setData_hora(data_horaField.getText());
				sessao.setNumero_sala(numero_salaField.getText());
				sessao.setQtd_publico(qtd_publicoField.getText());
				SessaoController.update(sessao);
				JOptionPane.showMessageDialog(null, "Sessão atualizada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAtualizar.addMouseListener(new MouseAdapter() {
		});
		btnAtualizar.addContainerListener(new ContainerAdapter() {
		});
		btnAtualizar.setBounds(123, 231, 102, 23);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessaoController.delete(codigoField.getText());
				JOptionPane.showMessageDialog(null, "Sessão deletada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(235, 231, 89, 23);
		add(btnDeletar);
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD 2015-12-23");
		lblExAaaammdd.setBounds(300, 157, 166, 14);
		add(lblExAaaammdd);
		
		JLabel lblCadastrarFuncionrioA = new JLabel("Cadastrar Funcion\u00E1rio em uma Sess\u00E3o");
		lblCadastrarFuncionrioA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarFuncionrioA.setBounds(502, 42, 305, 14);
		add(lblCadastrarFuncionrioA);
		
		JLabel lblCpfDoFuncionrio = new JLabel("CPF do Funcion\u00E1rio");
		lblCpfDoFuncionrio.setBounds(502, 81, 115, 14);
		add(lblCpfDoFuncionrio);
		
		cpfField = new JTextField();
		cpfField.setBounds(627, 78, 118, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		funcaoField = new JTextField();
		funcaoField.setBounds(627, 103, 29, 20);
		add(funcaoField);
		funcaoField.setColumns(10);
		
		JLabel lblCodigoDaFuno = new JLabel("Codigo da Fun\u00E7\u00E3o");
		lblCodigoDaFuno.setBounds(515, 106, 102, 14);
		add(lblCodigoDaFuno);
		
		JLabel lblCodigoDaSesso = new JLabel("Codigo da Sess\u00E3o");
		lblCodigoDaSesso.setBounds(515, 131, 102, 14);
		add(lblCodigoDaSesso);
		
		sessaoField = new JTextField();
		sessaoField.setEditable(false);
		sessaoField.setBounds(627, 128, 29, 20);
		add(sessaoField);
		sessaoField.setColumns(10);
		sessaoField.setText(sessao.getCodigo());
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessaoController.add_func(cpfField.getText(), sessaoField.getText(), funcaoField.getText());
			}
		});
		btnCadastrar.setBounds(565, 157, 92, 23);
		add(btnCadastrar);
		
		JButton btnDeletar_1 = new JButton("Deletar");
		btnDeletar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessaoController.del_func(cpfField.getText(), sessaoField.getText(), funcaoField.getText());
			}
		});
		btnDeletar_1.setBounds(667, 157, 89, 23);
		add(btnDeletar_1);
		
	}
}
