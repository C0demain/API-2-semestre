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
    private JLabel nomeArquivo = new JLabel("Escolha seu arquivo", SwingConstants.CENTER);
    
    public static String caminhoArquivo;
    private final JButton voltarButton = new JButton("Voltar");

    public SeletorArquivoGUI(){
    	JPanel MainPanel = new JPanel(new BorderLayout());
		MainPanel.add(nomeArquivo,BorderLayout.CENTER);
		
		voltarButton.addActionListener(this);
		MainPanel.add(voltarButton, BorderLayout.NORTH);
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
                if (r == JFileChooser.APPROVE_OPTION)
                {
                	caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                    nomeArquivo.setText(caminhoArquivo);
                }
                else
                    nomeArquivo.setText("Operação cancelada");
                
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