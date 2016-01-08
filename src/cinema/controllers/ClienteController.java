package cinema.controllers;

import java.util.ArrayList;
import java.util.List;

import cinema.dominio.Cliente;
import cinema.persistência.ClienteDAO;

public class ClienteController {
	public static void create(String nome, String cpf, String codigo){
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setCodigo(codigo);
		ClienteDAO.Create(cliente);
		
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
	public static void telefone(String codigo, String numero){
		ClienteDAO.Telefone(codigo, numero);
	}
	public static void del_telefone(String codigo, String numero){
		ClienteDAO.Del_Telefone(codigo, numero);
	}
	public static ArrayList<String> listar(){
		return ClienteDAO.Listar();
	}
	
}
