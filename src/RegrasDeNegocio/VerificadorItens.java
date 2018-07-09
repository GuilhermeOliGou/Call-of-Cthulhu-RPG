package RegrasDeNegocio;

import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.Jogador;
import Utilidades.Log;

public class VerificadorItens {
    
    //ATRIBUTOS
    
    private final int INVENTARIOMAXIMO;
    private final int RETORNOMAXIMO;
    private final int SORTEPADRAO = 20;
    
    private final IntermediarioBaseDados BASEDADOS;
    
    private final GeradorDeItens GERADOR;
    
    private Jogador jogador;
    private String resposta;
    
    //CONSTRUOTORES

    public VerificadorItens() {
        super();
        
        this.INVENTARIOMAXIMO = -1;
        this.RETORNOMAXIMO = -1;
        
        this.BASEDADOS = null;
        
        this.GERADOR = new GeradorDeItens();
    }

    public VerificadorItens(int INVENTARIOMAXIMO, int RETORNOMAXIMO, 
            Jogador jogador, String resposta,
            IntermediarioBaseDados BASEDADOS) {
        super();
        
        this.INVENTARIOMAXIMO = INVENTARIOMAXIMO;
        this.RETORNOMAXIMO = RETORNOMAXIMO;
        
        this.BASEDADOS = BASEDADOS;
        
        this.GERADOR = new GeradorDeItens(BASEDADOS, jogador.getSorte());
        
        this.jogador = jogador;
        this.resposta = resposta;
    }

    public VerificadorItens(Jogador jogador, String resposta,
            IntermediarioBaseDados BASEDADOS) {
        super();
        
        this.INVENTARIOMAXIMO = 20;
        this.RETORNOMAXIMO = 5;
        
        this.BASEDADOS = BASEDADOS;
        
        GeradorDeItens gerador;
        try{
            gerador = new GeradorDeItens(BASEDADOS, jogador.getSorte());
        }catch(NullPointerException e){
            Log.gravaLog(e);
            
            gerador = new GeradorDeItens(BASEDADOS, this.SORTEPADRAO);
        }
        
        this.GERADOR = gerador;
        
        this.jogador = jogador;
        this.resposta = resposta;
    }
    
    //FUNÇÕES AUXILIARES
    
    private void RecriaVetores(){
        Integer[] novoInventario = new Integer[this.INVENTARIOMAXIMO];
        System.arraycopy(this.jogador.getInventario(), 0, novoInventario, 0, 
                this.jogador.getInventario().length);
        this.jogador.setInventario(novoInventario);

        Integer[] novasQuantidades = new Integer[this.INVENTARIOMAXIMO];
        System.arraycopy(this.jogador.getQuantidades(), 0, novasQuantidades, 0, 
                this.jogador.getQuantidades().length);
        this.jogador.setQuantidades(novasQuantidades);
    }
    
    private void RemoveItem(int posicao){
        try{
            this.resposta += BASEDADOS.CarregaItem(this.jogador.getInventario()[posicao]).getNome()
                    + " removido!";
            this.jogador.getQuantidades()[posicao]--;
            if (this.jogador.getQuantidades()[posicao] <= 0){
                while(posicao < this.INVENTARIOMAXIMO-1){
                    this.jogador.getInventario()[posicao] = this.jogador.getInventario()[posicao+1];
                    this.jogador.getQuantidades()[posicao] = this.jogador.getQuantidades()[posicao+1];
                    posicao++;
                }
            }
        }catch(RegraNegocioException e){
            Log.gravaLog(e);
            while(posicao < this.INVENTARIOMAXIMO-1){
                this.jogador.getInventario()[posicao] = this.jogador.getInventario()[posicao+1];
                this.jogador.getQuantidades()[posicao] = this.jogador.getQuantidades()[posicao+1];
                posicao++;
            }
            this.jogador.getInventario()[posicao] = -1;
            this.jogador.getQuantidades()[posicao] = 0;
        }
    }    
    
    private void AdicionaItem(int posicao,int id){
        try{ 
            int quantidadeAdicionada = GERADOR.GerarItem(id);  
            
            this.jogador.getInventario()[posicao] = id;
            this.jogador.getQuantidades()[posicao] += quantidadeAdicionada;   
            
            resposta += " " + quantidadeAdicionada + "x " + BASEDADOS.CarregaItem(id).getNome() + 
                    " adicionados!";
        }catch(RegraNegocioException e){
            Log.gravaLog(e);
            while(posicao < this.INVENTARIOMAXIMO-1){
                this.jogador.getInventario()[posicao] = this.jogador.getInventario()[posicao+1];
                this.jogador.getQuantidades()[posicao] = this.jogador.getQuantidades()[posicao+1];
                posicao++;
            }
            this.jogador.getInventario()[posicao] = -1;
            this.jogador.getQuantidades()[posicao] = 0;
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
        }
    }
    
    private void ChecaItemRemovido(int id){        
        for (int i = 0; i < this.INVENTARIOMAXIMO; i++){
            try{
                if(this.jogador.getInventario()[i] == id){
                    RemoveItem(i);
                    return;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
            
                RecriaVetores();
                return;
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                this.jogador.getInventario()[i] = -1;
                this.jogador.getQuantidades()[i] = 0;
            }
        }
    }
    
    private void ChecaItemAdicionados (int id){
        int posicaoVaga = -1;
        
        for (int i = 0; i < this.INVENTARIOMAXIMO; i++){
            try{
                if(this.jogador.getInventario()[i] == id){
                    AdicionaItem(i, id);
                    return;
                }else if (this.jogador.getInventario()[i] == -1)
                    posicaoVaga = i;
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
            
                RecriaVetores();
                
                AdicionaItem(i, id);
                return;
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                this.jogador.getInventario()[i] = -1;
                this.jogador.getQuantidades()[i] = 0; 
                
                posicaoVaga = i;
            }
        }
        AdicionaItem(posicaoVaga, id);
    }
    
    //FUNÇÕES
    
    public void ChecaItens(Resposta respostaEvento){
        for (int i = 0; i < this.RETORNOMAXIMO; i++){
            try{
                ChecaItemRemovido(respostaEvento.getItensRemovidos()[i]);
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                Integer[] novoRemovidos = new Integer[this.RETORNOMAXIMO];
                System.arraycopy(respostaEvento.getItensRemovidos(), 0, novoRemovidos, 0, 
                        respostaEvento.getItensRemovidos().length);
                respostaEvento.setItensRemovidos(novoRemovidos);
            }catch (NullPointerException e){
                Log.gravaLog(e);
                
                respostaEvento.getItensRemovidos()[i] = -1;
            }
        }
        for (int i = 0; i < this.RETORNOMAXIMO; i++){
            try{
                ChecaItemAdicionados(respostaEvento.getItensAdicionados()[i]);
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                Integer[] novoAdicionados = new Integer[this.RETORNOMAXIMO];
                System.arraycopy(respostaEvento.getItensAdicionados(), 0, novoAdicionados, 0, 
                        respostaEvento.getItensAdicionados().length);
                respostaEvento.setItensAdicionados(novoAdicionados);
            }catch (NullPointerException e){
                Log.gravaLog(e);
                
                respostaEvento.getItensAdicionados()[i] = -1;
            }
        }
    }
    
    //GETTERS E SETTERS

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
}