package cinema.gui;


import cinema.controllers.*;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AtorCria {

	private JTextField codigoField;
	private JTextField dataField;
	private JTextField nomeField;
	private JTextField nacionalidadeField;
	
	public AtorCria() {
		setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(253, 104, 46, 14);
		add(lblCodigo);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(253, 129, 46, 14);
		add(lblData);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(253, 154, 46, 14);
		add(lblNome);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setBounds(253, 179, 87, 14);
		add(lblNacionalidade);
		
		codigoField = new JTextField();
		codigoField.setBounds(338, 102, 46, 17);
		add(codigoField);
		codigoField.setColumns(10);
		
		dataField = new JTextField();
		dataField.setBounds(338, 126, 97, 20);
		add(dataField);
		dataField.setColumns(10);
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD (2015-12-23)");
		lblExAaaammdd.setBounds(445, 129, 188, 14);
		add(lblExAaaammdd);
		
		nomeField = new JTextField();
		nomeField.setBounds(338, 151, 266, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		nacionalidadeField = new JTextField();
		nacionalidadeField.setBounds(338, 176, 97, 20);
		add(nacionalidadeField);
		nacionalidadeField.setColumns(10);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtorController.create(codigoField.getText(), nomeField.getText(), nacionalidadeField.getText(), dataField.getText());
				JOptionPane.showMessageDialog(null, "Ator cadastrado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCriar.setBounds(338, 207, 97, 23);
		add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		JLabel lblCadastrarAtor = new JLabel("Cadastrar Ator");
		lblCadastrarAtor.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastrarAtor.setBounds(338, 64, 152, 27);
		add(lblCadastrarAtor);
		
		
	}
}
