
package telas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import elementos.Personagem;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Carregamento extends javax.swing.JFrame {

    public Carregamento() {
        initComponents();
        mostraJogos();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlCarregamento = new javax.swing.JPanel();
        jLblEscolhaJogo = new javax.swing.JLabel();
        jBtnVoltaMenu = new javax.swing.JButton();
        jCBoxJogos = new javax.swing.JComboBox<>();
        jTxtDescricaoJogo = new javax.swing.JTextArea();
        jBtnIniciaJogo = new javax.swing.JButton();
        jBtnResetaJogos = new javax.swing.JButton();

        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPnlCarregamento.setBackground(new java.awt.Color(34, 34, 167));
        jPnlCarregamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblEscolhaJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLblEscolhaJogo.setForeground(new java.awt.Color(231, 235, 88));
        jLblEscolhaJogo.setText("Escolha o Jogo");

        jBtnVoltaMenu.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnVoltaMenu.setText("Voltar ao Menu");
        jBtnVoltaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltaMenuActionPerformed(evt);
            }
        });

        jCBoxJogos.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jCBoxJogos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jogo 1", "Jogo 2", "Jogo 3", "Jogo 4" }));

        jTxtDescricaoJogo.setEditable(false);
        jTxtDescricaoJogo.setBackground(new java.awt.Color(5, 5, 99));
        jTxtDescricaoJogo.setColumns(20);
        jTxtDescricaoJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jTxtDescricaoJogo.setForeground(new java.awt.Color(252, 247, 103));
        jTxtDescricaoJogo.setRows(5);

        jBtnIniciaJogo.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnIniciaJogo.setText("Iniciar Jogo");
        jBtnIniciaJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIniciaJogoActionPerformed(evt);
            }
        });

        jBtnResetaJogos.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jBtnResetaJogos.setForeground(new java.awt.Color(204, 0, 0));
        jBtnResetaJogos.setText("Popular Jogos");
        jBtnResetaJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnResetaJogosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlCarregamentoLayout = new javax.swing.GroupLayout(jPnlCarregamento);
        jPnlCarregamento.setLayout(jPnlCarregamentoLayout);
        jPnlCarregamentoLayout.setHorizontalGroup(
            jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                .addGroup(jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLblEscolhaJogo))
                            .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCBoxJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtDescricaoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jBtnIniciaJogo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnVoltaMenu)))
                    .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jBtnResetaJogos)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPnlCarregamentoLayout.setVerticalGroup(
            jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCarregamentoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLblEscolhaJogo)
                .addGroup(jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jCBoxJogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnlCarregamentoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jTxtDescricaoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPnlCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltaMenu)
                    .addComponent(jBtnIniciaJogo))
                .addGap(18, 18, 18)
                .addComponent(jBtnResetaJogos)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlCarregamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlCarregamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltaMenuActionPerformed
       this.dispose();
       TelaInicial telaInicio = new TelaInicial();
       telaInicio.setLocationRelativeTo(null);
       telaInicio.setVisible(true);    
    }//GEN-LAST:event_jBtnVoltaMenuActionPerformed

    private void jBtnIniciaJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIniciaJogoActionPerformed
       /*
        String jogador = carregaJogador(indice);//indice e selecionado pelo combobox 
        Local tela = carregaLocal();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        this.dispose();*/
    }//GEN-LAST:event_jBtnIniciaJogoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       /*Ao abrir, verifica se existem jogos salvos
        boolean existem = existeJogos();
        if(!existem){
            JOptionPane.showMessageDialog(this,"Nao existem jogos salvos.\n"
                    + "Voltando ao menu inicial.");
            TelaInicial tela = new TelaInicial();
            this.dispose();
            tela.setVisible(true);
            tela.setLocationRelativeTo(null);
        }else{
        ArrayList<String> jogos = getDescricoesJogadores();
        DefaultComboBoxModel mod = new DefaultComboBoxModel(jogos);
        jCBoxJogos.setModel(mod);
        }
        */
    }//GEN-LAST:event_formWindowOpened

    private void jBtnResetaJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnResetaJogosActionPerformed
        //resetaEPopula();
    }//GEN-LAST:event_jBtnResetaJogosActionPerformed
    
    private void mostraJogos(){
        String textoDefault = "Texto: ";
        String textoM = jCBoxJogos.getSelectedItem().toString();
        jTxtDescricaoJogo.setText(textoDefault + textoM);
        jCBoxJogos.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String texto = jCBoxJogos.getSelectedItem().toString();
                    String str = "Texto: ";
                    str = str + texto;
                    jTxtDescricaoJogo.setText(str);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIniciaJogo;
    private javax.swing.JButton jBtnResetaJogos;
    private javax.swing.JButton jBtnVoltaMenu;
    private javax.swing.JComboBox<String> jCBoxJogos;
    private javax.swing.JLabel jLblEscolhaJogo;
    private javax.swing.JPanel jPnlCarregamento;
    private javax.swing.JTextArea jTxtDescricaoJogo;
    // End of variables declaration//GEN-END:variables

    private Local carregaLocal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
