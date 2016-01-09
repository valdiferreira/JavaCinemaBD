package cinema.gui;

import java.awt.EventQueue;

import cinema.controllers.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SalaCria extends JPanel {

	private JFrame frame;

	public SalaCria() {
		setLayout(null);
		
		JLabel lblCod_cinema = new JLabel("Codigo Cinema");
		lblCod_cinema.setBounds(312, 116, 93, 14);
		add(lblCod_cinema);
		
		JTextField cod_cinemaField = new JTextField();
		cod_cinemaField.setBounds(404, 113, 34, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero sala");
		lblNumero.setBounds(324, 88, 81, 14);
		add(lblNumero);
		
		JTextField numero_salaField = new JTextField();
		numero_salaField.setBounds(405, 85, 33, 20);
		add(numero_salaField);
		numero_salaField.setColumns(10);
		
		JLabel lblQtd = new JLabel("Lugares");
		lblQtd.setBounds(343, 144, 60, 14);
		add(lblQtd);
		
		JTextField qtd_lugaresField = new JTextField();
		qtd_lugaresField.setBounds(404, 141, 34, 20);
		add(qtd_lugaresField);
		qtd_lugaresField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaController.create(numero_salaField.getText(), cod_cinemaField.getText(), qtd_lugaresField.getText());
				JOptionPane.showMessageDialog(null, "Sala CADASTRADA com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(374, 169, 116, 23);
		add(btnCadastrar);
		
		JLabel lblCadastroDeSala = new JLabel("Cadastro de Salas");
		lblCadastroDeSala.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		lblCadastroDeSala.setBounds(342, 55, 166, 14);
		add(lblCadastroDeSala);
	}


}
