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


public class TelaInicial extends Tela implements ActionListener{
	private JButton buttomChat;
	private JButton buttomArquivos;
	
	private JLabel lblNewLabel;
	
	public TelaInicial(TelaController controller) {
		super(controller);
		initialize();
	
	
	buttomChat.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			mudaTela("Bot"); // Muda para tela de bot
			}
		});
	
	/*Abre a tela de seleção de arquivo*/
    buttomArquivos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
			mudaTela("SeletorArquivo");      
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
		this.setBounds(100, 100, 375, 592);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JTextPane txtpnSeA = new JTextPane();
		txtpnSeA.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnSeA.setBackground(UIManager.getColor("Button.darkShadow"));
		txtpnSeA.setForeground(Color.WHITE);
		txtpnSeA.setText("Se é a sua primeira vez por aqui,\r\nselecione \"Arquivos\" para escolher \r\no arquivo que servirá de base para \r\nas respostas do bot.\r\n\r\n\r\nCaso contrário, pode ir diretamente para a tela do chat.");
		txtpnSeA.setBounds(30, 42, 276, 148);
		this.getContentPane().add(txtpnSeA);
		
		buttomChat = new JButton("Chat");
		buttomChat.setBounds(205, 428, 125, 43);
		this.getContentPane().add(buttomChat);
		
		buttomArquivos = new JButton("Arquivos");
		buttomArquivos.setBounds(30, 428, 125, 43);
		this.getContentPane().add(buttomArquivos);
		
		JButton registroButton = new JButton("Registro");
		registroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaTela("Dashboard"); // Vai pra tela Dashboard
			}
		});
		registroButton.setBounds(129, 508, 89, 23);
		this.getContentPane().add(registroButton);
		
		lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/GUI/img.png")));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabel.setBounds(0, 0, 359, 552);
		this.getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}