package GUI;

import javax.swing.*;
import javax.swing.filechooser.*;

import dao.RegistroDAO;
import modelo.Registro;
import utilitarios.LimpaArquivo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.Font;


public class SeletorArquivoGUI extends Tela implements ActionListener {
    private JPanel MainPanel;
    private JButton button1 = new JButton("Carregar");
    private JButton button2 = new JButton("Chat");
    private JLabel nomeArquivo = new JLabel("Escolha seu arquivo", SwingConstants.CENTER);

    public static String caminhoArquivo;

    public SeletorArquivoGUI(TelaController controller) {
    	super(controller);
    	
    	button2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        mudaTela("Bot"); // Muda para tela bot
    	    }
    	});

        MainPanel = new JPanel(new BorderLayout());
        nomeArquivo.setFont(new Font("Arial", Font.BOLD, 14));
        MainPanel.add(nomeArquivo, BorderLayout.CENTER);
        button1.setFont(new Font("Arial", Font.PLAIN, 11));
        MainPanel.add(button1, BorderLayout.SOUTH);

        setContentPane(MainPanel);
        setSize(376, 594);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeArquivo.setText("Escolhendo arquivo");
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = fileChooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                    setDado("caminhoArquivo", caminhoArquivo);
                    nomeArquivo.setText(caminhoArquivo);
                    MainPanel.remove(button1); // Remover o botão "Carregar"
                    MainPanel.add(button2, BorderLayout.SOUTH); // Adicionar o botão "Chat"
                    LimpaArquivo.limparArquivo(caminhoArquivo); // Limpa arquivo carregado pelo usuário
                    
                    // Registro
                    long millis = System.currentTimeMillis();
					Date date = new Date(millis);

					String descricao = "Arquivo " + caminhoArquivo.substring(caminhoArquivo.lastIndexOf('\\') + 1) + " selecionado";
					Registro registro = new Registro(Integer.parseInt(getDado("usuarioLogadoId")), descricao, date);
					
					RegistroDAO regDAO = new RegistroDAO();
					regDAO.adiciona(registro);
                    
                } else {
                    nomeArquivo.setText("Operação cancelada");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mudaTela("Inicial"); // Muda para tela inicial
    }
}
