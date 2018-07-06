package DTO.Itens;

public class Item {

    //ATRIBUTOS
    
    protected int id;
    
    protected String nome;
    protected String descricao;
    
    //CONSTRUTORES

    public Item(){
        super();
        
        this.id = -1;
        
        this.nome = "";
        this.descricao = "";
    }

    public Item(int id, String nome, String descricao) {
        super();
        
        this.id = id;
        
        this.nome = nome;
        this.descricao = descricao;
    }

    //GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
	
}
