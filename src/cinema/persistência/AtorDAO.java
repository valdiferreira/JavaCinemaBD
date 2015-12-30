package cinema.persistência;

import cinema.dominio.Ator;

import java.sql.*;

public class AtorDAO {
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Create(Ator ator) {
		PreparedStatement pst = null;
		String sql = ("INSERT INTO ATOR (CODIGO, NOME, NACIONALIDADE, DATA_NASC) VALUES ('"+ator.getCodigo()+"', '"+ator.getNome()+"', '"+ator.getNacionalidade()+"', TO_DATE('"+ator.getData()+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'))");
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

	public static void Delete(String codigo) {
		PreparedStatement pst = null;
		String sql = ("DELETE ATOR WHERE CODIGO = "+codigo);
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
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static Ator Busca(String codigo) {
		Ator ator = new Ator();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM ATOR WHERE CODIGO = "+codigo);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				ator.setCodigo(rs.getString("CODIGO"));
				ator.setNome(rs.getString("NOME"));
				ator.setNacionalidade(rs.getString("NACIONALIDADE"));
				ator.setData(rs.getString("DATA_NASC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return ator;
	}
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Update(Ator ator) {
		PreparedStatement pst = null;
		String sql = ("UPDATE ATOR SET NOME = '"+ator.getNome()+"', NACIONALIDADE = '"+ator.getNacionalidade()+"', DATA_NASC = TO_DATE('"+ator.getData()+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS') WHERE CODIGO = "+ator.getCodigo());
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
