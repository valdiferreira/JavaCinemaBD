package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.dominio.Filme;

public class FilmeDAO {
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Create(Filme filme){
		PreparedStatement pst = null;
		String sql=("INSERT INTO FILME(CODIGO, TITULO, TITULO_PORT, SINOPSE, ANO_LANCAMENTO, COD_DIRETOR, TIPO, GENERO) "
				+ "VALUES('"+filme.getCodigo()+"', '"+filme.getTitulo()+"', '"+filme.getTitulo_port()+"', '"+filme.getSinopse()+"', '"+filme.getAno()+"', '"
				+filme.getCod_diretor()+"', '"+filme.getTipo()+"', '"+filme.getGenero()+"')");
		Conecta.ExecuteQuery(sql);
	}
	
	public static void Delete(String codigo){
		//Deleta filme a partir do seu CPF
		String sql=("DELETE [cinema].[dbo].[FILME] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}
	
	public static Filme Busca(String codigo){
		Filme filme = new Filme();
		String sql = ("SELECT * FROM [cinema].[dbo].[FILME] WHERE CODIGO = "+codigo);
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				filme.setCodigo(rs.getString("CODIGO"));
				filme.setTitulo(rs.getString("TITULO"));
				filme.setTitulo_port(rs.getString("TITULO_PORT"));
				filme.setSinopse(rs.getString("SINOPSE"));
				filme.setAno(rs.getString("ANO_LANCAMENTO"));
				filme.setCod_diretor(rs.getString("COD_DIRETOR"));
				filme.setTipo(rs.getString("TIPO"));
				filme.setGenero(rs.getString("GENERO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return filme;
	}

	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Update(Filme filme){
		PreparedStatement pst = null;
		String sql=("UPDATE FILME "
				+ "SET TITULO = '"+filme.getTitulo()+"', TITULO_PORT = '"+filme.getTitulo_port()+"', SINOPSE = '"+filme.getSinopse()+"', ANO_LANCAMENTO = '"+filme.getAno()+"', COD_DIRETOR = "
				+filme.getCod_diretor()+", TIPO = '"+filme.getTipo()+"', GENERO = '"+filme.getGenero()+"' WHERE CODIGO = "+filme.getCodigo());
		Conecta.ExecuteQuery(sql);
	}
	
	public static void Add_Ator(String cod_filme, String cod_ator){
		PreparedStatement pst = null;
		String sql=("INSERT INTO FILME_POSSUI_ATOR (COD_FILME, COD_ATOR) VALUES ('"+cod_filme+"', '"+cod_ator+"')");
		Conecta.ExecuteQuery(sql);
	}
	
	public static void Del_Ator(String cod_filme, String cod_ator){
		String sql=("DELETE [cinema].[dbo].[FILME_POSSUI_ATOR] WHERE COD_ATOR = "+cod_ator+" AND COD_FILME = "+cod_filme);
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[FILME]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("COD_DIRETOR")+";"+rs.getString("ANO_LANCAMENTO").substring(0,10)+";"+rs.getString("GENERO")+";"+rs.getString("TIPO")+";"+rs.getString("TITULO")+";"+rs.getString("TITULO_PORT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
}
