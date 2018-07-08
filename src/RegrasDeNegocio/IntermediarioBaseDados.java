package RegrasDeNegocio;

import BaseDados.BaseDadosException;
import BaseDados.FacadeImplementada;
import DTO.ElementosDeSistema.Local;
import DTO.Itens.Item;
import DTO.Personagens.Jogador;
import java.util.ArrayList;
import java.util.List;
import utilidades.Log;

public class IntermediarioBaseDados {

    //ATRIBUTOS
    
    private final FacadeBaseDados BASEDADOS;
    
    private ArrayList<Jogador> jogadoresCarregados;
    private ArrayList<Item> itensCarregados;
    private ArrayList<Local> locaisCarregados;
    
    //CONSTRUTORES

    public IntermediarioBaseDados() throws RegraNegocioException{
        super();
        
        try{
            this.BASEDADOS = new FacadeImplementada();   
        }catch (BaseDadosException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("FALHA AO INSTANCIAR OS ARQUIVOS DE JOGO!");
        }     
    }    
    
    //FUNÇÕES
    
    public Jogador CarregaJogador(int codigo) throws RegraNegocioException{
        for (Jogador j : jogadoresCarregados){
            if (j.getId() == codigo)
                return j;
        }
        if (jogadoresCarregados.size() >= 10){
            jogadoresCarregados.remove(0);
        }
        try{
            Jogador novo = this.BASEDADOS.LeJogador(codigo);
            jogadoresCarregados.add(novo);
            return novo;
        }catch(BaseDadosException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("CÓDIGO DE JOGADOR NÃO EXISTENTE");
        }        
    }
    
    public void CarregaTodosJogadores(){
        try{
            List<Jogador> todosJogadores = this.BASEDADOS.ListaJogadores();
            todosJogadores.forEach((j) -> {
                jogadoresCarregados.add(j);
            });
        }catch(BaseDadosException e){
            Log.gravaLog(e);
        }        
    }
    
    public ArrayList<Jogador> DevolveTodosJogadores(){
        return this.jogadoresCarregados;
    }
    
    public Jogador DevolveJogador(int indice){
        return jogadoresCarregados.get(indice);
    }
    
    public boolean ListaDeJogadoresVazia(){
        return this.jogadoresCarregados == null;
    }
    
    public void LimpaJogadores(){
        this.jogadoresCarregados = new ArrayList<>();
    }
    
    public Item CarregaItem(int codigo) throws RegraNegocioException{
        for (Item i : itensCarregados){
            if (i.getId() == codigo)
                return i;
        }
        if (itensCarregados.size() >= 10){
            itensCarregados.remove(0);
        }
        try{
            Item novo = this.BASEDADOS.LeItem(codigo);
            itensCarregados.add(novo);
            return novo;
        }catch(BaseDadosException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("CÓDIGO DE ITEM NÃO EXISTENTE");
        }        
    }
    
    public Local CarregaLocal(int codigo) throws RegraNegocioException{
        for (Local l : locaisCarregados){
            if (l.getID() == codigo)
                return l;
        }
        if (locaisCarregados.size() >= 10){
            locaisCarregados.remove(0);
        }
        try{
            Local novo = this.BASEDADOS.LeLocal(codigo);
            locaisCarregados.add(novo);
            return novo;
        }catch(BaseDadosException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("CÓDIGO DE LOCAL NÃO EXISTENTE");
        }        
    }
    
}
