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

public class FuncionarioIndex extends JPanel {

	private JFrame frame;


	public FuncionarioIndex() {
		setLayout(null);
		CardLayout FuncionarioCard = new CardLayout(0,0);
		JPanel FuncionarioPanelCards=new JPanel();
		this.setBounds(0,75,884,389);
		
		JPanel FuncionarioInicio = new JPanel();
		FuncionarioInicio.setBounds(0, 75, 884, 553);
		add(FuncionarioInicio);
		FuncionarioInicio.setLayout(null);
		
		JTextField codigoField = new JTextField();
		codigoField.setBounds(217, 109, 119, 20);
		FuncionarioInicio.add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(185, 112, 36, 14);
		FuncionarioInicio.add(lblCPF);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("img/search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel FuncionarioUpdate = new FuncionarioUpdate(FuncionarioController.busca(codigoField.getText()));
				FuncionarioUpdate.setBounds(0, 75, 884, 389);
				FuncionarioPanelCards.add(FuncionarioUpdate, "Buscar");
				FuncionarioInicio.setVisible(false);
				FuncionarioCard.show(FuncionarioPanelCards, "Dados");
			}
		});
		btnPesquisar.setBounds(346, 108, 114, 23);
		FuncionarioInicio.add(btnPesquisar);
		btnPesquisar.setBorder(new RoundedBorder(5));
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel funcionarioCria = new FuncionarioCria();
				funcionarioCria.setBounds(0, 75, 884, 389);
				FuncionarioPanelCards.add(funcionarioCria, "Buscar");
				FuncionarioInicio.setVisible(false);
				FuncionarioCard.show(FuncionarioPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 114, 23);
		FuncionarioInicio.add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblFuncionario = new JLabel("Funcion\u00E1rio");
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFuncionario.setBounds(377, 57, 100, 20);
		FuncionarioInicio.add(lblFuncionario);
		
		FuncionarioPanelCards.setBounds(0, 75, 884, 389);
		add(FuncionarioPanelCards);
		FuncionarioPanelCards.setLayout(FuncionarioCard);
		FuncionarioCard.show(FuncionarioPanelCards, "FilmeInicio");
		
		//Colunas da tabela
		String[] colunas = new String[]{"CPF","Nome","Codigo do Cinema"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 157, 516, 84);
		FuncionarioInicio.add(scrollPane);
		DefaultTableModel date = new DefaultTableModel(colunas, 0);
		JTable table = new JTable();
		table.setEnabled(false);
		table.setModel(date);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/funcionario-2.png"));
		lblNewLabel.setBounds(472, 45, 36, 32);
		FuncionarioInicio.add(lblNewLabel);
		
		//Linhas da tabela
		ArrayList<String> dados = new ArrayList<String>();
		dados = FuncionarioController.listar();
		String[] linha;
		for(int i = 0; i < dados.size(); i++){
			linha = dados.get(i).split(";");
			date.addRow(linha);
		}
	}
}
