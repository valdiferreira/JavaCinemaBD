package cinema.dominio;

public class Compra {
	private int codigo;
	private int valor_total;
	private String forma_de_pagameto;
	private int qtd;
	private int codigoCliente;
	private int codigoSessao;
	private String data_hora;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getValor_total() {
		return valor_total;
	}
	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}
	public String getForma_de_pagameto() {
		return forma_de_pagameto;
	}
	public void setForma_de_pagameto(String forma_de_pagameto) {
		this.forma_de_pagameto = forma_de_pagameto;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoSessao() {
		return codigoSessao;
	}
	public void setCodigoSessao(int codigoSessao) {
		this.codigoSessao = codigoSessao;
	}
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

}
