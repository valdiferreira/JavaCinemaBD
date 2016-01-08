package cinema.persistência;

import java.sql.*;

import cinema.dominio.Funcao;

public class FuncaoDAO {

	public static void Create(Funcao funcao) {
		PreparedStatement pst = null;
		String sql = ("INSERT INTO FUNCAO (CODIGO, DESCRICAO) VALUES ('"+funcao.getCodigo()+"', '"+funcao.getDescrição()+"')");
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
		String sql = ("DELETE FUNCAO WHERE CODIGO = "+codigo);
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

	public static void Update(Funcao funcao) {
		PreparedStatement pst = null;
		String sql = ("UPDATE FUNCAO SET DESCRICAO = '"+funcao.getDescrição()+"' WHERE CODIGO = "+funcao.getCodigo());
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

	public static Funcao Buscar(String codigo) {
		Funcao funcao = new Funcao();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM FUNCAO WHERE CODIGO = "+codigo);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				funcao.setCodigo(rs.getString("CODIGO"));
				funcao.setDescrição(rs.getString("DESCRICAO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return funcao;
	}

}
