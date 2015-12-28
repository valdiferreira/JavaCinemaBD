package cinema.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.JTextField;

import cinema.controllers.ClienteControllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aplication extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplication frame = new Aplication();
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
	public Aplication() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 78, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 112, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(50, 143, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteControllers.addCliente(textField.getText(), Integer.parseInt(textField_1.getText()), 
						Integer.parseInt(textField_2.getText()));
			}
		});
		btnNewButton.setBounds(47, 191, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
