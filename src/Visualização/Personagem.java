package Visualização;

import ElementosDeJogo.Personagens.Jogador;
//import java.awt.Component;
//import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Personagem extends JFrame {   
    private JButton salvar;
    private JButton salvarESair;
    private JTextArea statusPersonagem;
    private Jogador jogador;
    private ButtonHandler handler;
    private JComboBox itens;

    public Personagem(/*Jogador jogador*/){        
        super(/*jogador.getNome()*/"Irineu");  
        Montar(/*jogador*/);
    }

    private void Montar(/*Jogador jogador*/){
        //this.jogador = jogador;
        
        setLayout( null );

        String[]inventario = {"poção", "revolver", "escudo", "corda", "ácido"};

        this.statusPersonagem = new JTextArea();
        statusPersonagem.setBounds(50, 500, 400, 40);
        add(statusPersonagem);

        this.salvarESair = new JButton( "Salvar e sair" );
        salvarESair.setBounds(700, 200 ,200 ,100 );
        add( salvarESair );

        this.salvar = new JButton( "salvar" );
        salvar.setBounds(700,50,200,100);
        add(salvar);

        this.itens = new JComboBox(inventario);
        itens.setName("Acoes");
        itens.setBounds(50,50,150,350);
        add(itens );

        this.handler = new ButtonHandler();
        salvarESair.addActionListener( handler );
        salvar.addActionListener( handler );
    }
    
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ){
            if ("criar".equals(event.getActionCommand())){
                //NOVO JOGO           
            }
        }
    }
}