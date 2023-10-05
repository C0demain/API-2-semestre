package test;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Tsrt {

	public static void main(String[] args) {
		Usuario user = new Usuario("Erick", "Awata", "524.696.124-33", "123456");
		
		UsuarioDAO teste = new UsuarioDAO(); 
		
		teste.adiciona(user);

	}

}
