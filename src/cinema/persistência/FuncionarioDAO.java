package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.controllers.FuncionarioController;
import cinema.dominio.Funcionario;

public class FuncionarioDAO {
	public static void Create(Funcionario funcionario){
		PreparedStatement pst=null;
		//Inserção de funcionarios a partir do Objeto funcionario.
		String sql=("{CALL CADASTRA_FUNC('"+funcionario.getNome()+"', '"+funcionario.getCpf()+"', '"+funcionario.getNct()+"', '"+funcionario.getRua()+"', '"+funcionario.getBairro()+"', '"
				+funcionario.getNumero()+"', '"+funcionario.getCod_cinema()+"', '"+funcionario.getSenha()+"')}");
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
	
	public static void Delete(String cpf){
		PreparedStatement pst=null;
		//Deleta funcionario a partir do seu CPF
		String sql=("{CALL DEL_FUNC('"+cpf+"')}");
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
	
	public static Funcionario Busca(String cpf){
		Funcionario funcionario = new Funcionario();
		PreparedStatement pst=null;
		String sql=("SELECT * FROM FUNCIONARIO WHERE CPF = "+cpf);
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				funcionario.setNome(rs.getString("NOME_FUNCIONARIO"));
				funcionario.setCpf(rs.getString("CPF"));
				funcionario.setNct(rs.getString("NUM_CARTEIRA_TRABALHO"));
				funcionario.setRua(rs.getString("RUA"));
				funcionario.setBairro(rs.getString("BAIRRO"));
				funcionario.setNumero(rs.getString("NUMERO"));
				funcionario.setCod_cinema(rs.getString("COD_CINEMA"));
				funcionario.setSenha(rs.getString("SENHA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return funcionario;
	}
	public static void Update(Funcionario funcionario){
		PreparedStatement pst=null;
		String sql = ("UPDATE FUNCIONARIO "
				+ "SET NOME_FUNCIONARIO = '"+funcionario.getNome()+"', NUM_CARTEIRA_TRABALHO = '"+funcionario.getNct()+"', RUA = '"+funcionario.getRua()+"', BAIRRO = '"+funcionario.getBairro()+"', NUMERO = "+funcionario.getNumero()+", COD_CINEMA = '"+funcionario.getCod_cinema()+"', SENHA = '"+funcionario.getSenha()
				+"' WHERE CPF = '"+funcionario.getCpf()+"'");
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
		String sql=("SELECT * FROM FUNCIONARIO");
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				dados.add(rs.getString("CPF")+";"+rs.getString("NOME_FUNCIONARIO")+";"+rs.getString("COD_CINEMA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
		return dados;
	}
}
