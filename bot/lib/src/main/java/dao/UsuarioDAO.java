package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import modelo.Usuario;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuarios(nome, usuario, cpf, senha) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getUsuario());
			stmt.setString(3, usuario.getCpf());
			stmt.setString(4, usuario.getSenha());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	public int getIdOf(String username) {
		String sql = "SELECT * FROM usuarios WHERE usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, username);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt("id");
			}else {
				throw new RuntimeException("Nao foi possivel encontrar um usuario com esse username");
			}
		}
		catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
}
