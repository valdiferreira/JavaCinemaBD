package cinema.gui;

import javax.swing.JPanel;

import cinema.controllers.ClienteControllers;
import cinema.dominio.Cliente;
import cinema.persistência.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Update extends JPanel {
	private long codidoCliente;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Update (){
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
	}
	public Update(Cliente cliente) {
		this.codidoCliente=cliente.getCodCliente();
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 47, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 92, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField.setText(cliente.getNomeCliente());
		textField_1.setText(Long.toString(cliente.getCpfCliente()));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteControllers.updateCliente(textField.getText(), Long.parseLong(textField_1.getText())
						, codidoCliente);
				
				
			}
		});
		btnNewButton.setBounds(27, 143, 89, 23);
		add(btnNewButton);
		
	}

}
