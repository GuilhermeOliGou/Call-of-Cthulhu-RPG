package DTO.Itens;

public class ItemConsumivel extends Item{
    
    //ATRIBUTOS
    
    private short hpRecuperado;
    private short mpRecuperado;
    
    //CONSTRUTORES

    public ItemConsumivel(){
        super();
        
        this.hpRecuperado = 0;
        this.mpRecuperado = 0;
    }

    public ItemConsumivel(int id, String nome, String descricao, 
            short hpRecuperado, short mpRecuperado) {
        super(id, nome, descricao);
        
        this.hpRecuperado = hpRecuperado;
        this.mpRecuperado = mpRecuperado;
    }
    
    //GETTERS E SETTERS   

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
