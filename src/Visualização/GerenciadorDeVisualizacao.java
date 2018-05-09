package Visualização;
import ElementosDeJogo.Sistema.Local;
import RegrasDeNegocio.RegrasDeNegocio;
import javax.swing.JFrame;

public class GerenciadorDeVisualizacao {
    
    private JFrame tela;
    private RegrasDeNegocio gerenciadorDeRegras;
    
    public GerenciadorDeVisualizacao(RegrasDeNegocio gerenciadorDeRegras){
        this.gerenciadorDeRegras = gerenciadorDeRegras;
    }
    
    public void Inicializa (){
        tela = CriaTelaInicial();
    }   
    
    public void TrocaTela (JFrame novaTela){
        tela.dispose();
        tela = novaTela;
    }
    
    public TelaInicial CriaTelaInicial() {     
        TelaInicial ti = new TelaInicial(this);
        ti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ti.setSize(600,400);
        ti.setVisible(true);
        return ti;
    }
        
    public CriaPersonagem CriaTelaCriacao(){   
        System.out.println("Batata");
        CriaPersonagem cp = new CriaPersonagem(this);
        cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.setSize(1000,600);
        cp.setVisible(true);
        return cp;
    }
        
    public Carregamento CriaTelaCarregamento(){
        Carregamento ca = new Carregamento();
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setSize(600,400);
        ca.setVisible(true);
        return ca;
    }  
        
    public Personagem CriaTelaPersonagem(){
        Personagem pe = new Personagem();
        pe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pe.setSize(1000,600);
        pe.setVisible(true);
        return pe;
    }  
        
    public TelaLocal CriaTelaLocal(){
        TelaLocal l = new TelaLocal();
        l.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        l.setSize(1000,600);
        l.setVisible(true);
        return l;
    }  
        
    public Respostas CriaTelaResposta(){
        Respostas r = new Respostas();
        r.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        r.setSize(1000,600);
        r.setVisible(true); 
        return r;
    }  
    
    public void CriarPersonagemActionPerformed (String nome, int[] modificadoresDeClasse){
        gerenciadorDeRegras.CriarJogador(nome, new Local(), modificadoresDeClasse);
    }
    
}
