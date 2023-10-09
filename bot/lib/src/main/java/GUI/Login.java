package GUI;

import factory.ConnectionFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				JOptionPane.showMessageDialog(panel, "Usuário logado - ID: "+resultSet.getString("id"));
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
		setBounds(100, 100, 500, 353);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(87, 215, 102, 23);
		panel.add(btnNewButton);

		JButton login = new JButton("Login");
		login.setBounds(276, 215, 102, 23);
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
		usuario.setBounds(87, 85, 291, 20);
		panel.add(usuario);
		usuario.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(87, 151, 291, 20);
		panel.add(senha);
		senha.setColumns(10);

		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setBackground(SystemColor.control);
		txtpnUsuario.setText("Usuario : ");
		txtpnUsuario.setBounds(87, 50, 53, 20);
		panel.add(txtpnUsuario);

		JTextPane txtpnSenha = new JTextPane();
		txtpnSenha.setBackground(SystemColor.control);
		txtpnSenha.setEditable(false);
		txtpnSenha.setText("Senha :");
		txtpnSenha.setBounds(87, 120, 44, 20);
		panel.add(txtpnSenha);
	}
}
