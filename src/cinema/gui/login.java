package cinema.gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

import cinema.controllers.AutenticationController;
import cinema.dominio.Autentication;
public class login {

	private JFrame frmSistemaDeGesto;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmSistemaDeGesto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeGesto = new JFrame();
		frmSistemaDeGesto.setTitle("Sistema de Gest\u00E3o de Dados");
		frmSistemaDeGesto.setBackground(Color.RED);
		frmSistemaDeGesto.setIconImage(new ImageIcon(getClass().getResource("/tools.png")).getImage());
		frmSistemaDeGesto.setResizable(false);
		frmSistemaDeGesto.setBounds(100, 100, 459, 331);
		frmSistemaDeGesto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeGesto.getContentPane().setLayout(null);
		
		JLabel lbl_img = new JLabel("");
		lbl_img.setBounds(159, 24, 133, 105);
		frmSistemaDeGesto.getContentPane().add(lbl_img);
		Image users_img = new ImageIcon(this.getClass().getResource("/users.png")).getImage();
		lbl_img.setIcon(new ImageIcon(users_img));
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf.setBounds(142, 153, 30, 14);
		frmSistemaDeGesto.getContentPane().add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 15));
		lblSenha.setBounds(126, 195, 46, 14);
		frmSistemaDeGesto.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(174, 151, 118, 20);
		frmSistemaDeGesto.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 193, 118, 20);
		frmSistemaDeGesto.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] password = passwordField.getPassword();
				String senha = new String(password);
				String cpf = new String(textField.getText());
				if(AutenticationController.Autentication(cpf, senha)){
					frmSistemaDeGesto.setVisible(false);
				    new TelaPrincipal().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,
						    "Dados incorretos, digite novamente.",
						    "Erro",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(174, 233, 118, 43);
		frmSistemaDeGesto.getContentPane().add(btnNewButton);
	}
}
