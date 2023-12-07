package GUI;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
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
import java.awt.Insets;

public class TelaBot extends Tela implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField pergunta;
    private JTextArea resposta; // Altere a variável para ser um JTextArea
    private StringBuilder historico; // Crie um StringBuilder para armazenar o histórico

    public void actionPerformed(ActionEvent e) {
        mudaTela("Inicial"); // Muda para tela inicial
    }

    public TelaBot(TelaController controller) {
        super(controller);
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBot.class.getResource("/images/parrot.png")));
        setTitle("ChatBot");

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 620);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Conversa :");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(32, 25, 120, 14);
        contentPane.add(lblNewLabel_2);

        // Adicione o JTextArea dentro de um JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 46, 416, 386);
        contentPane.add(scrollPane);
        
                resposta = new JTextArea();
                resposta.setMargin(new Insets(10, 10, 10, 10));
                resposta.setFont(new Font("Arial", Font.PLAIN, 15));
                scrollPane.setViewportView(resposta);
                resposta.setLineWrap(true);
                resposta.setEditable(false);

        historico = new StringBuilder(); // Inicialize o StringBuilder

        JLabel lblNewLabel_1 = new JLabel(" Pergunta :");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(32, 442, 120, 30);
        contentPane.add(lblNewLabel_1);

        pergunta = new JTextField();
        pergunta.setMargin(new Insets(4, 4, 4, 4));
        pergunta.setFont(new Font("Arial", Font.PLAIN, 15));
        pergunta.setBounds(32, 479, 287, 32);
        contentPane.add(pergunta);
        pergunta.setColumns(10);

        JButton buttomEnviar = new JButton("Enviar");
        buttomEnviar.setFont(new Font("Arial", Font.BOLD, 15));

        // Interação com o bot (pegar pergunta e devolver resposta
        buttomEnviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String textoPergunta = pergunta.getText();
                    String resp = Bot.perguntar(textoPergunta);
                    historico.append("Question: " + textoPergunta + "\n\n");
                    historico.append("Answer: " + resp + "\n\n");
                } catch (RuntimeException err) {
                	historico.append("Answer: " + "Erro na leitura de arquivo" + "\n\n");
                    System.out.println(err);
                } catch (Exception err2) {
                	historico.append("Answer: " + "Desculpe, não consegui achar informações sobre '" + pergunta.getText() + "'");
                    System.out.println(err2);
                }
                resposta.setText(historico.toString());

            }
        });

        // Adicione um Action que será executado quando a tecla Enter for pressionada no campo "pergunta"
        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoPergunta = pergunta.getText();
                if (!textoPergunta.isEmpty()) {
                    String resp = null;
                    try {
                        resp = Bot.perguntar(textoPergunta);
                        historico.append("Question: " + textoPergunta + "\n\n");
                        historico.append("Answer: " + resp + "\n\n");
                        resposta.setText(historico.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        pergunta.addActionListener(enterAction);

        buttomEnviar.setForeground(new Color(0, 0, 0));
        buttomEnviar.setBackground(new Color(255, 255, 255));
        buttomEnviar.setBounds(352, 480, 96, 30);
        contentPane.add(buttomEnviar);

        JButton buttomVoltar = new JButton("Voltar");
        buttomVoltar.setFont(new Font("Arial", Font.BOLD, 15));
        buttomVoltar.setForeground(new Color(0, 0, 0));
        buttomVoltar.setBounds(32, 528, 89, 32);
        buttomVoltar.addActionListener(this);
        contentPane.add(buttomVoltar);
        
    
        JButton buttomLimpar = new JButton("Limpar");
        buttomLimpar.setFont(new Font("Arial", Font.BOLD, 15));
        buttomLimpar.setForeground(new Color(0, 0, 0));
        buttomLimpar.setBounds(150, 528, 89, 32);
        contentPane.add(buttomLimpar);

        // Limpar
        buttomLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resposta.setText(""); // Limpa a caixa de conversa
                historico.setLength(0); // Limpa o historico
                pergunta.setText("");  //Limpa a caixa de pergunta
            }
        });

    }
}