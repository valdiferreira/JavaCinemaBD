package cinema.persistência;

import java.sql.*;

import cinema.dominio.Filme;

public class FilmeDAO {
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Create(Filme filme){
		PreparedStatement pst = null;
		String sql=("INSERT INTO FILME(CODIGO, TITULO, TITULO_PORT, SINOPSE, ANO_LANCAMENTO, COD_DIRETOR, TIPO, GENERO) "
				+ "VALUES('"+filme.getCodigo()+"', '"+filme.getTitulo()+"', '"+filme.getTitulo_port()+"', '"+filme.getSinopse()+"', TO_DATE('"+filme.getAno()+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '"
				+filme.getCod_diretor()+"', '"+filme.getTipo()+"', '"+filme.getGenero()+"')");
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
		//Deleta funcionario a partir do seu CPF
		String sql=("DELETE FILME WHERE CODIGO = "+codigo);
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
	
	public static Filme Busca(String codigo){
		Filme filme = new Filme();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM FILME WHERE CODIGO = "+codigo);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
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
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return filme;
	}

	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Update(Filme filme){
		PreparedStatement pst = null;
		String sql=("UPDATE FILME "
				+ "SET TITULO = '"+filme.getTitulo()+"', TITULO_PORT = '"+filme.getTitulo_port()+"', SINOPSE = '"+filme.getSinopse()+"', ANO_LANCAMENTO = TO_DATE('"+filme.getAno()+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), COD_DIRETOR = "
				+filme.getCod_diretor()+", TIPO = '"+filme.getTipo()+"', GENERO = '"+filme.getGenero()+"' WHERE CODIGO = "+filme.getCodigo());
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
