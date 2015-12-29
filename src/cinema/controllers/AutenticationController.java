package cinema.controllers;

import cinema.dominio.Autentication;
import cinema.persistência.AutenticationDAO;

public class AutenticationController {
	
	public static boolean Autentication(String cpf, String senha){
		Autentication autentication = new Autentication();
		autentication.setInput_cpf(cpf);
		autentication.setInput_senha(senha);
		return AutenticationDAO.Autentication(autentication);
	}
}
