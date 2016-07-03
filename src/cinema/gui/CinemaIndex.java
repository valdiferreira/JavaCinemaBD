package cinema.gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cinema.controllers.*;

@SuppressWarnings("serial")
public class CinemaIndex {


	public CinemaIndex() {
		setLayout(null);
		CardLayout cinemaCard = new CardLayout(0,0);
		JPanel CinemaPanelCards = new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel CinemaInicio = new JPanel();
		CinemaInicio.setBounds(0, 75, 884, 553);
		add(CinemaInicio);
		CinemaInicio.setLayout(null);
		
		JTextField codigoField = new JTextField();
		codigoField.setBounds(295, 109, 41, 20);
		CinemaInicio.add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(279, 112, 16, 14);
		CinemaInicio.add(lblID);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel cinemaUpdate = new CinemaUpdate(CinemaController.busca(codigoField.getText()), CinemaController.ingressos(codigoField.getText()), CinemaController.lucro(codigoField.getText()));
				cinemaUpdate.setBounds(0, 75, 884, 389);
				CinemaPanelCards.add(cinemaUpdate, "Buscar");
				CinemaInicio.setVisible(false);
				cinemaCard.show(CinemaPanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		CinemaInicio.add(btnPesquisar);
		btnPesquisar.setBorder(new RoundedBorder(5));
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel cinemaCria = new CinemaCria();
				cinemaCria.setBounds(0, 75, 884, 389);
				CinemaPanelCards.add(cinemaCria, "Buscar");
				CinemaInicio.setVisible(false);
				cinemaCard.show(CinemaPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		CinemaInicio.add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblCinema = new JLabel("Cinema");
		lblCinema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCinema.setBounds(377, 57, 63, 20);
		CinemaInicio.add(lblCinema);
		
		CinemaPanelCards.setBounds(0, 75, 884, 389);
		add(CinemaPanelCards);
		CinemaPanelCards.setLayout(cinemaCard);
		cinemaCard.show(CinemaPanelCards, "FilmeInicio");
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Cidade","Rua","Bairro","Numero","Nome"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 864, 69);
		CinemaInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/cinema-22.png"));
		lblNewLabel.setBounds(440, 52, 32, 32);
		CinemaInicio.add(lblNewLabel);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = CinemaController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
	}
}
