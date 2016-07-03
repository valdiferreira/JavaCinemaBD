package cinema.gui;

import java.awt.Font;

import cinema.controllers.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CompraCria {

	public CompraCria() {
		setLayout(null);
		
		JLabel lblInformaesDaCompra = new JLabel("Cadastro de Compra");
		lblInformaesDaCompra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDaCompra.setBounds(330, 11, 203, 14);
		add(lblInformaesDaCompra);
		
		JTextField cod_clienteField = new JTextField();
		cod_clienteField.setBounds(412, 66, 45, 20);
		add(cod_clienteField);
		cod_clienteField.setColumns(10);
		
		JLabel lblCodigoDoCliente = new JLabel("Codigo do cliente");
		lblCodigoDoCliente.setBounds(299, 69, 114, 14);
		add(lblCodigoDoCliente);
		
		JTextField cod_sessaoField = new JTextField();
		cod_sessaoField.setBounds(412, 93, 45, 20);
		add(cod_sessaoField);
		cod_sessaoField.setColumns(10);
		
		JLabel lblCodigoDaSessao = new JLabel("Codigo da sessao");
		lblCodigoDaSessao.setBounds(299, 96, 114, 14);
		add(lblCodigoDaSessao);
		
		JTextField codigoField = new JTextField();
		codigoField.setBounds(412, 38, 45, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigoDaCompra = new JLabel("Codigo da compra");
		lblCodigoDaCompra.setBounds(299, 41, 114, 14);
		add(lblCodigoDaCompra);
		
		JTextField data_horaField = new JTextField();
		data_horaField.setBounds(412, 124, 86, 20);
		add(data_horaField);
		data_horaField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(373, 127, 30, 14);
		add(lblData);
		
		JLabel lblExAaaammdd = new JLabel("Ex: AAAA-MM-DD 2015-12-23");
		lblExAaaammdd.setBounds(508, 127, 166, 14);
		add(lblExAaaammdd);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de pagamento");
		lblFormaDePagamento.setBounds(288, 155, 125, 14);
		add(lblFormaDePagamento);
		
		JTextField forma_pagamentoField = new JTextField();
		forma_pagamentoField.setBounds(412, 155, 86, 20);
		add(forma_pagamentoField);
		forma_pagamentoField.setColumns(10);
		
		JLabel lblQuantidadeDeIngressos = new JLabel("Quantidade de ingressos");
		lblQuantidadeDeIngressos.setBounds(264, 189, 149, 14);
		add(lblQuantidadeDeIngressos);
		
		JTextField qtd_ingressoField = new JTextField();
		qtd_ingressoField.setBounds(412, 186, 86, 20);
		add(qtd_ingressoField);
		qtd_ingressoField.setColumns(10);
		
		JTextField valor_totalField = new JTextField();
		valor_totalField.setBounds(412, 214, 45, 20);
		add(valor_totalField);
		valor_totalField.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(345, 217, 68, 14);
		add(lblValorTotal);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("img/register.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraController.create(codigoField.getText(), data_horaField.getText(), forma_pagamentoField.getText(), qtd_ingressoField.getText(), valor_totalField.getText(), cod_clienteField.getText(), cod_sessaoField.getText());
				JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(395, 245, 114, 20);
		add(btnCadastrar);

	}
}
