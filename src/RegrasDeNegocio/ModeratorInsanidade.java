package RegrasDeNegocio;

public class ModeratorInsanidade {
    
    //ATRIBUTOS
    
    private final Dados DADOS = new Dados();
    
    private int insanidadeJogador;
    
    //CONSTRUTORES
    
    public ModeratorInsanidade(){
        super();
        
    }
    
    public ModeratorInsanidade(int insanidadeJogador){
        super();
        
        this.insanidadeJogador = insanidadeJogador;
    }
    
    //FUNÇÕES
    
    public String DeformaçãoInsanidade(String base){
        if(this.insanidadeJogador > 50)
            return base;
        char[] baseDecomposta = base.toCharArray();
        for(char c : baseDecomposta){
            if(this.DADOS.TesteDePorcentagem() > this.insanidadeJogador+90){
                c = (char)(this.DADOS.TesteDePorcentagem()+this.DADOS.D20()*4);
            }
        }
        return String.valueOf(baseDecomposta);
    }

    public void setInsanidadeJogador(int insanidadeJogador) {
        this.insanidadeJogador = insanidadeJogador;
    }
    
}
