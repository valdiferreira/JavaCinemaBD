package cinema.persistência;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinema.dominio.Cliente;


public class ClienteDAO {

	public static void clienteSave (Cliente cliente) {
		PreparedStatement pst=null;		
		
		String sql=("insert into cliente (CODIGO, NOME, CPF) values ("
		+ cliente.getCodCliente()+",'"+cliente.getNomeCliente()+"',"+cliente.getCpfCliente()+ ")");
		
		try {
			pst = Conexao.executaStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.fechaConexaoBanco();
			Conexao.fechaPreparedStatement();
		}
		
	}
}
