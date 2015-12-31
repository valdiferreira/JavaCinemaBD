package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinema.dominio.Cliente;


public class ClienteDAO {

	public static void Create(Cliente cliente) {
		PreparedStatement pst=null;		
		
		String sql=("INSERT INTO CLIENTE(CODIGO, NOME, CPF) VALUES ("
		+ cliente.getCodigo()+",'"+cliente.getNome()+"',"+cliente.getCpf()+ ")");
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
	}	
	
	
	
	
	public static void Delete(String codigo){
        PreparedStatement pst=null;		
		
		String sql=("DELETE CLIENTE WHERE CODIGO = "+codigo);
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
	}
	public static List listaCliente (){
		List <Cliente>listaCliente = new ArrayList<Cliente>();
		
		PreparedStatement pst=null;		
		ResultSet rs;
		String sql=("SELECT * FROM CLIENTE");
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCpf(rs.getString("CPF"));
				cliente.setCodigo(rs.getString("CODIGO"));
				cliente.setNome(rs.getString("NOME"));
				listaCliente.add(cliente);
			}
			for(Cliente c : listaCliente){
				System.out.println(c.getNome());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return listaCliente;
	}
	public static Cliente Busca(String codigo){
		Cliente cliente = new Cliente ();
		PreparedStatement pst = null;		
		ResultSet rs;
		String sql=("SELECT * FROM CLIENTE WHERE CODIGO = "+codigo);
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				
				cliente.setCpf(rs.getString("CPF"));
				cliente.setCodigo(rs.getString("CODIGO"));
				cliente.setNome(rs.getString("NOME"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return cliente;
	}
	
	
	public static void Update(Cliente cliente) {
	PreparedStatement pst = null;		
		
		String sql=("UPDATE CLIENTE SET NOME ='"+cliente.getNome()+"', CPF = "+cliente.getCpf()+
				" WHERE CODIGO = "+cliente.getCodigo());
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		
		
		}
	
	
	}
}