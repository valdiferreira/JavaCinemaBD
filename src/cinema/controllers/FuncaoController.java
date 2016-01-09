package cinema.controllers;

import java.util.ArrayList;

import cinema.dominio.*;
import cinema.persistência.*;

public class FuncaoController {
	
	public static void create(String codigo, String descrição){
		Funcao funcao = new Funcao();
		funcao.setCodigo(codigo);
		funcao.setDescrição(descrição);
		FuncaoDAO.Create(funcao);
	}
	
	public static void delete(String codigo){
		FuncaoDAO.Delete(codigo);
	}
	
	public static void update(Funcao funcao){
		FuncaoDAO.Update(funcao);
	}
	
	public static Funcao busca(String codigo){
		return FuncaoDAO.Buscar(codigo);
	}
	
	public static ArrayList<String> listar(){
		return FuncaoDAO.Listar();
	}
}
