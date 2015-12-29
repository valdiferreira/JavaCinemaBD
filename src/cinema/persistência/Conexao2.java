package cinema.persistÍncia;

import java.sql.Connection;

import oracle.jdbc.pool.OracleDataSource;


public class Conexao2 {
        // declaracao de variaveis
        public static Connection con;
        public static String url;
        public static String user;
        public static String password;


/**
     * @param args the command line arguments
     */
    public static Connection conexao() {
        // TODO code application logic here
        
  
        
        /*url = "jdbc:oracle:thin:@localhost:1521/xe"; //string de conex√£o para o ORACLE
        
        user = "SYSTEM"; //nome do usu·rio
        
        password = "newpassword"; //senha*/     
        
        url = "jdbc:oracle:thin:@localhost:1521/xe"; //string de conex√£o para o ORACLE
        
        user = "SYSTEM"; //nome do usu·rio
        
        password = "newpassword"; //senha
        
        try{
            
           OracleDataSource ds = new OracleDataSource(); //nova fonte de dados

           ds.setURL(url); //passa a URL para a conexao

           ds.getConnection(user,password);//recebe usuario e senha

           con = ds.getConnection(user,password);//conexao recebe os parametros de usuario e senha
       
           //System.out.println("Conexao Realizada");
           return con;//confirma√ß√£o
        }

        catch(Exception e) {

           System.out.println("Ocorreu um erro" + e.getMessage());

           System.exit(0);

        }
        return null;

    }
    
    
    
}
