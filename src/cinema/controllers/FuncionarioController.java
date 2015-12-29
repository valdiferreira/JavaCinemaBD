package cinema.controllers;

import cinema.dominio.Funcionario;
import cinema.persistência.FuncionarioDAO;

public class FuncionarioController {
	public static void create(String nome, String cpf, String nct, String rua, String bairro, String numero, String cod_cinema, String senha){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setNct(nct);
		funcionario.setRua(rua);
		funcionario.setBairro(bairro);
		funcionario.setNumero(numero);
		funcionario.setCod_cinema(cod_cinema);
		funcionario.setSenha(senha);
		FuncionarioDAO.Create(funcionario);
		
	}
	public static void delete(String cpf){
		FuncionarioDAO.Delete(cpf);
	}
	public static Funcionario busca(String cpf){
		return FuncionarioDAO.Busca(cpf);
	}
	public static void update(Funcionario funcionario){
		FuncionarioDAO.Update(funcionario);
	}
}
