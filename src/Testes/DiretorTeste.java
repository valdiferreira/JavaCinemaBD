package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class DiretorTeste {

	public static void create(){
		DiretorController.create("5", "NETO", "BRASILEIRO");
	}
	
	public static void busca(){
		Diretor diretor = new Diretor();
		diretor = DiretorController.busca("5");
		System.out.println(diretor.getCodigo()+" - "+diretor.getNome()+" - "+diretor.getNacionalidade());
	}
	
	public static void update(){
		Diretor diretor = new Diretor();
		diretor.setCodigo("5");
		diretor.setNome("BARBOSA");
		diretor.setNacionalidade("ESTRANGEIRA");
		DiretorController.update(diretor);
	}
	
	public static void delete(){
		DiretorController.delete("5");
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
