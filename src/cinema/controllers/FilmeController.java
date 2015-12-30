package cinema.controllers;

import cinema.dominio.Filme;
import cinema.persist�ncia.FilmeDAO;

public class FilmeController {
	public static void create(String codigo, String titulo, String titulo_port, String sinopse, String ano, String cod_diretor, String tipo, String genero){
		Filme filme = new Filme();
		filme.setCodigo(codigo);
		filme.setTitulo(titulo);
		filme.setTitulo_port(titulo_port);
		filme.setSinopse(sinopse);
		filme.setAno(ano);
		filme.setCod_diretor(cod_diretor);
		filme.setTipo(tipo);
		filme.setGenero(genero);
		FilmeDAO.Create(filme);
	}
	
	public static void delete(String codigo){
		FilmeDAO.Delete(codigo);
	}
	
	public static Filme busca(String codigo){
		return FilmeDAO.Busca(codigo);
	}
	
	public static void update(Filme filme){
		FilmeDAO.Update(filme);
	}
}