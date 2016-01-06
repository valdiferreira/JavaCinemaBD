package cinema.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import cinema.controllers.*;

import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

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
		buscarTextField.setBounds(295, 109, 41, 20);
		atorInicio.add(buscarTextField, "buscarTextField");
		
		buscarTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Pesquisar");
		btnBuscar.setBounds(346, 108, 114, 23);
		atorInicio.add(btnBuscar, "btnBuscar");
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(279, 112, 16, 14);
		atorInicio.add(lblNewLabel);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorUpdate = new AtorCria();
				atorUpdate.setBounds(0, 75, 884, 389);
				atorPanelCards.add(atorUpdate, "Buscar");
				atorInicio.setVisible(false);
				atorCard.show(atorPanelCards, "Cria");
			}
		});
		btnCriar.setBounds(472, 108, 96, 23);
		atorInicio.add(btnCriar);
		
		JLabel lblAtor = new JLabel("Ator");
		lblAtor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtor.setBounds(377, 57, 63, 20);
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
		atorPanelCards.setBounds(0, 75, 884, 389);
		add(atorPanelCards);
		atorPanelCards.setLayout(atorCard);
		atorCard.show(atorPanelCards, "atorInicio");
		

	}
}
