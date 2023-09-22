package GUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;

public class SeletorArquivoGUI extends JFrame{
    private JPanel MainPanel;
    private JButton button1 = new JButton("Carregar");
    private JLabel nomeArquivo = new JLabel("Escolha seu arquivo", SwingConstants.CENTER);

    public SeletorArquivoGUI(){
    	JPanel MainPanel = new JPanel(new BorderLayout());
		MainPanel.add(nomeArquivo,BorderLayout.CENTER);
		MainPanel.add(button1,BorderLayout.SOUTH);
        
        setContentPane(MainPanel);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeArquivo.setText("Escolhendo arquivo");
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = fileChooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION)
                {
                    nomeArquivo.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
                else
                    nomeArquivo.setText("Operação cancelada");
                
            }
        });
    }

    public static void main(String[] args) {
        new SeletorArquivoGUI();

    }
}