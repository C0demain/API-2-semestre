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
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTextPane;


public class TelaInicial extends JFrame implements ActionListener{

	private JFrame frame;
	private JButton buttomChat;
	private JButton buttomArquivos;
	
	public static String caminhoArquivo = "";
	public static int usuarioLogadoId;
	private JLabel lblNewLabel;
	
	public TelaInicial() {
		/* Gera a tela*/
	initialize();
	
	
	buttomChat.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			TelaBot telaBot = new TelaBot();
			TelaBot.caminhoArquivo = caminhoArquivo;
			TelaBot.usuarioLogadoId = usuarioLogadoId;
			telaBot.setVisible(true);
			frame.dispose();
			}
		});
	
	/*Abre a tela de seleção de arquivo*/
    buttomArquivos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
			SeletorArquivoGUI seletor = new SeletorArquivoGUI();
			SeletorArquivoGUI.caminhoArquivo = caminhoArquivo;
			SeletorArquivoGUI.usuarioLogadoId = usuarioLogadoId;
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
		frame.setBounds(100, 100, 375, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnSeA = new JTextPane();
		txtpnSeA.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnSeA.setBackground(UIManager.getColor("Button.darkShadow"));
		txtpnSeA.setForeground(Color.WHITE);
		txtpnSeA.setText("Se é a sua primeira vez,\r\nselecione \"Arquivos\" para escolher \r\no arquivo que servirá de base para \r\nas respostas do bot.\r\n\r\n\r\nSe não, pode ir por onde preferir!\r\nBoa conversa!");
		txtpnSeA.setBounds(30, 42, 276, 148);
		frame.getContentPane().add(txtpnSeA);
		
		buttomChat = new JButton("Chat");
		buttomChat.setBounds(205, 428, 125, 43);
		frame.getContentPane().add(buttomChat);
		
		buttomArquivos = new JButton("Arquivos");
		buttomArquivos.setBounds(30, 428, 125, 43);
		frame.getContentPane().add(buttomArquivos);
		
		JButton registroButton = new JButton("Registro");
		registroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vai pra tela Dashboard
				Dashboard tela = new Dashboard();
				tela.usuarioLogadoId = usuarioLogadoId;
				tela.main(null);
				
				frame.dispose();
			}
		});
		registroButton.setBounds(129, 508, 89, 23);
		frame.getContentPane().add(registroButton);
		
		lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/GUI/img.png")));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabel.setBounds(0, 0, 359, 552);
		frame.getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}