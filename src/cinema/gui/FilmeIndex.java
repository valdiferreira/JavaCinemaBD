package cinema.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import cinema.controllers.ClienteController;
import cinema.controllers.FilmeController;
import cinema.dominio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCriar.setBounds(472, 108, 96, 23);
		FilmeInicio.add(btnCriar);
		
		JLabel lblFilme = new JLabel("Filme");
		lblFilme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFilme.setBounds(377, 57, 63, 20);
		FilmeInicio.add(lblFilme);
		
		FilmePanelCards.setBounds(0, 75, 884, 389);
		add(FilmePanelCards);
		FilmePanelCards.setLayout(filmeCard);
		filmeCard.show(FilmePanelCards, "FilmeInicio");
		
	}
}
