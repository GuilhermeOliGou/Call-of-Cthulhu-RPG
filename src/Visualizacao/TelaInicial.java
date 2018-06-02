package Visualizacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class TelaInicial extends GerenciadorDeVisualizacao{
    
    private JButton jButtonCarregar;
    private JButton jButtonIniciar;
    private JButton jButtonSair;
    private JPanel jPanelTelaInicial;
    private JFrame janelainicial;
    
    
    public TelaInicial(){        
        super();   
        montaJanela();
    }
    
    public void montaJanela(){
        setLayout(null);
        prepararJanela();
        prepararPainel();
        prepararBotaoIniciar(); 
        prepararBotaoCarregar();
        prepararBotaoSair();
        mostraJanela();
    }
    
     private void prepararJanela(){
        int largura = Toolkit.getDefaultToolkit().getScreenSize().width;
        janelainicial = new JFrame("Call of Ctulhu");
        janelainicial.setResizable(false);
        janelainicial.setLocation(largura - 1000,50);
        janelainicial.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
    
    private void prepararPainel(){
        jPanelTelaInicial = new JPanel();
        jPanelTelaInicial.setLayout(null);    
        jPanelTelaInicial.setBackground(java.awt.Color.LIGHT_GRAY);
        JLabel nome = new JLabel("Call of Ctulhu");
        nome.setBounds(270, 100, 100, 20);
        jPanelTelaInicial.add(nome);
        janelainicial.add(jPanelTelaInicial);  
    }
   
    private void prepararBotaoIniciar(){
        jButtonIniciar = new JButton("Novo Jogo");
        jButtonIniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CriaTelaCriacao();
                janelainicial.setVisible(false);
                System.out.println("abriu tela Criacao");
               
            }
        }); 
        jButtonIniciar.setBounds(70, 270,110, 20);
        jPanelTelaInicial.add(jButtonIniciar);
    }
    private void prepararBotaoCarregar(){
        jButtonCarregar = new JButton("Carregar Jogo");
        jButtonCarregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                CriaTelaCarregamento();
                janelainicial.setVisible(false);
                System.out.println("abriu tela Carregamento");
            }
        });
        jButtonCarregar.setBounds(220, 270,140, 20);
        jButtonCarregar.setLayout(null);
        jPanelTelaInicial.add(jButtonCarregar);
    }
    
    private void prepararBotaoSair(){ 
        jButtonSair = new JButton("Sair do Jogo");
        jButtonSair.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){ 
                System.out.println("Fechou o jogo");
                System.exit(0);
            }
        });
        jButtonSair.setBounds(400, 270,110, 20);
        jPanelTelaInicial.add(jButtonSair);
    }
     
    private void mostraJanela(){
        janelainicial.pack();
        janelainicial.setSize(600,350);
        janelainicial.setVisible(true);
    }
    
 
}
