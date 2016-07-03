package cinema.gui;


import cinema.controllers.*;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FilmeCria {

	private JTextField codigoField;
	private JTextField anoField;
	private JTextField generoField;
	private JTextField tipoField;
	private JTextField tituloField;
	private JTextField titulo_portField;
	private JTextField cod_diretorField;

	public FilmeCria(){
		setLayout(null);
		
		JLabel lblCadastrarFilme = new JLabel("Cadastrar Filme");
		lblCadastrarFilme.setFont(new Font("Arial", Font.BOLD, 15));
		lblCadastrarFilme.setBounds(388, 11, 155, 41);
		add(lblCadastrarFilme);
		
		codigoField = new JTextField();
		codigoField.setBounds(238, 88, 46, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(182, 91, 46, 14);
		add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Ano");
		lblNewLabel.setBounds(182, 116, 46, 14);
		add(lblNewLabel);
		
		anoField = new JTextField();
		anoField.setBounds(238, 113, 86, 20);
		add(anoField);
		anoField.setColumns(10);
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD 1992-12-23");
		lblExAaaammdd.setBounds(334, 116, 172, 14);
		add(lblExAaaammdd);
		
		generoField = new JTextField();
		generoField.setBounds(238, 144, 86, 20);
		add(generoField);
		generoField.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(182, 147, 46, 14);
		add(lblGenero);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(182, 180, 46, 14);
		add(lblTipo);
		
		tipoField = new JTextField();
		tipoField.setBounds(238, 175, 86, 20);
		add(tipoField);
		tipoField.setColumns(10);
		
		JLabel lblNacionalestrangeiro = new JLabel("Nacional/Estrangeiro");
		lblNacionalestrangeiro.setBounds(334, 180, 119, 14);
		add(lblNacionalestrangeiro);
		
		tituloField = new JTextField();
		tituloField.setBounds(238, 203, 199, 20);
		add(tituloField);
		tituloField.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(182, 206, 46, 14);
		add(lblTitulo);
		
		titulo_portField = new JTextField();
		titulo_portField.setBounds(238, 234, 199, 20);
		add(titulo_portField);
		titulo_portField.setColumns(10);
		
		JLabel lblTituloPort = new JLabel("Titulo Portugu\u00EAs");
		lblTituloPort.setBounds(130, 237, 98, 14);
		add(lblTituloPort);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(686, 38, 46, 14);
		add(lblSinopse);
		
		JTextArea sinopseArea = new JTextArea();
		sinopseArea.setLineWrap(true);
		sinopseArea.setTabSize(2);
		sinopseArea.setColumns(3);
		sinopseArea.setWrapStyleWord(true);
		sinopseArea.setRows(4);
		sinopseArea.setBounds(589, 63, 232, 191);
		add(sinopseArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController.create(codigoField.getText(), tituloField.getText(), titulo_portField.getText(), sinopseArea.getText(), anoField.getText(), cod_diretorField.getText(), tipoField.getText(), generoField.getText());
				JOptionPane.showMessageDialog(null, "Filme criado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(436, 265, 132, 23);
		add(btnCadastrar);
		btnCadastrar.setBorder(new RoundedBorder(5));
		
		cod_diretorField = new JTextField();
		cod_diretorField.setBounds(238, 57, 86, 20);
		add(cod_diretorField);
		cod_diretorField.setColumns(10);
		
		JLabel lblCodigoDiretor = new JLabel("Codigo Diretor");
		lblCodigoDiretor.setBounds(142, 60, 86, 14);
		add(lblCodigoDiretor);
		
		
	}
}
