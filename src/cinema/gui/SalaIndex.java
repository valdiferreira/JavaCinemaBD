package cinema.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cinema.controllers.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.controllers.FuncionarioController;

public class SalaIndex extends JPanel {

	private JFrame frame;
	private JTextField cod_cinemaField;

	public SalaIndex() {
		setLayout(null);
		CardLayout salaCard = new CardLayout(0,0);
		JPanel SalaPanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel SalaInicio = new JPanel();
		SalaInicio.setBounds(0, 75, 884, 389);
		add(SalaInicio);
		SalaInicio.setLayout(null);
		
		JTextField numero_salaField = new JTextField();
		numero_salaField.setBounds(307, 96, 29, 20);
		SalaInicio.add(numero_salaField);
		numero_salaField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero Sala");
		lblNumero.setBounds(216, 99, 91, 14);
		SalaInicio.add(lblNumero);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel SalaUpdate = new SalaUpdate(SalaController.busca(numero_salaField.getText(), cod_cinemaField.getText()));
				SalaUpdate.setBounds(0, 75, 884, 389);
				SalaPanelCards.add(SalaUpdate, "Buscar");
				SalaInicio.setVisible(false);
				salaCard.show(SalaPanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		SalaInicio.add(btnPesquisar);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel salaCria = new SalaCria();
				salaCria.setBounds(0, 75, 884, 389);
				SalaPanelCards.add(salaCria, "Buscar");
				SalaInicio.setVisible(false);
				salaCard.show(SalaPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 96, 23);
		SalaInicio.add(btnCriar);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSala.setBounds(377, 57, 119, 20);
		SalaInicio.add(lblSala);
		
		cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(307, 119, 29, 20);
		SalaInicio.add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		JLabel lblCodigoCinema = new JLabel("Codigo Cinema");
		lblCodigoCinema.setBounds(206, 122, 91, 14);
		SalaInicio.add(lblCodigoCinema);
		
		SalaPanelCards.setBounds(0, 75, 884, 389);
		add(SalaPanelCards);
		SalaPanelCards.setLayout(salaCard);
		salaCard.show(SalaPanelCards, "SalaInicio");
	}
}
