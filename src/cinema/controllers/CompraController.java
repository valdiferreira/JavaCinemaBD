package cinema.controllers;


import java.util.ArrayList;

import cinema.dominio.Compra;
import cinema.persistência.CompraDAO;

public class CompraController {
	
	public static void create(String codigo, String data_hora, String forma_pagamento, String qtd_ingresso, String valor_total, String cod_cliente, String cod_sessao){
		Compra compra = new Compra();
		compra.setCod_cliente(cod_cliente);
		compra.setCodigo(codigo);
		compra.setCod_sessao(cod_sessao);
		compra.setData_hora(data_hora);
		compra.setForma_pagameto(forma_pagamento);
		compra.setQtd_ingresso(qtd_ingresso);
		compra.setValor_total(valor_total);
		CompraDAO.Create(compra);
		
	}
	public static void delete(String codigo){
		CompraDAO.Delete(codigo);
	}
	public static Compra busca(String codigo){
		return CompraDAO.Busca(codigo);
	}
	public static void update(Compra compra){
		CompraDAO.Update(compra);
	}
	public static ArrayList<String> listar(){
		return CompraDAO.Listar();
	}
}
