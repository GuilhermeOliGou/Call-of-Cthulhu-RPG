package Visualizacao;
import javax.swing.*;
import ElementosDeJogo.Sistema.Resposta;
public class GerenciadorDeVisualizacao extends JFrame{
    
   
    
    public void Inicializa (){
        CriaTelaInicial();
    }   

        
    public TelaInicial CriaTelaInicial() {     
        TelaInicial telaInicial = new TelaInicial();
        return telaInicial;
    }
  
    public CriaPersonagem CriaTelaCriacao(){   
        CriaPersonagem telaCriacao = new CriaPersonagem();
        return telaCriacao;
    }
        
    public Carregamento CriaTelaCarregamento(){
        Carregamento telaCarregamento = new Carregamento();
        return telaCarregamento;
    }  
        
    public Personagem CriaTelaPersonagem(){
        Personagem telaPersonagem = new Personagem();
        return telaPersonagem;
    }  
        
    public TelaLocal CriaTelaLocal(){
        TelaLocal telaLocal = new TelaLocal();
        return telaLocal;
    }  
        
    public Resposta CriaTelaResposta(){
        Resposta telaResposta = new Resposta();
        return telaResposta;
    }  
    
   
    
}
