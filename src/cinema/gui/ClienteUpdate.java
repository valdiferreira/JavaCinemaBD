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

public class ClienteUpdate extends JPanel {
	private String codidoCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton; 
	
	
	/**
	 * Create the panel.
	 */
	public ClienteUpdate (){
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(67, 166, 89, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(70, 108, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 135, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		
	}
	public ClienteUpdate(Cliente cliente) {
		this.codidoCliente=cliente.getCodigo();
		setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(67, 166, 89, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(70, 108, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 135, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField.setText(cliente.getNome());
		textField_1.setText(cliente.getCpf());
		
		
		
		
		
	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Would you like green eggs and ham?",
					    "An Inane Question",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
				cliente.setCodigo(codidoCliente);
				cliente.setCpf(textField_1.getText());
				cliente.setNome(textField.getText());
				ClienteController.update(cliente);
				}
				
				
			}
		});
		
		
		
	}

}
