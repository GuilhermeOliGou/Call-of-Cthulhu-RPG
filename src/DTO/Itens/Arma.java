package DTO.Itens;

public class Arma extends Item{
    
    //ATRIBUTOS

    private short[] habilidadesUsadasTiro;
    private short[] habilidadesUsadasLuta;
    
    private FolhaDano dano;
    
    private short usosPorRound;
    private short tamanhoDoPente;
    
    private short malFuncionamento;
    
    //CONSTRUTORES

    public Arma() {
        super();
        
        this.dano = new FolhaDano();
        
        this.usosPorRound = 0;
        this.tamanhoDoPente = 0;
        
        this.malFuncionamento = 0;
    }
    
    public Arma(int id, String nome, String descricao, 
            short[] habilidadesUsadasTiro, short[] habilidadesUsadasLuta,
            FolhaDano dano, 
            short usosPorRound, short tamanhoDoPente,
            short malFuncionamento) {
        super(id,nome, descricao);
        
        this.habilidadesUsadasTiro = habilidadesUsadasTiro;
        this.habilidadesUsadasLuta = habilidadesUsadasLuta;
        
        this.dano = dano;
        
        this.usosPorRound = usosPorRound;
        this.tamanhoDoPente = tamanhoDoPente;
        
        this.malFuncionamento = malFuncionamento;
    }
    
    //ESSE CONSTRUTOR É IDEAL PARA ARMAS DE FOGO

    public Arma(int id, String nome, String descricao,
            short[] habilidadesUsadasTiro, 
            FolhaDano dano, short usosPorRound, short tamanhoDoPente, 
            short malFuncionamento) {
        
        super(id, nome, descricao);
        
        this.habilidadesUsadasTiro = habilidadesUsadasTiro;
        
        this.dano = dano;
        
        this.usosPorRound = usosPorRound;
        this.tamanhoDoPente = tamanhoDoPente;
        
        this.malFuncionamento = malFuncionamento;
    }
    
    
    
    //ESSE CONSTRUTOR É IDEAL PARA ARMAS BRANCAS

    public Arma(int id, String nome, String descricao,
            short[] habilidadesLuta, FolhaDano dano) {
        super(id,nome,descricao);
        
        this.habilidadesUsadasLuta = habilidadesLuta;
        
        this.dano = dano;
        
        this.usosPorRound = 1;
    }   
    
    //GETTERS E SETTERS

    public short[] getHabilidadesUsadasTiro() {
        return habilidadesUsadasTiro;
    }
    
    public void setHabilidadesUsadasTiro(short[] skill) {
        this.habilidadesUsadasTiro = skill;
    }

    public short[] getHabilidadesUsadasLuta() {
        return habilidadesUsadasLuta;
    }

    public void setHabilidadesUsadasLuta(short[] habilidadesUsadasLuta) {
        this.habilidadesUsadasLuta = habilidadesUsadasLuta;
    }
    
    

    public FolhaDano getDano() {
        return dano;
    }

    public void setDano(FolhaDano dano) {
        this.dano = dano;
    }

    
    
    public short getUsosPorRound() {
        return usosPorRound;
    }
    
    public void setUsosPorRound(short usosPorRound) {
        this.usosPorRound = usosPorRound;
    }

    public short getTamanhoDoPente() {
        return tamanhoDoPente;
    }

    public void setTamanhoDoPente(short tamanhoDoPente) {
        this.tamanhoDoPente = tamanhoDoPente;
    }
    
    
    
    public short getMalFuncionamento() {
        return malFuncionamento;
    }
    
    public void setMalFuncionamento(short malFuncionamento) {
        this.malFuncionamento = malFuncionamento;
    }
	
}