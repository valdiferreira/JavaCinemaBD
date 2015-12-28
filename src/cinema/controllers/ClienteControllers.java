package cinema.controllers;

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
}
