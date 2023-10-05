package GUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;

public class SeletorArquivoGUI extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private JPanel MainPanel;
    private JButton button1 = new JButton("Carregar");
    private JButton button2 = new JButton("Chat");
    private JLabel nomeArquivo = new JLabel("Escolha seu arquivo", SwingConstants.CENTER);
    
    public static String caminhoArquivo;

    public SeletorArquivoGUI(){

        button2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        TelaBot telaBot = new TelaBot();
    	        TelaBot.caminhoArquivo = caminhoArquivo;
    	        telaBot.setVisible(true);
    	        dispose(); // Fecha a janela atual (SeletorArquivoGUI)
    	    }
    	});

    	JPanel MainPanel = new JPanel(new BorderLayout());
		MainPanel.add(nomeArquivo,BorderLayout.CENTER);
		MainPanel.add(button1,BorderLayout.SOUTH);
        
        setContentPane(MainPanel);
        setSize(300,262);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeArquivo.setText("Escolhendo arquivo");
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = fileChooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                    nomeArquivo.setText(caminhoArquivo);
                    MainPanel.remove(button1); // Remover o botão "Carregar"
                    MainPanel.add(button2, BorderLayout.SOUTH); // Adicionar o botão "Chat"
                    LimpaArquivo.limparArquivo(caminhoArquivo); // Limpa arquivo carregado pelo usuário
                    
                } else {
                    nomeArquivo.setText("Operação cancelada");
                }
            }
        });
    }



	public static void main(String[] args) {
        new SeletorArquivoGUI();

    }



	@Override
	public void actionPerformed(ActionEvent e) {
		TelaInicial.main(null);
		TelaInicial.caminhoArquivo = caminhoArquivo;
		this.dispose();
		
	}
}