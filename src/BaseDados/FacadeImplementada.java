package BaseDados;
import BaseDados.DAO.DaoItem;
import BaseDados.DaoJDBC.DaoItemJdbc;
import Habilidades.FolhaDeHabilidadesCombateCienciaInterpessoal;
import DTO.Personagens.SetsDeHabilidade.HabilidadesCiencia;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesInterpessoais;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.Jogador;
import DTO.Personagens.Personagem;
import RegrasDeNegocio.FacadeBaseDados;

import java.io.IOException;
import java.util.List;

public class FacadeImplementada implements FacadeBaseDados{
    DaoItem daoItem = new DaoItemJdbc();
    public FacadeImplementada() throws IOException {
    }

    @Override
    public Item LeItem(int codigo) throws BaseDadosException {
        return daoItem.BuscaItem(codigo);
    }

    @Override
    public void EscreveItem(Item item) throws BaseDadosException {
        daoItem.EscreveItem(item);
    }

    @Override
    public void AlteraItem(Item item) throws BaseDadosException {
        daoItem.AlteraItem(item);
    }

    @Override
    public List<Item> ListaItens() throws BaseDadosException {
        return daoItem.ListaItens();
    }

    @Override
    public List<Item> ListaItensPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }

    @Override
    public ItemConsumivel LeItemConsumivel(int codigo) throws BaseDadosException {
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

    @Override
    public Arma LeArma(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveArma(Arma arma) throws BaseDadosException {

    }

    @Override
    public void AlteraArma(Arma arma) throws BaseDadosException {

    }

    @Override
    public List<Arma> ListaArmas() throws BaseDadosException {
        return null;
    }

    @Override
    public List<Arma> ListaArmasPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }

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

    @Override
    public FolhaDeHabilidadesCombateCienciaInterpessoal LeFolhaDeHabilidades(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveFolhaDeHabilidades(FolhaDeHabilidadesCombateCienciaInterpessoal folhaDeHabilidades) throws BaseDadosException {

    }

    @Override
    public void AlteraFolhaDeHabilidades(FolhaDeHabilidadesCombateCienciaInterpessoal folhaDeHabilidades) throws BaseDadosException {

    }

    @Override
    public List<FolhaDeHabilidadesCombateCienciaInterpessoal> ListaFolhaDeHabilidades() throws BaseDadosException {
        return null;
    }

    @Override
    public List<FolhaDeHabilidadesCombateCienciaInterpessoal> FolhaDeHabilidadesPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }

    @Override
    public HabilidadesCiencia LeHabilidadesCiencia(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveHabilidadesCiencia(HabilidadesCiencia habilidadesCiencia) throws BaseDadosException {

    }

    @Override
    public void AlteraHabilidadesCiencia(HabilidadesCiencia habilidadesCiencia) throws BaseDadosException {

    }

    @Override
    public List<HabilidadesCiencia> ListaHabilidadesCiencia() throws BaseDadosException {
        return null;
    }

    @Override
    public List<HabilidadesCiencia> HabilidadesCienciaPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }

    @Override
    public HabilidadesInterpessoais LeHabilidadesInterpessoais(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveHabilidadesInterpessoais(HabilidadesInterpessoais habilidadesInterpessoais) throws BaseDadosException {

    }

    @Override
    public void AlteraHabilidadesInterpessoais(HabilidadesInterpessoais habilidadesInterpessoais) throws BaseDadosException {

    }

    @Override
    public List<HabilidadesInterpessoais> ListaHabilidadesInterpessoais() throws BaseDadosException {
        return null;
    }

    @Override
    public List<HabilidadesInterpessoais> HabilidadesInterpessoaisPersonagem(Personagem personagem) throws BaseDadosException {
        return null;
    }

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
