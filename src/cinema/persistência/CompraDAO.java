package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cinema.dominio.Ator;
import cinema.dominio.Compra;

public class CompraDAO {
	
	public static void Create(Compra compra) {
		PreparedStatement pst = null;
		String sql = ("{CALL REGISTRO_DE_COMPRA('"+compra.getCodigo()+"', TIMESTAMP '"+compra.getData_hora()+" 17:45:00.12', '"+compra.getForma_pagameto()+"', '"+compra.getQtd_ingresso()+"', '"+compra.getValor_total()+"', '"+compra.getCod_cliente()+"', '"+compra.getCod_sessao()+"')}");
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
		String sql = ("UPDATE COMPRA SET DATA_HORA = TIMESTAMP '"+compra.getData_hora()+" 17:45:00.12"
				+"', FORMA_PAGAMENTO = '"+compra.getForma_pagameto()
				+"', QTD_INGRESSO = '"+compra.getQtd_ingresso()
				+"', VALOR_TOTAL = '"+compra.getValor_total()
				+"', COD_CLIENTE = '"+compra.getCod_cliente()
				+"', COD_SESSAO = '"+compra.getCod_sessao()
				+"' WHERE CODIGO = '"+compra.getCodigo()+"'");
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
				compra.setQtd_ingresso(rs.getString("QTD_INGRESSO"));
				compra.setValor_total(rs.getString("VALOR_TOTAL"));
				compra.setCod_cliente(rs.getString("COD_CLIENTE"));
				compra.setCod_sessao(rs.getString("COD_SESSAO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		return compra;
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		PreparedStatement pst=null;		
		ResultSet rs;
		String sql=("SELECT * FROM COMPRA");
		
		try {
			pst = Conexao.executaStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()){
				dados.add(rs.getString("CODIGO")+";"+rs.getString("COD_CLIENTE")+";"+rs.getString("COD_SESSAO")+";"+rs.getString("DATA_HORA").substring(0,10));
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
