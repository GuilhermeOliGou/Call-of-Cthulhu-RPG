package RegrasDeNegocio;

import DTO.ElementosDeSistema.EventoAvancado;
import DTO.Personagens.Jogador;
import Utilidades.Log;

public class TesteItem {
    
    //ATRIBUTOS
    
    private final int INVENTARIOMAXIMO;
    private final int EXIGENCIAMAXIMA;
    
    private Jogador jogador;
    
    //CONSTRUTORES

    public TesteItem() {
        super();
        
        this.INVENTARIOMAXIMO = -1;
        this.EXIGENCIAMAXIMA = -1;
    }

    public TesteItem(Jogador jogador) {
        super();
        
        this.INVENTARIOMAXIMO = 20;
        this.EXIGENCIAMAXIMA = 5;
        
        this.jogador = jogador;
    }

    public TesteItem(int INVENTARIOMAXIMO, int EXIGENCIAMAXIMA, Jogador jogador) {
        super();
        
        this.INVENTARIOMAXIMO = INVENTARIOMAXIMO;
        this.EXIGENCIAMAXIMA = EXIGENCIAMAXIMA;
        
        this.jogador = jogador;
    }
    
    //FUNÇÕES AUXILIARES
    
    private boolean PossuiItem(int id){
        for (int i = 0 ; i < this.INVENTARIOMAXIMO; i++){
            try{
                if(this.jogador.getInventario()[i] == id)
                    return true;
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                Integer[] novoInventario = new Integer[this.INVENTARIOMAXIMO];
                System.arraycopy(jogador.getInventario(), 0, novoInventario, 0, 
                        jogador.getInventario().length);
                jogador.setInventario(novoInventario);
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                this.jogador.getInventario()[i] = -1;
            }
        }
        return false;
    }
    
    //FUNÇÕES
    
    public boolean TestaItens(EventoAvancado evento){
        for (int i = 0; i < this.EXIGENCIAMAXIMA; i++){
            try{
                if(!PossuiItem(evento.getItensNecessários()[i]))
                    return false;
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                Integer[] novoNecessarios = new Integer[this.EXIGENCIAMAXIMA];
                System.arraycopy(evento.getItensNecessários(), 0, novoNecessarios, 0, 
                        evento.getItensNecessários().length);
                evento.setItensNecessários(novoNecessarios);
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                evento.getItensNecessários()[i] = -1;
            }
        }
        return true;
    }
    
}