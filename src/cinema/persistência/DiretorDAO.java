package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.dominio.Diretor;

public class DiretorDAO {
	
	public static void Create(Diretor diretor) {
		String sql = ("INSERT INTO DIRETOR (CODIGO, NOME, NACIONALIDADE) VALUES ('"+diretor.getCodigo()+"', '"+diretor.getNome()+"', '"+diretor.getNacionalidade()+"')"); 
		Conecta.ExecuteQuery(sql);
	}

	public static void Delete(String codigo) {
		PreparedStatement pst = null;
		String sql = ("DELETE [cinema].[dbo].[DIRETOR] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}

	public static Diretor Busca(String codigo) {
		Diretor diretor = new Diretor();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM [cinema].[dbo].[DIRETOR] WHERE CODIGO = "+codigo);
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				diretor.setCodigo(rs.getString("CODIGO"));
				diretor.setNome(rs.getString("NOME"));
				diretor.setNacionalidade(rs.getString("NACIONALIDADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return diretor;
	}

	public static void Update(Diretor diretor) {
		String sql = ("UPDATE [cinema].[dbo].[DIRETOR] SET NOME = '"+diretor.getNome()+"', NACIONALIDADE = '"+diretor.getNacionalidade()+"' WHERE CODIGO = "+diretor.getCodigo());
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[DIRETOR]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("NOME")+";"+rs.getString("NACIONALIDADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
}
