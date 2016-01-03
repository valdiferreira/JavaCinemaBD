package cinema.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import cinema.controllers.ClienteController;

import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

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
		atorInicio.setBounds(0, 75, 884, 389);
		add(atorInicio);
		atorInicio.setLayout(null);
		
		
		buscarTextField = new JTextField();
		buscarTextField.setBounds(0, 100, 89, 20);
		atorInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.setBounds(100, 100, 170, 20);
		atorInicio.add(btnBuscar, "btnBuscar");
		
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel atorUpdate = new ClienteUpdate(ClienteController.busca(buscarTextField.getText()));
				atorUpdate.setBounds(0, 75, 884, 389);
				atorPanelCards.add(atorUpdate, "Buscar");
				atorInicio.setVisible(false);
				atorCard.show(atorPanelCards, "Dados");
			}
		});
		atorPanelCards.setBounds(0, 75, 884, 389);
		add(atorPanelCards);
		atorPanelCards.setLayout(atorCard);
		atorCard.show(atorPanelCards, "atorInicio");
		

	}
}
