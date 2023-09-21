package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;


public class TelaInicial implements ActionListener{

	private JFrame frame;
	private JButton buttomChat;
	private JButton buttomArquivos;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TelaBot telaBot = new TelaBot();
		telaBot.setVisible(true);
		frame.dispose();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttomArquivos = new JButton("Aquivos");
		buttomArquivos.setBounds(64, 186, 125, 43);
		frame.getContentPane().add(buttomArquivos);
		
		buttomChat = new JButton("Chat");
		buttomChat.setBounds(314, 186, 125, 43);
		buttomChat.addActionListener(this);
		frame.getContentPane().add(buttomChat);
	}
}