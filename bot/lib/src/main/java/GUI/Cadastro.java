package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import modelo.Usuario;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import modelo.Usuario;
import dao.UsuarioDAO;

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
		this.frame.setBounds(100, 100, 429, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuario = new JTextField();
		usuario.setBounds(53, 135, 241, 23);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JButton Entrar = new JButton("Cadastrar-se");
		Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = new Usuario(nome.getText(), usuario.getText(),cpf.getText(), senha.getText() );
				
				UsuarioDAO cadastro = new UsuarioDAO(); 
				
				cadastro.adiciona(user);
				
				frame.dispose();
								
			}
		});
		Entrar.setFont(new Font("Arial", Font.PLAIN, 11));
		Entrar.setBackground(Color.LIGHT_GRAY);
		Entrar.setForeground(Color.BLACK);
		Entrar.setBounds(53, 343, 119, 23);
		contentPane.add(Entrar);
		
		nome = new JTextField();
		nome.setBounds(53, 59, 241, 23);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(53, 34, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(53, 110, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(53, 255, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cpf :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(53, 179, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(53, 210, 241, 23);
		contentPane.add(cpf);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(53, 280, 241, 23);
		contentPane.add(senha);
		
		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setIcon(new ImageIcon(Cadastro.class.getResource("MicrosoftTeams-image.png")));
		lblNewLabel.setBounds(0, 0, 423, 414);
		contentPane.add(lblNewLabel);
	}
}
