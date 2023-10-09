package test;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Tsrt {

	public static void main(String[] args) {
		Usuario user = new Usuario("Erick", "Awata", "52469612433", "123456");
		
		UsuarioDAO teste = new UsuarioDAO(); 
		
		teste.adiciona(user);

	}

}
