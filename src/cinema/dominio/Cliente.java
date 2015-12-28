package cinema.dominio;

public class Cliente {
	private Long codCliente;
	private String nomeCliente;
	private long cpfCliente;
	
	
	public long getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(long codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public long getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	
}
