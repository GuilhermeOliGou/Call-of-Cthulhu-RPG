package BaseDados;
import BaseDados.Dao.Items.DaoArma;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
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

import java.util.List;

public class FacadeImplementada implements FacadeBaseDados{

    DaoItem daoItem;
    DaoArma daoArma;
    DaoConsumivel daoConsumivel;

    public FacadeImplementada(DaoItem daoItem, DaoArma daoArma, DaoConsumivel daoConsumivel){
        this.daoItem = daoItem;
        this.daoArma = daoArma;
        this.daoConsumivel = daoConsumivel;
    }


    //Eventos





    @Override
    public Evento LeEvento(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveEvento(Evento evento) throws BaseDadosException {

    }

    @Override
    public void AlteraEvento(Evento evento) throws BaseDadosException {

    }

    @Override
    public List<Evento> ListaEvento() throws BaseDadosException {
        return null;
    }

    @Override
    public EventoAvancado LeEventoAvancado(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveEventoAvancado(EventoAvancado eventoAvancado) throws BaseDadosException {

    }

    @Override
    public void AlteraEventoAvancado(EventoAvancado eventoAvancado) throws BaseDadosException {

    }

    @Override
    public List<EventoAvancado> ListaEventoAvancado() throws BaseDadosException {
        return null;
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

    @Override
    public List<Local> ListaLocal() throws BaseDadosException {
        return null;
    }





    //Resposta





    @Override
    public Resposta LeResposta(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveResposta(Resposta resposta) throws BaseDadosException {

    }

    @Override
    public void AlteraHabilidade(Resposta resposta) throws BaseDadosException {

    }

    @Override
    public List<Resposta> ListaResposta() throws BaseDadosException {
        return null;
    }




    //Arma





    @Override
    public Arma LeArma(int codigo) throws BaseDadosException {
        return daoArma.Busca(codigo);
    }

    @Override
    public void EscreveArma(Arma arma) throws BaseDadosException {
        daoArma.Insere(arma);
    }

    @Override
    public void AlteraArma(Arma arma) throws BaseDadosException {
        daoArma.Altera(arma);
    }

    @Override
    public List<Arma> ListaArmas() throws BaseDadosException {
        return daoArma.Lista();
    }

    @Override
    public List<Arma> ListaArmasPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }





    //Folha Dano





    @Override
    public Arma LeFolhaDano(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveFolhaDano(FolhaDano folhaDano) throws BaseDadosException {

    }

    @Override
    public void AlteraFolhaDano(FolhaDano folhaDano) throws BaseDadosException {

    }

    @Override
    public List<FolhaDano> ListaFolhaDano() throws BaseDadosException {
        return null;
    }




    //Item





    @Override
    public Item LeItem(int codigo) throws BaseDadosException {
        return daoItem.Busca(codigo);
    }

    @Override
    public void EscreveItem(Item item) throws BaseDadosException {
        daoItem.Insere(item);
    }

    @Override
    public void AlteraItem(Item item) throws BaseDadosException {
        daoItem.Altera(item);
    }

    @Override
    public List<Item> ListaItens() throws BaseDadosException {
        return daoItem.Lista();
    }


    public List<Item> ListaItensPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }





    //Consumivel






    @Override
    public ItemConsumivel LeItemConsumivel(int codigo) throws BaseDadosException {
        return daoConsumivel.Busca(codigo);
    }

    @Override
    public void EscreveItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException {
        daoConsumivel.Insere(itemConsumivel);
    }

    @Override
    public void AlteraItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException {
        daoConsumivel.Altera(itemConsumivel);
    }

    @Override
    public List<ItemConsumivel> ListaItensConsumiveis() throws BaseDadosException {
        return daoConsumivel.Lista();
    }

    @Override
    public List<ItemConsumivel> ListaItensConsumiveisPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }





    //Folha de Atributos






    @Override
    public FolhaDeAtributos LeFolhaDeAtributos(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveFolhaDeAtributos(FolhaDeAtributos folhaDeAtributos) throws BaseDadosException {

    }

    @Override
    public void AlteraFolhaDeAtributos(FolhaDeAtributos folhaDeAtributos) throws BaseDadosException {

    }

    @Override
    public List<FolhaDeAtributos> ListaFolhaDeAtributos() throws BaseDadosException {
        return null;
    }

    @Override
    public List<FolhaDeAtributos> FolhaDeAtributosPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }





    //Folha de Caracteristicas





    @Override
    public FolhaDeCaracteristicas LeFolhaDeCaracteristicas(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveFolhaDeCaracteristicas(FolhaDeCaracteristicas folhaDeCaracteristicas) throws BaseDadosException {

    }

    @Override
    public void AlteraFolhaDeCaracteristicas(FolhaDeCaracteristicas folhaDeCaracteristicas) throws BaseDadosException {

    }

    @Override
    public List<FolhaDeCaracteristicas> ListaFolhaDeCaracteristicas() throws BaseDadosException {
        return null;
    }

    @Override
    public List<FolhaDeCaracteristicas> FolhaDeCaracteristicasPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }





    //Folha de Habilidades




    @Override
    public FolhaDeHabilidades LeFolhaDeHabilidades(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades) throws BaseDadosException {

    }

    @Override
    public void AlteraFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades) throws BaseDadosException {

    }

    @Override
    public List<FolhaDeHabilidades> ListaFolhaDeHabilidades() throws BaseDadosException {
        return null;
    }

    @Override
    public List<FolhaDeHabilidades> FolhaDeHabilidadesPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
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

    @Override
    public List<Jogador> ListaJogadores() throws BaseDadosException {
        return null;
    }





    //Personagem





    @Override
    public Personagem LePersonagem(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscrevePersonagem(Personagem personagem) throws BaseDadosException {

    }

    @Override
    public void AlteraPersonagem(Personagem personagem) throws BaseDadosException {

    }

    @Override
    public List<Personagem> ListaPersonagens() throws BaseDadosException {
        return null;
    }





    //Habilidades Luta





    @Override
    public HabilidadesLuta LeHabilidadesLuta(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveHabilidadesLuta(HabilidadesLuta habilidadesLuta) throws BaseDadosException {

    }

    @Override
    public void AlteraHabilidadesLuta(HabilidadesLuta habilidadesLuta) throws BaseDadosException {

    }

    @Override
    public List<HabilidadesLuta> ListaHabilidadesLuta() throws BaseDadosException {
        return null;
    }

    @Override
    public List<HabilidadesLuta> HabilidadesLutaPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }




    //Habilidades Tiro






    @Override
    public HabilidadesTiro LeHabilidadesTiro(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveHabilidadesTiro(HabilidadesTiro HabilidadesTiro) throws BaseDadosException {

    }

    @Override
    public void AlteraHabilidadesTiro(HabilidadesTiro HabilidadesTiro) throws BaseDadosException {

    }

    @Override
    public List<HabilidadesTiro> ListaHabilidadesTiro() throws BaseDadosException {
        return null;
    }

    @Override
    public List<HabilidadesTiro> HabilidadesTiroPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }
}
