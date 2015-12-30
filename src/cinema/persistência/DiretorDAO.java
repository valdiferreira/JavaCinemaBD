package cinema.persistência;

import java.sql.*;

import cinema.dominio.Diretor;

public class DiretorDAO {
	
	public static void Create(Diretor diretor) {
		PreparedStatement pst = null;
		String sql = ("INSERT INTO DIRETOR (CODIGO, NOME, NACIONALIDADE) VALUES ('"+diretor.getCodigo()+"', '"+diretor.getNome()+"', '"+diretor.getNacionalidade()+"')"); 
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
		String sql = ("DELETE DIRETOR WHERE CODIGO = "+codigo);
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

	public static Diretor Busca(String codigo) {
		Diretor diretor = new Diretor();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM DIRETOR WHERE CODIGO = "+codigo);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				diretor.setCodigo(rs.getString("CODIGO"));
				diretor.setNome(rs.getString("NOME"));
				diretor.setNacionalidade(rs.getString("NACIONALIDADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return diretor;
	}

	public static void Update(Diretor diretor) {
		PreparedStatement pst = null;
		String sql = ("UPDATE DIRETOR SET NOME = '"+diretor.getNome()+"', NACIONALIDADE = '"+diretor.getNacionalidade()+"' WHERE CODIGO = "+diretor.getCodigo());
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
