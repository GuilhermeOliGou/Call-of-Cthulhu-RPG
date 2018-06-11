package BaseDados;
import ElementosDeJogo.Itens.ItemConsumivel;
import Visualizacao.Personagem;

import java.util.List;

public class DaoConsumivelJdbc implements DaoConsumivel{
    @Override
    public ItemConsumivel BuscaItemConsumivel(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException {

    }

    @Override
    public void AlteraItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException {

    }

    @Override
    public List<ItemConsumivel> ListaItensConsumiveis() throws BaseDadosException {
        return null;
    }

    @Override
    public List<ItemConsumivel> ListaItensConsumiveisPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }
}
