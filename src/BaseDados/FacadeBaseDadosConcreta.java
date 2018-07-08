package BaseDados;
import BaseDados.Dao.*;
import BaseDados.Dao.Evento.DaoEventoJogador;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.Dao.Evento.EventoGeral.*;
import BaseDados.Dao.Evento.Resposta.*;
import BaseDados.Dao.Items.DaoArma;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.Dao.Items.DaoItemGeral;
import BaseDados.Dao.Items.Utilidades.DaoFolhaDano;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesLutaItem;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesTiroItem;
import BaseDados.Dao.Personagem.DaoInventario;
import BaseDados.Dao.Personagem.DaoJogador;
import BaseDados.Dao.Personagem.DaoJogo;
import BaseDados.Dao.Personagem.DaoPersonagem;
import BaseDados.Dao.Personagem.Utilidades.*;
import BaseDados.DaoJDBC.Eventos.Geral.DaoJogoJdbc;
import BaseDados.DaoJDBC.Eventos.DaoEventoAvancadoJdbc;
import BaseDados.DaoJDBC.Eventos.DaoEventoBaseJdbc;
import BaseDados.DaoJDBC.Eventos.DaoEventoLutaJdbc;
import BaseDados.DaoJDBC.Eventos.Geral.DaoEventoGeralJdbc;
import BaseDados.DaoJDBC.Eventos.Geral.DaoEventoJogadorJdbc;
import BaseDados.DaoJDBC.Eventos.Geral.DaoLocalJdbc;
import BaseDados.DaoJDBC.Eventos.Geral.DaoRespostaJdbc;
import BaseDados.DaoJDBC.Eventos.Utilidades.*;
import BaseDados.DaoJDBC.Eventos.Utilidades.Resposta.*;
import BaseDados.DaoJDBC.Items.*;
import BaseDados.DaoJDBC.Items.Utilidades.DaoFolhaDanoJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.HabilidadesLutaItemJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.HabilidadesTiroItemJdbc;
import BaseDados.DaoJDBC.Personagem.DaoJogadorJdbc;
import BaseDados.DaoJDBC.Personagem.DaoPersonagemJdbc;
import BaseDados.DaoJDBC.Personagem.Utilidades.*;
import DTO.ElementosDeSistema.Local;
import DTO.Personagens.*;
import DTO.Itens.Item;
import RegrasDeNegocio.FacadeBaseDados;


import java.util.List;

public class FacadeBaseDadosConcreta implements FacadeBaseDados {

    private DaoItemGeral daoItemGeral;
    private DaoLocal daoLocal;

    private DaoJogo daoJogo;

    public FacadeBaseDadosConcreta() throws BaseDadosException {
        DaoFolhaDano daoFolhaDano = new DaoFolhaDanoJdbc();
        DaoHabilidadesLutaItem daoLutaItem = new HabilidadesLutaItemJdbc();
        DaoHabilidadesTiroItem daoTiroItem = new HabilidadesTiroItemJdbc();

        DaoItem daoItem = new DaoItemJdbc();

        DaoArma daoArma = new DaoArmaJdbc(daoItem, daoFolhaDano, daoLutaItem, daoTiroItem);
        DaoConsumivel daoConsumivel = new DaoConsumivelJdbc(daoItem);

        this.daoItemGeral = new DaoItemGeralJdbc(daoItem, daoArma, daoConsumivel);

        DaoCaracteristicas daoCaracteristicas = new DaoCaracteristicasJdbc();
        DaoAtributos daoAtributos = new DaoAtributosJdbc(daoCaracteristicas);

        DaoPersonagem daoPersonagem = new DaoPersonagemJdbc(daoAtributos);
        DaoInventario daoInventario = new DaoInventarioJdbc();
        DaoJogador daoJogador = new DaoJogadorJdbc(daoPersonagem, daoInventario);


        DaoHabilidadesLutaRespostaJdbc daoHabilidadesLutaRespostaJdbc = new DaoHabilidadesLutaRespostaJdbc();
        DaoHabilidadesTiroRespostaJdbc daoHabilidadesTiroRespostaJdbc = new DaoHabilidadesTiroRespostaJdbc();

        DaoHabilidadesResposta daoHabilidadesResposta = new DaoHabilidadesRespostaJdbc(daoHabilidadesLutaRespostaJdbc, daoHabilidadesTiroRespostaJdbc);

        DaoCaracteristicasResposta daoCaracteristicasResposta = new DaoCaracteristicasRespostaJdbc();
        DaoAtributosResposta daoAtributosResposta = new DaoAtributosRespostaJdbc(daoCaracteristicasResposta);

        DaoItemModificadoResposta daoItemModificadoResposta = new DaoItemModificadoRespostaJdbc();

        DaoResposta daoResposta = new DaoRespostaJdbc(daoAtributosResposta, daoHabilidadesResposta, daoItemModificadoResposta);


        DaoEventoBase daoEventoBase = new DaoEventoBaseJdbc(daoResposta);

        DaoItemRequerido daoItemRequerido = new DaoItemRequeridaJdbc();

        DaoHabilidadeTiroRequerida daoHabilidadeTiroRequerida = new DaoHabilidadeTiroRequeridaJdbc();
        DaoHabilidadesLutaRequerida daoHabilidadesLutaRequerida = new DaoHabilidadeLutaRequeridaJdbc();

        DaoCaracteristicaRequerida daoCaracteristicaRequerida = new DaoCaracteristicaRequeridaJdbc();
        DaoHabilidadeRequerida daoHabilidadeRequerida = new DaoHabilidadeRequeridaJdbc(daoHabilidadesLutaRequerida, daoHabilidadeTiroRequerida);

        DaoEventoAvancado daoEventoAvancado = new DaoEventoAvancadoJdbc(daoEventoBase, daoCaracteristicaRequerida, daoItemRequerido, daoHabilidadeRequerida);
        DaoEventoLuta daoEventoLuta =new DaoEventoLutaJdbc(daoEventoBase, daoPersonagem);

        DaoEventoJogador daoEventoJogador = new DaoEventoJogadorJdbc();

        DaoEventoGeral daoEventoGeral = new DaoEventoGeralJdbc(daoEventoBase, daoEventoAvancado, daoEventoLuta);
        this.daoLocal = new DaoLocalJdbc(daoEventoGeral, daoEventoJogador);

        this.daoJogo = new DaoJogoJdbc(daoJogador, daoEventoJogador);
    }


    //Local


    @Override
    public Local LeLocal(int idPersonagem, int idLocal) throws BaseDadosException {
        return daoLocal.Busca(idPersonagem, idLocal);
    }

    //Item


    @Override
    public Item LeItem(int codigo) throws BaseDadosException {
        return daoItemGeral.Busca(codigo);
    }


    //Jogador


    @Override
    public Jogador LeJogador(int codigo) throws BaseDadosException {
        return daoJogo.CarregaJogo(codigo);
    }

    @Override
    public void EscreveJogador(Jogador jogador) throws BaseDadosException {
        daoJogo.CriaJogo(jogador);
    }

    @Override
    public void AlteraJogador(List<Local> locais, Jogador jogador) throws BaseDadosException {
        daoJogo.SalvaJogo(locais, jogador);
    }

    public void RemoveJogador(int codigo) throws BaseDadosException {
        daoJogo.RemoveJogo(codigo);
    }

    @Override
    public List<Jogador> ListaJogadores() throws BaseDadosException {
        return daoJogo.ListaJogos();
    }

}