package cinema.controllers;

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
	
	public static void delete(String numero){
		SalaDAO.Delete(numero);
	}
	
	public static Sala busca(String numero){
		return SalaDAO.Busca(numero);
	}
	
	public static void update(Sala sala){
		SalaDAO.Update(sala);
	}
}
