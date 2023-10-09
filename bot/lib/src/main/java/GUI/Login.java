package GUI;

import dao.UsuarioDAO;
import factory.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Component {
    private JFrame frame;
    private JTextField user;
    private JPasswordField senha;
    private JLabel label;
    private JButton login;
    private JButton sair;
    private Connection connection = new ConnectionFactory().getConnection();;

    public Login(){
        initialize();
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strUsuario = user.getText();
                String strSenha = new String(senha.getPassword());
                execLogin(strUsuario, strSenha);
            }
        });
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaInicial.main(null);
                frame.dispose();
            }
        });
    }

    public void execLogin(String user, String senha) {
        String sql = "SELECT * FROM chatbot";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next());{
                if (user.equals(resultSet.getString("usuario")) && senha.equals(resultSet.getString("senha"))){
                    System.out.println("Login realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this,"Nome de usuário ou senha incorreto");
                }
            }

        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    private void initialize(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        login = new JButton("Login");
        login.setBounds(50,200,100,40);
        frame.getContentPane().add(login);

        sair = new JButton("Sair");
        sair.setBounds(250,200,100,40);
        frame.getContentPane().add(sair);
    }

    public static void main(String[] args) {
        new Login();
    }
}
