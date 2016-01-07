package cinema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cinema.controllers.*;
import cinema.dominio.*;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraUpdate extends JPanel {

	private JFrame frame;
	private JTextField cod_clienteField;
	private JTextField cod_sessaoField;
	private JTextField codigoField;
	private JTextField data_horaField;
	private JTextField forma_pagamentoField;
	private JTextField qtd_ingressoField;
	private JTextField valor_totalField;

	public CompraUpdate(Compra compra) {
		setLayout(null);
		
		JLabel lblInformaesDaCompra = new JLabel("Informa\u00E7\u00F5es da compra");
		lblInformaesDaCompra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformaesDaCompra.setBounds(330, 11, 203, 14);
		add(lblInformaesDaCompra);
		
		cod_clienteField = new JTextField();
		cod_clienteField.setBounds(412, 66, 45, 20);
		add(cod_clienteField);
		cod_clienteField.setColumns(10);
		
		JLabel lblCodigoDoCliente = new JLabel("Codigo do cliente");
		lblCodigoDoCliente.setBounds(299, 69, 114, 14);
		add(lblCodigoDoCliente);
		
		cod_sessaoField = new JTextField();
		cod_sessaoField.setBounds(412, 93, 45, 20);
		add(cod_sessaoField);
		cod_sessaoField.setColumns(10);
		
		JLabel lblCodigoDaSessao = new JLabel("Codigo da sessao");
		lblCodigoDaSessao.setBounds(299, 96, 114, 14);
		add(lblCodigoDaSessao);
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setBounds(412, 38, 45, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblCodigoDaCompra = new JLabel("Codigo da compra");
		lblCodigoDaCompra.setBounds(299, 41, 114, 14);
		add(lblCodigoDaCompra);
		
		data_horaField = new JTextField();
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
		
		forma_pagamentoField = new JTextField();
		forma_pagamentoField.setBounds(412, 155, 86, 20);
		add(forma_pagamentoField);
		forma_pagamentoField.setColumns(10);
		
		JLabel lblQuantidadeDeIngressos = new JLabel("Quantidade de ingressos");
		lblQuantidadeDeIngressos.setBounds(264, 189, 149, 14);
		add(lblQuantidadeDeIngressos);
		
		qtd_ingressoField = new JTextField();
		qtd_ingressoField.setBounds(412, 186, 86, 20);
		add(qtd_ingressoField);
		qtd_ingressoField.setColumns(10);
		
		valor_totalField = new JTextField();
		valor_totalField.setBounds(412, 214, 45, 20);
		add(valor_totalField);
		valor_totalField.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(345, 217, 68, 14);
		add(lblValorTotal);
		
		cod_clienteField.setText(compra.getCod_cliente());
		cod_sessaoField.setText(compra.getCod_sessao());
		codigoField.setText(compra.getCodigo());
		data_horaField.setText(compra.getData_hora().substring(0,10));
		forma_pagamentoField.setText(compra.getForma_pagameto());
		qtd_ingressoField.setText(compra.getQtd_ingresso());
		valor_totalField.setText(compra.getValor_total());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compra.setCod_cliente(cod_clienteField.getText());
				compra.setCod_sessao(cod_sessaoField.getText());
				compra.setData_hora(data_horaField.getText());
				compra.setForma_pagameto(forma_pagamentoField.getText());
				compra.setQtd_ingresso(qtd_ingressoField.getText());
				compra.setValor_total(valor_totalField.getText());
				CompraController.update(compra);
				JOptionPane.showMessageDialog(null, "Compra atualizada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAtualizar.setBounds(324, 242, 89, 23);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraController.delete(codigoField.getText());
				JOptionPane.showMessageDialog(null, "Compra deletada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeletar.setBounds(422, 242, 89, 23);
		add(btnDeletar);
		
		
	}
}
