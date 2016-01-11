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
		
		String sql=("{CALL CADASTRA_CLIENTE("
		+ cliente.getCodigo()+",'"+cliente.getNome()+"',"+cliente.getCpf()+ ")}");
		
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
		
		String sql=("{CALL DEL_CLIENTE("+codigo+")}");
		
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
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		PreparedStatement pst=null;		
		ResultSet rs;
		String sql=("SELECT * FROM CLIENTE");
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("NOME")+";"+rs.getString("CPF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		return dados;
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
	public static void Telefone(String codigo, String numero){
		PreparedStatement pst=null;		
		
		String sql=("INSERT INTO CLIENTE_TELEFONE (COD_CLIENTE, TELEFONE) VALUES ('"+codigo+"', '"+numero+"')");
		
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
	public static void Del_Telefone(String codigo, String numero){
		PreparedStatement pst=null;		
		String sql=("DELETE CLIENTE_TELEFONE WHERE COD_CLIENTE = "+codigo+" AND TELEFONE = "+numero+"");

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
	public static String Total_Gasto(String codigo){
		String total = "";
		PreparedStatement pst = null;		
		ResultSet rs;
		String sql=("SELECT CLIENTE_GASTO("+codigo+") as TOTAL FROM DUAL");
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				total = rs.getString("TOTAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return total;
	}
}