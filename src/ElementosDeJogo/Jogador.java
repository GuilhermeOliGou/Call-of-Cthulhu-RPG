package ElementosDeJogo;

public class Jogador extends Personagem {
    
    //ATRIBUTOS DE JOGADOR
    
    private short sanidade;
    private short sorte;
    
    //CONSTRUTORES
    
    //FIM DE CONSTRUTORES
    
    //GETTERS AND SETTERS
    
    public short getSanidade() {
        return sanidade;
    }

    public void setSanidade(short sanidade) {
        this.sanidade = sanidade;
    }

    public short getSorte() {
        return sorte;
    }

    public void setSorte(short sorte) {
        this.sorte = sorte;
    }
    
    //FIM DE GETTERS AND SETTERS
    
}
