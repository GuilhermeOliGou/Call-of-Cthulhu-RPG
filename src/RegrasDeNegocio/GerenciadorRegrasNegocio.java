package RegrasDeNegocio;

import java.util.Random;

public class GerenciadorRegrasNegocio {
    
    private final Random rng = new Random(); //rng = Random Number Generator (Gerador de Números aleatório)
    
    //FUNÇÕES DE DADOS
    
    public int D4 (){
        return rng.nextInt(4)+1;
    }
    
    public int D6 (){
        return rng.nextInt(6)+1;
    }
    
    public int D8 (){
        return rng.nextInt(8)+1;
    }
    
    public int D10 (){
        return rng.nextInt(10)+1;
    }
    
    public int D12 (){
        return rng.nextInt(12)+1;
    }
    
    public int D20 (){
        return rng.nextInt(20)+1;
    }
    
    public int TesteDePorcentagem (){
        return rng.nextInt(100)+1;
    }
    
    //FIM FUNÇÕES DE DADOS
    
    //FUNÇÕES DE CRIAÇÃO DE PERSONAGEM
    
    public int GeradorDeForca(){
        return (D6()+D6()+D6())*5;
    }
    
    public int GeradorDeConstituicao(){
        return (D6()+D6()+D6())*5;
    }
    
    public int GeradorDeTamanho(){
        return (D6()+D6()+6)*5;
    }
    
    public int GeradorDeDestreza(){
        return (D6()+D6()+D6())*5;
    }
    
    public int GeradorDeAparencia(){
        return (D6()+D6()+D6())*5;
    }
    
    public int GeradorDeInteligencia(){
        return (D6()+D6()+6)*5;
    }
    
    public int GeradorDeEducacao(){
        return (D6()+D6()+6)*5;
    }
    
    public int GeradorDePoder(){
        return (D6()+D6()+D6())*5;
    }
    
    public int GeradorDeSorte(){
        return (D6()+D6()+6)*5;
    }
    
    //FIM FUNÇÕES CRIAÇÃO DE PERSONAGEM
    
}
