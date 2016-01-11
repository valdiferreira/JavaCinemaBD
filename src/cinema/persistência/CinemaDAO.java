package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.dominio.*;

public class CinemaDAO {
	public static void Create(Cinema cinema){
		PreparedStatement pst=null;
		String sql = ("INSERT INTO CINEMA (CODIGO, CIDADE, RUA, BAIRRO, NUMERO, NOME_FANTASIA) VALUES ('"+cinema.getCodigo()+"', '"+cinema.getCidade()+"', '"+cinema.getRua()+"', '"+cinema.getBairro()+"', '"+cinema.getNumero()+"', '"+cinema.getNome()+"')");
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
		String sql = ("DELETE CINEMA WHERE CODIGO = "+codigo);
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
		String sql=("SELECT * FROM CINEMA");
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("CIDADE")+";"+rs.getString("RUA")+";"+rs.getString("BAIRRO")+";"+rs.getString("NUMERO")+";"+rs.getString("NOME_FANTASIA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		return dados;
	}
	public static Cinema Busca(String codigo){
		Cinema cinema = new Cinema ();
		PreparedStatement pst = null;		
		ResultSet rs;
		String sql=("SELECT * FROM CINEMA WHERE CODIGO = "+codigo);
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
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
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return cinema;
	}
	public static void Update(Cinema cinema){
		PreparedStatement pst = null;
		String sql = ("UPDATE CINEMA SET BAIRRO = '"+cinema.getBairro()+"', CIDADE = '"+cinema.getCidade()+"', NOME_FANTASIA = '"+cinema.getNome()+"', NUMERO = '"+cinema.getNumero()+"', RUA = '"+cinema.getRua()+"' WHERE CODIGO = "+cinema.getCodigo()+"");
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
	public static void Add_Telefone(String codigo, String numero){
		PreparedStatement pst = null;
		String sql = ("INSERT INTO CINEMA_TELEFONE (COD_CINEMA, TELEFONE) VALUES ('"+codigo+"', '"+numero+"')");
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
		PreparedStatement pst = null;
		String sql = ("DELETE CINEMA_TELEFONE WHERE COD_CINEMA = "+codigo+" AND TELEFONE = "+numero);
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
	public static String Ingressos(String codigo){
		String total = "";
		PreparedStatement pst = null;		
		ResultSet rs;
		String sql=("SELECT CINEMA.NOME_FANTASIA AS NOME_CINEMA, SUM(COMPRA.QTD_INGRESSO) AS QTD_INGRESSOS"
				+" FROM CINEMA, COMPRA, SESSAO"
				+" WHERE "+codigo+" = SESSAO.COD_CINEMA"
				+" AND SESSAO.CODIGO = COMPRA.COD_SESSAO"
				+" GROUP BY CINEMA.NOME_FANTASIA");
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				total = rs.getString("QTD_INGRESSOS");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return total;
	}
	public static String Lucro(String codigo){
		String total = "";
		PreparedStatement pst = null;		
		ResultSet rs;
		String sql=("SELECT LUCRO_CINEMA("+codigo+") as LUCRO FROM DUAL");
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				total = rs.getString("LUCRO");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return total;
	}
	public static ArrayList<String> Lista_Filmes(String codigo){
		ArrayList<String> dados = new ArrayList<String>();
		PreparedStatement pst=null;		
		ResultSet rs;
		String sql=("SELECT FILME.TITULO_PORT AS NOME, FILME.GENERO FROM SESSAO, FILME WHERE SESSAO.COD_CINEMA = "+codigo+" AND SESSAO.COD_FILME = FILME.CODIGO");
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				dados.add(rs.getString("NOME")+";"+rs.getString("GENERO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		return dados;
	}
}
