package cinema.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.MouseAdapter;

import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SessaoCria extends JPanel{

	private JFrame frame;
	private JTextField codigoField;
	private JTextField cod_cinemaField;
	private JTextField cod_filmeField;
	private JTextField data_horaField;
	private JTextField numero_salaField;
	private JTextField qtd_publicoField;
	
	public SessaoCria() {
		setLayout(null);
		JLabel lblInformaesDaSessao = new JLabel("Cadastro de Sess\u00E3o");
		lblInformaesDaSessao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDaSessao.setBounds(301, 41, 195, 14);
		add(lblInformaesDaSessao);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(301, 80, 46, 14);
		add(lblCodigo);
		
		codigoField = new JTextField();
		codigoField.setBounds(357, 77, 35, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigoDoCinema = new JLabel("Codigo do Cinema");
		lblCodigoDoCinema.setBounds(245, 102, 102, 14);
		add(lblCodigoDoCinema);
		
		cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(357, 102, 35, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		cod_filmeField = new JTextField();
		cod_filmeField.setBounds(357, 127, 35, 20);
		add(cod_filmeField);
		cod_filmeField.setColumns(10);
		
		JLabel lblCodigoDoFilme = new JLabel("Codigo do Filme");
		lblCodigoDoFilme.setBounds(255, 130, 92, 14);
		add(lblCodigoDoFilme);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(312, 156, 35, 14);
		add(lblData);
		
		data_horaField = new JTextField();
		data_horaField.setBounds(357, 153, 86, 20);
		add(data_horaField);
		data_horaField.setColumns(10);
		
		JLabel lblNumeroDaSala = new JLabel("Numero da Sala");
		lblNumeroDaSala.setBounds(255, 178, 92, 14);
		add(lblNumeroDaSala);
		
		numero_salaField = new JTextField();
		numero_salaField.setBounds(357, 175, 35, 20);
		add(numero_salaField);
		numero_salaField.setColumns(10);
		
		qtd_publicoField = new JTextField();
		qtd_publicoField.setBounds(357, 199, 35, 20);
		add(qtd_publicoField);
		qtd_publicoField.setColumns(10);
		
		JLabel lblPublico = new JLabel("Publico");
		lblPublico.setBounds(301, 202, 46, 14);
		add(lblPublico);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessaoController.create(cod_cinemaField.getText(), cod_filmeField.getText(), codigoField.getText(), data_horaField.getText(), numero_salaField.getText(), qtd_publicoField.getText());
				JOptionPane.showMessageDialog(null, "Sessão criada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.addMouseListener(new MouseAdapter() {
		});
		btnCadastrar.addContainerListener(new ContainerAdapter() {
		});
		btnCadastrar.setBounds(325, 230, 102, 23);
		add(btnCadastrar);
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD 2015-12-23");
		lblExAaaammdd.setBounds(453, 156, 166, 14);
		add(lblExAaaammdd);
	}

}
