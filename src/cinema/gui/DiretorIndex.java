package cinema.gui;

import java.awt.CardLayout;

import cinema.controllers.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DiretorIndex extends JPanel {

	private JFrame frame;

	public DiretorIndex() {
		setLayout(null);
		CardLayout diretorCard = new CardLayout(0,0);
		JPanel DiretorPanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel DiretorInicio = new JPanel();
		DiretorInicio.setBounds(0, 75, 884, 553);
		add(DiretorInicio);
		DiretorInicio.setLayout(null);
		
		JTextField codigoField = new JTextField();
		codigoField.setBounds(295, 109, 41, 20);
		DiretorInicio.add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(279, 112, 16, 14);
		DiretorInicio.add(lblID);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel diretorUpdate = new DiretorUpdate(DiretorController.busca(codigoField.getText()));
				diretorUpdate.setBounds(0, 75, 884, 389);
				DiretorPanelCards.add(diretorUpdate, "Buscar");
				DiretorInicio.setVisible(false);
				diretorCard.show(DiretorPanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		DiretorInicio.add(btnPesquisar);
		btnPesquisar.setBorder(new RoundedBorder(5));
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel diretorCria = new DiretorCria();
				diretorCria.setBounds(0, 75, 884, 389);
				DiretorPanelCards.add(diretorCria, "Buscar");
				DiretorInicio.setVisible(false);
				diretorCard.show(DiretorPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		DiretorInicio.add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblDiretor = new JLabel("Diretor");
		lblDiretor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiretor.setBounds(377, 57, 63, 20);
		DiretorInicio.add(lblDiretor);
		
		DiretorPanelCards.setBounds(0, 75, 884, 389);
		add(DiretorPanelCards);
		DiretorPanelCards.setLayout(diretorCard);
		diretorCard.show(DiretorPanelCards, "FilmeInicio");
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Nome","Nacionalidade"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 157, 591, 81);
		DiretorInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = DiretorController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
		
	}

}
