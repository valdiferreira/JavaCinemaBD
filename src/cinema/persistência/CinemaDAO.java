package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.dominio.*;

public class CinemaDAO {
	public static void Create(Cinema cinema){
		String sql = ("INSERT INTO CINEMA (CODIGO, CIDADE, RUA, BAIRRO, NUMERO, NOME_FANTASIA) VALUES ('"+cinema.getCodigo()+"', '"+cinema.getCidade()+"', '"+cinema.getRua()+"', '"+cinema.getBairro()+"', '"+cinema.getNumero()+"', '"+cinema.getNome()+"')");
		Conecta.ExecuteQuery(sql);
	}
	public static void Delete(String codigo){
		String sql = ("DELETE [cinema].[dbo].[CINEMA] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[CINEMA]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("CIDADE")+";"+rs.getString("RUA")+";"+rs.getString("BAIRRO")+";"+rs.getString("NUMERO")+";"+rs.getString("NOME_FANTASIA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {};
		}
		
		return dados;
	}
	public static Cinema Busca(String codigo){
		Cinema cinema = new Cinema ();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[CINEMA] WHERE CODIGO = "+codigo);
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				cinema.setBairro(rs.getString("BAIRRO"));
				cinema.setCidade(rs.getString("CIDADE"));
				cinema.setCodigo(rs.getString("CODIGO"));
				cinema.setNome(rs.getString("NOME_FANTASIA"));
				cinema.setNumero(rs.getString("NUMERO"));
				cinema.setRua(rs.getString("RUA"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return cinema;
	}
	public static void Update(Cinema cinema){
		String sql = ("UPDATE [cinema].[dbo].[CINEMA] SET BAIRRO = '"+cinema.getBairro()+"', CIDADE = '"+cinema.getCidade()+"', NOME_FANTASIA = '"+cinema.getNome()+"', NUMERO = '"+cinema.getNumero()+"', RUA = '"+cinema.getRua()+"' WHERE CODIGO = "+cinema.getCodigo()+"");
		Conecta.ExecuteQuery(sql);
	}
	public static void Add_Telefone(String codigo, String numero){
		String sql = ("INSERT INTO CINEMA_TELEFONE (COD_CINEMA, TELEFONE) VALUES ('"+codigo+"', '"+numero+"')");
		Conecta.ExecuteQuery(sql);
	}
	public static void Del_Telefone(String codigo, String numero){
		String sql = ("DELETE [cinema].[dbo].[CINEMA_TELEFONE] WHERE COD_CINEMA = "+codigo+" AND TELEFONE = "+numero);
		Conecta.ExecuteQuery(sql);
	}
	public static String Ingressos(String codigo){
		String total = "";
		ResultSet rs = null;
		String sql=("SELECT CINEMA.NOME_FANTASIA AS NOME_CINEMA, SUM(COMPRA.QTD_INGRESSO) AS QTD_INGRESSOS"
				+" FROM [cinema].[dbo].[CINEMA], [cinema].[dbo].[COMPRA], [cinema].[dbo].[SESSAO]"
				+" WHERE "+codigo+" = SESSAO.COD_CINEMA"
				+" AND SESSAO.CODIGO = COMPRA.COD_SESSAO"
				+" GROUP BY CINEMA.NOME_FANTASIA");
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				total = rs.getString("QTD_INGRESSOS");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		
		return total;
	}
	public static String Lucro(String codigo){
		String total = "";
		ResultSet rs = null;
		String sql = "SELECT SUM(COMPRA.VALOR_TOTAL) AS LUCRO FROM [cinema].[dbo].[SESSAO], [cinema].[dbo].[COMPRA] WHERE SESSAO.COD_CINEMA = "+codigo+" AND SESSAO.CODIGO = COMPRA.COD_SESSAO";
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				total = rs.getString("LUCRO");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		
		return total;
	}
	public static ArrayList<String> Lista_Filmes(String codigo){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT FILME.TITULO_PORT AS NOME, FILME.GENERO FROM [cinema].[dbo].[SESSAO], [cinema].[dbo].[FILME] WHERE SESSAO.COD_CINEMA = "+codigo+" AND SESSAO.COD_FILME = FILME.CODIGO");
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("NOME")+";"+rs.getString("GENERO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
}
