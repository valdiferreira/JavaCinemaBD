package cinema.controllers;

import java.util.ArrayList;

import cinema.dominio.Ator;
import cinema.persistência.AtorDAO;

public class AtorController {

	public static void create(String codigo, String nome, String nacionalidade, String data){
		Ator ator = new Ator();
		ator.setCodigo(codigo);
		ator.setNome(nome);
		ator.setNacionalidade(nacionalidade);
		ator.setData(data);
		AtorDAO.Create(ator);
	}
	public static void delete(String codigo){
		AtorDAO.Delete(codigo);
	}
	public static Ator busca(String codigo){
		return AtorDAO.Busca(codigo);
	}
	public static void update(Ator ator){
		AtorDAO.Update(ator);
	}
	public static ArrayList<String> listar(){
		return AtorDAO.Listar();
	}
}
