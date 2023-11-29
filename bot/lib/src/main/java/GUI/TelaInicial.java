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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.SystemColor;


public class TelaInicial extends Tela implements ActionListener{
	private JButton buttomChat;
	private JButton buttomArquivos;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextPane txtpnChatbotCapazDe;
	
	public TelaInicial(TelaController controller) {
		super(controller);
		setTitle("Tela Inicial");
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 64));
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
		this.setBounds(100, 100, 500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(44, 42, 397, 476);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnSeA = new JTextPane();
		txtpnSeA.setEditable(false);
		txtpnSeA.setBounds(30, 159, 342, 60);
		panel.add(txtpnSeA);
		txtpnSeA.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtpnSeA.setMinimumSize(new Dimension(8, 6));
		txtpnSeA.setFont(new Font("Arial", Font.PLAIN, 15));
		txtpnSeA.setBackground(SystemColor.menu);
		txtpnSeA.setForeground(new Color(0, 0, 0));
		txtpnSeA.setText("- Selecione 'Arquivos' para carregar um arquivo.\r\n");
		
		buttomArquivos = new JButton("Arquivos");
		buttomArquivos.setBackground(new Color(255, 255, 255));
		buttomArquivos.setBounds(45, 330, 137, 43);
		panel.add(buttomArquivos);
		buttomArquivos.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttomArquivos.setFont(new Font("Arial", Font.BOLD, 15));
		
		buttomChat = new JButton("Chat");
		buttomChat.setBackground(new Color(255, 255, 255));
		buttomChat.setBounds(211, 330, 137, 43);
		panel.add(buttomChat);
		buttomChat.setFont(new Font("Arial", Font.BOLD, 15));
		buttomChat.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton registroButton = new JButton("Registro");
		registroButton.setBackground(new Color(255, 255, 255));
		registroButton.setBounds(129, 402, 129, 34);
		panel.add(registroButton);
		registroButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		registroButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblNewLabel = new JLabel("Parrot AI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(45, 27, 161, 43);
		panel.add(lblNewLabel);
		
		txtpnChatbotCapazDe = new JTextPane();
		txtpnChatbotCapazDe.setEditable(false);
		txtpnChatbotCapazDe.setText("- ChatBot capaz de ler e responder perguntas baseadas em um arquivo PDF ou TXT.");
		txtpnChatbotCapazDe.setMinimumSize(new Dimension(8, 6));
		txtpnChatbotCapazDe.setForeground(Color.BLACK);
		txtpnChatbotCapazDe.setFont(new Font("Arial", Font.PLAIN, 15));
		txtpnChatbotCapazDe.setBackground(SystemColor.menu);
		txtpnChatbotCapazDe.setBounds(30, 99, 326, 60);
		panel.add(txtpnChatbotCapazDe);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(45, 80, 276, 3);
		panel.add(separator);
		registroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaTela("Dashboard"); // Vai pra tela Dashboard
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}