package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cinema.dominio.Sessao;

public class SessaoDAO {
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Create(Sessao sessao) {
		String sql = ("INSERT INTO SESSAO (CODIGO, QTD_PUBLICO, DATA_HORA, COD_FILME, COD_CINEMA, NUMERO_SALA) VALUES ('"+sessao.getCodigo()+"', '"+sessao.getQtd_publico()+"', '"+sessao.getData_hora()+"', '"+sessao.getCod_filme()+"', '"+sessao.getCod_cinema()+"', '"+sessao.getNumero_sala()+"')");
		Conecta.ExecuteQuery(sql);
	}

	public static void Delete(String codigo) {
		String sql = ("DELETE [cinema].[dbo].[SESSAO] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}

	public static Sessao Busca(String codigo) {
		Sessao sessao = new Sessao();
		String sql = ("SELECT * FROM [cinema].[dbo].[SESSAO] WHERE CODIGO = "+codigo);
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("COD_CINEMA"));
				sessao.setCod_cinema(rs.getString("COD_CINEMA"));
				sessao.setCod_filme(rs.getString("COD_FILME"));
				sessao.setCodigo(rs.getString("CODIGO"));
				sessao.setData_hora(rs.getString("DATA_HORA"));
				sessao.setNumero_sala(rs.getString("NUMERO_SALA"));
				sessao.setQtd_publico(rs.getString("QTD_PUBLICO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return sessao;
	}

	public static void Update(Sessao sessao) {
		String sql = ("UPDATE [cinema].[dbo].[SESSAO] SET COD_CINEMA = "+sessao.getCod_cinema()+", COD_FILME = "+sessao.getCod_filme()+", DATA_HORA = TIMESTAMP '"+sessao.getData_hora()+" 10:30:00.12', NUMERO_SALA = "+sessao.getNumero_sala()+", QTD_PUBLICO = "+sessao.getQtd_publico()+" WHERE CODIGO = "+sessao.getCodigo());
		Conecta.ExecuteQuery(sql);
	}
	public static void Add_Func(String cpf, String c_sessao, String c_funcao){
		String sql = ("INSERT INTO FUNCIONARIO_FUNCAO_SESSAO (FUNCIONARIO_CPF, COD_FUNCAO, COD_SESSAO) VALUES ('"+cpf+"', '"+c_funcao+"', '"+c_sessao+"')");
		Conecta.ExecuteQuery(sql);
	}
	public static void Del_Func(String cpf, String c_sessao, String c_funcao){
		String sql = ("DELETE [cinema].[dbo].[FUNCIONARIO_FUNCAO_SESSAO] WHERE FUNCIONARIO_CPF = "+cpf+" AND COD_FUNCAO = "+c_funcao+" AND COD_SESSAO = "+c_sessao);
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[SESSAO]");
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("COD_CINEMA")+";"+rs.getString("COD_FILME")+";"+rs.getString("NUMERO_SALA")+";"+rs.getString("QTD_PUBLICO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
	public static String Assentos(String codigo){
		String total = "55";
		
		
		
		return total;
	}

}
