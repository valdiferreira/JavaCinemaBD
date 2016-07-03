package cinema.gui;


import cinema.controllers.FilmeController;
import cinema.dominio.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FilmeUpdate {

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
		codigoField.setBounds(111, 53, 46, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(61, 56, 46, 14);
		add(lblCodigo);
		
		cod_diretorField = new JTextField();
		cod_diretorField.setBounds(111, 84, 46, 20);
		add(cod_diretorField);
		cod_diretorField.setColumns(10);
		
		JLabel lblCodigoDiretor = new JLabel("Codigo Diretor");
		lblCodigoDiretor.setBounds(24, 87, 86, 14);
		add(lblCodigoDiretor);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(179, 56, 46, 14);
		add(lblGenero);
		
		generoField = new JTextField();
		generoField.setBounds(225, 53, 86, 20);
		add(generoField);
		generoField.setColumns(10);
		
		tipoField = new JTextField();
		tipoField.setBounds(225, 84, 86, 20);
		add(tipoField);
		tipoField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(194, 87, 31, 14);
		add(lblTipo);
		
		anoField = new JTextField();
		anoField.setBounds(111, 115, 86, 20);
		add(anoField);
		anoField.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(75, 118, 26, 14);
		add(lblAno);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(72, 149, 35, 14);
		add(lblTitulo);
		
		tituloField = new JTextField();
		tituloField.setBounds(111, 146, 210, 20);
		add(tituloField);
		tituloField.setColumns(10);
		
		JLabel lblTituloPortugus = new JLabel("Titulo Portugu\u00EAs");
		lblTituloPortugus.setBounds(10, 178, 97, 14);
		add(lblTituloPortugus);
		
		titulo_portField = new JTextField();
		titulo_portField.setBounds(111, 175, 210, 20);
		add(titulo_portField);
		titulo_portField.setColumns(10);
		
		JTextArea sinopseArea = new JTextArea();
		sinopseArea.setWrapStyleWord(true);
		sinopseArea.setLineWrap(true);
		sinopseArea.setBounds(350, 105, 210, 87);
		add(sinopseArea);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(417, 80, 46, 14);
		add(lblSinopse);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon("img/atualizar.png"));
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
		btnAtualizar.setBounds(121, 206, 89, 23);
		add(btnAtualizar);
		btnAtualizar.setBorder(new RoundedBorder(5));
		
		JButton btnAdicionarAtor = new JButton("Adicionar");
		btnAdicionarAtor.setIcon(new ImageIcon("img/atualizar.png"));
		btnAdicionarAtor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.add_ator(filme.getCodigo(), codigoAtorField.getText());
				JOptionPane.showMessageDialog(null, "Ator adicionado ao filme com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAdicionarAtor.setBounds(599, 122, 97, 23);
		add(btnAdicionarAtor);
		btnAdicionarAtor.setBorder(new RoundedBorder(5));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon("img/delete.png"));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.delete(codigoField.getText());
				JOptionPane.showMessageDialog(null, "Filme deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(225, 206, 89, 23);
		add(btnDeletar);
		btnDeletar.setBorder(new RoundedBorder(5));
		
		generoField.setText(filme.getGenero());
		anoField.setText(filme.getAno().substring(0,10));
		cod_diretorField.setText(filme.getCod_diretor());
		codigoField.setText(filme.getCodigo());
		sinopseArea.setText(filme.getSinopse());
		tipoField.setText(filme.getTipo());
		tituloField.setText(filme.getTitulo());
		titulo_portField.setText(filme.getTitulo_port());
		
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD");
		lblExAaaammdd.setBounds(203, 118, 108, 14);
		add(lblExAaaammdd);
		
		JLabel label = new JLabel("Adicionar Ator a Filme");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(620, 24, 165, 32);
		add(label);
		
		JLabel lblCodigoFilme = new JLabel("Codigo Filme");
		lblCodigoFilme.setBounds(630, 64, 76, 14);
		add(lblCodigoFilme);
		
		JLabel lblCodigoAtor = new JLabel("Codigo Ator");
		lblCodigoAtor.setBounds(640, 92, 66, 14);
		add(lblCodigoAtor);
		
		codigoFilmeField = new JTextField();
		codigoFilmeField.setEditable(false);
		codigoFilmeField.setBounds(712, 64, 46, 20);
		add(codigoFilmeField);
		codigoFilmeField.setColumns(10);
		
		codigoAtorField = new JTextField();
		codigoAtorField.setBounds(712, 89, 46, 20);
		add(codigoAtorField);
		codigoAtorField.setColumns(10);
		
		codigoFilmeField.setText(filme.getCodigo());
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setIcon(new ImageIcon("img/delete.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.del_ator(filme.getCodigo(), codigoAtorField.getText());
				JOptionPane.showMessageDialog(null, "Ator deletado do filme com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDelete.setBounds(706, 122, 79, 23);
		add(btnDelete);
		btnDelete.setBorder(new RoundedBorder(5));
		
		JLabel lblInformaesDoFilme = new JLabel("Informa\u00E7\u00F5es do Filme");
		lblInformaesDoFilme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDoFilme.setBounds(121, 24, 210, 14);
		add(lblInformaesDoFilme);
	}
}
