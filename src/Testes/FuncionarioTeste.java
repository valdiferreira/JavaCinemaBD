package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class FuncionarioTeste {
	
	public static void create(){
		FuncionarioController.create("NETO", "12345678910", "12345678911", "JOSÈ PESSOA", "SÂo PEDRO", "95", "1", "123");
	}
	
	public static void busca(){
		Funcionario funcionario = new Funcionario();
		funcionario = FuncionarioController.busca("12345678910");
		System.out.println(funcionario.getNome()+" - "+funcionario.getCpf()+" - "+funcionario.getNct()+" - "+funcionario.getRua()+" - "+funcionario.getBairro()+" - "+funcionario.getNumero()+" - "+funcionario.getCod_cinema()+" - "+funcionario.getSenha());
	}
	
	public static void update(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("BARBOSA");
		funcionario.setCpf("12345678910");
		funcionario.setNct("55555555555");
		funcionario.setRua("PESSOA SOBRINHO");
		funcionario.setBairro("SÂO PEDRO");
		funcionario.setNumero("45");
		funcionario.setCod_cinema("2");
		funcionario.setSenha("12345");
		FuncionarioController.update(funcionario);
	}
	
	public static void delete(){
		FuncionarioController.delete("12345678910");
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
