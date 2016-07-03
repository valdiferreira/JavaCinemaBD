package cinema.persistência;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cinema.dominio.Compra;

public class CompraDAO {
	
	public static void Create(Compra compra) {
		String sql = "INSERT INTO COMPRA (CODIGO, DATA_HORA, FORMA_PAGAMENTO, QTD_INGRESSO, VALOR_TOTAL, COD_CLIENTE, COD_SESSAO) VALUES ('"+compra.getCodigo()+"', '"+compra.getData_hora()+"', '"+compra.getForma_pagameto()+"', '"+compra.getQtd_ingresso()+"', '"+compra.getValor_total()+"', '"+compra.getCod_cliente()+"', '"+compra.getCod_sessao()+"');";
		Conecta.ExecuteQuery(sql);
	}
	public static void Delete(String codigo) {
		String sql = ("DELETE [cinema].[dbo].[COMPRA] WHERE CODIGO = "+codigo);
		Conecta.ExecuteQuery(sql);
	}
	public static void Update(Compra compra) {
		String sql = ("UPDATE [cinema].[dbo].[COMPRA] SET DATA_HORA = '"+compra.getData_hora()
				+"', FORMA_PAGAMENTO = '"+compra.getForma_pagameto()
				+"', QTD_INGRESSO = '"+compra.getQtd_ingresso()
				+"', VALOR_TOTAL = '"+compra.getValor_total()
				+"', COD_CLIENTE = '"+compra.getCod_cliente()
				+"', COD_SESSAO = '"+compra.getCod_sessao()
				+"' WHERE CODIGO = '"+compra.getCodigo()+"'");
		Conecta.ExecuteQuery(sql);
	}
	
	public static Compra Busca (String codigo) {
		Compra compra = new Compra();
		String sql = ("SELECT * FROM [cinema].[dbo].[COMPRA] WHERE CODIGO='"+codigo+"'");
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				compra.setCodigo(rs.getString("CODIGO"));
				compra.setData_hora(rs.getString("DATA_HORA"));
				compra.setForma_pagameto(rs.getString("FORMA_PAGAMENTO"));
				compra.setQtd_ingresso(rs.getString("QTD_INGRESSO"));
				compra.setValor_total(rs.getString("VALOR_TOTAL"));
				compra.setCod_cliente(rs.getString("COD_CLIENTE"));
				compra.setCod_sessao(rs.getString("COD_SESSAO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return compra;
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[COMPRA]");
		
		try {
			rs = Conecta.GetResultQuery(sql); 
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("COD_CLIENTE")+";"+rs.getString("COD_SESSAO")+";"+rs.getString("DATA_HORA").substring(0,10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
}
