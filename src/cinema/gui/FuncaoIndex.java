package cinema.gui;

import java.awt.CardLayout;

import cinema.controllers.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.controllers.FilmeController;

public class FuncaoIndex extends JPanel {

	private JFrame frame;

	public FuncaoIndex() {
		setLayout(null);
		CardLayout funcaoCard = new CardLayout(0,0);
		JPanel FuncaoPanelCards = new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel FuncaoInicio = new JPanel();
		FuncaoInicio.setBounds(0, 75, 884, 553);
		add(FuncaoInicio);
		FuncaoInicio.setLayout(null);
		
		JTextField codigoField = new JTextField();
		codigoField.setBounds(295, 109, 41, 20);
		FuncaoInicio.add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(279, 112, 16, 14);
		FuncaoInicio.add(lblID);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel funcaoUpdate = new FuncaoUpdate(FuncaoController.busca(codigoField.getText()));
				funcaoUpdate.setBounds(0, 75, 884, 389);
				FuncaoPanelCards.add(funcaoUpdate, "Buscar");
				FuncaoInicio.setVisible(false);
				funcaoCard.show(FuncaoPanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		FuncaoInicio.add(btnPesquisar);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel funcaoCria = new FuncaoCria();
				funcaoCria.setBounds(0, 75, 884, 389);
				FuncaoPanelCards.add(funcaoCria, "Buscar");
				FuncaoInicio.setVisible(false);
				funcaoCard.show(FuncaoPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		FuncaoInicio.add(btnCriar);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o");
		lblFuncao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFuncao.setBounds(377, 57, 63, 20);
		FuncaoInicio.add(lblFuncao);
		
		FuncaoPanelCards.setBounds(0, 75, 884, 389);
		add(FuncaoPanelCards);
		FuncaoPanelCards.setLayout(funcaoCard);
		funcaoCard.show(FuncaoPanelCards, "FilmeInicio");
		
	}

}
