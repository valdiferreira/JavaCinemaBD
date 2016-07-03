package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.dominio.Funcao;

public class FuncaoDAO {

	public static void Create(Funcao funcao) {
		String sql = ("INSERT INTO FUNCAO (CODIGO, DESCRICAO) VALUES ('"+funcao.getCodigo()+"', '"+funcao.getDescrição()+"')");
		Conecta.ExecuteQuery(sql);
	}

	public static void Delete(String codigo) {
		String sql = ("DELETE [cinema].[dbo].[FUNCAO] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}

	public static void Update(Funcao funcao) {
		String sql = ("UPDATE [cinema].[dbo].[FUNCAO] SET DESCRICAO = '"+funcao.getDescrição()+"' WHERE CODIGO = "+funcao.getCodigo());
		Conecta.ExecuteQuery(sql);
	}

	public static Funcao Buscar(String codigo) {
		Funcao funcao = new Funcao();
		String sql = ("SELECT * FROM [cinema].[dbo].[FUNCAO] WHERE CODIGO = "+codigo);
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				funcao.setCodigo(rs.getString("CODIGO"));
				funcao.setDescrição(rs.getString("DESCRICAO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return funcao;
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[FUNCAO]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("DESCRiCAO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}

}
