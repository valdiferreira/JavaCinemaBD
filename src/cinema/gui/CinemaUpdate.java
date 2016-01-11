package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CinemaUpdate extends JPanel {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField ruaField;
	private JTextField numeroField;
	private JTextField codField;
	private JTextField telefoneField;
	private JTextField totalField;
	private JTextField lucroField;

	public CinemaUpdate(Cinema cinema, String total, String lucro) {
		setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(186, 61, 46, 14);
		add(lblCodigo);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
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
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cinema cinema = new Cinema();
				cinema.setRua(ruaField.getText());
				cinema.setBairro(bairroField.getText());
				cinema.setCidade(cidadeField.getText());
				cinema.setCodigo(codigoField.getText());
				cinema.setNome(nomeField.getText());
				cinema.setNumero(numeroField.getText());
				CinemaController.update(cinema);
				JOptionPane.showMessageDialog(null, "Cinema atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAtualizar.setIcon(new ImageIcon("img/atualizar.png"));
		btnAtualizar.setBounds(185, 252, 111, 23);
		add(btnAtualizar);
		btnAtualizar.setBorder(new RoundedBorder(5));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaController.delete(codigoField.getText());
				JOptionPane.showMessageDialog(null, "Cinema deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setIcon(new ImageIcon("img/delete.png"));
		btnDeletar.setBounds(306, 252, 105, 23);
		add(btnDeletar);
		btnDeletar.setBorder(new RoundedBorder(5));
		
		bairroField.setText(cinema.getBairro());
		cidadeField.setText(cinema.getCidade());
		codigoField.setText(cinema.getCodigo());
		nomeField.setText(cinema.getNome());
		numeroField.setText(cinema.getNumero());
		ruaField.setText(cinema.getRua());
		
		JLabel lblInformaesDoCinema = new JLabel("Informa\u00E7\u00F5es do Cinema");
		lblInformaesDoCinema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDoCinema.setBounds(219, 33, 192, 14);
		add(lblInformaesDoCinema);
		
		JLabel lblAdicionarTelefoneAo = new JLabel("Adicionar telefone do cinema");
		lblAdicionarTelefoneAo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdicionarTelefoneAo.setBounds(568, 35, 249, 14);
		add(lblAdicionarTelefoneAo);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(603, 61, 40, 14);
		add(lblCodigo_1);
		
		codField = new JTextField();
		codField.setEditable(false);
		codField.setBounds(647, 58, 31, 20);
		add(codField);
		codField.setColumns(10);
		codField.setText(codigoField.getText());
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(582, 86, 61, 14);
		add(lblTelefone);
		
		telefoneField = new JTextField();
		telefoneField.setBounds(647, 83, 105, 20);
		add(telefoneField);
		telefoneField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaController.add_telefone(codField.getText(), telefoneField.getText());
				JOptionPane.showMessageDialog(null, "Telefone cadastrado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.setBounds(568, 111, 110, 23);
		add(btnCadastrar);
		btnCadastrar.setBorder(new RoundedBorder(5));
		
		JButton btnDeletar_1 = new JButton("Deletar");
		btnDeletar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaController.del_telefone(codField.getText(), telefoneField.getText());
				JOptionPane.showMessageDialog(null, "Telefone deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar_1.setIcon(new ImageIcon("img/delete.png"));
		btnDeletar_1.setBounds(688, 111, 105, 23);
		add(btnDeletar_1);
		btnDeletar_1.setBorder(new RoundedBorder(5));
		
		JLabel lblIngressosVendido = new JLabel("Ingressos Vendidos");
		lblIngressosVendido.setBounds(288, 199, 123, 14);
		add(lblIngressosVendido);
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(409, 196, 31, 20);
		add(totalField);
		totalField.setColumns(10);
		totalField.setText(total);
		
		JLabel lblLucroTotal = new JLabel("Lucro total  R$");
		lblLucroTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLucroTotal.setBounds(219, 224, 99, 14);
		add(lblLucroTotal);
		
		lucroField = new JTextField();
		lucroField.setEditable(false);
		lucroField.setBounds(323, 221, 40, 20);
		add(lucroField);
		lucroField.setColumns(10);
		lucroField.setText(lucro);
		
		//Colunas da tabela
		String[] colunas = new String[]{"Nome", "Genero"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(494, 196, 323, 87);
		add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblFimesEmCartaz = new JLabel("Fimes em cartaz");
		lblFimesEmCartaz.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFimesEmCartaz.setBounds(594, 163, 143, 14);
		add(lblFimesEmCartaz);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = CinemaController.lista_filmes(cinema.getCodigo());
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
		
	}
}
