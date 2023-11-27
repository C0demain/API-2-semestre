package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import dao.RegistroDAO;
import modelo.Usuario;
import modelo.Registro;

import GUI.Login;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

public class Cadastro extends Tela {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField usuario;
	private JTextField cpf;
	private JTextField senha;


	/**
	 * Create the frame.
	 */
	public Cadastro(TelaController controller) {
		super(controller);
		setResizable(false);
		setTitle("Cadastro");
		setForeground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(44, 42, 380, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton Entrar = new JButton("Cadastrar");
		Entrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		Entrar.setBounds(58, 416, 127, 33);
		panel.add(Entrar);
		Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Cadastro
					Usuario user = new Usuario(nome.getText(), usuario.getText(),cpf.getText(), senha.getText() );
					
					UsuarioDAO cadastro = new UsuarioDAO(); 
					
					cadastro.adiciona(user);
					
					// Registro
					long millis = System.currentTimeMillis();
					Date date = new Date(millis);
					int userId = cadastro.getIdOf(user.getUsuario());
					Registro registro = new Registro(userId, "Se cadastrou no sistema", date);
					
					RegistroDAO regDAO = new RegistroDAO();
					regDAO.adiciona(registro);
					
				}catch (Exception error) {
					System.out.println(error);
				}
				
				// Troca de janela
				mudaTela("Login");
								
			}
		});
		Entrar.setFont(new Font("Arial", Font.BOLD, 15));
		Entrar.setBackground(SystemColor.text);
		Entrar.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_4 = new JLabel("Realize seu Cadastro\r\n");
		lblNewLabel_4.setBounds(58, 10, 233, 50);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nome\r\n");
		lblNewLabel_1.setBounds(58, 67, 89, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		nome = new JTextField();
		nome.setBorder(new LineBorder(null));
		nome.setSelectedTextColor(new Color(192, 192, 192));
		nome.setFont(new Font("Arial", Font.PLAIN, 15));
		nome.setBounds(58, 106, 241, 23);
		panel.add(nome);
		nome.setColumns(15);
		
		usuario = new JTextField();
		usuario.setBorder(new LineBorder(null));
		usuario.setBounds(58, 184, 241, 23);
		panel.add(usuario);
		usuario.setFont(new Font("Arial", Font.PLAIN, 15));
		usuario.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBorder(new LineBorder(null));
		cpf.setBounds(58, 256, 241, 23);
		panel.add(cpf);
		cpf.setFont(new Font("Arial", Font.PLAIN, 15));
		cpf.setColumns(10);

	    senha = new JPasswordField(); // Transformando em um campo de senha
	    senha.setBorder(new LineBorder(null));
	    senha.setBounds(58, 332, 241, 23);
	    panel.add(senha);
	    senha.setFont(new Font("Arial", Font.PLAIN, 15));
	    
	    JButton mostrarSenha = new JButton("Mostrar");
	    mostrarSenha.setAutoscrolls(true);
	    mostrarSenha.setBackground(new Color(255, 255, 255));
	    mostrarSenha.setBorder(new LineBorder(new Color(0, 0, 0)));
	    mostrarSenha.setFont(new Font("Arial", Font.BOLD, 10));
        mostrarSenha.setBounds(58, 365, 85, 23);
        panel.add(mostrarSenha);

        mostrarSenha.addActionListener(new ActionListener() {
            boolean senhaVisivel = false;

            public void actionPerformed(ActionEvent e) {
                if (senhaVisivel) {
                    ((JPasswordField) senha).setEchoChar('\u2022'); // Torna a senha oculta
                    mostrarSenha.setText("Mostrar");
                } else {
                    ((JPasswordField) senha).setEchoChar((char) 0); // Torna a senha visível
                    mostrarSenha.setText("Ocultar");
                }
                senhaVisivel = !senhaVisivel; // Alterna entre visível e oculta
            }
        });
    
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setBounds(58, 306, 102, 14);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setBounds(58, 230, 89, 14);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Usuário");
		lblNewLabel_2.setBounds(58, 152, 75, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
	}
}
