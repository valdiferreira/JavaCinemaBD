package cinema.gui;

import java.awt.CardLayout;
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

import cinema.controllers.*;

public class CompraIndex extends JPanel {

	private JFrame frame;

	public CompraIndex() {
		setLayout(null);
		CardLayout compraCard = new CardLayout(0,0);
		JPanel CompraPanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel CompraInicio = new JPanel();
		CompraInicio.setBounds(0, 75, 884, 389);
		add(CompraInicio);
		CompraInicio.setLayout(null);
		
		
		JTextField buscarTextField = new JTextField();
		buscarTextField.setBounds(295, 109, 41, 20);
		CompraInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Pesquisar");
		btnBuscar.setIcon(new ImageIcon("img/search.png"));
		btnBuscar.setBounds(346, 108, 114, 23);
		CompraInicio.add(btnBuscar, "btnBuscar");
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(279, 112, 16, 14);
		CompraInicio.add(lblId);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel compraCria = new CompraCria();
				compraCria.setBounds(0, 75, 884, 389);
				CompraPanelCards.add(compraCria, "Buscar");
				CompraInicio.setVisible(false);
				compraCard.show(CompraPanelCards, "Criar");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		CompraInicio.add(btnCriar);
		
		JLabel lblCompra = new JLabel("Compra");
		lblCompra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompra.setBounds(377, 57, 63, 20);
		CompraInicio.add(lblCompra);
		
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel compraUpdate = new CompraUpdate(CompraController.busca(buscarTextField.getText()));
				compraUpdate.setBounds(0, 75, 884, 389);
				CompraPanelCards.add(compraUpdate, "Buscar");
				CompraInicio.setVisible(false);
				compraCard.show(CompraPanelCards, "Dados");
			}
		});
		CompraPanelCards.setBounds(0, 75, 884, 389);
		add(CompraPanelCards);
		CompraPanelCards.setLayout(compraCard);
		compraCard.show(CompraPanelCards, "CompraInicio");
		
		//Colunas da tabela
		String[] colunas = new String[]{"Codigo","Cliente","Sessao","Data"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 157, 516, 84);
		CompraInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/compra-2.png"));
		lblNewLabel.setBounds(450, 44, 41, 32);
		CompraInicio.add(lblNewLabel);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = CompraController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
	}

}
