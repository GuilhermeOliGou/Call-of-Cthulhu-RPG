package BaseDados;

import BaseDados.Dao.*;
import BaseDados.Dao.Evento.DaoEventoJogador;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoAvancado;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoBase;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoGeral;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoLuta;
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
import BaseDados.Dao.Personagem.Utilidades.DaoAtributos;
import BaseDados.Dao.Personagem.Utilidades.DaoCaracteristicas;
import BaseDados.DaoJDBC.Eventos.DaoEventoAvancadoJdbc;
import BaseDados.DaoJDBC.Eventos.DaoEventoBaseJdbc;
import BaseDados.DaoJDBC.Eventos.DaoEventoLutaJdbc;
import BaseDados.DaoJDBC.Eventos.Geral.*;
import BaseDados.DaoJDBC.Eventos.Utilidades.*;
import BaseDados.DaoJDBC.Eventos.Utilidades.Resposta.*;
import BaseDados.DaoJDBC.Items.*;
import BaseDados.DaoJDBC.Items.Utilidades.DaoFolhaDanoJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.HabilidadesLutaItemJdbc;
import BaseDados.DaoJDBC.Items.Utilidades.HabilidadesTiroItemJdbc;
import BaseDados.DaoJDBC.Personagem.DaoJogadorJdbc;
import BaseDados.DaoJDBC.Personagem.DaoPersonagemJdbc;
import BaseDados.DaoJDBC.Personagem.Utilidades.DaoAtributosJdbc;
import BaseDados.DaoJDBC.Personagem.Utilidades.DaoCaracteristicasJdbc;
import DTO.ElementosDeSistema.Local;
import DTO.Itens.Item;
import DTO.Personagens.Jogador;
import RegrasDeNegocio.FacadeBaseDados;

import java.util.List;

public class FacadeBaseDadosConcreta implements FacadeBaseDados {

    private Popula popula;
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

        this.daoJogo = new DaoJogoJdbc(daoJogador, daoEventoJogador, daoLocal);

        this.popula = new Popula();
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


    public void InicializaBancoDados() throws BaseDadosException {
        popula.criaTabelas();
        popula.populaTabelas();
    }
    public void ResetaBancoDados() throws BaseDadosException {
        popula.esvaziaTabelas();
        InicializaBancoDados();
    }
}