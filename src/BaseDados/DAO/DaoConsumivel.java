package BaseDados.DAO;

import BaseDados.BaseDadosException;
import DTO.Itens.ItemConsumivel;
import ;

import java.util.List;

public interface DaoConsumivel {
    //Busca um Item Consumivel no Banco de Dados
    public ItemConsumivel BuscaItemConsumivel(int codigo) throws BaseDadosException;

    //Registra um Item Consumivel no Banco de Dados
    public void EscreveItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException;

    //Modifica um Item Consumivel no Banco de Dados
    public void AlteraItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException;

    //Lista todos os Itens Consumiveis registrados no Banco de Dados
    public List<ItemConsumivel> ListaItensConsumiveis() throws BaseDadosException;

    //Lista os Itens Consumiveis de um dado Personagem (Seja um Jogador ou um NPC)
    public List<ItemConsumivel> ListaItensConsumiveisPersonagem(Personagem personagem) throws BaseDadosException;
}
