package modelo;

public class Usuario {

	private String nome;
    private String usuario;
    private String cpf;
    private String senha;


    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Usuario(String nome, String usuario, String cpf, String senha) {
		this.nome = nome;
		this.usuario = usuario;
		this.cpf = cpf;
		this.senha = senha;
	}
}
