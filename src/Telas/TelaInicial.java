
package Telas;

import RegrasDeNegocio.RegraNegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelaInicial extends javax.swing.JFrame {
    
    public TelaInicial() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInicial = new javax.swing.JPanel();
        jBtnIniciaJogo = new javax.swing.JButton();
        jBtnCarregaJogo = new javax.swing.JButton();
        jBtnSairJogo = new javax.swing.JButton();
        jLblTituloJogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanelInicial.setBackground(new java.awt.Color(34, 34, 167));
        jPanelInicial.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jBtnIniciaJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnIniciaJogo.setText("Novo Jogo");
        jBtnIniciaJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIniciaJogoActionPerformed(evt);
            }
        });

        jBtnCarregaJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnCarregaJogo.setText("Carregar Jogo");
        jBtnCarregaJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCarregaJogoActionPerformed(evt);
            }
        });

        jBtnSairJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnSairJogo.setText("Sair do Jogo");
        jBtnSairJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairJogoActionPerformed(evt);
            }
        });

        jLblTituloJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLblTituloJogo.setForeground(new java.awt.Color(231, 235, 88));
        jLblTituloJogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTituloJogo.setText("Call of Ctulhu: O Jogo");

        javax.swing.GroupLayout jPanelInicialLayout = new javax.swing.GroupLayout(jPanelInicial);
        jPanelInicial.setLayout(jPanelInicialLayout);
        jPanelInicialLayout.setHorizontalGroup(
            jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicialLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLblTituloJogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelInicialLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jBtnIniciaJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(jBtnCarregaJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jBtnSairJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanelInicialLayout.setVerticalGroup(
            jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicialLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLblTituloJogo)
                .addGap(85, 85, 85)
                .addGroup(jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIniciaJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCarregaJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSairJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(169, 169, 169))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairJogoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBtnSairJogoActionPerformed

    private void jBtnCarregaJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregaJogoActionPerformed
            this.dispose();
        Carregamento telaCarrega = null;
        try {
            telaCarrega = new Carregamento();
        } catch (RegraNegocioException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaCarrega.setVisible(true);
        telaCarrega.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnCarregaJogoActionPerformed

    private void jBtnIniciaJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIniciaJogoActionPerformed
        NovoJogo telaNovo = null;
        try {
            telaNovo = new NovoJogo();
        } catch (RegraNegocioException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        telaNovo.setVisible(true);
        telaNovo.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnIniciaJogoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCarregaJogo;
    private javax.swing.JButton jBtnIniciaJogo;
    private javax.swing.JButton jBtnSairJogo;
    private javax.swing.JLabel jLblTituloJogo;
    private javax.swing.JPanel jPanelInicial;
    // End of variables declaration//GEN-END:variables
}
