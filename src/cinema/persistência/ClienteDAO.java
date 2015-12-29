package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinema.dominio.Cliente;


public class ClienteDAO {

	public static void clienteSave (Cliente cliente) {
		PreparedStatement pst=null;		
		
		String sql=("insert into cliente (CODIGO, NOME, CPF) values ("
		+ cliente.getCodCliente()+",'"+cliente.getNomeCliente()+"',"+cliente.getCpfCliente()+ ")");
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
	}	
	
	
	
	
	public static void clienteDelete (Cliente cliente){
        PreparedStatement pst=null;		
		
		String sql=("DELETE FROM cliente WHERE codigo ="+cliente.getCpfCliente());
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String sql=("select * from cliente");
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCpfCliente(rs.getLong("CPF"));
				cliente.setCodCliente(rs.getLong("CODIGO"));
				cliente.setNomeCliente(rs.getString("NOME"));
				listaCliente.add(cliente);
			}
			for(Cliente c : listaCliente){
				System.out.println(c.getNomeCliente());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return listaCliente;
	}
	public static Cliente clienteBusca (long l){
		Cliente cliente = new Cliente ();
		PreparedStatement pst=null;		
		ResultSet rs;
		String sql=("select * from cliente where codigo="+l);
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				
				cliente.setCpfCliente(rs.getLong("CPF"));
				cliente.setCodCliente(rs.getLong("CODIGO"));
				cliente.setNomeCliente(rs.getString("NOME"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return cliente;
	}
	
	
	public static void clienteUpdate(Cliente cliente) {
	PreparedStatement pst=null;		
		
		String sql=("UPDATE cliente SET nome ='"+cliente.getNomeCliente()+"', cpf="+cliente.getCpfCliente()+
				" WHERE codigo="+cliente.getCodCliente());
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		
		
	}
	
	
}
	}