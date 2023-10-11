package modelo;

public class Registro {
	private int idUsuario;
	private String descricao;
	private String data;
	
	
	public Registro(int idUsuario, String descricao, String data) {
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


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
}
