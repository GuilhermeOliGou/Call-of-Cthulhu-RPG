
package telas;

import elementos.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JogoPrincipal extends javax.swing.JFrame {
    static Personagem personagem = null;
    /**
     * Creates new form JogoPrincipal
     * @param personagem
     */
    public JogoPrincipal(Personagem personagem) {
        initComponents();
        JogoPrincipal.personagem = personagem;
    }

    private JogoPrincipal() {
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
        jLblLocal = new javax.swing.JLabel();
        jBtnLutaYog = new javax.swing.JButton();
        jBtnLutaNya = new javax.swing.JButton();
        jBtnLutaShog = new javax.swing.JButton();
        jBtnPersonagem = new javax.swing.JButton();
        jBtnMenu = new javax.swing.JButton();
        jBtnLutaMiniYog = new javax.swing.JButton();
        jLblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(637, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelJogo.setBackground(new java.awt.Color(34, 34, 167));
        jPanelJogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblLocal.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLblLocal.setForeground(new java.awt.Color(231, 235, 88));
        jLblLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/bola.jpg"))); // NOI18N

        jBtnLutaYog.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnLutaYog.setText("LUTE COM YOG-SOTHOTH");
        jBtnLutaYog.setAutoscrolls(true);
        jBtnLutaYog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLutaYogActionPerformed(evt);
            }
        });

        jBtnLutaNya.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnLutaNya.setText("LUTE COM Nyarlathotep");
        jBtnLutaNya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLutaNyaActionPerformed(evt);
            }
        });

        jBtnLutaShog.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnLutaShog.setText("Lute com Shoggoths");
        jBtnLutaShog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLutaShogActionPerformed(evt);
            }
        });

        jBtnPersonagem.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnPersonagem.setText("Personagem");
        jBtnPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPersonagemActionPerformed(evt);
            }
        });

        jBtnMenu.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnMenu.setText("Menu");
        jBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMenuActionPerformed(evt);
            }
        });

        jBtnLutaMiniYog.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnLutaMiniYog.setText("LUTE COM MINI YOG");
        jBtnLutaMiniYog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLutaMiniYogActionPerformed(evt);
            }
        });

        jLblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(231, 235, 88));
        jLblTitulo.setText("Tela do jogo");

        javax.swing.GroupLayout jPanelJogoLayout = new javax.swing.GroupLayout(jPanelJogo);
        jPanelJogo.setLayout(jPanelJogoLayout);
        jPanelJogoLayout.setHorizontalGroup(
            jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtnLutaYog)
                    .addComponent(jBtnLutaNya)
                    .addComponent(jBtnLutaShog)
                    .addComponent(jBtnLutaMiniYog))
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJogoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnMenu)
                        .addGap(132, 132, 132))
                    .addGroup(jPanelJogoLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelJogoLayout.createSequentialGroup()
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJogoLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jBtnPersonagem))
                    .addGroup(jPanelJogoLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLblTitulo)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanelJogoLayout.setVerticalGroup(
            jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLblTitulo)
                .addGap(38, 38, 38)
                .addGroup(jPanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelJogoLayout.createSequentialGroup()
                        .addComponent(jBtnLutaYog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnLutaNya)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnLutaShog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnLutaMiniYog))
                    .addComponent(jLblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
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

    private void jBtnLutaShogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLutaShogActionPerformed
        Luta telaLuta = new Luta(personagem,"Shog");
        this.dispose();
        telaLuta.setVisible(true);
        telaLuta.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnLutaShogActionPerformed

    private void jBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMenuActionPerformed
        MenuJogoPrincipal telaMenu = new MenuJogoPrincipal();
        this.setEnabled(false);
        telaMenu.setAlwaysOnTop(true);
        telaMenu.setVisible(true);
        telaMenu.setLocationRelativeTo(null);
        telaMenu.recebeTela(this);
    }//GEN-LAST:event_jBtnMenuActionPerformed

    private void jBtnPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPersonagemActionPerformed
        JOptionPane.showMessageDialog(rootPane,"Nome: " + personagem.getNome() + "\n" +
                "Nivel: " + personagem.getNivel() + "\n" + 
                "Dano: " + personagem.getDano() + "\n" +
                "Estado: " + personagem.getMedo().toString() + "\n" +
                "HP: " + personagem.getVidaAtual() + "\n" +
                "HP Maximo: " + personagem.getVidaMaxima());
    }//GEN-LAST:event_jBtnPersonagemActionPerformed

    private void jBtnLutaNyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLutaNyaActionPerformed
        Luta telaLuta = new Luta(personagem,"Nya");
        this.dispose();
        telaLuta.setVisible(true);
        telaLuta.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnLutaNyaActionPerformed

    private void jBtnLutaYogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLutaYogActionPerformed
        Luta telaLuta = new Luta(personagem,"Yog");
        this.dispose();
        telaLuta.setVisible(true);
        telaLuta.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnLutaYogActionPerformed

    private void jBtnLutaMiniYogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLutaMiniYogActionPerformed
        Luta telaLuta = new Luta(personagem,"MiniYog");
        this.dispose();
        telaLuta.setVisible(true);
        telaLuta.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnLutaMiniYogActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       jLblLocal.setIcon(new ImageIcon("bola.jpg"));
    }//GEN-LAST:event_formWindowOpened
    
    public Personagem getPersonagemAtual(){
        return personagem;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnLutaMiniYog;
    private javax.swing.JButton jBtnLutaNya;
    private javax.swing.JButton jBtnLutaShog;
    private javax.swing.JButton jBtnLutaYog;
    private javax.swing.JButton jBtnMenu;
    private javax.swing.JButton jBtnPersonagem;
    private javax.swing.JLabel jLblLocal;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelJogo;
    // End of variables declaration//GEN-END:variables
}
