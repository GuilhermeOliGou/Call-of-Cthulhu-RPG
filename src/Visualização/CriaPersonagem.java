package Visualização;

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

public class CriaPersonagem extends JFrame{
    
    private JTextArea nomePersonagem;   
    private JButton voltar, criar;
    private JComboBox classePersonagem;
    private ButtonHandler handler;
    private GerenciadorDeVisualizacao gerenciador;

    public CriaPersonagem(GerenciadorDeVisualizacao gerenciador){
        super( "WELCOME!" );
        this.gerenciador=gerenciador;
        Montagem();        
    }
    
    private void Montagem (){
        setLayout( null );

        String[]classesPer = {"SI"};

        this.nomePersonagem = new JTextArea("Nome");
        nomePersonagem.setBounds(200, 100, 400, 40);
        add(nomePersonagem);

        this.voltar = new JButton( "Voltar" );
        voltar.setBounds(40,40,80,40);
        add(voltar );

        this.classePersonagem = new JComboBox(classesPer);
        classePersonagem.setName("Classe");
        classePersonagem.setBounds(200,200,400,100);
        add( classePersonagem );


        this.criar = new JButton( "CRIAR" );
        criar.setBounds(200, 400 ,400 ,100 );
        add(criar );


        this.handler = new ButtonHandler();
        criar.addActionListener(handler);
        voltar.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {    
        @Override
        public void actionPerformed( ActionEvent event ){
            if ("criar".equals(event.getActionCommand())){
                int[] modificadoresDeClasse = new int[78];
                switch (classePersonagem.getSelectedIndex()){
                    case 1:
                        modificadoresDeClasse[9] = 70;
                        modificadoresDeClasse[16] = 50;
                        modificadoresDeClasse[17] = 50;
                        modificadoresDeClasse[43] = 40;
                        modificadoresDeClasse[66] = 60;
                        modificadoresDeClasse[72] = 60;
                        modificadoresDeClasse[62] = 60;
                        modificadoresDeClasse[69] = 50;
                        break;
                }
                gerenciador.CriarPersonagemActionPerformed(nomePersonagem.getText(),modificadoresDeClasse);
            }
        }
    }
    
}