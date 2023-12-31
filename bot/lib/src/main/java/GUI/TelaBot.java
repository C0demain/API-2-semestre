package GUI;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import bot.Bot;

public class TelaBot extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pergunta;
	
	public static String caminhoArquivo;
	public static int usuarioLogadoId;

	public void actionPerformed(ActionEvent e) {
		SeletorArquivoGUI.main(null);
		SeletorArquivoGUI.caminhoArquivo = caminhoArquivo;
		SeletorArquivoGUI.usuarioLogadoId = usuarioLogadoId;
		this.dispose();
	}
	
	public TelaBot() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Resposta :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(22, 29, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea resposta = new JTextArea();
		resposta.setLineWrap(true);
		resposta.setEditable(false);
		resposta.setBounds(22, 46, 310, 386);
		contentPane.add(resposta);
		
		JLabel lblNewLabel_1 = new JLabel(" Pergunta :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(22, 443, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		pergunta = new JTextField();
		pergunta.setBounds(22, 464, 204, 26);
		contentPane.add(pergunta);
		pergunta.setColumns(10);
		
		JButton buttomEnviar = new JButton("Enviar");
		
		// Interação com o bot (pegar pergunta e devolver resposta
		buttomEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String resp = Bot.perguntar(caminhoArquivo, pergunta.getText());
					resposta.setText(resp);
				}catch (RuntimeException err) {
					resposta.setText("Erro na leitura de arquivo");
					System.out.println(err);
				}catch (Exception err2) {
					resposta.setText("Desculpe, não consegui achar informações sobre '" + pergunta.getText() + "'");
					System.out.println(err2);
				}
				
			}
		});
	
		
		// Adicione um Action que será executado quando a tecla Enter for pressionada no campo "pergunta"
        Action enterAction = new AbstractAction() {
        	 @Override
             public void actionPerformed(ActionEvent e) {
                 String textoPergunta = pergunta.getText(); // Obtém o texto da caixa de texto
                 if (!textoPergunta.isEmpty()) {
                     // Verifique se o campo de pergunta não está vazio
                     String resp = null;
					try {
						resp = Bot.perguntar(caminhoArquivo, textoPergunta);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                     resposta.setText(resp);
                 }
        	 }
        };

        // Adicione o Action ao campo de pergunta para o evento Enter
        pergunta.addActionListener(enterAction);
		
		buttomEnviar.setForeground(new Color(0, 0, 0));
		buttomEnviar.setBackground(new Color(255, 255, 255));
		buttomEnviar.setBounds(236, 464, 96, 26);
		contentPane.add(buttomEnviar);
		
		JButton buttomVoltar = new JButton("Voltar");
		buttomVoltar.setForeground(new Color(0, 0, 0));
		buttomVoltar.setBounds(128, 518, 89, 23);
		buttomVoltar.addActionListener(this);
		contentPane.add(buttomVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setIcon(new ImageIcon(TelaBot.class.getResource("img.png")));
		lblNewLabel.setBounds(0, 0, 358, 552);
		contentPane.add(lblNewLabel);
	}
	
	public static void main(String[] args) {
        new TelaBot().setVisible(true);;
    }
}
