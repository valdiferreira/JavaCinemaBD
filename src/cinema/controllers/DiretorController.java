package cinema.controllers;

import java.util.ArrayList;

import cinema.dominio.Diretor;
import cinema.persistência.DiretorDAO;

public class DiretorController {
	public static void create(String codigo, String nome, String nacionalidade){
		Diretor diretor = new Diretor();
		diretor.setCodigo(codigo);
		diretor.setNome(nome);
		diretor.setNacionalidade(nacionalidade);
		DiretorDAO.Create(diretor);
	}
	public static void delete(String codigo){
		DiretorDAO.Delete(codigo);
	}
	public static Diretor busca(String codigo){
		return DiretorDAO.Busca(codigo);
	}
	public static void update(Diretor diretor){
		DiretorDAO.Update(diretor);
	}
	public static ArrayList<String> listar(){
		return DiretorDAO.Listar();
	}
}
