package RegrasDeNegocio;

import BaseDados.BaseDadosException;
import ElementosDeJogo.Itens.Arma;
import ElementosDeJogo.Itens.FolhaDano;
import ElementosDeJogo.Itens.Item;
import ElementosDeJogo.Itens.ItemConsumivel;
import ElementosDeJogo.Personagens.FolhaDeAtributos;
import ElementosDeJogo.Personagens.FolhaDeCaracteristicas;
import ElementosDeJogo.Personagens.Habilidades.FolhaDeHabilidades;
import ElementosDeJogo.Personagens.Habilidades.HabilidadesCiencia;
import ElementosDeJogo.Personagens.Habilidades.HabilidadesInterpessoais;
import ElementosDeJogo.Personagens.Habilidades.HabilidadesLuta;
import ElementosDeJogo.Personagens.Habilidades.HabilidadesTiro;
import ElementosDeJogo.Personagens.Jogador;
import ElementosDeJogo.Personagens.Personagem;
import java.util.List;

interface FacadeBaseDados {
    
    //ITENS
  
    public Item LeItem(int codigo) throws BaseDadosException;

    public void EscreveItem(Item item) throws BaseDadosException;
    
    public void AlteraItem(Item item) throws BaseDadosException;

    public List<Item> ListaItens() throws BaseDadosException;

    public List<Item> ListaItensPersonagem(Personagem personagem) throws BaseDadosException;
    
    

    public ItemConsumivel LeItemConsumivel(int codigo) throws BaseDadosException;

    public void EscreveItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException;

    public void AlteraItemConsumivel(ItemConsumivel itemConsumivel) throws BaseDadosException;

    public List<ItemConsumivel> ListaItensConsumiveis() throws BaseDadosException;

    public List<ItemConsumivel> ListaItensConsumiveisPersonagem(Personagem personagem) throws BaseDadosException;
    
    

    public Arma LeArma(int codigo) throws BaseDadosException;

    public void EscreveArma(Arma arma) throws BaseDadosException;

    public void AlteraArma(Arma arma) throws BaseDadosException;

    public List<Arma> ListaArmas() throws BaseDadosException;

    public List<Arma> ListaArmasPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public Arma LeFolhaDano(int codigo) throws BaseDadosException;

    public void EscreveFolhaDano(FolhaDano folhaDano) throws BaseDadosException;

    public void AlteraFolhaDano(FolhaDano folhaDano) throws BaseDadosException;

    public List<FolhaDano> ListaFolhaDano() throws BaseDadosException;

    //JOGADOR E PERSONAGENS

    public Jogador LeJogador(int codigo) throws BaseDadosException;

    public void EscreveJogador(Jogador jogador) throws BaseDadosException;
    
    public void AlteraJogador(Jogador jogador) throws BaseDadosException;

    public List<Jogador> ListaJogadores() throws BaseDadosException;
    
    

    public Personagem LePersonagem(int codigo) throws BaseDadosException;

    public void EscrevePersonagem(Personagem personagem) throws BaseDadosException;
    
    public void AlteraPersonagem(Personagem personagem) throws BaseDadosException;

    public List<Personagem> ListaPersonagens() throws BaseDadosException;
    
    //FOLHAS DE PERSONAGENS
    
    public FolhaDeAtributos LeFolhaDeAtributos(int codigo) throws BaseDadosException;

    public void EscreveFolhaDeAtributos(FolhaDeAtributos folhaDeAtributos) throws BaseDadosException;
    
    public void AlteraFolhaDeAtributos(FolhaDeAtributos folhaDeAtributos) throws BaseDadosException;

    public List<FolhaDeAtributos> ListaFolhaDeAtributos() throws BaseDadosException;

    public List<FolhaDeAtributos> FolhaDeAtributosPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public FolhaDeCaracteristicas LeFolhaDeCaracteristicas(int codigo) throws BaseDadosException;

    public void EscreveFolhaDeCaracteristicas(FolhaDeCaracteristicas folhaDeCaracteristicas) throws BaseDadosException;
    
    public void AlteraFolhaDeCaracteristicas(FolhaDeCaracteristicas folhaDeCaracteristicas) throws BaseDadosException;

    public List<FolhaDeCaracteristicas> ListaFolhaDeCaracteristicas() throws BaseDadosException;

    public List<FolhaDeCaracteristicas> FolhaDeCaracteristicasPersonagem(Personagem personagem) throws BaseDadosException;
    
    //HABILIDADES
    
    public FolhaDeHabilidades LeFolhaDeHabilidades(int codigo) throws BaseDadosException;

    public void EscreveFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades) throws BaseDadosException;
    
    public void AlteraFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades) throws BaseDadosException;

    public List<FolhaDeHabilidades> ListaFolhaDeHabilidades() throws BaseDadosException;

    public List<FolhaDeHabilidades> FolhaDeHabilidadesPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public HabilidadesCiencia LeHabilidadesCiencia(int codigo) throws BaseDadosException;

    public void EscreveHabilidadesCiencia(HabilidadesCiencia habilidadesCiencia) throws BaseDadosException;
    
    public void AlteraHabilidadesCiencia(HabilidadesCiencia habilidadesCiencia) throws BaseDadosException;

    public List<HabilidadesCiencia> ListaHabilidadesCiencia() throws BaseDadosException;

    public List<HabilidadesCiencia> HabilidadesCienciaPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public HabilidadesInterpessoais LeHabilidadesInterpessoais(int codigo) throws BaseDadosException;

    public void EscreveHabilidadesInterpessoais(HabilidadesInterpessoais habilidadesInterpessoais) throws BaseDadosException;
    
    public void AlteraHabilidadesInterpessoais(HabilidadesInterpessoais habilidadesInterpessoais) throws BaseDadosException;

    public List<HabilidadesInterpessoais> ListaHabilidadesInterpessoais() throws BaseDadosException;

    public List<HabilidadesInterpessoais> HabilidadesInterpessoaisPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public HabilidadesLuta LeHabilidadesLuta(int codigo) throws BaseDadosException;

    public void EscreveHabilidadesLuta(HabilidadesLuta habilidadesLuta) throws BaseDadosException;
    
    public void AlteraHabilidadesLuta(HabilidadesLuta habilidadesLuta) throws BaseDadosException;

    public List<HabilidadesLuta> ListaHabilidadesLuta() throws BaseDadosException;

    public List<HabilidadesLuta> HabilidadesLutaPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public HabilidadesTiro LeHabilidadesTiro(int codigo) throws BaseDadosException;

    public void EscreveHabilidadesTiro(HabilidadesTiro HabilidadesTiro) throws BaseDadosException;
    
    public void AlteraHabilidadesTiro(HabilidadesTiro HabilidadesTiro) throws BaseDadosException;

    public List<HabilidadesTiro> ListaHabilidadesTiro() throws BaseDadosException;

    public List<HabilidadesTiro> HabilidadesTiroPersonagem(Personagem personagem) throws BaseDadosException;

}