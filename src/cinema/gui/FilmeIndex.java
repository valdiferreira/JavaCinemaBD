package cinema.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import cinema.controllers.AtorController;
import cinema.controllers.ClienteController;
import cinema.controllers.FilmeController;
import cinema.dominio.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

public class FilmeIndex extends JPanel {

	private JFrame frame;
	private JTextField codigoField;
	private JButton btnPesquisar;

	
	public FilmeIndex() {
		setLayout(null);
		CardLayout filmeCard = new CardLayout(0,0);
		JPanel FilmePanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel FilmeInicio = new JPanel();
		FilmeInicio.setBounds(0, 75, 884, 553);
		add(FilmeInicio);
		FilmeInicio.setLayout(null);
		
		codigoField = new JTextField();
		codigoField.setBounds(295, 109, 41, 20);
		FilmeInicio.add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(279, 112, 16, 14);
		FilmeInicio.add(lblID);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel filmeUpdate = new FilmeUpdate(FilmeController.busca(codigoField.getText()));
				filmeUpdate.setBounds(0, 75, 884, 389);
				FilmePanelCards.add(filmeUpdate, "Buscar");
				FilmeInicio.setVisible(false);
				filmeCard.show(FilmePanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		FilmeInicio.add(btnPesquisar);
		btnPesquisar.setBorder(new RoundedBorder(5));
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel filmeCria = new FilmeCria();
				filmeCria.setBounds(0, 75, 884, 389);
				FilmePanelCards.add(filmeCria, "Buscar");
				FilmeInicio.setVisible(false);
				filmeCard.show(FilmePanelCards, "Cadastrar");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		FilmeInicio.add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblFilme = new JLabel("Filme");
		lblFilme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFilme.setBounds(377, 57, 63, 20);
		FilmeInicio.add(lblFilme);
		
		FilmePanelCards.setBounds(0, 75, 884, 389);
		add(FilmePanelCards);
		FilmePanelCards.setLayout(filmeCard);
		filmeCard.show(FilmePanelCards, "FilmeInicio");
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Codigo do Diretor","Lançamento","Genero","Tipo","Titulo Original","Titulo Português"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 864, 84);
		FilmeInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/filme-2.png"));
		lblNewLabel.setBounds(430, 45, 32, 32);
		FilmeInicio.add(lblNewLabel);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = FilmeController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
		
	}
}
