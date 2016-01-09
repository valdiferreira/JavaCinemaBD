package cinema.controllers;

import java.util.ArrayList;

import cinema.dominio.*;
import cinema.persistência.*;

public class CinemaController {
	
	public static void create(String bairro, String cidade, String codigo, String nome, String numero, String rua){
		Cinema cinema = new Cinema();
		cinema.setBairro(bairro);
		cinema.setCidade(cidade);
		cinema.setCodigo(codigo);
		cinema.setNome(nome);
		cinema.setNumero(numero);
		cinema.setRua(rua);
		CinemaDAO.Create(cinema);
	}
	public static void delete(String codigo){
		CinemaDAO.Delete(codigo);
	}
	public static Cinema busca(String codigo){
		return CinemaDAO.Busca(codigo);
	}
 	public static void update(Cinema cinema){
 		CinemaDAO.Update(cinema);
 	}
 	public static ArrayList<String> listar(){
 		return CinemaDAO.Listar();
 	}
 	public static void add_telefone(String codigo, String numero){
 		CinemaDAO.Add_Telefone(codigo, numero);
 	}
 	public static void del_telefone(String codigo, String numero){
 		CinemaDAO.Del_Telefone(codigo, numero);
 	}
}
