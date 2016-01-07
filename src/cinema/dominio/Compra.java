package cinema.dominio;

public class Compra {
	private String codigo;
	private String valor_total;
	private String forma_pagameto;
	private String qtd_ingresso;
	private String cod_cliente;
	private String cod_sessao;
	private String data_hora;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor_total() {
		return valor_total;
	}
	public void setValor_total(String valor_total) {
		this.valor_total = valor_total;
	}
	public String getForma_pagameto() {
		return forma_pagameto;
	}
	public void setForma_pagameto(String forma_pagameto) {
		this.forma_pagameto = forma_pagameto;
	}
	public String getQtd_ingresso() {
		return qtd_ingresso;
	}
	public void setQtd_ingresso(String qtd_ingresso) {
		this.qtd_ingresso = qtd_ingresso;
	}
	public String getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getCod_sessao() {
		return cod_sessao;
	}
	public void setCod_sessao(String cod_sessao) {
		this.cod_sessao = cod_sessao;
	}
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	

}
