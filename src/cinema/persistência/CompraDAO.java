package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinema.dominio.Ator;
import cinema.dominio.Compra;

public class CompraDAO {
	
	public static void Create(Compra compra) {
		PreparedStatement pst = null;
		String sql = ("INSERT INTO COMPRA (CODIGO, DATA_HORA, FORMA_PAGAMENTO, QTD_INGRESSO, VALOR_TOTAL, COD_CLIENTE, COD_SESSAO) "
				+ "VALUES ('"+compra.getCodigo()+"', TO_DATE('"+compra.getData_hora()+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS')),"
						+ "'"+compra.getForma_pagameto()+"', '"+compra.getQtd_ingresso()+"','"+compra.getValor_total()+"','"
							+compra.getCod_cliente()+"','"+compra.getCod_sessao()+"'");
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
		String sql = ("DELETE COMPRA WHERE CODIGO = "+codigo);
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
	public static void Update(Compra compra) {
		PreparedStatement pst = null;
		String sql = ("UPDATE COMPRA WHERE SET DATA_HORA='"+compra.getData_hora()
				+"' FORMA_PAGAMENTO='"+compra.getForma_pagameto()
				+"' QTD_INGRESSO ='"+compra.getQtd_ingresso()
				+"' VALOR_TOTAL='"+compra.getValor_total()
				+"' COD_CLIENTE='"+compra.getCod_cliente()
				+"' COD_SESSAO='"+compra.getCod_sessao()
				+"' where CODIGO='"+compra.getCodigo()+"'");
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
	
	public static Compra Busca (String codigo) {
		Compra compra = new Compra();
		PreparedStatement pst = null;
		String sql = ("SELECT * FROM COMPRA WHERE CODIGO='"+codigo+"'");
		ResultSet rs;
		try {
			pst = Conexao.executaStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				compra.setCodigo(rs.getString("CODIGO"));
				compra.setData_hora(rs.getString("DATA_HORA"));
				compra.setForma_pagameto(rs.getString("FORMA_PAGAMENTO"));
				compra.setValor_total(rs.getString("VALOR_TOTAL"));
				compra.setCod_cliente(rs.getString("cod_cliente"));
				compra.setCod_sessao(rs.getString("cod_sessao"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return compra;
	}
	
}
