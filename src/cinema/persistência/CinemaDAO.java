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
}
