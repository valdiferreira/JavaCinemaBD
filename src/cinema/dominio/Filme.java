package cinema.dominio;

public class Filme {
	private String codigo;
	private String titulo;
	private String titulo_port;
	private String sinopse;
	private String ano;
	private String cod_diretor;
	private String tipo;
	private String genero;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo_port() {
		return titulo_port;
	}
	
	public void setTitulo_port(String titulo_port) {
		this.titulo_port = titulo_port;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getCod_diretor() {
		return cod_diretor;
	}
	
	public void setCod_diretor(String cod_diretor) {
		this.cod_diretor = cod_diretor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
