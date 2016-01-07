package cinema.gui;

import java.awt.EventQueue;

import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalaUpdate extends JPanel {

	private JFrame frame;

	public SalaUpdate(Sala sala) {
		setLayout(null);
		
		JLabel lblCod_cinema = new JLabel("Codigo Cinema");
		lblCod_cinema.setBounds(310, 116, 93, 14);
		add(lblCod_cinema);
		
		JTextField cod_cinemaField = new JTextField();
		cod_cinemaField.setEditable(false);
		cod_cinemaField.setBounds(402, 113, 34, 20);
		add(cod_cinemaField);
		cod_cinemaField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero sala");
		lblNumero.setBounds(320, 88, 83, 14);
		add(lblNumero);
		
		JTextField numero_salaField = new JTextField();
		numero_salaField.setEditable(false);
		numero_salaField.setBounds(403, 85, 33, 20);
		add(numero_salaField);
		numero_salaField.setColumns(10);
		
		JLabel lblQtd = new JLabel("Lugares");
		lblQtd.setBounds(343, 144, 60, 14);
		add(lblQtd);
		
		JTextField qtd_lugaresField = new JTextField();
		qtd_lugaresField.setBounds(404, 141, 34, 20);
		add(qtd_lugaresField);
		qtd_lugaresField.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sala.setCod_cinema(cod_cinemaField.getText());
				sala.setNumero(numero_salaField.getText());
				sala.setQtd_assentos(qtd_lugaresField.getText());
				SalaController.update(sala);
				JOptionPane.showMessageDialog(null, "Sala atualizada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAtualizar.setBounds(310, 183, 89, 23);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaController.delete(numero_salaField.getText(), cod_cinemaField.getText());
				JOptionPane.showMessageDialog(null, "Sala deletada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(409, 183, 89, 23);
		add(btnDeletar);
		
		JLabel lblInformaesDaSala = new JLabel("Informa\u00E7\u00F5es da Sala");
		lblInformaesDaSala.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		lblInformaesDaSala.setBounds(356, 38, 166, 14);
		add(lblInformaesDaSala);
		
		qtd_lugaresField.setText(sala.getQtd_assentos());
		numero_salaField.setText(sala.getNumero());
		cod_cinemaField.setText(sala.getCod_cinema());
	}
}
