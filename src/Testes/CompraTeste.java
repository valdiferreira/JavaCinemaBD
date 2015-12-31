package Testes;

import cinema.controllers.*;
import cinema.dominio.*;

public class CompraTeste {
	
	public static void create(){
		CompraController.create("19", "2015-10-20", "BOLETO", "1", "25", "1", "1");
	}
	
	public static void busca(){
		Compra compra = new Compra();
		compra = CompraController.busca("19");
		System.out.println(compra.getCodigo()+" - "+compra.getData_hora()+" - "+compra.getForma_pagameto()+" - "+compra.getQtd_ingresso()+" - "+compra.getValor_total()+" - "+compra.getCod_cliente()+" - "+compra.getCod_sessao());
	}
	
	public static void update(){
		Compra compra = new Compra();
		compra.setCodigo("19");
		compra.setData_hora("2014-01-01");
		compra.setForma_pagameto("CARTÂO");
		compra.setQtd_ingresso("2");
		compra.setValor_total("50");
		compra.setCod_cliente("1");
		compra.setCod_sessao("1");
		CompraController.update(compra);
	}
	
	public static void delete(){
		CompraController.delete("19");
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
