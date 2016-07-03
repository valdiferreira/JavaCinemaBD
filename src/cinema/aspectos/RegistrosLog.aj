package cinema.aspectos;

import cinema.dominio.*;
import cinema.persist�ncia.*;

public aspect RegistrosLog {

	public static void Ator.inserting(Ator ator) {
		// Fazer uma conexão para registrar no banco.
		System.out.println("Novo Ator " + ator.getNome() + " registrado");
	}

	public static void Ator.updating(Ator o) {
		// Fazer uma conexão para registrar no banco.
		System.out.println("Dados do Ator " + o.getNome() + " alterados");
	}

	public static void Ator.deleting(Ator o) {
		// Fazer uma conexão para registrar no banco.
		System.out.println("Ator " + o.getNome() + " deletado");
	}

	pointcut posInsercaoAtor(Ator ator): 
		call(* AtorDAO.Create(Ator)) && target(ator);

	before(Ator ator):
		posInsercaoAtor(ator){
		Ator.inserting(ator);
	}
}