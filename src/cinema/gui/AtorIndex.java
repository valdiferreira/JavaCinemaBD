package cinema.gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import cinema.controllers.*;

import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AtorIndex extends JPanel {
	
	private JTextField buscarTextField;

	/**
	 * Create the panel.
	 */
	public AtorIndex() {
		setLayout(null);
		CardLayout atorCard = new CardLayout(0,0);
		JPanel atorPanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		atorPanelCards.setBounds(0, 75, 884, 389);
		add(atorPanelCards);
		atorPanelCards.setLayout(atorCard);
		atorCard.show(atorPanelCards, "atorInicio");
		
		JPanel atorInicio = new JPanel();
		atorPanelCards.add(atorInicio, "name_143698387695044");
		atorInicio.setLayout(null);
		
		
		buscarTextField = new JTextField();
		buscarTextField.setBounds(295, 109, 41, 20);
		atorInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Pesquisar");
		btnBuscar.setIcon(new ImageIcon("img/search.png"));
		btnBuscar.setBounds(346, 108, 114, 23);
		atorInicio.add(btnBuscar, "btnBuscar");
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(279, 112, 16, 14);
		atorInicio.add(lblNewLabel);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorUpdate = new AtorCria();
				atorUpdate.setBounds(0, 75, 884, 389);
				atorPanelCards.add(atorUpdate, "Buscar");
				atorInicio.setVisible(false);
				atorCard.show(atorPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		atorInicio.add(btnCriar);
		
		JLabel lblAtor = new JLabel("Ator");
		lblAtor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtor.setBounds(377, 57, 63, 20);
		atorInicio.add(lblAtor);
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Nome","Nacionalidade","Data"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 157, 597, 115);
		atorInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = AtorController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorUpdate = new AtorUpdate(AtorController.busca(buscarTextField.getText()));
				atorUpdate.setBounds(0, 75, 884, 389);
				atorPanelCards.add(atorUpdate, "Buscar");
				atorInicio.setVisible(false);
				atorCard.show(atorPanelCards, "Dados");
			}
		});
		

	}
}
