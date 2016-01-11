package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cinema.dominio.Sessao;

public class SessaoDAO {
	//OBS: FORMATO PARA A DATA (YYYY-MM-DD) EX: 2015-11-21
	public static void Create(Sessao sessao) {
		PreparedStatement pst = null;
		String sql = ("INSERT INTO SESSAO (CODIGO, QTD_PUBLICO, DATA_HORA, COD_FILME, COD_CINEMA, NUMERO_SALA) VALUES ('"+sessao.getCodigo()+"', '"+sessao.getQtd_publico()+"', TIMESTAMP '"+sessao.getData_hora()+" 10:30:00.12', '"+sessao.getCod_filme()+"', '"+sessao.getCod_cinema()+"', '"+sessao.getNumero_sala()+"')");
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
		String sql = ("DELETE SESSAO WHERE CODIGO = "+codigo);
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

	public static Sessao Busca(String codigo) {
		Sessao sessao = new Sessao();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM SESSAO WHERE CODIGO = "+codigo);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
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
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return sessao;
	}

	public static void Update(Sessao sessao) {
		PreparedStatement pst = null;
		String sql = ("UPDATE SESSAO SET COD_CINEMA = "+sessao.getCod_cinema()+", COD_FILME = "+sessao.getCod_filme()+", DATA_HORA = TIMESTAMP '"+sessao.getData_hora()+" 10:30:00.12', NUMERO_SALA = "+sessao.getNumero_sala()+", QTD_PUBLICO = "+sessao.getQtd_publico()+" WHERE CODIGO = "+sessao.getCodigo());
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
	public static void Add_Func(String cpf, String c_sessao, String c_funcao){
		PreparedStatement pst = null;
		String sql = ("INSERT INTO FUNCIONARIO_FUNCAO_SESSAO (FUNCIONARIO_CPF, COD_FUNCAO, COD_SESSAO) VALUES ('"+cpf+"', '"+c_funcao+"', '"+c_sessao+"')");
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
	public static void Del_Func(String cpf, String c_sessao, String c_funcao){
		PreparedStatement pst = null;
		String sql = ("DELETE FUNCIONARIO_FUNCAO_SESSAO WHERE FUNCIONARIO_CPF = "+cpf+" AND COD_FUNCAO = "+c_funcao+" AND COD_SESSAO = "+c_sessao);
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
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		PreparedStatement pst=null;		
		ResultSet rs;
		String sql=("SELECT * FROM SESSAO");
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("COD_CINEMA")+";"+rs.getString("COD_FILME")+";"+rs.getString("NUMERO_SALA")+";"+rs.getString("QTD_PUBLICO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		return dados;
	}
	public static String Assentos(String codigo){
		String total = "";
		PreparedStatement pst = null;		
		ResultSet rs;
		String sql=("SELECT LUGARES("+codigo+") as TOTAL FROM DUAL");
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				total = rs.getString("TOTAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		
		return total;
	}

}
