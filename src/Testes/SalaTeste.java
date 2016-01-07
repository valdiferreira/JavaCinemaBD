package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class SalaTeste {

	public static void create(){
		SalaController.create("5", "3", "25");
	}
	
	public static void busca(){
		Sala sala = new Sala();
		sala = SalaController.busca("5", "3");
		System.out.println(sala.getNumero()+" - "+sala.getCod_cinema()+" - "+sala.getQtd_assentos());
	}
	
	public static void update(){
		Sala sala = new Sala();
		sala.setNumero("5");
		sala.setCod_cinema("3");
		sala.setQtd_assentos("100");
		SalaController.update(sala);
	}
	
	public static void delete(){
		SalaController.delete("5", "3");
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
