package cinema.gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import cinema.controllers.ClienteController;

import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ClienteIndex extends JPanel {
	
	private JTextField buscarTextField;

	/**
	 * Create the panel.
	 */
	public ClienteIndex() {
		setLayout(null);
		CardLayout clienteCard = new CardLayout(0,0);
		JPanel ClientePanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel ClienteInicio = new JPanel();
		ClienteInicio.setBounds(0, 75, 884, 389);
		add(ClienteInicio);
		ClienteInicio.setLayout(null);
		
		
		buscarTextField = new JTextField();
		buscarTextField.setBounds(295, 109, 41, 20);
		ClienteInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Pesquisar");
		btnBuscar.setIcon(new ImageIcon("img/search.png"));
		btnBuscar.setBounds(346, 108, 114, 23);
		ClienteInicio.add(btnBuscar, "btnBuscar");
		btnBuscar.setBorder(new RoundedBorder(5));
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(279, 112, 16, 14);
		ClienteInicio.add(lblId);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel clienteCria = new ClienteCria();
				clienteCria.setBounds(0, 75, 884, 389);
				ClientePanelCards.add(clienteCria, "Buscar");
				ClienteInicio.setVisible(false);
				clienteCard.show(ClientePanelCards, "Criar");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		ClienteInicio.add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCliente.setBounds(377, 57, 63, 20);
		ClienteInicio.add(lblCliente);
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Nome","CPF"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 157, 484, 115);
		ClienteInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = ClienteController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel clienteUpdate = new ClienteUpdate(ClienteController.busca(buscarTextField.getText()));
				clienteUpdate.setBounds(0, 75, 884, 389);
				ClientePanelCards.add(clienteUpdate, "Buscar");
				ClienteInicio.setVisible(false);
				clienteCard.show(ClientePanelCards, "Dados");
			}
		});
		ClientePanelCards.setBounds(0, 75, 884, 389);
		add(ClientePanelCards);
		ClientePanelCards.setLayout(clienteCard);
		clienteCard.show(ClientePanelCards, "ClienteInicio");
		

	}
}