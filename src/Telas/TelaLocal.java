package Telas;

import RegrasDeNegocio.RegraNegocioException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class TelaLocal extends javax.swing.JFrame {
    private  FacadeRegraNegocio facade;
    
    private String localfinal = "Local: ";
    private ArrayList<String> eventos;
    
    public TelaLocal() throws RegraNegocioException {
        this.facade = new FacadeTelasImp();
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlLocal = new javax.swing.JPanel();
        jLblNome = new javax.swing.JLabel();
        jBtnSalvarSair = new javax.swing.JButton();
        jBtnPersonagem = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jListLista = new javax.swing.JList<>();
        jBtnEvento = new javax.swing.JButton();
        jLblEventosssss = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jListLista.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        jListLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListLista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListListaValueChanged(evt);
            }
        });
        jScrollPane.setViewportView(jListLista);

        jBtnEvento.setFont(new java.awt.Font("Charlemagne Std", 0, 13)); // NOI18N
        jBtnEvento.setText("Executar");
        jBtnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEventoActionPerformed(evt);
            }
        });

        jLblEventosssss.setFont(new java.awt.Font("Charlemagne Std", 1, 18)); // NOI18N
        jLblEventosssss.setForeground(new java.awt.Color(255, 255, 88));
        jLblEventosssss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblEventosssss.setText("Eventos");
        jLblEventosssss.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPnlLocalLayout = new javax.swing.GroupLayout(jPnlLocal);
        jPnlLocal.setLayout(jPnlLocalLayout);
        jPnlLocalLayout.setHorizontalGroup(
            jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLocalLayout.createSequentialGroup()
                .addGroup(jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlLocalLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnlLocalLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblEventosssss, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPnlLocalLayout.createSequentialGroup()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addGroup(jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnEvento)
                                    .addComponent(jBtnPersonagem)
                                    .addComponent(jBtnSalvarSair))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlLocalLayout.setVerticalGroup(
            jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLocalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblEventosssss)
                .addGap(12, 12, 12)
                .addGroup(jPnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPnlLocalLayout.createSequentialGroup()
                        .addComponent(jBtnEvento)
                        .addGap(105, 105, 105)
                        .addComponent(jBtnPersonagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSalvarSair))
                    .addComponent(jScrollPane))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPersonagemActionPerformed
        try{
            String info = facade.getDescricaoJogador();
            JOptionPane.showMessageDialog(this,info);
        }catch(RegraNegocioException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
       
    }//GEN-LAST:event_jBtnPersonagemActionPerformed

    private void jBtnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEventoActionPerformed
        try{
            int indice = jListLista.getSelectedIndex();
            facade.executaEvento(indice);
            
            if(facade.hasBatalha()){
                
                Luta telaLuta = new Luta();
                telaLuta.setVisible(true);
                telaLuta.setLocationRelativeTo(this);
                
            } if(facade.hasResposta()){
                
                String info = facade.getResposta();
                JOptionPane.showMessageDialog(this, info);
            }
            
            jLblNome.setText(localfinal + facade.carregaNomeLocal());
            eventos = facade.getEventos();
            
        }catch(RegraNegocioException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_jBtnEventoActionPerformed

    private void jBtnSalvarSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarSairActionPerformed
        int botaoDialogo = JOptionPane.YES_NO_OPTION;
        if(JOptionPane.showConfirmDialog(this, "Tem certeza?", "Confirme", botaoDialogo) == 
                JOptionPane.YES_OPTION){
            try {
                facade.salvarJogador();
                TelaInicial tela = new TelaInicial();
                tela.setVisible(true);
                tela.setLocationRelativeTo(null);
                this.dispose();
            } catch (RegraNegocioException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
               
        }  
    }//GEN-LAST:event_jBtnSalvarSairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
           
            jLblNome.setText(localfinal + facade.carregaNomeLocal()) ;
            eventos = facade.getEventos();
            DefaultListModel modeloLista = new DefaultListModel();
            for(String evento : eventos){
                modeloLista.addElement(evento);
            }
            jListLista = new JList(modeloLista);
            jListLista.setSelectedIndex(0);
            jListLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jListLista.setVisibleRowCount(6);
            jScrollPane = new JScrollPane(jListLista);
            
            jBtnEvento.setEnabled(false);
        }catch(RegraNegocioException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jListListaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListListaValueChanged
       if(evt.getValueIsAdjusting()==false){
           if(jListLista.getSelectedIndex()==-1){
               jBtnEvento.setEnabled(false);
           }else{
               jBtnEvento.setEnabled(true);
           }
       }
    }//GEN-LAST:event_jListListaValueChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEvento;
    private javax.swing.JButton jBtnPersonagem;
    private javax.swing.JButton jBtnSalvarSair;
    private javax.swing.JLabel jLblEventosssss;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JList<String> jListLista;
    private javax.swing.JPanel jPnlLocal;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
