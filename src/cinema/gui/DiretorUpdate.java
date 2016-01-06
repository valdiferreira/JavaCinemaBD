package cinema.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiretorUpdate extends JPanel {

	private JFrame frame;

	public DiretorUpdate(Diretor diretor) {
		setLayout(null);

		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setBounds(363, 166, 87, 23);
		add(btnUpdate);
		
		JTextField codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setText((String) null);
		codigoField.setColumns(10);
		codigoField.setBounds(363, 82, 59, 20);
		add(codigoField);
		
		JTextField nomeField = new JTextField();
		nomeField.setBounds(363, 108, 184, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		JTextField nacionalidadeField = new JTextField();
		nacionalidadeField.setBounds(363, 135, 184, 20);
		add(nacionalidadeField);
		nacionalidadeField.setColumns(10);
		
		codigoField.setText(diretor.getCodigo());
		nomeField.setText(diretor.getNome());
		nacionalidadeField.setText(diretor.getNacionalidade());
		
		JLabel lblInformaesDoUsurio = new JLabel("Informa\u00E7\u00F5es do Diretor");
		lblInformaesDoUsurio.setBounds(390, 57, 145, 14);
		add(lblInformaesDoUsurio);
		
		JLabel lblId = new JLabel("Codigo:");
		lblId.setBounds(307, 85, 46, 14);
		add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(307, 111, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("Nacionalidade:");
		lblCpf.setBounds(266, 138, 87, 14);
		add(lblCpf);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja deletar este Diretor?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
					DiretorController.delete(diretor.getCodigo());
					JOptionPane.showMessageDialog(null, "Diretor deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(458, 166, 89, 23);
		add(btnDelete);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja atualizar este diretor?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
					diretor.setCodigo(codigoField.getText());
					diretor.setNacionalidade(nacionalidadeField.getText());
					diretor.setNome(nomeField.getText());
					DiretorController.update(diretor);
					JOptionPane.showMessageDialog(null, "Diretor atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
	}

}
