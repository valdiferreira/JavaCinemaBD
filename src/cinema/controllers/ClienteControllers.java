package cinema.controllers;

import java.util.List;

import cinema.dominio.Cliente;
import cinema.persistência.ClienteDAO;

public class ClienteControllers {
	public static void addCliente (String nome, int cpf, int codigo){
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(nome);
		cliente.setCpfCliente(cpf);
		cliente.setCodCliente(codigo);
		ClienteDAO.clienteSave(cliente);
		
	}
	public static List listarCliente (){
		return ClienteDAO.listaCliente();
	}
	public static void deleteCliente (int codigo){
		Cliente cliente = new Cliente();
		cliente.setCodCliente(codigo);
		ClienteDAO.clienteSave(cliente);
		
	}
	public static void updateCliente (String nome, long l, long codidoCliente){
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(nome);
		cliente.setCpfCliente(l);
		cliente.setCodCliente(codidoCliente);
		ClienteDAO.clienteUpdate(cliente);
		
	}
	public static Cliente buscaCliente (long l){
		return ClienteDAO.clienteBusca(l);
	}
	
	
}
