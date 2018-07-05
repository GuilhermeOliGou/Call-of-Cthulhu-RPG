/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import DTO.Personagens.Jogador;
import RegrasDeNegocio.RegraNegocioException;
import elementos.Personagem;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Leonardo
 */
public class NovoJogo extends javax.swing.JFrame {
    private final String nomes[] = {"Joana","Cleber","Josefino","Rosimara","Miranha",
    "Leona","Amanda","Marco","Vanderlei","Joedson","Jamal","Tijolinho","fREIre"};
    private int i = 0;
    private int erros=0;
    Random r = new Random();
    public NovoJogo() {
        initComponents();
    }

    private FacadeRegraNegocio facade = new FacadeTelasImp();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPblCriacao = new javax.swing.JPanel();
        jLblNome = new javax.swing.JLabel();
        jTxtFldNome = new javax.swing.JTextField();
        jBtnPronto = new javax.swing.JButton();
        jBtnVoltar = new javax.swing.JButton();
        jBtnNomeRandom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPblCriacao.setBackground(new java.awt.Color(34, 34, 167));
        jPblCriacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblNome.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLblNome.setForeground(new java.awt.Color(231, 235, 88));
        jLblNome.setText("Nome:");

        jTxtFldNome.setBackground(new java.awt.Color(34, 24, 64));
        jTxtFldNome.setFont(new java.awt.Font("Charlemagne Std", 0, 11)); // NOI18N
        jTxtFldNome.setForeground(new java.awt.Color(255, 255, 255));

        jBtnPronto.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        jBtnPronto.setText("Pronto");
        jBtnPronto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProntoActionPerformed(evt);
            }
        });

        jBtnVoltar.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        jBtnVoltar.setText("Voltar");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });

        jBtnNomeRandom.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        jBtnNomeRandom.setText("Nome aleatório");
        jBtnNomeRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNomeRandomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPblCriacaoLayout = new javax.swing.GroupLayout(jPblCriacao);
        jPblCriacao.setLayout(jPblCriacaoLayout);
        jPblCriacaoLayout.setHorizontalGroup(
            jPblCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPblCriacaoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPblCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPblCriacaoLayout.createSequentialGroup()
                        .addComponent(jLblNome)
                        .addGap(26, 26, 26)
                        .addComponent(jTxtFldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPblCriacaoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jBtnPronto)
                        .addGap(58, 58, 58)
                        .addComponent(jBtnVoltar)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPblCriacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnNomeRandom)
                .addGap(87, 87, 87))
        );
        jPblCriacaoLayout.setVerticalGroup(
            jPblCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPblCriacaoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPblCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNome)
                    .addComponent(jTxtFldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnNomeRandom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jPblCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPronto)
                    .addComponent(jBtnVoltar))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPblCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPblCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNomeRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNomeRandomActionPerformed
       jTxtFldNome.setText(nomes[i]);
       i++;
       if(i==nomes.length) i = 0;
    }//GEN-LAST:event_jBtnNomeRandomActionPerformed

    private void jBtnProntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnProntoActionPerformed
        String nome;
        nome = jTxtFldNome.getText();
        if(nome.equals("")){
            if(erros==0) JOptionPane.showMessageDialog(this, "O personagem deve possuir um nome, por favor\n");
            else if(erros == 1) JOptionPane.showMessageDialog(this, "Um nome, por favor...\n");
            else if(erros == 2) JOptionPane.showMessageDialog(this, "Ok.\n");
            else jTxtFldNome.setText(nomes[r.nextInt(nomes.length)]);
            erros++;
        }else{
            try {
                facade.criaJogador(nome);
            } catch (RegraNegocioException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        Local local = new Local();
        local.setVisible(true);
        local.setLocationRelativeTo(null);
        this.dispose();
        }
    }//GEN-LAST:event_jBtnProntoActionPerformed

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
      TelaInicial telaInicial = new TelaInicial();
       this.dispose();
       telaInicial.setVisible(true);
       telaInicial.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnVoltarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnNomeRandom;
    private javax.swing.JButton jBtnPronto;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JPanel jPblCriacao;
    private javax.swing.JTextField jTxtFldNome;
    // End of variables declaration//GEN-END:variables
}
