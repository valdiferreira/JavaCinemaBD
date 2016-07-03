package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.dominio.Sala;

public class SalaDAO {
	
	public static void Create(Sala sala){
		PreparedStatement pst = null;
		String sql = ("INSERT INTO SALA(NUMERO, COD_CINEMA, QTD_ASSENTOS) VALUES('"+sala.getNumero()+"', '"+sala.getCod_cinema()+"', '"+sala.getQtd_assentos()+"')");
		Conecta.ExecuteQuery(sql);
	}
	
	public static void Delete(String n_sala, String c_cinema){
		String sql = ("DELETE [cinema].[dbo].[SALA] WHERE NUMERO = "+n_sala+" AND COD_CINEMA = "+c_cinema);
		Conecta.ExecuteQuery(sql);
	}
	
	public static Sala Busca(String n_sala, String c_cinema){
		Sala sala = new Sala();
		String sql = ("SELECT * FROM SALA WHERE NUMERO = "+n_sala+" AND COD_CINEMA = "+c_cinema);
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				sala.setNumero(rs.getString("NUMERO"));
				sala.setCod_cinema(rs.getString("COD_CINEMA"));
				sala.setQtd_assentos(rs.getString("QTD_ASSENTOS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return sala;
	}
	
	public static void Update(Sala sala){
		String sql = ("UPDATE [cinema].[dbo].[SALA] SET QTD_ASSENTOS = "+sala.getQtd_assentos()+" WHERE NUMERO = "+sala.getNumero()+" AND COD_CINEMA = "+sala.getCod_cinema());
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		PreparedStatement pst=null;		
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[SALA]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("COD_CINEMA")+";"+rs.getString("NUMERO")+";"+rs.getString("QTD_ASSENTOS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
	
}
