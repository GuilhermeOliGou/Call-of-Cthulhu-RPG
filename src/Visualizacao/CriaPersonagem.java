package Visualizacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CriaPersonagem extends GerenciadorDeVisualizacao{
    
     
    /*
    Nesta tela, precisa fazer a conecxão com as regras de negocio de onde sera 
    pego uma lista de "objetos" clase que sera utilizado nos comboBox, ou seja,
    também sera necessario alterar o comboBox para receber objetos.
    Depois implementar o botao criar (chamar a funcao de criar um personagem)

    */
    
    private JFrame janelaCriaPersonagem;
    private JPanel jPanelTelaCriaPersonagem;
    private JButton jButtonVoltar,jButtonCriar;
    private JTextArea jTextAreaNome;
    private String nome, classe;
    private JOptionPane aviso;
    private JComboBox<String> comboClasse;
     
     

    public CriaPersonagem(){
        super();
        montaJanela();        
    }
    
    public void montaJanela(){
        setLayout(null);
        preparaJanela();
        preparaPainel();
        preparaBotaoVoltar();
        preparaTextAreaNome();
        preparaComboClasse();
        preparaBotaoCriar();
        mostraJanela();
    }

    private void preparaJanela(){
        int largura = Toolkit.getDefaultToolkit().getScreenSize().width;
        int altura = Toolkit.getDefaultToolkit().getScreenSize().height;
        janelaCriaPersonagem = new JFrame("Cria Personagem");
        janelaCriaPersonagem.setResizable(false);
        janelaCriaPersonagem.setLocation(largura/6,altura/11);
        janelaCriaPersonagem.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    private void preparaPainel(){
        jPanelTelaCriaPersonagem = new JPanel();
        jPanelTelaCriaPersonagem.setLayout(null);    
        jPanelTelaCriaPersonagem.setBackground(java.awt.Color.LIGHT_GRAY);
        JLabel nome = new JLabel("Cria Personagem");
        nome.setBounds(425,25,150,50);
        jPanelTelaCriaPersonagem.add(nome);
        janelaCriaPersonagem.add(jPanelTelaCriaPersonagem);  
    }
    
    private void preparaBotaoVoltar() {
        jButtonVoltar = new JButton("Voltar");
        jButtonVoltar.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){ 
                System.out.println("Voltou para Tela Inicial");
                CriaTelaInicial();
                janelaCriaPersonagem.setVisible(false);
                                
            }
        });
        jButtonVoltar.setBounds(25, 25,100, 30);
        jPanelTelaCriaPersonagem.add(jButtonVoltar);
    }

    private void preparaTextAreaNome() {
        jTextAreaNome = new JTextArea("Digite o nome do personagem Aqui");
        jTextAreaNome.setBounds(300,100,400,30);
        jPanelTelaCriaPersonagem.add(jTextAreaNome);
        
    }

    private void preparaComboClasse() {
        comboClasse = new JComboBox();
        comboClasse.addItem("Aluno");//mudar para objeto tipo classe depois
        comboClasse.addItem("Professor");//mudar para objeto tipo classe depois
        comboClasse.setBounds(300,140,400,30);
        jPanelTelaCriaPersonagem.add(comboClasse);
        
    }

    private void preparaBotaoCriar() {
         jButtonCriar = new JButton("Criar");
         jButtonCriar.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){ 
                nome=jTextAreaNome.getText();
                classe = (String) comboClasse.getSelectedItem();
                System.out.println("Criar Personagem nome: "+ nome + " Classe: "+ classe);
            }
        });
        jButtonCriar.setBounds(450, 400,100, 50);
        jPanelTelaCriaPersonagem.add(jButtonCriar);
    }

    private void mostraJanela() {
        aviso = new JOptionPane();
        janelaCriaPersonagem.pack();
        janelaCriaPersonagem.setSize(1000,500);
        janelaCriaPersonagem.setVisible(true);
         aviso.showMessageDialog(janelaCriaPersonagem, "Aviso ao professor: "
                 + "As classes ainda serao implementadas");
    }
    
    
}