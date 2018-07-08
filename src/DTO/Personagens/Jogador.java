package DTO.Personagens;

import DTO.Itens.Item;
import RegrasDeNegocio.RegraNegocioException;

public class Jogador extends Personagem {

    //ATRIBUTOS
    
    private short maxSanidade;
    private short sanidadeAtual;
    private short sorte;
    
    protected Item[] inventario;

    private FolhaDeHabilidades habilidades;
    
    //CONSTRUTORES
    
    public Jogador() {
        super();
        
        this.maxSanidade = 0;
        this.sanidadeAtual = 0;
        this.sorte = 0;
        
        this.habilidades = new FolhaDeHabilidades();
    }
    
    public Jogador( int id, FolhaDeAtributos atributos, short idade, String nome, int localidadeAtual,
            short maxSanidade, short sanidadeAtual, short sorte,
            Item[] inventario){
        super(id,atributos,
                idade,nome, 
                localidadeAtual);
        
        this.maxSanidade = maxSanidade;
        this.sanidadeAtual = sanidadeAtual;
        this.sorte = sorte;
        
        this.inventario = inventario;
        
        this.habilidades = new FolhaDeHabilidades(atributos.getCaracteristicas().getDestreza());
    }
    
    //FUNÇÕES

    public String DescricaoJogador() throws RegraNegocioException{
        try{
            return nome + "(" + idade + " anos):\n" +
                    "Força: " + atributos.getCaracteristicas().getForca() + "\n" +
                    "Constituição: " + atributos.getCaracteristicas().getConstituicao() + "\n" +
                    "Tamanho: " + atributos.getCaracteristicas().getTamanho() + "\n" +
                    "Destreza: " + atributos.getCaracteristicas().getDestreza() + "\n" +
                    "Poder: " + atributos.getCaracteristicas().getPoder();
        }catch(NullPointerException e){
            //Log.gravaLog(e);
            throw new RegraNegocioException("FOLHA DE CARACTERÍTICAS NÃO INICIALIZADA!"
                    + " INCAPAZ DE RETORNAR DESCRIÇÃO!");
        }
    }
    
    //GETTERS E SETTERS
    
    
    
    public short getMaxSanidade() {
        return maxSanidade;
    }
    
    public void setMaxSanidade(short maxSanidade) {    
        this.maxSanidade = maxSanidade;
    }

    public short getSanidadeAtual() {
        return sanidadeAtual;
    }

    public void setSanidadeAtual(short sanidade) {
        this.sanidadeAtual = sanidade;
    }

    public short getSorte() {
        return sorte;
    }

    public void setSorte(short sorte) {
        this.sorte = sorte;
    }
    
    

    public Item[] getInventario() throws ArrayIndexOutOfBoundsException{
        return inventario;
    }

    public void setInventario(Item[] inventario) throws ArrayIndexOutOfBoundsException{
        this.inventario = inventario;
    }
    
    
    
    public FolhaDeHabilidades getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(FolhaDeHabilidades habilidades) {
        this.habilidades = habilidades;
    }
    
}
