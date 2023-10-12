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

public class Login extends JFrame {

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
				
				JOptionPane.showMessageDialog(panel, "Usuário logado - ID: "+resultSet.getString("id"));
				
				// Troca de janela
				TelaInicial tela = new TelaInicial();
				tela.main(null);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(panel, "Nome de usuário ou senha incorreto");
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 594);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		JTextArea txtrPodeLogarPara = new JTextArea();
		txtrPodeLogarPara.setBackground(UIManager.getColor("Button.darkShadow"));
		txtrPodeLogarPara.setForeground(Color.WHITE);
		txtrPodeLogarPara.setFont(new Font("Arial", Font.BOLD, 14));
		txtrPodeLogarPara.setText("Pode logar para utilizar o nosso bot!\r\n\r\nCaso não tenha login,\r\nRealize seu cadastro!");
		txtrPodeLogarPara.setBounds(34, 37, 291, 80);
		panel.add(txtrPodeLogarPara);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(34, 356, 102, 23);
		panel.add(btnNewButton);

		JButton login = new JButton("Login");
		login.setBounds(223, 356, 102, 23);
		panel.add(login);
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

		usuario = new JTextField();
		usuario.setBounds(34, 195, 291, 20);
		panel.add(usuario);
		usuario.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(34, 258, 291, 20);
		panel.add(senha);
		senha.setColumns(10);

		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setBackground(SystemColor.control);
		txtpnUsuario.setText("Usuario : ");
		txtpnUsuario.setBounds(34, 174, 53, 20);
		panel.add(txtpnUsuario);

		JTextPane txtpnSenha = new JTextPane();
		txtpnSenha.setBackground(SystemColor.control);
		txtpnSenha.setEditable(false);
		txtpnSenha.setText("Senha :");
		txtpnSenha.setBounds(34, 237, 44, 20);
		panel.add(txtpnSenha);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/GUI/img.png")));
		lblNewLabel.setBounds(0, 0, 361, 555);
		panel.add(lblNewLabel);
	}
}
