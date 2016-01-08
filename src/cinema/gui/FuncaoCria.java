package cinema.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cinema.controllers.FuncaoController;

public class FuncaoCria extends JPanel{

	private JFrame frame;
	private JTextField codigoField;

	public FuncaoCria() {
		setLayout(null);
		
		JLabel lblInformaesDeFuno = new JLabel("Informa\u00E7\u00F5es de Fun\u00E7\u00E3o");
		lblInformaesDeFuno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDeFuno.setBounds(323, 50, 197, 14);
		add(lblInformaesDeFuno);
		
		codigoField = new JTextField();
		codigoField.setBounds(387, 75, 39, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JTextArea descricaoArea = new JTextArea();
		descricaoArea.setWrapStyleWord(true);
		descricaoArea.setLineWrap(true);
		descricaoArea.setBounds(387, 106, 175, 23);
		add(descricaoArea);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(333, 78, 46, 14);
		add(lblCodigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(318, 111, 59, 14);
		add(lblDescrio);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncaoController.create(codigoField.getText(), descricaoArea.getText());
				JOptionPane.showMessageDialog(null, "Função criada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(397, 140, 100, 23);
		add(btnCadastrar);
		
		
	}


}
