package cinema.persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Conexao {
	private static String url = "jdbc:oracle:thin:@//oracle11g.cin.ufpe.br:1521/Instance01";
	private static String usr = "u_jbsn";
	private static String pwd = "jewzgtrv";
	private static Connection con = null;
	private static PreparedStatement pst = null;
	public Conexao(){}
	public static Connection conectaBanco() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url,usr,pwd);
		return Conexao2.conexao();
	}
	public static Connection fechaConexaoBanco(){
		if(con != null){
		   try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return con;
	}
	public static PreparedStatement fechaPreparedStatement (){
		if(pst != null){
			   try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return pst;
	}
	
	public static PreparedStatement executaStatement (String sql){
		try {
			con = conectaBanco();
			pst = con.prepareStatement(sql);
			return pst;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
}