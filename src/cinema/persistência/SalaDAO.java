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
	
	public static void Delete(String n_sala, String c_cinema){
		PreparedStatement pst = null;
		String sql = ("DELETE SALA WHERE NUMERO = "+n_sala+" AND COD_CINEMA = "+c_cinema);
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
	
	public static Sala Busca(String n_sala, String c_cinema){
		Sala sala = new Sala();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM SALA WHERE NUMERO = "+n_sala+" AND COD_CINEMA = "+c_cinema);
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
		String sql = ("UPDATE SALA SET QTD_ASSENTOS = "+sala.getQtd_assentos()+" WHERE NUMERO = "+sala.getNumero()+" AND COD_CINEMA = "+sala.getCod_cinema());
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
