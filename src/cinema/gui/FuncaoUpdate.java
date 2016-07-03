package cinema.gui;



import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FuncaoUpdate {

	private JTextField codigoField;

	public FuncaoUpdate(Funcao funcao) {
		setLayout(null);
		
		JLabel lblInformaesDeFuno = new JLabel("Informa\u00E7\u00F5es de Fun\u00E7\u00E3o");
		lblInformaesDeFuno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDeFuno.setBounds(323, 50, 197, 14);
		add(lblInformaesDeFuno);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setBounds(387, 75, 39, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JTextField descricaoField = new JTextField();
		descricaoField.setBounds(387, 106, 175, 23);
		add(descricaoField);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(333, 78, 46, 14);
		add(lblCodigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(318, 111, 59, 14);
		add(lblDescrio);
		
		codigoField.setText(funcao.getCodigo());
		descricaoField.setText(funcao.getDescrição());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon("img/atualizar.png"));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcao.setDescrição(descricaoField.getText());
				FuncaoController.update(funcao);
				JOptionPane.showMessageDialog(null, "Função atualizada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAtualizar.setBounds(303, 140, 119, 23);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon("img/delete.png"));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncaoController.delete(codigoField.getText());
				JOptionPane.showMessageDialog(null, "Função deletada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(432, 140, 99, 23);
		add(btnDeletar);
		
		
		
		
	}
}
