package test;

import dao.RegistroDAO;
import modelo.Registro;
import java.sql.Date;

public class TesteRegistroDAO {

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		Date date = new java.sql.Date(millis);
		Registro registro = new Registro(1, "Registro teste", date);
		
		RegistroDAO teste = new RegistroDAO(); 
		
		teste.adiciona(registro);

	}

}
