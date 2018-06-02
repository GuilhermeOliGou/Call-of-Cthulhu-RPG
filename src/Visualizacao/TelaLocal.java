package Visualizacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TelaLocal extends JFrame {
   
   JFrame janelaLocal;
    private JPanel jPanelTelaLocal;
    private JLabel jLabelLocal;
    private JTextArea jTextAreaCodigo;
    private JTable tabelaEventos= new JTable(new DefaultTableModel(
                new Object[]{"Código", "Nome"},0));
    private JButton jButtonVoltar, jButtonRealizaEvento;
    private JLabel jTextCodigo;
    
    public TelaLocal(){
       super();
       Montar();
    }
    
    private void Montar (){
        setLayout(null);
        preparaJanela();
        preparaPainel();
        preparaBotaoVoltar();
        preparaTextLocal();
        preparaTabelaEventos();
        preparaTextAreaCodigo();
        preparaBotaoRealizarEvento();
        mostraJanela();
    }
    private void preparaJanela() {
        int largura = Toolkit.getDefaultToolkit().getScreenSize().width;
        int altura = Toolkit.getDefaultToolkit().getScreenSize().height;
        janelaLocal = new JFrame("LOCAL");
        janelaLocal.setResizable(false);
        janelaLocal.setLocation(largura/20,altura/15);
        janelaLocal.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void preparaPainel() {
        jPanelTelaLocal = new JPanel();
        jPanelTelaLocal.setLayout(null);    
        jPanelTelaLocal.setBackground(java.awt.Color.LIGHT_GRAY);
        JLabel nome = new JLabel("Local");
        nome.setBounds(425,10,150,50);
        jPanelTelaLocal.add(nome);
        janelaLocal.add(jPanelTelaLocal);  
    
    }
     private void preparaBotaoVoltar() {
       jButtonVoltar = new JButton("Voltar");
       jButtonVoltar.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){ 
                System.out.println("Fechou tela Local");
               janelaLocal.setVisible(false);
                                
            }
        });
        jButtonVoltar.setBounds(25, 25,100, 30);
        jPanelTelaLocal.add(jButtonVoltar);
    }
     
    private void preparaTextLocal(){
        jLabelLocal = new JLabel("Local Atual: ");
        jLabelLocal.setBounds(25,60,200,50);
        
        jPanelTelaLocal.add(jLabelLocal);
    }
    
    private void preparaTabelaEventos(){
        DefaultTableModel model = (DefaultTableModel) tabelaEventos.getModel();
        model.addRow(new Object[]{"CODIGO","NOME"});
        model.addRow(new Object[]{1,"Evento 1"});
        model.addRow(new Object[]{2,"evento 2"});
        model.addRow(new Object[]{3,"evento 3"});
        
        tabelaEventos.setBounds(15,125,400,325);
        jPanelTelaLocal.add(tabelaEventos);
    }
    
    private void preparaTextAreaCodigo(){
        jTextCodigo = new JLabel("Digite o código do evento: ");
        jTextAreaCodigo = new JTextArea();
        jTextCodigo.setBounds(600,125,200,30);
        jTextAreaCodigo.setBounds(600, 150, 50, 30);
        
        jPanelTelaLocal.add(jTextCodigo);
        jPanelTelaLocal.add(jTextAreaCodigo);
    }
    private void preparaBotaoRealizarEvento(){
       jButtonRealizaEvento = new JButton("Realizar Evento");
       jButtonRealizaEvento.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){ 
                System.out.println("Realizar evento");
            }
        });
        jButtonRealizaEvento.setBounds(600, 200,200, 50);
        jPanelTelaLocal.add(jButtonRealizaEvento);
    }
    
    
    private void mostraJanela() {
        janelaLocal.pack();
        janelaLocal.setSize(1000,500);
        janelaLocal.setVisible(true);
    }
    public void encerraJanela(){
        janelaLocal.dispose();
    }
}