package BaseDados;

import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;
import Visualizacao.Personagem;

import java.util.ArrayList;
import java.util.List;

public interface DaoItem {

    //Busca um Item especifico no Banco de Dados e retorna suas descricoes.
    public Item BuscaItem(int codigo) throws BaseDadosException;

    //Registra um Item "generico" no Banco de Dados
    public void EscreveItem(Item item) throws BaseDadosException;

    //Modifica um Item "generico" ja existente.
    public void AlteraItem(Item item) throws BaseDadosException;

    //Lista todos os Itens registrados no Banco de Dados.
    public List<Item> ListaItens() throws BaseDadosException;

    //Lista os Itens de um dado Personagem (Seja um Jogador ou um NPC)
    public List<Item> ListaItensPersonagem(int codigo) throws BaseDadosException;

}
