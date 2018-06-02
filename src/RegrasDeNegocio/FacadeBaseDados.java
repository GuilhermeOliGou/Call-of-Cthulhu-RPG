package RegrasDeNegocio;

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
  
    public Item LeItem(int codigo);

    public void EscreveItem(Item item);
    
    public void AlteraItem(Item item);

    public List<Item> ListaItens();

    public List<Item> ListaItensPersonagem(Personagem personagem);
    
    

    public ItemConsumivel LeItemConsumivel(int codigo);

    public void EscreveItemConsumivel(ItemConsumivel itemConsumivel);

    public void AlteraItemConsumivel(ItemConsumivel itemConsumivel);

    public List<ItemConsumivel> ListaItensConsumiveis();

    public List<ItemConsumivel> ListaItensConsumiveisPersonagem(Personagem personagem);
    
    

    public Arma LeArma(int codigo);

    public void EscreveArma(Arma arma);

    public void AlteraArma(Arma arma);

    public List<Arma> ListaArmas();

    public List<Arma> ListaArmasPersonagem(Personagem personagem);
    
    
    
    public Arma LeFolhaDano(int codigo);

    public void EscreveFolhaDano(FolhaDano folhaDano);

    public void AlteraFolhaDano(FolhaDano folhaDano);

    public List<FolhaDano> ListaFolhaDano();

    //JOGADOR E PERSONAGENS

    public Jogador LeJogador(int codigo);

    public void EscreveJogador(Jogador jogador);
    
    public void AlteraJogador(Jogador jogador);

    public List<Jogador> ListaJogadores();
    
    

    public Personagem LePersonagem(int codigo);

    public void EscrevePersonagem(Personagem personagem);
    
    public void AlteraPersonagem(Personagem personagem);

    public List<Personagem> ListaPersonagens();
    
    //FOLHAS DE PERSONAGENS
    
    public FolhaDeAtributos LeFolhaDeAtributos(int codigo);

    public void EscreveFolhaDeAtributos(FolhaDeAtributos folhaDeAtributos);
    
    public void AlteraFolhaDeAtributos(FolhaDeAtributos folhaDeAtributos);

    public List<FolhaDeAtributos> ListaFolhaDeAtributos();

    public List<FolhaDeAtributos> FolhaDeAtributosPersonagem(Personagem personagem);
    
    
    
    public FolhaDeCaracteristicas LeFolhaDeCaracteristicas(int codigo);

    public void EscreveFolhaDeCaracteristicas(FolhaDeCaracteristicas folhaDeCaracteristicas);
    
    public void AlteraFolhaDeCaracteristicas(FolhaDeCaracteristicas folhaDeCaracteristicas);

    public List<FolhaDeCaracteristicas> ListaFolhaDeCaracteristicas();

    public List<FolhaDeCaracteristicas> FolhaDeCaracteristicasPersonagem(Personagem personagem);
    
    //HABILIDADES
    
    public FolhaDeHabilidades LeFolhaDeHabilidades(int codigo);

    public void EscreveFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades);
    
    public void AlteraFolhaDeHabilidades(FolhaDeHabilidades folhaDeHabilidades);

    public List<FolhaDeHabilidades> ListaFolhaDeHabilidades();

    public List<FolhaDeHabilidades> FolhaDeHabilidadesPersonagem(Personagem personagem);
    
    
    
    public HabilidadesCiencia LeHabilidadesCiencia(int codigo);

    public void EscreveHabilidadesCiencia(HabilidadesCiencia habilidadesCiencia);
    
    public void AlteraHabilidadesCiencia(HabilidadesCiencia habilidadesCiencia);

    public List<HabilidadesCiencia> ListaHabilidadesCiencia();

    public List<HabilidadesCiencia> HabilidadesCienciaPersonagem(Personagem personagem);
    
    
    
    public HabilidadesInterpessoais LeHabilidadesInterpessoais(int codigo);

    public void EscreveHabilidadesInterpessoais(HabilidadesInterpessoais habilidadesInterpessoais);
    
    public void AlteraHabilidadesInterpessoais(HabilidadesInterpessoais habilidadesInterpessoais);

    public List<HabilidadesInterpessoais> ListaHabilidadesInterpessoais();

    public List<HabilidadesInterpessoais> HabilidadesInterpessoaisPersonagem(Personagem personagem);
    
    
    
    public HabilidadesLuta LeHabilidadesLuta(int codigo);

    public void EscreveHabilidadesLuta(HabilidadesLuta habilidadesLuta);
    
    public void AlteraHabilidadesLuta(HabilidadesLuta habilidadesLuta);

    public List<HabilidadesLuta> ListaHabilidadesLuta();

    public List<HabilidadesLuta> HabilidadesLutaPersonagem(Personagem personagem);
    
    
    
    public HabilidadesTiro LeHabilidadesTiro(int codigo);

    public void EscreveHabilidadesTiro(HabilidadesTiro HabilidadesTiro);
    
    public void AlteraHabilidadesTiro(HabilidadesTiro HabilidadesTiro);

    public List<HabilidadesTiro> ListaHabilidadesTiro();

    public List<HabilidadesTiro> HabilidadesTiroPersonagem(Personagem personagem);

}