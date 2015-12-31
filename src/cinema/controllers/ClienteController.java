package cinema.controllers;

import java.util.List;

import cinema.dominio.Cliente;
import cinema.persist�ncia.ClienteDAO;

public class ClienteController {
	public static void create(String nome, String cpf, String codigo){
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setCodigo(codigo);
		ClienteDAO.Create(cliente);
		
	}
	public static List listarCliente (){
		return ClienteDAO.listaCliente();
	}
	public static void delete(String codigo){
		ClienteDAO.Delete(codigo);
		
	}
	public static void update(Cliente cliente){
		ClienteDAO.Update(cliente);
		
	}
	public static Cliente busca(String codigo){
		return ClienteDAO.Busca(codigo);
	}
	
	
}