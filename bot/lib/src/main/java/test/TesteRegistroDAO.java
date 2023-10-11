package test;

import dao.RegistroDAO;
import modelo.Registro;

public class TesteRegistroDAO {

	public static void main(String[] args) {
		Registro registro = new Registro(1, "Adicionou arquivo", "10-09-2023");
		
		RegistroDAO teste = new RegistroDAO(); 
		
		teste.adiciona(registro);

	}

}
