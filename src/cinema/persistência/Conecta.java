package cinema.persistência;
import java.sql.*;

public class Conecta {
	//String Neto
	public static String url = "jdbc:sqlserver://localhost;databaseName=cinema;integratedSecurity=true";
	public static Connection con = null;  
    public static Statement stmt = null;  
    public static ResultSet rs = null;
    
    //Método utilizado para execução de QUerys que retornam dados, EX: SELECT FROM
	public static ResultSet GetResultQuery(String sql){
		try {
			
	         // Estabilização de conexão.  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(url);  
	  
	         // Execução de SQL.  
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(sql);
	         return rs;
	       
	      }  
	  
	      // Handle any errors that may have occurred.  
	      catch (Exception e) {  
	         e.printStackTrace();  
	      }
		
		//Retorna o sql
		return null;
		
	}
	
	//Método utilizado para executar Querys do tipo que não retornam dads, EX: INSERT INTO
	public static void ExecuteQuery(String sql){
		try {
			
	         // Estabilização de conexão.  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(url);  
	  
	         // Execução de SQL.  
	         stmt = con.createStatement();  
	         stmt.execute(sql);  
	       
	      }  
	  
	      // Handle any errors that may have occurred.  
	      catch (Exception e) {  
	         e.printStackTrace();  
	      }finally { 
	          if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	          if (con != null) try { con.close(); } catch(Exception e) {}  
	       }
		
	}
}
