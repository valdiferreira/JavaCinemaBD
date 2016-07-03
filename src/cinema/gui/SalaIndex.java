package cinema.gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import cinema.controllers.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class SalaIndex {

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
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
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
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel salaCria = new SalaCria();
				salaCria.setBounds(0, 75, 884, 389);
				SalaPanelCards.add(salaCria, "Buscar");
				SalaInicio.setVisible(false);
				salaCard.show(SalaPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		SalaInicio.add(btnCriar);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSala.setBounds(377, 57, 49, 20);
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
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo do Cinema","Numero da Sala","Assentos"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 157, 516, 84);
		SalaInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/sala-2.png"));
		lblNewLabel.setBounds(420, 44, 39, 32);
		SalaInicio.add(lblNewLabel);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = SalaController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
	}
}
