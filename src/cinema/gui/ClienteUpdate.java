package cinema.gui;

import javax.swing.JPanel;

import cinema.controllers.ClienteController;
import cinema.dominio.Cliente;
import cinema.persistência.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JLabel;

public class ClienteUpdate extends JPanel {
	private String codidoCliente;
	private JTextField nomeField;
	private JTextField cpfField;
	private JButton btnNewButton; 
	private JTextField codigoField;
	
	
	/**
	 * Create the panel.
	 */

	
	public ClienteUpdate(Cliente cliente) {
		this.codidoCliente=cliente.getCodigo();
		setLayout(null);

		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setBounds(363, 166, 87, 23);
		add(btnUpdate);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setText((String) null);
		codigoField.setColumns(10);
		codigoField.setBounds(363, 82, 59, 20);
		add(codigoField);
		
		nomeField = new JTextField();
		nomeField.setBounds(363, 108, 184, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		cpfField = new JTextField();
		cpfField.setBounds(363, 135, 184, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		codigoField.setText(cliente.getCodigo());
		nomeField.setText(cliente.getNome());
		cpfField.setText(cliente.getCpf());
		
		JLabel lblInformaesDoUsurio = new JLabel("Informa\u00E7\u00F5es do cliente");
		lblInformaesDoUsurio.setBounds(390, 57, 145, 14);
		add(lblInformaesDoUsurio);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(307, 85, 46, 14);
		add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(307, 111, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(307, 138, 46, 14);
		add(lblCpf);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja deletar este usuário?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
					ClienteController.delete(cliente.getCodigo());
					JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(458, 166, 89, 23);
		add(btnDelete);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja atualizar este usuário?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
				cliente.setCodigo(codidoCliente);
				cliente.setCpf(cpfField.getText());
				cliente.setNome(nomeField.getText());
				ClienteController.update(cliente);
				JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		
		
		
	}
}
