  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import dao.RegistroDAO;
import dao.UsuarioDAO;
import modelo.Usuario;
import modelo.Registro;

import GUI.TelaInicial;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;


public class Dashboard extends Tela {
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private static Dashboard dashboard;

    /**
     * Creates new form Dashboard
     */
    public Dashboard(TelaController controller) {
    	super(controller);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/parrot.png")));
    	setTitle("Registro");
    	setResizable(false);
    	getContentPane().setBackground(new Color(0, 0, 64));
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setEnabled(false);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        JButton voltarButton = new javax.swing.JButton("Voltar");
        voltarButton.setBackground(new Color(255, 255, 255));
        voltarButton.setFont(new Font("Arial", Font.BOLD, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        RegistroDAO registroDAO = new RegistroDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        // Adiciona as colunas da tabela
        modelo.addColumn("Data");
        modelo.addColumn("Usuario");
        modelo.addColumn("Descrição");
        
        // Adiciona os registros a tabela
        for (Registro reg : registroDAO.getAll()) {
			modelo.addRow(new Object[]{
				reg.getData(),
				usuarioDAO.getById(reg.getIdUsuario()).getUsuario(),
				reg.getDescricao()
			});
			
		}
        
        voltarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				mudaTela("Inicial"); // Vai para a tela inicial
				
			}
		});
        
        jTable1.setMinimumSize(new Dimension(jTable1.getWidth(), jTable1.getRowHeight()*modelo.getRowCount())); // Define tamanho para caber os registros
        
        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("ChatBot");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastro");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(31, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}