package RegrasDeNegocio;

import DTO.ElementosDeSistema.*;
import DTO.Itens.*;
import DTO.Personagens.*;
import DTO.Personagens.SetsDeHabilidade.*;

import BaseDados.BaseDadosException;
import java.util.List;

public interface FacadeBaseDados {
    
    

    //ELEMENTOS DE SISTEMA
    
    
        
    public Local LeLocal(int codigo) throws BaseDadosException;
    
    public void EscreveLocal(Local local) throws BaseDadosException;
    
    public void AlteraLocal(Local local) throws BaseDadosException;
    
    public List<Local> ListaLocal() throws BaseDadosException;
    
    
    
    //ITENS
    
    

    public Arma LeArma(int codigo) throws BaseDadosException;

    public void EscreveArma(Arma arma) throws BaseDadosException;

    public void AlteraArma(Arma arma) throws BaseDadosException;

    public List<Arma> ListaArmas() throws BaseDadosException;

    public List<Arma> ListaArmasPersonagem(Personagem personagem) throws BaseDadosException;
    
    
    
    public FolhaDano LeFolhaDano(int codigo) throws BaseDadosException;

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
    
    

    public Jogador LeJogador(int codigo) throws BaseDadosException;

    public void EscreveJogador(Jogador jogador) throws BaseDadosException;
    
    public void AlteraJogador(Jogador jogador) throws BaseDadosException;

    public List<Jogador> ListaJogadores() throws BaseDadosException;
    
    

    public Personagem LePersonagem(int codigo) throws BaseDadosException;

    public void EscrevePersonagem(Personagem personagem) throws BaseDadosException;
    
    public void AlteraPersonagem(Personagem personagem) throws BaseDadosException;

    public List<Personagem> ListaPersonagens() throws BaseDadosException;
    
    
        
    //PERSONAGENS : SETS DE HABILIDADE 


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