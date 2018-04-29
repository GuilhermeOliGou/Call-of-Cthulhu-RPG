package Geral;

import java.util.Random;

public class Dados {
    
    private final Random RNG = new Random(); //rng = Random Number Generator (Gerador de Números aleatório)
    
    public int D4 (){
        return RNG.nextInt(4)+1;
    }
    
    public int D6 (){
        return RNG.nextInt(6)+1;
    }
    
    public int D8 (){
        return RNG.nextInt(8)+1;
    }
    
    public int D10 (){
        return RNG.nextInt(10)+1;
    }
    
    public int D12 (){
        return RNG.nextInt(12)+1;
    }
    
    public int D20 (){
        return RNG.nextInt(20)+1;
    }
    
    public int TesteDePorcentagem (){
        return RNG.nextInt(100)+1;
    }
    
}
