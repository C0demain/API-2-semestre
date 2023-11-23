package dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import modelo.Registro;

public class RegistroDAO {
	private Connection connection;
	
	public RegistroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Registro registro) {
		String sql = "INSERT INTO registro(id_usuario, descricao, data) VALUES(?, ?, ?)";
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
	
	public List<Registro> getAll(){
		List<Registro> registros = new ArrayList<Registro>();
		String sql = "SELECT * FROM registro";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Registro reg = new Registro(resultSet.getInt("id"), resultSet.getInt("id_usuario"), resultSet.getString("descricao"), resultSet.getDate("data"));
				registros.add(reg);
			}
			
			return registros;
			
		}
		catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	}
