package cinema.gui;

import javax.swing.JPanel;

import cinema.controllers.*;
import cinema.dominio.Ator;
import cinema.dominio.Cliente;
import cinema.persistência.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AtorUpdate extends JPanel {
	private String codidoAtor;
	private JTextField nomeField;
	private JTextField codigoField;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblData;
	private JLabel lblNacionalidade;
	private JButton btnDelete;
	private JTextField dataField;
	private JTextField nacionalidadeField;
	private JLabel lblInformaesDoFuncionrio;

	/**
	 * Create the panel.
	 */

	public AtorUpdate(Ator ator) {
		this.codidoAtor=ator.getCodigo();
		setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(333, 100, 171, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setBounds(333, 130, 58, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		dataField = new JTextField();
		dataField.setBounds(333, 161, 171, 20);
		add(dataField);
		dataField.setColumns(10);
		
		nacionalidadeField = new JTextField();
		nacionalidadeField.setBounds(333, 192, 171, 20);
		add(nacionalidadeField);
		nacionalidadeField.setColumns(10);
		
		nomeField.setText(ator.getNome());
		codigoField.setText(ator.getCodigo());
		dataField.setText(ator.getData().substring(0,10));
		nacionalidadeField.setText(ator.getNacionalidade());

		
		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setIcon(new ImageIcon("img/atualizar.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você deseja mesmo atualizar?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
				ator.setCodigo(codidoAtor);
				ator.setNome(nomeField.getText());
				ator.setData(dataField.getText());
				ator.setNacionalidade(nacionalidadeField.getText());
				AtorController.update(ator);
				JOptionPane.showMessageDialog(null, "Ator atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnUpdate.setBounds(333, 223, 89, 20);
		add(btnUpdate);
		btnUpdate.setBorder(new RoundedBorder(5));
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(287, 103, 46, 14);
		add(lblNome);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(287, 133, 46, 14);
		add(lblCodigo);
		
		lblData = new JLabel("Data");
		lblData.setBounds(287, 164, 46, 14);
		add(lblData);
		
		lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setBounds(244, 195, 89, 14);
		add(lblNacionalidade);
		
		btnDelete = new JButton("Deletar");
		btnDelete.setIcon(new ImageIcon("img/delete.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você deseja mesmo deletar?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
					AtorController.delete(codigoField.getText());
					JOptionPane.showMessageDialog(null, "Ator deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(427, 223, 77, 20);
		add(btnDelete);
		btnDelete.setBorder(new RoundedBorder(5));
		
		JLabel lblExAaaa = new JLabel("Ex: AAAA-MM-DD (2015-12-23)");
		lblExAaaa.setBounds(514, 164, 209, 14);
		add(lblExAaaa);
		
		lblInformaesDoFuncionrio = new JLabel("Informa\u00E7\u00F5es do Funcion\u00E1rio");
		lblInformaesDoFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDoFuncionrio.setBounds(306, 75, 237, 14);
		add(lblInformaesDoFuncionrio);
		
	}
}
