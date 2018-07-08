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
    
    private final IntermediarioBaseDados BASEDADOS;
    
    private final GeradorDeItens GERADOR;
    
    private Jogador jogador;
    private String resposta;
    private int[] quantidadeItens;
    
    //CONSTRUOTORES

    public VerificadorItens() {
        super();
        
        this.DADOS = new Dados();
        
        this.INVENTARIOMAXIMO = -1;
        this.RETORNOMAXIMO = -1;
        
        this.BASEDADOS = null;
        
        this.GERADOR = new GeradorDeItens();
    }

    public VerificadorItens(int INVENTARIOMAXIMO, int RETORNOMAXIMO, 
            Jogador jogador, String resposta, int[] quantidadeItens,
            IntermediarioBaseDados BASEDADOS) {
        super();
        
        this.DADOS = new Dados();
        
        this.INVENTARIOMAXIMO = INVENTARIOMAXIMO;
        this.RETORNOMAXIMO = RETORNOMAXIMO;
        
        this.BASEDADOS = BASEDADOS;
        
        this.GERADOR = new GeradorDeItens(BASEDADOS, jogador.getSorte());
        
        this.jogador = jogador;
        this.resposta = resposta;
        this.quantidadeItens = quantidadeItens;
    }

    public VerificadorItens(Jogador jogador, String resposta, int[] quantidadeItens,
            IntermediarioBaseDados BASEDADOS) {
        super();
        
        this.DADOS = new Dados();
        
        this.INVENTARIOMAXIMO = 20;
        this.RETORNOMAXIMO = 5;
        
        this.BASEDADOS = BASEDADOS;
        
        this.GERADOR = new GeradorDeItens(BASEDADOS, jogador.getSorte());
        
        this.jogador = jogador;
        this.resposta = resposta;
        this.quantidadeItens = quantidadeItens;
    }
    
    //FUNÇÕES AUXILIARES
    
    private void RecriaVetores(){
        Item[] novoInventario = new Item[20];
        System.arraycopy(this.jogador.getInventario(), 0, novoInventario, 0, 
                this.jogador.getInventario().length);
        this.jogador.setInventario(novoInventario);

        int[] novasQuantidades = new int[20];
        System.arraycopy(this.quantidadeItens, 0, novasQuantidades, 0, this.quantidadeItens.length);
        this.quantidadeItens = novasQuantidades;
    }
    
    private void RemoveItem(int posicao){
        this.quantidadeItens[posicao]--;
        this.resposta += this.jogador.getInventario()[posicao].getNome() + " removido!";
        if (this.quantidadeItens[posicao] <= 0){
            while(posicao < this.INVENTARIOMAXIMO-1){
                this.jogador.getInventario()[posicao] = this.jogador.getInventario()[posicao+1];
                this.quantidadeItens[posicao] = this.quantidadeItens[posicao+1];
                posicao++;
            }
        }
    }    
    
    private void AdicionaItem(int posicao,int id){
        try{
            Item novoItem = BASEDADOS.CarregaItem(id);
            this.jogador.getInventario()[posicao] = novoItem;
            quantidadeItens[posicao] += GERADOR.GerarItem(id);
        }catch(RegraNegocioException e){
            Log.gravaLog(e);
        }
    }
    
    private void ChecaItemRemovido(int id){
        if (id < 0)
            return;
        int i = 0;
        try{
            while (i < this.INVENTARIOMAXIMO){
                if(this.jogador.getInventario()[i].getId() == id){
                    RemoveItem(i);
                    return;
                }
                i++;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
            
            RecriaVetores();
            
            while(i < this.INVENTARIOMAXIMO){
                if(this.jogador.getInventario()[i].getId() == id){
                    RemoveItem(i);
                    return;
                }
                i++;
            }
        }
    }
    
    private void ChecaItensAdicionados (int id){
        if (id < 0)
            return;
        int i = 0;
        try{
            while (i < this.INVENTARIOMAXIMO){
                if(this.jogador.getInventario()[i].getId() == id){
                    AdicionaItem(i, id);
                    return;
                }else if (this.jogador.getInventario()[i] == null)
                    break;
                i++;
            }
            AdicionaItem(i, id);
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
            
            RecriaVetores();
            
            while (i < this.INVENTARIOMAXIMO){
                if(this.jogador.getInventario()[i].getId() == id){
                    AdicionaItem(i, id);
                    return;
                }else if (this.jogador.getInventario()[i] == null)
                    break;
                i++;
            }
            AdicionaItem(i, id);
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
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
            
        }
    }
    
}