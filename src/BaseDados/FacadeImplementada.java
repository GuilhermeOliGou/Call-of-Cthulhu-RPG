package BaseDados;
import BaseDados.Dao.Items.DaoArma;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.Dao.Items.DaoItemGeral;
import BaseDados.Dao.Items.Utilidades.DaoFolhaDano;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesLutaItem;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesTiroItem;
import BaseDados.Dao.Personagem.Utilidades.DaoAtributos;
import BaseDados.DaoJDBC.Items.DaoArmaJdbc;
import BaseDados.DaoJDBC.Items.DaoConsumivelJdbc;
import BaseDados.DaoJDBC.Items.DaoItemGeralJdbc;
import BaseDados.DaoJDBC.Items.DaoItemJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.DaoFolhaDanoJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.HabilidadesLutaItemJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.HabilidadesTiroItemJdbc;
import BaseDados.DaoJDBC.Personagem.Utilidades.DaoAtributosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.ElementosDeSistema.Local;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.*;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;
import RegrasDeNegocio.FacadeBaseDados;
import java.io.IOException;

import java.util.List;

public class FacadeImplementada implements FacadeBaseDados {

    private DaoItemGeral daoItemGeral;

    public FacadeImplementada() throws BaseDadosException {
        DaoFolhaDano daoFolhaDano = new DaoFolhaDanoJdbc();
        DaoHabilidadesLutaItem daoLutaItem = new HabilidadesLutaItemJdbc();
        DaoHabilidadesTiroItem daoTiroItem = new HabilidadesTiroItemJdbc();

        DaoItem daoItem = new DaoItemJdbc();

        DaoArma daoArma = new DaoArmaJdbc(daoItem, daoFolhaDano, daoLutaItem, daoTiroItem);
        DaoConsumivel daoConsumivel = new DaoConsumivelJdbc(daoItem);

        this.daoItemGeral = new DaoItemGeralJdbc(daoItem, daoArma, daoConsumivel);
    }


    //Local


    @Override
    public Local LeLocal(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveLocal(Local local) throws BaseDadosException {

    }

    @Override
    public void AlteraLocal(Local local) throws BaseDadosException {

    }


    //Item


    @Override
    public Item LeItem(int codigo) throws BaseDadosException {
        return daoItemGeral.Busca(codigo);
    }

    @Override
    public void EscreveItem(Item item) throws BaseDadosException {
        daoItemGeral.Insere(item);
    }

    @Override
    public void AlteraItem(Item item) throws BaseDadosException {
        daoItemGeral.Altera(item);
    }


    //Jogador


    @Override
    public Jogador LeJogador(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveJogador(Jogador jogador) throws BaseDadosException {

    }

    @Override
    public void AlteraJogador(Jogador jogador) throws BaseDadosException {

    }

    public void RemoveJogador(int codigo) throws BaseDadosException {

    }

    @Override
    public List<Jogador> ListaJogadores() throws BaseDadosException {
        return null;
    }

}