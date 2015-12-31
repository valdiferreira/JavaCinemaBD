package cinema.persistência;

import java.sql.*;

import cinema.dominio.Sala;

public class SalaDAO {
	
	public static void Create(Sala sala){
		PreparedStatement pst = null;
		String sql = ("INSERT INTO SALA(NUMERO, COD_CINEMA, QTD_ASSENTOS) VALUES('"+sala.getNumero()+"', '"+sala.getCod_cinema()+"', '"+sala.getQtd_assentos()+"')");
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
	
	public static void Delete(String numero){
		PreparedStatement pst = null;
		String sql = ("DELETE SALA WHERE NUMERO = "+numero);
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
	
	public static Sala Busca(String numero){
		Sala sala = new Sala();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM SALA WHERE NUMERO = "+numero);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				sala.setNumero(rs.getString("NUMERO"));
				sala.setCod_cinema(rs.getString("COD_CINEMA"));
				sala.setQtd_assentos(rs.getString("QTD_ASSENTOS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return sala;
	}
	
	public static void Update(Sala sala){
		PreparedStatement pst = null;
		String sql = ("UPDATE SALA SET COD_CINEMA = "+sala.getCod_cinema()+", QTD_ASSENTOS = "+sala.getQtd_assentos()+" WHERE NUMERO = "+sala.getNumero());
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
