package cinema.gui;

import javax.swing.JPanel;

import cinema.controllers.ClienteController;
import cinema.dominio.Cliente;
import cinema.persistência.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.ImageIcon;

public class ClienteUpdate extends JPanel {
	private String codidoCliente;
	private JTextField nomeField;
	private JTextField cpfField;
	private JButton btnNewButton; 
	private JTextField codigoField;
	private JTextField idFoneField;
	private JTextField numeroFoneField;
	
	
	/**
	 * Create the panel.
	 */

	
	public ClienteUpdate(Cliente cliente) {
		this.codidoCliente=cliente.getCodigo();
		setLayout(null);

		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setIcon(new ImageIcon("img/atualizar.png"));
		btnUpdate.setBounds(327, 166, 87, 23);
		add(btnUpdate);
		btnUpdate.setBorder(new RoundedBorder(5));
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setText((String) null);
		codigoField.setColumns(10);
		codigoField.setBounds(327, 82, 35, 20);
		add(codigoField);
		
		nomeField = new JTextField();
		nomeField.setBounds(327, 108, 184, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		cpfField = new JTextField();
		cpfField.setBounds(327, 135, 184, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		codigoField.setText(cliente.getCodigo());
		nomeField.setText(cliente.getNome());
		cpfField.setText(cliente.getCpf());
		
		JLabel lblInformaesDoUsurio = new JLabel("Informa\u00E7\u00F5es do cliente");
		lblInformaesDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDoUsurio.setBounds(342, 48, 198, 14);
		add(lblInformaesDoUsurio);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(271, 85, 46, 14);
		add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(271, 111, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(271, 138, 46, 14);
		add(lblCpf);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setIcon(new ImageIcon("img/delete.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja deletar este cliente?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
					ClienteController.delete(cliente.getCodigo());
					JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(422, 166, 89, 23);
		add(btnDelete);
		btnDelete.setBorder(new RoundedBorder(5));
		
		JLabel lblCadastrarNumero = new JLabel("Cadastrar Numero Telefonico");
		lblCadastrarNumero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarNumero.setBounds(547, 48, 236, 14);
		add(lblCadastrarNumero);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(589, 85, 25, 14);
		add(lblId_1);
		
		idFoneField = new JTextField();
		idFoneField.setEditable(false);
		idFoneField.setBounds(622, 82, 25, 20);
		add(idFoneField);
		idFoneField.setColumns(10);
		idFoneField.setText(cliente.getCodigo());
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(557, 111, 57, 14);
		add(lblNumero);
		
		numeroFoneField = new JTextField();
		numeroFoneField.setBounds(622, 108, 114, 20);
		add(numeroFoneField);
		numeroFoneField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController.telefone(idFoneField.getText(), numeroFoneField.getText());
				JOptionPane.showMessageDialog(null, "Telefone adicionado ao cliente com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(567, 134, 100, 23);
		add(btnCadastrar);
		btnCadastrar.setBorder(new RoundedBorder(5));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon("img/delete.png"));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController.del_telefone(idFoneField.getText(), numeroFoneField.getText());
				JOptionPane.showMessageDialog(null, "Telefone deletado do cliente com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(677, 134, 89, 23);
		add(btnDeletar);
		btnDeletar.setBorder(new RoundedBorder(5));
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int n = JOptionPane.showConfirmDialog(
					    getComponent(0),
					    "Você tem certeza que deseja atualizar este usuário?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION);
				if (n==0){
				cliente.setCodigo(codidoCliente);
				cliente.setCpf(cpfField.getText());
				cliente.setNome(nomeField.getText());
				ClienteController.update(cliente);
				JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		
		
		
	}
}
