package cinema.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import cinema.controllers.AtorController;
import cinema.controllers.FilmeController;
import cinema.dominio.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

public class FilmeUpdate extends JPanel {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField cod_diretorField;
	private JTextField generoField;
	private JTextField tipoField;
	private JTextField anoField;
	private JTextField tituloField;
	private JTextField titulo_portField;
	private JTextField codigoFilmeField;
	private JTextField codigoAtorField;

	public FilmeUpdate(Filme filme) {
		setLayout(null);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setBounds(111, 36, 46, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(61, 39, 46, 14);
		add(lblCodigo);
		
		cod_diretorField = new JTextField();
		cod_diretorField.setBounds(111, 67, 46, 20);
		add(cod_diretorField);
		cod_diretorField.setColumns(10);
		
		JLabel lblCodigoDiretor = new JLabel("Codigo Diretor");
		lblCodigoDiretor.setBounds(24, 70, 86, 14);
		add(lblCodigoDiretor);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(179, 39, 46, 14);
		add(lblGenero);
		
		generoField = new JTextField();
		generoField.setBounds(225, 36, 86, 20);
		add(generoField);
		generoField.setColumns(10);
		
		tipoField = new JTextField();
		tipoField.setBounds(225, 67, 86, 20);
		add(tipoField);
		tipoField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(194, 70, 31, 14);
		add(lblTipo);
		
		anoField = new JTextField();
		anoField.setBounds(111, 98, 86, 20);
		add(anoField);
		anoField.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(75, 101, 26, 14);
		add(lblAno);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(72, 132, 35, 14);
		add(lblTitulo);
		
		tituloField = new JTextField();
		tituloField.setBounds(111, 129, 210, 20);
		add(tituloField);
		tituloField.setColumns(10);
		
		JLabel lblTituloPortugus = new JLabel("Titulo Portugu\u00EAs");
		lblTituloPortugus.setBounds(18, 161, 89, 14);
		add(lblTituloPortugus);
		
		titulo_portField = new JTextField();
		titulo_portField.setBounds(111, 158, 210, 20);
		add(titulo_portField);
		titulo_portField.setColumns(10);
		
		JTextArea sinopseArea = new JTextArea();
		sinopseArea.setWrapStyleWord(true);
		sinopseArea.setLineWrap(true);
		sinopseArea.setBounds(353, 41, 210, 87);
		add(sinopseArea);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(420, 16, 46, 14);
		add(lblSinopse);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja atualizar este filme?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
					Filme filme = new Filme();
					filme.setAno(anoField.getText());
					filme.setCod_diretor(cod_diretorField.getText());
					filme.setCodigo(codigoField.getText());
					filme.setGenero(generoField.getText());
					filme.setSinopse(sinopseArea.getText());
					filme.setTipo(tipoField.getText());
					filme.setTitulo(tituloField.getText());
					filme.setTitulo_port(titulo_portField.getText());
					FilmeController.update(filme);
					JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAtualizar.setBounds(121, 189, 89, 23);
		add(btnAtualizar);
		
		JButton btnAdicionarAtor = new JButton("Adicionar");
		btnAdicionarAtor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.add_ator(filme.getCodigo(), codigoAtorField.getText());
				JOptionPane.showMessageDialog(null, "Ator adicionado ao filme com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAdicionarAtor.setBounds(599, 105, 97, 23);
		add(btnAdicionarAtor);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.delete(codigoField.getText());
				JOptionPane.showMessageDialog(null, "Filme deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(225, 189, 89, 23);
		add(btnDeletar);
		
		generoField.setText(filme.getGenero());
		anoField.setText(filme.getAno().substring(0,10));
		cod_diretorField.setText(filme.getCod_diretor());
		codigoField.setText(filme.getCodigo());
		sinopseArea.setText(filme.getSinopse());
		tipoField.setText(filme.getTipo());
		tituloField.setText(filme.getTitulo());
		titulo_portField.setText(filme.getTitulo_port());
		
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD");
		lblExAaaammdd.setBounds(203, 101, 108, 14);
		add(lblExAaaammdd);
		
		JLabel label = new JLabel("Adicionar Ator a Filme");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(620, 7, 165, 32);
		add(label);
		
		JLabel lblCodigoFilme = new JLabel("Codigo Filme");
		lblCodigoFilme.setBounds(630, 47, 76, 14);
		add(lblCodigoFilme);
		
		JLabel lblCodigoAtor = new JLabel("Codigo Ator");
		lblCodigoAtor.setBounds(640, 75, 66, 14);
		add(lblCodigoAtor);
		
		codigoFilmeField = new JTextField();
		codigoFilmeField.setEditable(false);
		codigoFilmeField.setBounds(712, 47, 46, 20);
		add(codigoFilmeField);
		codigoFilmeField.setColumns(10);
		
		codigoAtorField = new JTextField();
		codigoAtorField.setBounds(712, 72, 46, 20);
		add(codigoAtorField);
		codigoAtorField.setColumns(10);
		
		codigoFilmeField.setText(filme.getCodigo());
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.del_ator(filme.getCodigo(), codigoAtorField.getText());
				JOptionPane.showMessageDialog(null, "Ator deletado do filme com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(706, 105, 79, 23);
		add(btnNewButton);		

	}
}
