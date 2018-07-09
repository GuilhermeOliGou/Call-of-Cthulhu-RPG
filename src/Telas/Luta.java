package Telas;

import RegrasDeNegocio.RegraNegocioException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import Utilidades.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Luta extends javax.swing.JFrame {

    private ArrayList<String> acoes = new ArrayList<>();

    public Luta() {
        try {
            this.facade = new FacadeTelasImp();
        } catch (RegraNegocioException ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        initComponents();
    }

    private FacadeRegraNegocio facade;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlLuta = new javax.swing.JPanel();
        jLblInimigo = new javax.swing.JLabel();
        jLblPersonagem = new javax.swing.JLabel();
        jLblHP = new javax.swing.JLabel();
        jHPQuantidade = new javax.swing.JLabel();
        jLblMPPersonagem = new javax.swing.JLabel();
        jLblMP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListListaAcoes = new javax.swing.JList<>();
        jBtnRealiza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(136, 18, 82));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPnlLuta.setBackground(new java.awt.Color(150, 15, 121));
        jPnlLuta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblInimigo.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        jLblInimigo.setForeground(new java.awt.Color(27, 163, 73));
        jLblInimigo.setText("jLabel1");

        jLblPersonagem.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        jLblPersonagem.setForeground(new java.awt.Color(43, 173, 194));
        jLblPersonagem.setText("jLabel1");

        jLblHP.setFont(new java.awt.Font("Charlemagne Std", 1, 11)); // NOI18N
        jLblHP.setForeground(new java.awt.Color(43, 173, 194));
        jLblHP.setText("HP:");

        jHPQuantidade.setFont(new java.awt.Font("Charlemagne Std", 0, 11)); // NOI18N
        jHPQuantidade.setForeground(new java.awt.Color(42, 167, 142));
        jHPQuantidade.setText("jLabel1");

        jLblMPPersonagem.setBackground(new java.awt.Color(255, 255, 255));
        jLblMPPersonagem.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        jLblMPPersonagem.setForeground(new java.awt.Color(42, 167, 142));
        jLblMPPersonagem.setText("jLabel1");

        jLblMP.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        jLblMP.setForeground(new java.awt.Color(43, 173, 194));
        jLblMP.setText("MP:");

        jListListaAcoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListListaAcoes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListListaAcoesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListListaAcoes);

        jBtnRealiza.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnRealiza.setText("Realizar ACAO");
        jBtnRealiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRealizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlLutaLayout = new javax.swing.GroupLayout(jPnlLuta);
        jPnlLuta.setLayout(jPnlLutaLayout);
        jPnlLutaLayout.setHorizontalGroup(
            jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLutaLayout.createSequentialGroup()
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlLutaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLblHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jHPQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(jLblMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblMPPersonagem))
                    .addGroup(jPnlLutaLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlLutaLayout.createSequentialGroup()
                                .addComponent(jLblInimigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPnlLutaLayout.createSequentialGroup()
                                .addComponent(jLblPersonagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnRealiza)
                                .addGap(20, 20, 20)))))
                .addGap(26, 26, 26))
        );
        jPnlLutaLayout.setVerticalGroup(
            jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLutaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblInimigo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPersonagem)
                    .addComponent(jBtnRealiza))
                .addGap(18, 18, 18)
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblHP)
                    .addComponent(jHPQuantidade)
                    .addComponent(jLblMPPersonagem)
                    .addComponent(jLblMP))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlLuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlLuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            acoes = facade.getAcoesBatalha();
            DefaultListModel modeloLista = new DefaultListModel();
            for (String acao : acoes) {
                modeloLista.addElement(acao);
            }
            jListListaAcoes = new JList(modeloLista);
            jListListaAcoes.setSelectedIndex(0);
            jListListaAcoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jListListaAcoes.setVisibleRowCount(7);
            jScrollPane1 = new JScrollPane(jListListaAcoes);

            jLblInimigo.setText(facade.getNomeInimigo());
            jLblPersonagem.setText(facade.getNomePersonagem());
            jHPQuantidade.setText(facade.getHPPersonagem());
            jLblMPPersonagem.setText(facade.getMPPersonagem());
        } catch (RegraNegocioException ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jBtnRealizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRealizaActionPerformed
        try {
            int indice = jListListaAcoes.getSelectedIndex();
            facade.realizaAcaoBatalha(indice);
            verificaBatalha();
        } catch (RegraNegocioException ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jBtnRealizaActionPerformed

    private void jListListaAcoesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListListaAcoesValueChanged
        if (evt.getValueIsAdjusting() == false) {
            if (jListListaAcoes.getSelectedIndex() == -1) {
                jBtnRealiza.setEnabled(false);
            } else {
                jBtnRealiza.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jListListaAcoesValueChanged

    private void verificaBatalha() {
        String hpPersonagem = "";
        try {
            hpPersonagem = facade.getHPPersonagem();
        } catch (RegraNegocioException ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        if (Integer.parseInt(hpPersonagem) <= 0) {
            jHPQuantidade.setText("0");
            JOptionPane.showMessageDialog(this, "Voce perdeu a luta e foi levado"
                    + " pela criatura. Agora voce eh um deles. Bom proveito.");
            TelaInicial telaInicial = new TelaInicial();
            this.dispose();
            telaInicial.setVisible(true);
            telaInicial.setLocationRelativeTo(null);
        } else {
            jHPQuantidade.setText(hpPersonagem);
        }
        String hpCriatura = "";
        try {
            hpCriatura = facade.getHPInimigo();
        } catch (RegraNegocioException ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Log.gravaLog(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        if (Integer.parseInt(hpCriatura) <= 0) {
            JOptionPane.showMessageDialog(this, "Voce sobreviveu a luta.\n");
            TelaLocal local = new TelaLocal();
            this.dispose();
            local.setVisible(true);
            local.setLocationRelativeTo(null);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRealiza;
    private javax.swing.JLabel jHPQuantidade;
    private javax.swing.JLabel jLblHP;
    private javax.swing.JLabel jLblInimigo;
    private javax.swing.JLabel jLblMP;
    private javax.swing.JLabel jLblMPPersonagem;
    private javax.swing.JLabel jLblPersonagem;
    private javax.swing.JList<String> jListListaAcoes;
    private javax.swing.JPanel jPnlLuta;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
