package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class ClienteTeste {
	
	public static void create(){
		ClienteController.create("NETO", "12345678910", "7");
	}
	
	public static void busca(){
		Cliente cliente = new Cliente();
		cliente = ClienteController.busca("1");
		System.out.println(cliente.getCodigo()+" - "+cliente.getNome()+" - "+cliente.getCpf());
	}
	
	public static void update(){
		Cliente cliente = new Cliente();
		cliente.setNome("NETO2");
		cliente.setCpf("12345678910");
		cliente.setCodigo("7");
		ClienteController.update(cliente);
	}
	
	public static void delete(){
		ClienteController.delete("7");
	}
	
	public static void main(String[] args) {
		create();
		busca();
		update();
		busca();
		delete();
		busca();
	}

}
