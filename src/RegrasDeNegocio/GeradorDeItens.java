package RegrasDeNegocio;

import DTO.Itens.Arma;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;
import utilidades.Log;

public class GeradorDeItens {
    
    //ATRIBUTOS
    
    private final IntermediarioBaseDados BASEDADOS;
    private final Dados DADOS;
    private final int SORTEJOGADOR;
    
    //CONSTRUTORES

    public GeradorDeItens() {
        super();
        
        this.BASEDADOS = null;
        this.DADOS = new Dados();
        this.SORTEJOGADOR = -1;
    }

    public GeradorDeItens(IntermediarioBaseDados BASEDADOS,int SORTEJOGADOR) {
        super();
        
        this.BASEDADOS = BASEDADOS;
        this.DADOS = new Dados();
        this.SORTEJOGADOR = SORTEJOGADOR;
    }
    
    //FUNÇÕES AUXILIARES
    
    private int TesouroMaximo(int encontrado, int maximo){
        if(encontrado > maximo)
            return maximo;
        return encontrado;
    }
    
    //FUNÇÕES
    
    public int GerarItem(int id){
        try{
            Item novoItem = this.BASEDADOS.CarregaItem(id);
            if (novoItem instanceof Arma){
                int pente = ((Arma) novoItem).getTamanhoDoPente();
                if(pente <= 0){
                    return 1;
                }else{
                    if (DADOS.TesteDePorcentagem() <= SORTEJOGADOR){
                        return TesouroMaximo(DADOS.D12()+DADOS.D20(), pente+(int)(pente/2));
                    }else{
                        return TesouroMaximo(DADOS.D10()+DADOS.D12(), pente);
                    }
                }
            }else if (novoItem instanceof ItemConsumivel){
                if (DADOS.TesteDePorcentagem() <= SORTEJOGADOR){
                    return DADOS.D6();
                }else{
                    return DADOS.D4();
                }
            }else
                return 1;
        }catch(RegraNegocioException e){
            Log.gravaLog(e);
            return -1;
        }
    }
    
}
