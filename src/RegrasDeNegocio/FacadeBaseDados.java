package RegrasDeNegocio;

import DTO.ElementosDeSistema.*;
import DTO.Itens.*;
import DTO.Personagens.*;
import DTO.Personagens.SetsDeHabilidade.*;

import BaseDados.BaseDadosException;
import java.util.List;

public interface FacadeBaseDados {
    
    

    //ELEMENTOS DE SISTEMA
    
    
    
    public Evento LeEvento(int codigo) throws BaseDadosException;
    
    public void EscreveEvento(Evento evento) throws BaseDadosException;
    
    public void AlteraEvento(Evento evento) throws BaseDadosException;
    
    public List<Evento> ListaEvento() throws BaseDadosException;
    
    
    
    public EventoAvancado LeEventoAvancado(int codigo) throws BaseDadosException;
    
    public void EscreveEventoAvancado(EventoAvancado eventoAvancado) throws BaseDadosException;
    
    public void AlteraEventoAvancado(EventoAvancado eventoAvancado) throws BaseDadosException;
    
    public List<EventoAvancado> ListaEventoAvancado() throws BaseDadosException;
    
    
        
    public Local LeLocal(int codigo) throws BaseDadosException;
    
    public void EscreveLocal(Local local) throws BaseDadosException;
    
    public void AlteraLocal(Local local) throws BaseDadosException;
    
    public List<Local> ListaLocal() throws BaseDadosException;
    
    
    
    public Resposta LeResposta(int codigo) throws BaseDadosException;
    
    public void EscreveResposta(Resposta resposta) throws BaseDadosException;
    
    public void AlteraHabilidade(Resposta resposta) throws BaseDadosException;
    
    public List<Resposta> ListaResposta() throws BaseDadosException;
    
    
    
    //ITENS
    
    

    public Arma LeArma(int codigo) throws BaseDadosException;

    public void EscreveArma(Arma arma) throws BaseDadosException;

    public void AlteraArma(Arma arma) throws BaseDadosException;

    public List<Arma> ListaArmas() throws BaseDadosException;

    public List<Arma> ListaArmasPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public Arma LeFolhaDano(int codigo) throws BaseDadosException;

    public void EscreveFolhaDano(FolhaDano folhaDano) throws BaseDadosException;

    public void AlteraFolhaDano(FolhaDano folhaDano) throws BaseDadosException;

    public List<FolhaDano> ListaFolhaDano() throws BaseDadosException;
    
    
  
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
    
    

    //PERSONAGENS
    
    
    
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
    
    
    
    public FolhaDeHabilidades LeFolhaDeHabilidades(int codigo) throws BaseDadosException;

    public void EscreveFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades) throws BaseDadosException;
    
    public void AlteraFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades) throws BaseDadosException;

    public List<FolhaDeHabilidades> ListaFolhaDeHabilidades() throws BaseDadosException;

    public List<FolhaDeHabilidades> FolhaDeHabilidadesPersonagem(Personagem personagem) throws BaseDadosException;
    
    

    public Jogador LeJogador(int codigo) throws BaseDadosException;

    public void EscreveJogador(Jogador jogador) throws BaseDadosException;
    
    public void AlteraJogador(Jogador jogador) throws BaseDadosException;

    public List<Jogador> ListaJogadores() throws BaseDadosException;
    
    

    public Personagem LePersonagem(int codigo) throws BaseDadosException;

    public void EscrevePersonagem(Personagem personagem) throws BaseDadosException;
    
    public void AlteraPersonagem(Personagem personagem) throws BaseDadosException;

    public List<Personagem> ListaPersonagens() throws BaseDadosException;
    
    
        
    //PERSONAGENS : SETS DE HABILIDADE 
    
    
    
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