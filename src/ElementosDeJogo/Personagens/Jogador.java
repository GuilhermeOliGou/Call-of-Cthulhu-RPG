package ElementosDeJogo.Personagens;

import ElementosDeJogo.Itens.Item;
import ElementosDeJogo.Personagens.Habilidades.FolhaDeHabilidades;
import ElementosDeJogo.Sistema.Local;
import RegrasDeNegocio.RegraNegocioException;
import utilidades.Log;

public class Jogador extends Personagem {

    //ATRIBUTOS
    
    private short maxSanidade;
    private short sanidadeAtual;
    private short sorte;

    private FolhaDeHabilidades habilidades;
    
    //CONSTRUTORES
    
    public Jogador() {
        super();
    }
    
    public Jogador( int id, FolhaDeAtributos atributos, short idade, String nome, Local localidadeAtual,
            short maxSanidade, short sanidadeAtual, short sorte,
            Item[] inventario) throws RegraNegocioException{
        super(id,atributos,
                idade,nome, 
                inventario,localidadeAtual);
        
        this.maxSanidade = maxSanidade;
        this.sanidadeAtual = sanidadeAtual;
        this.sorte = sorte;
        
        try{
            this.habilidades = new FolhaDeHabilidades(atributos.getCaracteristicas().getDestreza());
        }catch(RegraNegocioException e){
            Log.gravaLog(e);
            throw new RegraNegocioException();
        }
    }
    
    //FUNÇÕES

    public String DescricaoJogador() throws RegraNegocioException{
        try{
            return nome + "(" + idade + " anos):\n" +
                    "Força: " + atributos.getCaracteristicas().getForca() + "\n" +
                    "Constituição: " + atributos.getCaracteristicas().getConstituicao() + "\n" +
                    "Tamanho: " + atributos.getCaracteristicas().getTamanho() + "\n" +
                    "Destreza: " + atributos.getCaracteristicas().getDestreza() + "\n" +
                    "Aparência: " + atributos.getCaracteristicas().getAparencia() + "\n" +
                    "Inteligência: " + atributos.getCaracteristicas().getInteligencia() + "\n" +
                    "Educação: " + atributos.getCaracteristicas().getEducacao() + "\n" +
                    "Poder: " + atributos.getCaracteristicas().getPoder();
        }catch(NullPointerException e){
            Log.gravaLog(e);
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
    
    
    
    public FolhaDeHabilidades getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(FolhaDeHabilidades habilidades) {
        this.habilidades = habilidades;
    }
    
}
