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
import javax.swing.table.TableModel;

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
		
		JPanel atorInicio = new JPanel();
		atorInicio.setBounds(0, 0, 884, 389);
		add(atorInicio);
		atorInicio.setLayout(null);
		
		
		buscarTextField = new JTextField();
		buscarTextField.setBounds(295, 109, 41, 20);
		atorInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Pesquisar");
		btnBuscar.setIcon(new ImageIcon("img/search.png"));
		btnBuscar.setBounds(346, 108, 114, 23);
		atorInicio.add(btnBuscar, "btnBuscar");
		btnBuscar.setBorder(new RoundedBorder(5));
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(279, 112, 16, 14);
		atorInicio.add(lblNewLabel);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorCria = new AtorCria();
				atorCria.setBounds(0, 75, 884, 389);
				atorPanelCards.add(atorCria, "Buscar");
				atorInicio.setVisible(false);
				atorCard.show(atorPanelCards, "Criar");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		atorInicio.add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblAtor = new JLabel("Ator");
		lblAtor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtor.setBounds(376, 77, 63, 20);
		atorInicio.add(lblAtor);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorUpdate = new AtorUpdate(AtorController.busca(buscarTextField.getText()));
				atorUpdate.setBounds(0, 75, 884, 389);
				atorPanelCards.add(atorUpdate, "Buscar");
				atorInicio.setVisible(false);
				atorCard.show(atorPanelCards, "Dados");
			}
		});
		atorPanelCards.setBounds(0, 66, 884, 398);
		add(atorPanelCards);
		atorPanelCards.setLayout(atorCard);
		atorCard.show(atorPanelCards, "atorInicio");
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Nome","Nacionalidade","Data"};
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = AtorController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 157, 597, 115);
		atorInicio.add(scrollPane);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/ator-2.png"));
		lblNewLabel_1.setBounds(420, 68, 29, 32);
		atorInicio.add(lblNewLabel_1);

	}
}
