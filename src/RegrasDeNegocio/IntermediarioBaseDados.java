package RegrasDeNegocio;

import BaseDados.BaseDadosException;
import BaseDados.FacadeImplementada;
import DTO.ElementosDeSistema.Local;
import DTO.Itens.Item;
import DTO.Personagens.Jogador;
import java.util.ArrayList;
import utilidades.Log;

public class IntermediarioBaseDados {

    //ATRIBUTOS
    
    private final FacadeBaseDados baseDados;
    
    private ArrayList<Jogador> jogadoresCarregados;
    private ArrayList<Item> itensCarregados;
    private ArrayList<Local> locaisCarregados;
    
    //CONSTRUTORES

    public IntermediarioBaseDados() throws RegraNegocioException{
        super();
        
        try{
            this.baseDados = new FacadeImplementada();   
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
            Jogador novo = baseDados.LeJogador(codigo);
            jogadoresCarregados.add(novo);
            return novo;
        }catch(BaseDadosException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("CÓDIGO DE JOGADOR NÃO EXISTENTE");
        }        
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
            Item novo = baseDados.LeItem(codigo);
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
            Local novo = baseDados.LeLocal(codigo);
            locaisCarregados.add(novo);
            return novo;
        }catch(BaseDadosException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("CÓDIGO DE LOCAL NÃO EXISTENTE");
        }        
    }
    
}
