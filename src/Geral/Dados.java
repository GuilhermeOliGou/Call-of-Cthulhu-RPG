package Geral;

import java.util.Random;

public class Dados {
    
    private final Random rng = new Random(); //rng = Random Number Generator (Gerador de Números aleatório)
    
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
    
}
