package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import modelo.Registro;

public class RegistroDAO {
	private Connection connection;
	
	public RegistroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Registro registro) {
		String sql = "INSERT INTO registros(idUsuario, descricao, data) VALUES(?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, registro.getIdUsuario());
			stmt.setString(2, registro.getDescricao());
			stmt.setDate(3, registro.getData());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
}
