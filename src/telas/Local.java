/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;


public class Local extends javax.swing.JFrame {

    
    public Local() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlLocal = new javax.swing.JPanel();
        jLblNome = new javax.swing.JLabel();
        jBtnSalvarSair = new javax.swing.JButton();
        jBtnPersonagem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jBtnEvento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPnlLocal.setBackground(new java.awt.Color(34, 34, 167));
        jPnlLocal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPnlLocal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLblNome.setFont(new java.awt.Font("Charlemagne Std", 1, 18)); // NOI18N
        jLblNome.setForeground(new java.awt.Color(255, 255, 88));
        jLblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNome.setText("Nome");
        jLblNome.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jBtnSalvarSair.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnSalvarSair.setText("Salvar e Sair");
        jBtnSalvarSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarSairActionPerformed(evt);
            }
        });

        jBtnPersonagem.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnPersonagem.setText("Personagem");
        jBtnPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPersonagemActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jBtnEvento.setFont(new java.awt.Font("Charlemagne Std", 0, 13)); // NOI18N
        jBtnEvento.setText("Evento");
        jBtnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlLocalLayout = new javax.swing.GroupLayout(jPnlLocal);
        jPnlLocal.setLayout(jPnlLocalLayout);
        jPnlLocalLayout.setHorizontalGroup(
            jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLocalLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPnlLocalLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnPersonagem)))
            .addGroup(jPnlLocalLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jBtnSalvarSair))
        );
        jPnlLocalLayout.setVerticalGroup(
            jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLocalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblNome)
                .addGap(68, 68, 68)
                .addGroup(jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPnlLocalLayout.createSequentialGroup()
                        .addComponent(jBtnEvento)
                        .addGap(131, 131, 131)
                        .addComponent(jBtnPersonagem)))
                .addGap(11, 11, 11)
                .addComponent(jBtnSalvarSair))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPersonagemActionPerformed
        //String info = getDescricaoJogador();
        //JOptionPane.showMessageDialog(null,info,"Informacao");
    }//GEN-LAST:event_jBtnPersonagemActionPerformed

    private void jBtnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEventoActionPerformed
        //recebe um evento apropriado, entre eles troca de local, resposta ou 
        //batalha, podendo haver simultaneidade
        //executaEvento(indice); //indice selecionado pela JList
        JOptionPane.showMessageDialog(null,jList1.getSelectedValue());
    }//GEN-LAST:event_jBtnEventoActionPerformed

    private void jBtnSalvarSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarSairActionPerformed
        //salvarJogador(jogador);
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jBtnSalvarSairActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEvento;
    private javax.swing.JButton jBtnPersonagem;
    private javax.swing.JButton jBtnSalvarSair;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPnlLocal;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
