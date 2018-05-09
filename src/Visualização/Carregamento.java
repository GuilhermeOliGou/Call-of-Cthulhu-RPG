package Visualização;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Carregamento extends JFrame 
{ 
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JLabel fundo;
    private Icon cthulhu;
    private JButton voltar, carregar;
    private JTextField infos;
    private JComboBox jogosSalvos;
    private ButtonHandler handler;

    public Carregamento(){
        super( "Carregar jogo" );
        Montar();
    }
    
    private void Montar (){
        layout = new GridBagLayout();
        setLayout( layout );
        constraints = new GridBagConstraints();

        this.cthulhu = new ImageIcon(getClass().getResource("fundo.jpg"));
        this.fundo = new JLabel("", cthulhu, SwingConstants.CENTER);

        JTextArea infoJogosCarregados = new JTextArea( "", 5, 10 );

        // TROQUE A LINHA DEBAIXO PELO MÉTODO COMENTADO
        String[] names = { "Iron", "Steel", "Brass" };

        /* 

        // Cria string que contem NOVO JOGO mais os jogos Salvos
        String[] names = new String[Objeto.jogosSalvos() + 1]

        names[0] = "Novo Jogo";

        //adiciona a Sstring o nome dos jogos salvos
        void JogosSalvosNaCombo()
        {
          implemente!
        }

        */

        this.jogosSalvos = new JComboBox(names);

        /*Disparar evento JCOMBO!
        quando você clicar, carregar na tela de texo as informações
        do jogo pelo método*/

        JTextField textField = new JTextField( "TextField" );
        this.voltar = new JButton( "Voltar" );
        this.carregar = new JButton( "Carregar" );

        constraints.fill = GridBagConstraints.BOTH;
        addComponent( infoJogosCarregados, 0, 0, 1, 3 );    

        constraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent( voltar, 0, 1, 2, 1 );

        addComponent(jogosSalvos, 2, 1, 2, 1 );             

        constraints.weightx = 1000;  // can grow wider
        constraints.weighty = 1;     // can grow taller
        constraints.fill = GridBagConstraints.BOTH;
        //addComponent( button2, 1, 1, 1, 1 );
        addComponent( fundo, 1, 1, 1, 1 );

        constraints.weightx = 0;
        constraints.weighty = 0;    
        addComponent( carregar, 1, 2, 1, 1 );

        addComponent( textField, 3, 0, 2, 1 );
        
        this.handler = new ButtonHandler();
        carregar.addActionListener(handler);
        voltar.addActionListener(handler);
    }

    private void addComponent( Component component,
            int row, int column, int width, int height ){
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints( component, constraints );
        add( component );
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