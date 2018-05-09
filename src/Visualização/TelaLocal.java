package Visualização;

//import java.awt.FlowLayout;
import ElementosDeJogo.Sistema.Local;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
//import javax.swing.JTextArea;

public class TelaLocal extends JFrame {
   
    private JComboBox acoes;
    private Local local;
    private ButtonHandler handler;
    
    public TelaLocal(/*Jogador jogador*/){
       super(/*jogador->nome*/);
       Montar(/*jogador*/);
    }
    
    private void Montar (/*Jogador jogador*/){
        /*this.jogador = jogador*/
        
        setLayout( null );

        String[]classesPer = {"aturar", "curar", "comprar", "bater", "recolher"};

        this.acoes = new JComboBox(classesPer);
        acoes.setName("Classe");
        acoes.setBounds(100,100,200,100);
        add( acoes );

        this.handler = new ButtonHandler();
    }
    
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ){
            if ("carregar".equals(event.getActionCommand())){
                //NOVO JOGO           
            }
        }
    }
}