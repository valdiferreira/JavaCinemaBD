package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class AtorTeste {
	
	public static void create(){
		AtorController.create("17", "Neto", "BRASILEIRO", "2015-10-20");
	}
	
	public static void busca(){
		Ator ator = new Ator();
		ator = AtorController.busca("17");
		System.out.println(ator.getCodigo()+" - "+ator.getNome()+" - "+ator.getNacionalidade()+" - "+ator.getData());
	}
	
	public static void update(){
		Ator ator = new Ator();
		ator.setCodigo("17");
		ator.setNome("BARBOSA");
		ator.setNacionalidade("BRASILEIRO");
		ator.setData("2015-10-20");
		AtorController.update(ator);
	}
	
	public static void delete(){
		AtorController.delete("17");
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
