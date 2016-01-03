package cinema.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import cinema.controllers.ClienteController;

import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

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
		buscarTextField.setBounds(0, 100, 89, 20);
		ClienteInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.setBounds(100, 100, 170, 20);
		ClienteInicio.add(btnBuscar, "btnBuscar");
		
		
		
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
