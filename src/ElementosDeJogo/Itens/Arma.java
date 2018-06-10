package ElementosDeJogo.Itens;

public class Arma extends Item{
    
    //ATRIBUTOS

    private short[] habilidadesTiro;
    private short[] habilidadesLuta;
    
    private FolhaDano dano;
    
    private short alcance;
    private short usosPorRound;
    private short tamanhoDoPente;
    private short municao;
    
    private short malFuncionamento;
    
    //CONSTRUTORES

    public Arma() {
        super();
        
        this.dano = new FolhaDano();
        
        this.alcance = 0;
        this.usosPorRound = 0;
        this.tamanhoDoPente = 0;
        this.municao = 0;
        
        this.malFuncionamento = 0;
    }

    public Arma(int id, String nome, String descricao, 
            short[] habilidadesTiro, short[] habilidadesLuta,
            FolhaDano dano, 
            short alcance, short usosPorRound, short tamanhoDoPente, short municao,
            short malFuncionamento) {
        super(id,nome, descricao);
        
        this.habilidadesTiro = habilidadesTiro;
        this.habilidadesLuta = habilidadesLuta;
        
        this.dano = dano;
        
        this.alcance = alcance;
        this.usosPorRound = usosPorRound;
        this.tamanhoDoPente = tamanhoDoPente;
        this.municao = municao;
        
        this.malFuncionamento = malFuncionamento;
    }
    
    //GETTERS E SETTERS

    public short[] getHabilidadesTiro() {
        return habilidadesTiro;
    }
    
    public void setHabilidadesTiro(short[] skill) {
        this.habilidadesTiro = skill;
    }

    public short[] getHabilidadesLuta() {
        return habilidadesLuta;
    }

    public void setHabilidadesLuta(short[] habilidadesLuta) {
        this.habilidadesLuta = habilidadesLuta;
    }
    
    

    public FolhaDano getDano() {
        return dano;
    }

    public void setDano(FolhaDano dano) {
        this.dano = dano;
    }
    
    
    
    public short getAlcance() {
        return alcance;
    }
    
    public void setAlcance(short alcance) {
        this.alcance = alcance;
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

    public short getMunicao() {
        return municao;
    }

    public void setMunicao(short municao) {
        this.municao = municao;
    }
    
    
    
    public short getMalFuncionamento() {
        return malFuncionamento;
    }
    
    public void setMalFuncionamento(short malFuncionamento) {
        this.malFuncionamento = malFuncionamento;
    }
	
}