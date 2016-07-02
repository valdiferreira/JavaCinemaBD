package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinema.dominio.Cliente;


public class ClienteDAO {

	public static void Create(Cliente cliente) {
		String sql=("INSERT INTO CLIENTE (CODIGO, NOME, CPF) VALUES ('"+ cliente.getCodigo()+"', '"+cliente.getNome()+"', '"+cliente.getCpf()+"');");
		
		
		Conecta.ExecuteQuery(sql);
		
	}	
	
	public static void Delete(String codigo){
		String sql = null;
		sql = ("DELETE [cinema].[dbo].[CLIENTE_TELEFONE] WHERE COD_cliente ="+codigo);
		Conecta.ExecuteQuery(sql);
		sql = ("DELETE [cinema].[dbo].[COMPRA] WHERE COD_CLIENTE ="+codigo);
		Conecta.ExecuteQuery(sql);
		sql=("DELETE [cinema].[dbo].[CLIENTE] WHERE CODIGO ="+codigo);
		Conecta.ExecuteQuery(sql);
		
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[CLIENTE]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("NOME")+";"+rs.getString("CPF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}    
	    }
		
		return dados;
	}
	public static Cliente Busca(String codigo){
		Cliente cliente = new Cliente ();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[CLIENTE] WHERE CODIGO = "+codigo);
		
		try {
			rs=Conecta.GetResultQuery(sql);
			while (rs.next()){
				cliente.setCpf(rs.getString("CPF"));
				cliente.setCodigo(rs.getString("CODIGO"));
				cliente.setNome(rs.getString("NOME"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}    
	     }
		return cliente;
	}
	
	
	public static void Update(Cliente cliente) {		
		String sql=("UPDATE [cinema].[dbo].[CLIENTE] SET NOME ='"+cliente.getNome()+"', CPF = "+cliente.getCpf()+
				" WHERE CODIGO = "+cliente.getCodigo());
		
		Conecta.ExecuteQuery(sql);
	}
	public static void Telefone(String codigo, String numero){
		String sql=("INSERT INTO [cinema].[dbo].[CLIENTE_TELEFONE] (COD_CLIENTE, TELEFONE) VALUES ('"+codigo+"', '"+numero+"')");
		
		Conecta.ExecuteQuery(sql);
		
	}
	public static void Del_Telefone(String codigo, String numero){
		String sql=("DELETE [cinema].[dbo].[CLIENTE_TELEFONE] WHERE COD_CLIENTE = "+codigo+" AND TELEFONE = "+numero+"");

		Conecta.ExecuteQuery(sql);
	}
	public static String Total_Gasto(String codigo){
		String total = "";	
		ResultSet rs = null;
		String sql=("SELECT SUM(COMPRA.VALOR_TOTAL) AS TOTAL FROM [cinema].[dbo].[COMPRA] WHERE COMPRA.COD_CLIENTE = "+codigo);
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				total = rs.getString("TOTAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}    
	      }
		
		
		return total;
	}
}