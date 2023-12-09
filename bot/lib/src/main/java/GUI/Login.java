package GUI;

import factory.ConnectionFactory;
import modelo.Registro;
import dao.RegistroDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.border.LineBorder;

public class Login extends Tela {

	private JPanel panel;
	private JTextField usuario;
	private JPasswordField senha;
	private Connection connection = new ConnectionFactory().getConnection();
	;

	public void execLogin(String user, String senha) {
		String sql = "SELECT * FROM usuarios WHERE usuario=? AND senha=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, senha);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				
				// Registro
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				Registro registro = new Registro(resultSet.getInt("id"), "Entrou no sistema", date);
				RegistroDAO regDAO = new RegistroDAO();
				regDAO.adiciona(registro);
				
				setDado("usuarioLogadoId", resultSet.getString("id")); // Manda id para o controller
				
				JOptionPane.showMessageDialog(panel, "Usuário logado - ID: "+resultSet.getString("id"));
				
				// Troca de janela
				
				mudaTela("Inicial");
			} else {
				JOptionPane.showMessageDialog(panel, "Nome de usuário ou senha incorreto");
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Login(TelaController controller) {
		super(controller);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/parrot.png")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(44, 42, 388, 476);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
				usuario = new JTextField();
				usuario.setBorder(new LineBorder(new Color(0, 0, 0)));
				usuario.setFont(new Font("Arial", Font.PLAIN, 15));
				usuario.setBounds(42, 137, 291, 34);
				panel_1.add(usuario);
				usuario.setColumns(15);
				
						senha = new JPasswordField();
						senha.setBorder(new LineBorder(new Color(0, 0, 0)));
						senha.setFont(new Font("Arial", Font.PLAIN, 15));
						senha.setBounds(42, 217, 291, 34);
						panel_1.add(senha);
						senha.setColumns(10);
						
						JLabel lblNewLabel = new JLabel("Usuário");
						lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
						lblNewLabel.setBounds(42, 101, 76, 26);
						panel_1.add(lblNewLabel);
						
						JLabel lblSenha = new JLabel("Senha");
						lblSenha.setFont(new Font("Arial", Font.BOLD, 15));
						lblSenha.setBounds(42, 181, 76, 26);
						panel_1.add(lblSenha);
						
								JButton cadastroBtn = new JButton("Cadastrar");
								cadastroBtn.setBackground(new Color(255, 255, 255));
								cadastroBtn.setBounds(116, 396, 136, 34);
								panel_1.add(cadastroBtn);
								cadastroBtn.setFont(new Font("Arial", Font.BOLD, 15));
								
										JButton login = new JButton("Login");
										login.setBackground(new Color(255, 255, 255));
										login.setBounds(116, 293, 136, 34);
										panel_1.add(login);
										login.setFont(new Font("Arial", Font.BOLD, 15));
										
										JSeparator separator = new JSeparator();
										separator.setPreferredSize(new Dimension(0, 3));
										separator.setForeground(new Color(0, 0, 0));
										separator.setBounds(42, 361, 120, 3);
										panel_1.add(separator);
										
										JSeparator separator_1 = new JSeparator();
										separator_1.setPreferredSize(new Dimension(0, 3));
										separator_1.setForeground(Color.BLACK);
										separator_1.setBounds(213, 361, 120, 3);
										panel_1.add(separator_1);
										
										JLabel lblNewLabel_1 = new JLabel("OU");
										lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
										lblNewLabel_1.setBounds(172, 337, 76, 49);
										panel_1.add(lblNewLabel_1);
										
										JLabel lblNewLabel_2 = new JLabel("Login\r\n");
										lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
										lblNewLabel_2.setBounds(150, 23, 76, 58);
										panel_1.add(lblNewLabel_2);
										login.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												String strUsuario = usuario.getText();
												String strSenha = new String(senha.getPassword());
												if (strUsuario.isEmpty() || strSenha.isEmpty()) {
													JOptionPane.showMessageDialog(panel, "Usuário e senha não podem estar vazios");
												} else {
													execLogin(strUsuario, strSenha);
												}
											}
										});
								
								cadastroBtn.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										mudaTela("Cadastro");
									}
								});
	}
}
