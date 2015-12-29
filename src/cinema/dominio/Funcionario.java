package cinema.dominio;

public class Funcionario {
	private String nome;
	private String cpf;
	private String nct; //nct = Numero da Carteira de Trabalho
	private String rua;
	private String bairro;
	private String numero;
	private String cod_cinema;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNct() {
		return nct;
	}
	
	public void setNct(String nct) {
		this.nct = nct;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCod_cinema() {
		return cod_cinema;
	}
	
	public void setCod_cinema(String cod_cinema) {
		this.cod_cinema = cod_cinema;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
