package RegrasDeNegocio;

public class Acao {
    
    public enum TipoAcao{ofensiva, passiva}
    
    //ATRIBUTOS
    
    public TipoAcao tipoAcao;
    private String nome;
    
    private int idItem;
    private int quantidadeItem;
    
    private boolean valido;
    
    //CONSTRUTORES

    public Acao() {
        super();
    }

    public Acao(TipoAcao tipoAcao, String nome) {
        super();
        
        this.tipoAcao = tipoAcao;
        this.nome = nome;
        
        this.valido = true;
    }

    public Acao(TipoAcao tipoAcao, String nome, int idItem, int quantidadeItem) {
        super();
        
        this.tipoAcao = tipoAcao;
        this.nome = nome;
        
        this.idItem = idItem;
        this.quantidadeItem = quantidadeItem;
        
        this.valido = true;
    }
    
    //GETTERS E SETTERS

    public TipoAcao getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(TipoAcao tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
    
    

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
}
