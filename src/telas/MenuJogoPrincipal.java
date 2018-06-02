/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author Leonardo
 */
public class MenuJogoPrincipal extends javax.swing.JFrame {
    private JogoPrincipal telaJogoPrincipal;
    /**
     * Creates new form MenuJogoPrincipal
     */
    public MenuJogoPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlMenuJogoPrincipal = new javax.swing.JPanel();
        jBtnSalvarSair = new javax.swing.JButton();
        jBtnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 280));
        setResizable(false);
        setSize(new java.awt.Dimension(100, 500));

        jPnlMenuJogoPrincipal.setBackground(new java.awt.Color(34, 34, 167));
        jPnlMenuJogoPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, new java.awt.Color(0, 0, 0)));
        jPnlMenuJogoPrincipal.setForeground(new java.awt.Color(240, 240, 240));

        jBtnSalvarSair.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnSalvarSair.setText("Salvar e Sair");
        jBtnSalvarSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarSairActionPerformed(evt);
            }
        });

        jBtnVoltar.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnVoltar.setText("Voltar");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlMenuJogoPrincipalLayout = new javax.swing.GroupLayout(jPnlMenuJogoPrincipal);
        jPnlMenuJogoPrincipal.setLayout(jPnlMenuJogoPrincipalLayout);
        jPnlMenuJogoPrincipalLayout.setHorizontalGroup(
            jPnlMenuJogoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlMenuJogoPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnVoltar)
                .addGap(159, 159, 159))
            .addGroup(jPnlMenuJogoPrincipalLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jBtnSalvarSair)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPnlMenuJogoPrincipalLayout.setVerticalGroup(
            jPnlMenuJogoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMenuJogoPrincipalLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jBtnSalvarSair)
                .addGap(46, 46, 46)
                .addComponent(jBtnVoltar)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMenuJogoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMenuJogoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
       this.dispose();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void jBtnSalvarSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarSairActionPerformed
        this.dispose();
        telaJogoPrincipal.dispose();
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        telaInicial.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnSalvarSairActionPerformed
    
    public void recebeTela(JogoPrincipal tela){
        this.telaJogoPrincipal = tela;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJogoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalvarSair;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JPanel jPnlMenuJogoPrincipal;
    // End of variables declaration//GEN-END:variables
}
