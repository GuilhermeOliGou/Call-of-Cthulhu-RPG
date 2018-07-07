package RegrasDeNegocio;

import DTO.ElementosDeSistema.Resposta;
import DTO.Itens.Item;
import DTO.Personagens.Jogador;
import utilidades.Log;

public class VerificadorItens {
    
    //ATRIBUTOS
    
    private final Dados DADOS;
    
    private final int INVENTARIOMAXIMO;
    private final int RETORNOMAXIMO;
    
    private Jogador jogador;
    private String resposta;
    private int[] quantidadeItens;
    
    //CONSTRUOTORES

    public VerificadorItens() {
        super();
        
        this.DADOS = new Dados();
        
        this.INVENTARIOMAXIMO = -1;
        this.RETORNOMAXIMO = -1;
    }

    public VerificadorItens(int INVENTARIOMAXIMO, int RETORNOMAXIMO, 
            Jogador jogador, String resposta, int[] quantidadeItens) {
        super();
        
        this.DADOS = new Dados();
        
        this.INVENTARIOMAXIMO = INVENTARIOMAXIMO;
        this.RETORNOMAXIMO = RETORNOMAXIMO;
        
        this.jogador = jogador;
        this.resposta = resposta;
        this.quantidadeItens = quantidadeItens;
    }

    public VerificadorItens(Jogador jogador, String resposta, int[] quantidadeItens) {
        super();
        
        this.DADOS = new Dados();
        
        this.INVENTARIOMAXIMO = 20;
        this.RETORNOMAXIMO = 5;
        
        this.jogador = jogador;
        this.resposta = resposta;
        this.quantidadeItens = quantidadeItens;
    }
    
    //FUNÇÕES AUXILIARES
    
    private void AdicionaItem(int posicao,int id){
        
    }
    
    private void ChecaItemRemovido(int id){
        if (id < 0)
            return;
        try{
            int i;
            for (i = 0; i < this.INVENTARIOMAXIMO; i++){
                if(this.jogador.getInventario()[i].getId() == id){
                    this.quantidadeItens[i]--;
                    this.resposta += this.jogador.getInventario()[i].getNome() + " removido!";
                    if (this.quantidadeItens[i] <= 0){
                        while(i < this.INVENTARIOMAXIMO-1){
                            this.jogador.getInventario()[i] = this.jogador.getInventario()[i+1];
                            this.quantidadeItens[i] = this.quantidadeItens[i+1];
                            i++;
                        }
                    }
                    return;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
            
            Item[] novoInventario = new Item[20];
            System.arraycopy(this.jogador.getInventario(), 0, novoInventario, 0, 
                    this.jogador.getInventario().length);
            this.jogador.setInventario(novoInventario);
            
            int[] novasQuantidades = new int[20];
            System.arraycopy(this.quantidadeItens, 0, novasQuantidades, 0, this.quantidadeItens.length);
            this.quantidadeItens = novasQuantidades;
            
            ChecaItemRemovido(id);
        }
    }
    
    private void ChecaItensAdicionados (int id){
        if (id < 0)
            return;
        try{
            for (int i = 0; i < this.INVENTARIOMAXIMO; i++){
                if(this.jogador.getInventario()[i].getId() == id){
                    
                    return;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
            
            Item[] novoInventario = new Item[20];
            System.arraycopy(this.jogador.getInventario(), 0, novoInventario, 0, 
                    this.jogador.getInventario().length);
            this.jogador.setInventario(novoInventario);
            
            int[] novasQuantidades = new int[20];
            System.arraycopy(this.quantidadeItens, 0, novasQuantidades, 0, this.quantidadeItens.length);
            this.quantidadeItens = novasQuantidades;
            
            ChecaItemRemovido(id);
        }
    }
    
    //FUNÇÕES
    
    public void ChecaItens(Resposta resposta){
        int i;
        try{
            for (i = 0; i < this.RETORNOMAXIMO; i++){
                ChecaItemRemovido(resposta.getItensRemovidos()[i]);
                ChecaItensAdicionados(resposta.getItensAdicionados()[i]);
            }
        }
    }
    
}
