package elementos;

import javax.swing.JOptionPane;
import java.util.Random;

public abstract class Criatura {
    private String nome;
    private int vidaAtual;
    private int vidaMax;
    private BizarriceCriatura classificacao;
    private int qtdDano;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public double getQtdDano(){
        return qtdDano;
    }
    
    public void setQtdDano(int dano){
        qtdDano = dano;
    }
    
    public BizarriceCriatura getClassificacao(){
        return classificacao;
    }
    
    public void setClassificacao(BizarriceCriatura tipo){
        classificacao = tipo;
    }
    
    public void ataca(Personagem personagem){
        Random r = new Random();
        int danoCausado = qtdDano + r.nextInt(qtdDano+1);
        personagem.recebeDano(danoCausado);
        JOptionPane.showMessageDialog(null, nome + " atacou voce " +
                "e causou " + danoCausado);
    }
    
    public void recebeDano(int danoRecebido){
        vidaAtual -= danoRecebido;
    }
    
    public int getVidaAtual(){
        return vidaAtual;
    }
    
    public void setVidaMax(int vida){
        vidaMax=vida;
        vidaAtual = vidaMax;
    }
    
    public void surge(){
        System.out.println(getNome() + " esta na sua frente.");
    }
    
    
}
