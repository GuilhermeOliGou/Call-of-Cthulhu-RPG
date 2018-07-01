/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import elementos.Personagem;
import javax.swing.JOptionPane;

public class MenuJogoPrincipal extends javax.swing.JFrame {
    private JogoPrincipal telaJogoPrincipal;

    public MenuJogoPrincipal() {
        initComponents();
    }

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
       telaJogoPrincipal.setEnabled(true);
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void jBtnSalvarSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarSairActionPerformed
        //salvarJogador(jogador);
        this.dispose();
        telaJogoPrincipal.dispose();
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        telaInicial.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnSalvarSairActionPerformed
    
    public void recebeTela(JogoPrincipal tela){
        this.telaJogoPrincipal = tela;
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalvarSair;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JPanel jPnlMenuJogoPrincipal;
    // End of variables declaration//GEN-END:variables
}
