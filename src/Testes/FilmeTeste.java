package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class FilmeTeste {
	
	public static void main(String[] args) {
		create();
		busca();
		update();
		busca();
		delete();
		busca();
	}

	private static void create() {
		FilmeController.create("10", "MERDA 2", "MERDA 1", "DESCRÇÂO", "2015-12-23", "1", "NACIONAL", "MERDA");
	}
	
	private static void busca() {
		Filme filme = new Filme();
		filme = FilmeController.busca("10");
		System.out.println(filme.getCodigo()+" - "+filme.getTitulo()+" - "+filme.getTitulo_port()+" - "+filme.getSinopse()+" - "+filme.getAno()+" - "+filme.getCod_diretor()+" - "+filme.getTipo()+" - "+filme.getGenero());
	}
	
	private static void update() {
		Filme filme = new Filme();
		filme.setCodigo("10");
		filme.setTitulo("MERDA 22");
		filme.setTitulo_port("MERDA 11");
		filme.setSinopse("DESCRIÇÂO");
		filme.setAno("2015-12-23");
		filme.setCod_diretor("1");
		filme.setTipo("NACIONAL");
		filme.setGenero("CARAI");
		FilmeController.update(filme);
	}
	
	private static void delete() {
		FilmeController.delete("10");
	}




}
