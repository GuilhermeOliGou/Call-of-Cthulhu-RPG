package DTO.Personagens;

public class Personagem {
    
    //ATRIBUTOS
    
    protected int id;
    
    protected FolhaDeAtributos atributos;
    
    protected short idade;
    protected String nome;
    
    protected int localidadeAtual;
    
    //CONSTRUTORES
    
    public Personagem (){
        super();
        
        this.id = -1;
        
        this.atributos = new FolhaDeAtributos();
        
        this.idade = 0;
        this.nome = "HP Lovecraft";
        
        this.localidadeAtual = -1;
    }

    public Personagem(int id, FolhaDeAtributos atributos, 
            short idade, String nome, 
            int localidadeAtual) {
        super();
        
        this.id = id;
        
        this.atributos = atributos;
        
        this.idade = idade;
        this.nome = nome;
        
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
    
    
    
    public int getLocalidadeAtual() {
        return localidadeAtual;
    }

    public void setLocalidadeAtual(int localidadeAtual) {
        this.localidadeAtual = localidadeAtual;
    }
    
}
