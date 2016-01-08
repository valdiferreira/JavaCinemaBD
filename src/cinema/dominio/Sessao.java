package cinema.dominio;

public class Sessao {
	private String codigo;
	private String qtd_publico;
	private String data_hora;
	private String cod_filme;
	private String cod_cinema;
	private String numero_sala;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getQtd_publico() {
		return qtd_publico;
	}
	
	public void setQtd_publico(String qtd_publico) {
		this.qtd_publico = qtd_publico;
	}
	
	public String getData_hora() {
		return data_hora;
	}
	
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	
	public String getCod_filme() {
		return cod_filme;
	}
	
	public void setCod_filme(String cod_filme) {
		this.cod_filme = cod_filme;
	}
	
	public String getCod_cinema() {
		return cod_cinema;
	}
	
	public void setCod_cinema(String cod_cinema) {
		this.cod_cinema = cod_cinema;
	}
	
	public String getNumero_sala() {
		return numero_sala;
	}
	
	public void setNumero_sala(String numero_sala) {
		this.numero_sala = numero_sala;
	}
}
