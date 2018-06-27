/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

/**
 *
 * @author Leonardo
 */
public class JogoPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JogoPrincipal
     */
    public JogoPrincipal() {
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

        jPanelJogo = new javax.swing.JPanel();
        jLblExemploLocal = new javax.swing.JLabel();
        jBtnEvento1 = new javax.swing.JButton();
        jBtnEvento2 = new javax.swing.JButton();
        jBtnEvento3 = new javax.swing.JButton();
        jBtnPersonagem = new javax.swing.JButton();
        jBtnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(637, 500));

        jPanelJogo.setBackground(new java.awt.Color(34, 34, 167));
        jPanelJogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblExemploLocal.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLblExemploLocal.setForeground(new java.awt.Color(231, 235, 88));
        jLblExemploLocal.setText("IMAGEM DO LOCAL");

        jBtnEvento1.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnEvento1.setText("Evento 1");

        jBtnEvento2.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnEvento2.setText("Evento 2");

        jBtnEvento3.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnEvento3.setText("Evento 3");
        jBtnEvento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEvento3ActionPerformed(evt);
            }
        });

        jBtnPersonagem.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnPersonagem.setText("Personagem");

        jBtnMenu.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnMenu.setText("Menu");
        jBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelJogoLayout = new javax.swing.GroupLayout(jPanelJogo);
        jPanelJogo.setLayout(jPanelJogoLayout);
        jPanelJogoLayout.setHorizontalGroup(
            jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJogoLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jBtnPersonagem)
                .addGap(91, 91, 91)
                .addComponent(jBtnMenu)
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJogoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEvento1)
                    .addComponent(jBtnEvento3)
                    .addComponent(jBtnEvento2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblExemploLocal)
                .addGap(87, 87, 87))
        );
        jPanelJogoLayout.setVerticalGroup(
            jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogoLayout.createSequentialGroup()
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJogoLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblExemploLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEvento2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJogoLayout.createSequentialGroup()
                        .addContainerGap(115, Short.MAX_VALUE)
                        .addComponent(jBtnEvento1)
                        .addGap(92, 92, 92)
                        .addComponent(jBtnEvento3)
                        .addGap(104, 104, 104)))
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPersonagem)
                    .addComponent(jBtnMenu))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelJogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelJogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEvento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEvento3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEvento3ActionPerformed

    private void jBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMenuActionPerformed
        MenuJogoPrincipal telaMenu = new MenuJogoPrincipal();
        telaMenu.setVisible(true);
        telaMenu.setLocationRelativeTo(null);
        telaMenu.recebeTela(this);
    }//GEN-LAST:event_jBtnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(JogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEvento1;
    private javax.swing.JButton jBtnEvento2;
    private javax.swing.JButton jBtnEvento3;
    private javax.swing.JButton jBtnMenu;
    private javax.swing.JButton jBtnPersonagem;
    private javax.swing.JLabel jLblExemploLocal;
    private javax.swing.JPanel jPanelJogo;
    // End of variables declaration//GEN-END:variables
}