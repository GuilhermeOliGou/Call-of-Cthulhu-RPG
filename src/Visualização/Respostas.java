package Visualização;

//import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Respostas extends JFrame{
    
    private JTextArea textoResposta;
    private JButton ok;
    private ButtonHandler handler;

    public Respostas(){
        super( "Atenção!!" );        
        Montar();
    }
    
    private void Montar(){
        setLayout(null);

        this.textoResposta = new JTextArea("Nome");
        textoResposta.setBounds(200, 50, 600, 300);
        add(textoResposta);

        this.ok = new JButton("OK");
        ok.setBounds(450,400,100,50);
        add(ok);

        handler = new ButtonHandler();

        ok.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ){
           if ("OK".equals(event.getActionCommand())){
                //NOVO JOGO           
            }
        }
    }
}