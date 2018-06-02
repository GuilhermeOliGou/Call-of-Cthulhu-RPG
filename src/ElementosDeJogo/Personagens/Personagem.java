package ElementosDeJogo.Personagens;

import ElementosDeJogo.Itens.Item;
import ElementosDeJogo.Sistema.Local;

public class Personagem {
    
    //ATRIBUTOS
    
    protected int id;
    
    protected FolhaDeAtributos atributos;
    
    protected short idade;
    protected String nome;
    
    private Item[] inventario;
    
    protected Local localidadeAtual;
    
    //CONSTRUTORES
    
    public Personagem (){
        super();
    }

    public Personagem(int id, FolhaDeAtributos atributos, 
            short idade, String nome, 
            Item[] inventario, Local localidadeAtual) {
        super();
        
        this.id = id;
        
        this.atributos = atributos;
        
        this.idade = idade;
        this.nome = nome;
        
        this.inventario = inventario;
        
        this.localidadeAtual = localidadeAtual;
    }
    
    //GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FolhaDeAtributos getAtributos() {
        return atributos;
    }

    public void setAtributos(FolhaDeAtributos atributos) {
        this.atributos = atributos;
    }
    
    

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        if (idade < 15)        
            this.idade = 15;
        else if (idade > 90)
            this.idade = 90;
        else
            this.idade = idade;            
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public Item[] getInventario() {
        return inventario;
    }

    public void setInventario(Item[] inventario) {
        this.inventario = inventario;
    }
    
    
    
    public Local getLocalidadeAtual() {
        return localidadeAtual;
    }

    public void setLocalidadeAtual(Local localidadeAtual) {
        this.localidadeAtual = localidadeAtual;
    }
    
}
