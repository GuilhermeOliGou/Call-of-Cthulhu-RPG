package telas;

import elementos.Criatura;
import elementos.CriaturaFactory;
import elementos.Medo;
import elementos.Personagem;
import javax.swing.JOptionPane;

public class Luta extends javax.swing.JFrame {

    private Criatura criatura = null;
    private Personagem personagem = null;
    
    public Luta(Personagem personagem,String nome){
        initComponents();
        this.personagem = personagem;
        CriaturaFactory factory = new CriaturaFactory();
        criatura = factory.criaCriatura(nome);
        personagem.setMedo(criatura);
        jLblInimigo.setText(criatura.getNome());
        jLblPersonagem.setText(personagem.getNome());
        jHPQuantidade.setText(personagem.getVidaToString());
    }

    public Luta() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlLuta = new javax.swing.JPanel();
        jLblInimigo = new javax.swing.JLabel();
        jLblPersonagem = new javax.swing.JLabel();
        jBtnAtacar = new javax.swing.JButton();
        jBtnFoge = new javax.swing.JButton();
        jHPPersonagem = new javax.swing.JLabel();
        jHPQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(136, 18, 82));
        setUndecorated(true);

        jPnlLuta.setBackground(new java.awt.Color(150, 15, 121));
        jPnlLuta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblInimigo.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        jLblInimigo.setForeground(new java.awt.Color(27, 163, 73));
        jLblInimigo.setText("jLabel1");

        jLblPersonagem.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        jLblPersonagem.setForeground(new java.awt.Color(43, 173, 194));
        jLblPersonagem.setText("jLabel1");

        jBtnAtacar.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnAtacar.setText("Atacar");
        jBtnAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtacarActionPerformed(evt);
            }
        });

        jBtnFoge.setFont(new java.awt.Font("Charlemagne Std", 1, 12)); // NOI18N
        jBtnFoge.setText("Fugir");

        jHPPersonagem.setFont(new java.awt.Font("Charlemagne Std", 1, 11)); // NOI18N
        jHPPersonagem.setForeground(new java.awt.Color(43, 173, 194));
        jHPPersonagem.setText("HP:");

        jHPQuantidade.setFont(new java.awt.Font("Charlemagne Std", 0, 11)); // NOI18N
        jHPQuantidade.setForeground(new java.awt.Color(42, 167, 142));
        jHPQuantidade.setText("jLabel1");

        javax.swing.GroupLayout jPnlLutaLayout = new javax.swing.GroupLayout(jPnlLuta);
        jPnlLuta.setLayout(jPnlLutaLayout);
        jPnlLutaLayout.setHorizontalGroup(
            jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLutaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLblPersonagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jBtnAtacar)
                .addGap(18, 18, 18)
                .addComponent(jBtnFoge)
                .addGap(57, 57, 57))
            .addGroup(jPnlLutaLayout.createSequentialGroup()
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlLutaLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLblInimigo))
                    .addGroup(jPnlLutaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jHPPersonagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jHPQuantidade)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlLutaLayout.setVerticalGroup(
            jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLutaLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLblInimigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPersonagem)
                    .addComponent(jBtnAtacar)
                    .addComponent(jBtnFoge))
                .addGap(18, 18, 18)
                .addGroup(jPnlLutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHPPersonagem)
                    .addComponent(jHPQuantidade))
                .addGap(28, 28, 28))
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

    private void jBtnAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtacarActionPerformed
        if(personagem.getMedo()==Medo.APAVORADO){
            JOptionPane.showMessageDialog(this, personagem.getNome() + " esta " +
                    Medo.APAVORADO.toString().toLowerCase() + ".\nNao pode atacar.");
        }
        else{
            int danoCausado = personagem.ataque();
            if(personagem.calculaSorte()>7){
                danoCausado *= 2;
                criatura.recebeDano(danoCausado);
            }
            criatura.recebeDano(danoCausado);
            JOptionPane.showMessageDialog(this,personagem.getNome() + " causou " + danoCausado + 
                    " em " + criatura.getNome());
        }
        criatura.ataca(personagem);
        verificaBatalha(personagem,criatura);        
    }//GEN-LAST:event_jBtnAtacarActionPerformed
    
    private void verificaBatalha(Personagem personagem,Criatura criatura){
        if(personagem.getVidaAtual()<=0){
            jHPQuantidade.setText("0");
            JOptionPane.showMessageDialog(this, "Voce perdeu a luta e foi levado"
                    + " pela criatura. Agora voce eh um deles. Bom proveito.");
            TelaInicial telaInicial = new TelaInicial();
            this.dispose();
            telaInicial.setVisible(true);
            telaInicial.setLocationRelativeTo(null);
        }else{
            jHPQuantidade.setText(personagem.getVidaToString());
        }
        if(criatura.getVidaAtual()<=0){
                personagem.incrementaInimigosDerrotados();
                JOptionPane.showMessageDialog(this, "Voce sobreviveu a luta.\n");
                personagem.setMedo(Medo.NORMAL);
                JogoPrincipal telaPrincipal = new JogoPrincipal(personagem);
                this.dispose();
                telaPrincipal.setVisible(true);
                telaPrincipal.setLocationRelativeTo(null);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtacar;
    private javax.swing.JButton jBtnFoge;
    private javax.swing.JLabel jHPPersonagem;
    private javax.swing.JLabel jHPQuantidade;
    private javax.swing.JLabel jLblInimigo;
    private javax.swing.JLabel jLblPersonagem;
    private javax.swing.JPanel jPnlLuta;
    // End of variables declaration//GEN-END:variables
}
