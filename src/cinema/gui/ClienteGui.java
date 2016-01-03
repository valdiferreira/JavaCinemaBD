package cinema.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import cinema.controllers.ClienteController;
import cinema.persistência.ClienteDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGui frame = new ClienteGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteGui() {
		CardLayout cards = new CardLayout(0,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 35, 434, 226);
		contentPane.add(panel);
		panel.setLayout(cards);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "busca");
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel panel_2 = new ClienteUpdate(ClienteController.busca(textField.getText()));
				panel.add(panel_2, "Dados");
				cards.show(panel, "Dados");
				
			}
		});
		btnBuscar.setBounds(10, 58, 89, 23);
		panel_1.add(btnBuscar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(panel, "Dados");
			}
		});
		btnNewButton.setBounds(165, 1, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
