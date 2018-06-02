package Visualizacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Carregamento extends GerenciadorDeVisualizacao { 
   
    
    private JFrame janelaCarregamento;
    private JPanel jPanelTelaCarregamento;
    private JButton jButtonVoltar, jButtonLoad;
    private JTextField jTextFieldDescricao;
    private JComboBox<String> comboJogosSalvos;
    private String descricao="descricao";
    
    
    public Carregamento(){
        super();
        montarTela();
    }

    private void montarTela() {
        setLayout(null);
        preparaJanela();
        preparaPainel();
        preparaBotaoVoltar();
        preparaComboJogosSalvos();
        preparaTextFieldDescricao();
        preparaBotaoLoad();
        mostraJanela();
    }

    private void preparaJanela() {
        int largura = Toolkit.getDefaultToolkit().getScreenSize().width;
        int altura = Toolkit.getDefaultToolkit().getScreenSize().height;
        janelaCarregamento = new JFrame("Carregamento");
        janelaCarregamento.setResizable(false);
        janelaCarregamento.setLocation(largura/5,altura/11);
        janelaCarregamento.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void preparaPainel() {
        jPanelTelaCarregamento = new JPanel();
        jPanelTelaCarregamento.setLayout(null);    
        jPanelTelaCarregamento.setBackground(java.awt.Color.LIGHT_GRAY);
        JLabel nome = new JLabel("Carregamento de Jogo");
        nome.setBounds(425,25,150,50);
        jPanelTelaCarregamento.add(nome);
        janelaCarregamento.add(jPanelTelaCarregamento);  
    
    }
    
    private void preparaBotaoVoltar() {
       jButtonVoltar = new JButton("Voltar");
       jButtonVoltar.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){ 
                System.out.println("Voltou para Tela Inicial");
                CriaTelaInicial();
                janelaCarregamento.setVisible(false);
                                
            }
        });
        jButtonVoltar.setBounds(25, 25,100, 30);
        jPanelTelaCarregamento.add(jButtonVoltar);
    }
    
    private void preparaComboJogosSalvos(){
        comboJogosSalvos = new JComboBox();
        comboJogosSalvos.addItem("Jogo 1");
        comboJogosSalvos.addItem("Jogo 2");
        comboJogosSalvos.addItem("Jogo 3");
        
        comboJogosSalvos.addActionListener((e) -> {
            if(comboJogosSalvos.getSelectedItem() == "Jogo 1"){
                System.out.println("Jogo 1");
                descricao = "essa é a descricao do jogo 1";
                jTextFieldDescricao.setText(descricao);
            }else{
                if(comboJogosSalvos.getSelectedItem() == "Jogo 2"){
                    System.out.println("Jogo 2");
                    descricao = "essa é a descricao do jogo 2";
                    jTextFieldDescricao.setText(descricao);
                }else{
                    if(comboJogosSalvos.getSelectedItem() == "Jogo 3"){
                        System.out.println("Jogo 3");
                        descricao = "essa é a descricao do jogo 3";
                        jTextFieldDescricao.setText(descricao);
                    }
                }
            }
        });

       comboJogosSalvos.setBounds(300,100,400,60);
       jPanelTelaCarregamento.add(comboJogosSalvos); 
                
    }
    
    private void preparaTextFieldDescricao(){
        jTextFieldDescricao = new JTextField(descricao);
        jTextFieldDescricao.setBounds(300,160,400,100);
        jPanelTelaCarregamento.add(jTextFieldDescricao);
    }
    
    
    private void preparaBotaoLoad(){
        jButtonLoad = new JButton("LOAD");
        jButtonLoad.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Carregando Jogo");
                CriaTelaPersonagem();
                janelaCarregamento.setVisible(false);
            }
        });
        jButtonLoad.setBounds(600, 300, 150,30);
        jPanelTelaCarregamento.add(jButtonLoad);
    }
    

    private void mostraJanela() {
        janelaCarregamento.pack();
        janelaCarregamento.setSize(1000,500);
        janelaCarregamento.setVisible(true);
    }
    
} 