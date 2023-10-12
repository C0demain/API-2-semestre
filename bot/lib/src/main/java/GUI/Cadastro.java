package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import dao.RegistroDAO;
import modelo.Usuario;
import modelo.Registro;

import GUI.Login;

import javax.swing.JButton;
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

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField usuario;
	private JTextField cpf;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro cadastro = new Cadastro();
					cadastro.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});				
		
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		this.frame = new JFrame();
		this.frame.setTitle("Login");
		this.frame.setForeground(new Color(128, 128, 128));
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setBounds(100, 100, 377, 594);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Para se cadastrar, basta preencher todos os campos.");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 64, 339, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cadastro:");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 11, 150, 58);
		contentPane.add(lblNewLabel_4);
		
		usuario = new JTextField();
		usuario.setBounds(10, 220, 241, 23);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JButton Entrar = new JButton("Cadastrar-se");
		Entrar.setBounds(202, 492, 119, 23);
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
				Login login = new Login();
				login.main(null);
				frame.dispose();
								
			}
		});
		Entrar.setFont(new Font("Arial", Font.PLAIN, 11));
		Entrar.setBackground(Color.LIGHT_GRAY);
		Entrar.setForeground(Color.BLACK);
		contentPane.add(Entrar);
		
		nome = new JTextField();
		nome.setBounds(10, 144, 241, 23);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setBounds(10, 119, 89, 14);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário :");
		lblNewLabel_2.setBounds(10, 195, 75, 14);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha :");
		lblNewLabel_2_1.setBounds(10, 347, 46, 14);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cpf :");
		lblNewLabel_1_1.setBounds(10, 271, 89, 14);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1);
		
		cpf = new JTextField();
		cpf.setBounds(10, 296, 241, 23);
		cpf.setColumns(10);
		contentPane.add(cpf);
		
		senha = new JTextField();
		senha.setBounds(10, 372, 241, 23);
		senha.setColumns(10);
		contentPane.add(senha);
		
		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setBounds(0, 0, 359, 552);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setIcon(new ImageIcon(Cadastro.class.getResource("img.png")));
		contentPane.add(lblNewLabel);
	}
}
