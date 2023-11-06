package GUI;

import java.lang.reflect.Field;

import javax.management.AttributeNotFoundException;
import javax.swing.JFrame;

public class Tela extends JFrame{
	private TelaController controller;
	
	public void mudaTela(String nome) {
		this.controller.mudaTela(nome);
	}
	
	public Tela(TelaController controller) {
		super();
		this.controller = controller;
	}
	
	public String getDado(String chave) {
		return this.controller.getDadosUteis().get(chave);
	}
	
	public void setDado(String chave, String valor) {
		this.controller.setDado(chave, valor);
	}
}
