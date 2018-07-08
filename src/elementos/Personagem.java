package Elementos;
import java.util.Random;

public class Personagem {
    private int id;
    private int vidaAtual;
    private int vidaMaxima;
    private int dano;
    private int stamina;
    private Medo medo;
    private String nome;
    private int inimigosDerrotados;
    private int nivel;
    private int sorte;
    
    public Personagem(String nome){
        Random r = new Random();
        this.nome = nome;
        vidaMaxima = 30 + r.nextInt(71);
        vidaAtual = vidaMaxima;
        dano = 7;
        stamina = 50;
        medo = Medo.NORMAL;
        inimigosDerrotados = 0;
        nivel = 1;
        sorte = 0;
    }
    
    
    public int ataque(){
        if(this.medo == Medo.APAVORADO){
            stamina += 3;
            return 0;
        }
        stamina -= 2;
        return dano;
        
    }
    
    public void recebeDano(int danoRecebido){
        if(danoRecebido >= 20) {
            stamina -= 3;
            medo = Medo.ASSUSTADO;
        }
        else stamina -= 1;
        vidaAtual -= danoRecebido;
    }
    
    public void passaNivel(){
        nivel += 1;
        vidaAtual += 10;
        vidaMaxima += 10;
        dano += 2;
    }
    
    public int calculaSorte(){
        Random r = new Random();
        sorte = r.nextInt(10)+1;
        return sorte;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getDano() {
        return dano;
    }

    public Medo getMedo() {
        return medo;
    }

    public int getNivel() {
        return nivel;
    }
    
    public void setMedo(Criatura criatura){
        if((criatura.getClassificacao() == BizarriceCriatura.DISFORME) ||
                (criatura.getClassificacao() == BizarriceCriatura.BIZARRA)){
            medo = Medo.APAVORADO;
        }
        else if(criatura.getClassificacao() == BizarriceCriatura.PADRAO) medo = Medo.NORMAL;
    }
    
    public void setMedo(Medo medo){
        this.medo = medo;
    }
    
    public void incrementaInimigosDerrotados(){
        inimigosDerrotados++;
    }
    
    public String getVidaToString(){
        return "" + vidaAtual + "";
    }
}
