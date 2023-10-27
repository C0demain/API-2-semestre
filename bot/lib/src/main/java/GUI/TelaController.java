package GUI;

import java.util.HashMap;
import bot.Bot;

public class TelaController {
	private HashMap<String, Tela> telas;
	private Tela telaAtiva;
	private HashMap<String, String> dadosUteis;
	private Bot bot;

	public static void main(String args[]) {
		TelaController controller = new TelaController();
		
		// Registra todas as telas do sistema com um nome
		controller.registraTela("Inicial", new TelaInicial(controller));
		controller.registraTela("Bot", new TelaBot(controller));
		controller.registraTela("SeletorArquivo", new SeletorArquivoGUI(controller));
		controller.registraTela("Login", new Login(controller));
		controller.registraTela("Cadastro", new Cadastro(controller));
		controller.registraTela("Dashboard", new Dashboard(controller));
		
		controller.mudaTela("Login"); // Inicia com a tela de login
		
	}
	
	
	public TelaController() {
		this.telas = new HashMap<String, Tela>();
		this.dadosUteis = new HashMap<String, String>();
		
		this.setDado("usuarioLogadoId", "");
		this.setDado("caminhoArquivo", "");
		this.bot = new Bot();
		
	}
	
	
	public void registraTela(String nome, Tela tela) {
		this.telas.put(nome, tela);
	}

	public void mudaTela(String nome) {
		if(this.telas.containsKey(nome)){
			if(this.telaAtiva != null) this.telaAtiva.dispose();
			
			setTelaAtiva(this.telas.get(nome));
			this.telaAtiva.setVisible(true);
		}
	}
	
	public void setDado(String chave, String valor) {
		this.dadosUteis.put(chave, valor);
	}
	
	public Tela getTelaAtiva() {
		return this.telaAtiva;
	}
	
	public void setTelaAtiva(Tela tela) {
		this.telaAtiva = tela;
	}
	
	public HashMap<String, String> getDadosUteis() {
		return dadosUteis;
	}
	
	public Bot getBot() {
		return this.bot;
	}
	
	public void adicionarArquivo(String arquivo) {
		this.bot.adicionarArquivo(arquivo);
	}
}
