package Visualização;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaInicial extends JFrame{
    
    private GerenciadorDeVisualizacao gerenciadorTelas;
    private JButton novoJog, carregarJogo;
    private ButtonHandler handler;
    
    public TelaInicial(GerenciadorDeVisualizacao gerenciadorTelas){        
        super("Cthulhu");        
        this.gerenciadorTelas = gerenciadorTelas;
        Montar();        
    }
    
    private void Montar(){
        setLayout(new FlowLayout());
        
        this.novoJog = new JButton("Novo Jogo");
        add(novoJog);
        
        this.carregarJogo = new JButton("Carregar");
        add(carregarJogo);
                
        this.handler = new ButtonHandler();
        novoJog.addActionListener(handler);
        carregarJogo.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if ("newGameButton".equals(event.getActionCommand())){
                
            }else if ("loadGameButton".equals(event.getActionCommand())){
                //CARREGA JOGO
                System.out.println("Teste do botao");                
            }           
        }
    }
    
}
