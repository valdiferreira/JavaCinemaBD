package cinema.persistência;

import cinema.dominio.Ator;

import java.sql.*;
import java.util.ArrayList;

public class AtorDAO {
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Create(Ator ator) {
		String sql = ("INSERT INTO ATOR (CODIGO, NOME, NACIONALIDADE, DATA_NASC) VALUES ('"+ator.getCodigo()+"', '"+ator.getNome()+"', '"+ator.getNacionalidade()+"', '"+ator.getData()+"')");
		Conecta.ExecuteQuery(sql);
	}

	public static void Delete(String codigo) {
		String sql = ("DELETE [cinema].[dbo].[ATOR] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static Ator Busca(String codigo) {
		Ator ator = new Ator();
		String sql = ("SELECT * FROM [cinema].[dbo].[ATOR] WHERE CODIGO = "+codigo);
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				ator.setCodigo(rs.getString("CODIGO"));
				ator.setNome(rs.getString("NOME"));
				ator.setNacionalidade(rs.getString("NACIONALIDADE"));
				ator.setData(rs.getString("DATA_NASC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {} 
		}
		return ator;
	}
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Update(Ator ator) {
		String sql = ("UPDATE [cinema].[dbo].[ATOR] SET NOME = '"+ator.getNome()+"', NACIONALIDADE = '"+ator.getNacionalidade()+"', DATA_NASC = '"+ator.getData()+"' WHERE CODIGO = "+ator.getCodigo());
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[ATOR]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("NOME")+";"+rs.getString("NACIONALIDADE")+";"+rs.getString("DATA_NASC").substring(0,10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {} 
		}
		
		return dados;
	}
}
