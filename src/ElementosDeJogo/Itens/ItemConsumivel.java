package ElementosDeJogo.Itens;

public class ItemConsumivel extends Item{
    
    //ATRIBUTOS

    private short quantidade;
    
    private short hpRecuperado;
    private short mpRecuperado;
    
    //CONSTRUTORES

    public ItemConsumivel(){}

    public ItemConsumivel(int id, String nome, String descricao, 
            short quantidade, short hpRecuperado, short mpRecuperado) {
        super(id, nome, descricao);
        
        this.quantidade = quantidade;
        
        this.hpRecuperado = hpRecuperado;
        this.mpRecuperado = mpRecuperado;
    }
    
    //GETTERS E SETTERS

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }
    
    

    public short getHpRecuperado() {
        return hpRecuperado;
    }

    public void setHpRecuperado(short hpRecuperado) {
        this.hpRecuperado = hpRecuperado;
    }

    public short getMpRecuperado() {
        return mpRecuperado;
    }

    public void setMpRecuperado(short mpRecuperado) {
        this.mpRecuperado = mpRecuperado;
    }
	
}
