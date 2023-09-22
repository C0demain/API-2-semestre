package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;


public class TelaInicial extends JFrame implements ActionListener{

	private JFrame frame;
	private JButton buttomChat;
	private JButton buttomArquivos;
	
	public TelaInicial() {
		/* Gera a tela*/
	initialize();
	
	
	buttomChat.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			TelaBot telaBot = new TelaBot();
			telaBot.setVisible(true);
			frame.dispose();
			}
		});
	
	/*Abre a tela de seleção de arquivo*/
    buttomArquivos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
			SeletorArquivoGUI seletor = new SeletorArquivoGUI();
			seletor.setVisible(true);
			frame.dispose();        
			}
    });
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttomArquivos = new JButton("Arquivos");
		buttomArquivos.setBounds(64, 186, 125, 43);
		frame.getContentPane().add(buttomArquivos);
		
		buttomChat = new JButton("Chat");
		buttomChat.setBounds(314, 186, 125, 43);
		frame.getContentPane().add(buttomChat);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}