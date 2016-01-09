package cinema.controllers;

import java.util.ArrayList;

import cinema.dominio.*;
import cinema.persistência.*;

public class SessaoController {
	
	public static void create(String cod_cinema, String cod_filme, String codigo, String data_hora, String numero_sala, String qtd_publico) {
		Sessao sessao = new Sessao();
		sessao.setCod_cinema(cod_cinema);
		sessao.setCod_filme(cod_filme);
		sessao.setCodigo(codigo);
		sessao.setData_hora(data_hora);
		sessao.setNumero_sala(numero_sala);
		sessao.setQtd_publico(qtd_publico);
		SessaoDAO.Create(sessao);
	}
	public static void delete(String codigo){
		SessaoDAO.Delete(codigo);
	}
	public static Sessao busca(String codigo){
		return SessaoDAO.Busca(codigo);
	}
	public static void update(Sessao sessao){
		SessaoDAO.Update(sessao);
	}
	public static void add_func(String cpf, String c_sessao, String c_funcao){
		SessaoDAO.Add_Func(cpf, c_sessao, c_funcao);
	}
	public static void del_func(String cpf, String c_sessao, String c_funcao){
		SessaoDAO.Del_Func(cpf, c_sessao, c_funcao);
	}
	public static ArrayList<String> listar(){
		return SessaoDAO.Listar();
	}
}
