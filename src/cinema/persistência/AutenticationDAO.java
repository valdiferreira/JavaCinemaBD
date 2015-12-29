package cinema.persistência;

import java.sql.*;

import cinema.dominio.Autentication;

public class AutenticationDAO {

	public static boolean Autentication(Autentication autentication){
		PreparedStatement pst = null;	
		String sql=("SELECT SENHA FROM FUNCIONARIO WHERE CPF="+autentication.getInput_cpf());
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				autentication.setOutput_senha(rs.getString("SENHA"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		if(autentication.getInput_senha().equals(autentication.getOutput_senha())){
			return true;
		}else{
			return false;
		}
	}
	
}
