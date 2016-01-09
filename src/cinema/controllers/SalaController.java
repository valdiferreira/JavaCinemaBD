package cinema.controllers;

import java.util.ArrayList;

import cinema.dominio.Sala;
import cinema.persistência.SalaDAO;

public class SalaController {
	
	public static void create(String numero, String cod_cinema, String qtd_assentos){
		Sala sala = new Sala();
		sala.setNumero(numero);
		sala.setCod_cinema(cod_cinema);
		sala.setQtd_assentos(qtd_assentos);
		SalaDAO.Create(sala);
	}
	
	public static void delete(String n_sala, String c_cinema){
		SalaDAO.Delete(n_sala, c_cinema);
	}
	
	public static Sala busca(String n_sala, String c_cinema){
		return SalaDAO.Busca(n_sala, c_cinema);
	}
	
	public static void update(Sala sala){
		SalaDAO.Update(sala);
	}
	
	public static ArrayList<String> listar(){
		return SalaDAO.Listar();
	}
}
