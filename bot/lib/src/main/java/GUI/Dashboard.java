  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

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


public class Dashboard extends javax.swing.JFrame {
	
	private DefaultTableModel modelo = new DefaultTableModel();
	public static int usuarioLogadoId;
	private static Dashboard dashboard;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
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
				// Trocar janela
				TelaInicial tela = new TelaInicial();
				tela.usuarioLogadoId = usuarioLogadoId;
				tela.main(null);
				
				dashboard.dispose();
				
			}
		});
        
        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("ChatBot");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastro");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(voltarButton)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(voltarButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dashboard = new Dashboard();
                dashboard.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}