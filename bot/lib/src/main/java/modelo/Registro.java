package modelo;

import java.sql.Date;

public class Registro {
	private int idUsuario;
	private String descricao;
	private Date data;
	
	
	public Registro(int idUsuario, String descricao, Date data) {
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.data = data;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	
}
