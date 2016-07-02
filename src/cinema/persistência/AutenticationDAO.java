package cinema.persistência;

import java.sql.*;

import cinema.dominio.Autentication;

public class AutenticationDAO {

	public static boolean Autentication(Autentication autentication){
		String sql=("SELECT SENHA FROM [cinema].[dbo].[FUNCIONARIO] WHERE CPF='"+autentication.getInput_cpf()+"'");
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()) {
				autentication.setOutput_senha(rs.getString("SENHA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}    
	      }
		if(autentication.getInput_senha().equals(autentication.getOutput_senha())){
			return true;
		}else{
			return false;
		}
	}
	
}
