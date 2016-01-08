package cinema.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.controllers.*;

import javax.swing.ImageIcon;

public class SessaoIndex extends JPanel {

	private JFrame frame;
	private JTextField codigoField;
	private JButton btnPesquisar;

	public SessaoIndex() {
		setLayout(null);
		CardLayout sessaoCard = new CardLayout(0,0);
		JPanel SessaoPanelCards = new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel SessaoInicio = new JPanel();
		SessaoInicio.setBounds(0, 75, 884, 553);
		add(SessaoInicio);
		SessaoInicio.setLayout(null);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel sessaoUpdate = new SessaoUpdate(SessaoController.busca(codigoField.getText()));
				sessaoUpdate.setBounds(0, 75, 884, 389);
				SessaoPanelCards.add(sessaoUpdate, "Buscar");
				SessaoInicio.setVisible(false);
				sessaoCard.show(SessaoPanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		SessaoInicio.add(btnPesquisar);
		
		codigoField = new JTextField();
		codigoField.setBounds(295, 109, 41, 20);
		SessaoInicio.add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(279, 112, 16, 14);
		SessaoInicio.add(lblID);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel sessaoCria = new SessaoCria();
				sessaoCria.setBounds(0, 75, 884, 389);
				SessaoPanelCards.add(sessaoCria, "Buscar");
				SessaoInicio.setVisible(false);
				sessaoCard.show(SessaoPanelCards, "Cadastrar");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		SessaoInicio.add(btnCriar);
		
		JLabel lblSessao = new JLabel("Sessao");
		lblSessao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSessao.setBounds(377, 57, 63, 20);
		SessaoInicio.add(lblSessao);
		
		SessaoPanelCards.setBounds(0, 75, 884, 389);
		add(SessaoPanelCards);
		SessaoPanelCards.setLayout(sessaoCard);
		sessaoCard.show(SessaoPanelCards, "FilmeInicio");
	}

}
