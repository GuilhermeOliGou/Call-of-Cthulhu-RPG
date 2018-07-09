package RegrasDeNegocio;

import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;
import DTO.Personagens.Jogador;
import DTO.Personagens.Personagem;
import Utilidades.Log;
import java.util.ArrayList;

public class ModeratorBatalha {
    
    //ATRIBUTOS
    
    private final Dados DADOS = new Dados();
    private final int MAXINVENTARIO;
    private final IntermediarioBaseDados BASEDADOS;
    
    private Jogador jogador;
    private Personagem inimigo;
    
    private ArrayList<Acao> acoes;
    
    private boolean seuTurno;
    private int contadorDeAcoes;
    private int pente;
    
    //CONSTRUTORES

    public ModeratorBatalha() {
        super();
        
        this.MAXINVENTARIO = 20;
        this.BASEDADOS = null;
    }

    public ModeratorBatalha(IntermediarioBaseDados baseDados, Jogador jogador) {
        super();
        
        this.MAXINVENTARIO = 20;
        this.BASEDADOS = baseDados;
        
        this.jogador = jogador;
    
        this.contadorDeAcoes = 0;
    }
    
    public ModeratorBatalha(int maxInventario, IntermediarioBaseDados baseDados, 
            Jogador jogador, Personagem inimigo) {
        super();
        
        this.MAXINVENTARIO = maxInventario;
        this.BASEDADOS = baseDados;
        
        this.jogador = jogador;
        this.inimigo = inimigo;
    
        this.contadorDeAcoes = 0;
    }
    
    //FUNÇÕES AUXILIARES
    
    private void GeraAcoesItem(int posicao, int id){
        try{
            Item tipoDeItem = this.BASEDADOS.CarregaItem(id);
            if (tipoDeItem instanceof Arma){
                Arma arma = (Arma)tipoDeItem;
                
                if (arma.getTamanhoDoPente() > 0){
                    this.acoes.add(new Acao(Acao.TipoAcao.ofensiva, "Atacar com " + tipoDeItem.getNome(),
                            id,1));
                    if(this.jogador.getInventario()[posicao] % arma.getTamanhoDoPente() == 0){
                        Acao recarregar = new Acao(Acao.TipoAcao.passiva, "Recarregar " + tipoDeItem.getNome(),
                                id,1);
                        recarregar.setValido(false);
                        this.acoes.add(recarregar);
                    }else{
                        this.acoes.add(new Acao(Acao.TipoAcao.passiva, "Recarregar " + tipoDeItem.getNome(),
                                id,1));
                    }
                    
                }else{
                    this.acoes.add(new Acao(Acao.TipoAcao.ofensiva, "Atacar com " + tipoDeItem.getNome(),
                            id,0));
                }
                
                if (arma.getHabilidadesUsadasTiro().getArremesso() > 0){
                    this.acoes.add(new Acao(Acao.TipoAcao.passiva, "Arremessar " + tipoDeItem.getNome(),
                            id,1));
                }
            }else if (tipoDeItem instanceof ItemConsumivel){
                this.acoes.add(new Acao(Acao.TipoAcao.passiva, "Consumir " + tipoDeItem.getNome(),
                id,1));
            }
        }catch (RegraNegocioException e){
            Log.gravaLog(e);
            
            while(posicao < this.MAXINVENTARIO-1){
                this.jogador.getInventario()[posicao] = this.jogador.getInventario()[posicao+1];
                this.jogador.getQuantidades()[posicao] = this.jogador.getQuantidades()[posicao+1];
                posicao++;
            }
        }        
    }
    
    private int ProcuraItem(int id){
        for (int i = 0; i < this.MAXINVENTARIO; i++){
            try{
                if (this.jogador.getInventario()[i] == id)
                    return i;
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                Integer[] novoInventario = new Integer[this.MAXINVENTARIO];
                System.arraycopy(this.jogador.getInventario(), 0, novoInventario, 0, 
                        this.jogador.getInventario().length);
                this.jogador.setInventario(novoInventario);
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                this.jogador.getInventario()[i] = -1;
                this.jogador.getQuantidades()[i] = 0;
            }
        }
        return -1;
    }
    
    private boolean PenteCheior(int pente, int quantidades){
        return (pente==0)&&();
    }
    
    private void CausaDano(FolhaDano dano){
        for (int i = 0; i < 6; i++){
            try{
                this.inimigo.getAtributos().setHpAtual((short)(this.inimigo.getAtributos().getHpAtual()-
                        this.DADOS.D4()*dano.getRolagens()[0]+
                        this.DADOS.D6()*dano.getRolagens()[1]+
                        this.DADOS.D8()*dano.getRolagens()[2]+
                        this.DADOS.D10()*dano.getRolagens()[3]+
                        this.DADOS.D12()*dano.getRolagens()[4]+
                        this.DADOS.D20()*dano.getRolagens()[5]));
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                short[] novoDano = new short[6];
                System.arraycopy(dano.getRolagens(), 0, novoDano, 0, 
                        dano.getRolagens().length);
                dano.setRolagens(novoDano);
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                this.jogador.getInventario()[i] = -1;
                this.jogador.getQuantidades()[i] = 0;
            }
        }
    }
    
    private void Usa(int posicao, Arma arma, Acao executada){
        if (this.DADOS.TesteDePorcentagem() < )
        CausaDano(arma.getDano());
        this.contadorDeAcoes++;
        this.jogador.getQuantidades()[posicao] = this.jogador.getQuantidades()[posicao]
                -executada.getQuantidadeItem();
        if (this.pente <= 0)
            executada.setValido(false);
    }
    
    private void Recupera(){
        this.jogador.getAtributos().setHpAtual((short)(this.jogador.getAtributos().getHpAtual()-
                this.DADOS.D4()));
    }
    
    private void UsaConsumiveil(int posicao, Acao executada){
        
        this.contadorDeAcoes++;
        this.jogador.getQuantidades()[posicao] = this.jogador.getQuantidades()[posicao]
                -executada.getQuantidadeItem();
        if(this.jogador.getQuantidades()[posicao] <= 0)
            executada.setValido(false);
    }
    
    //FUNÇÕES
    
    public String GetNomeInimigo(){
        return this.inimigo.getNome();
    }
    
    public String GetHPInimigo(){
        return this.inimigo.getAtributos().getHpAtual() + " / " + this.inimigo.getAtributos().getMaxHp();
    }
    
    public ArrayList<String> GetNomesAcoes(){
        ArrayList<String> nomes = new ArrayList<>();
        acoes.forEach((a) -> {
            nomes.add(a.getNome());
        });
        return nomes;
    }
    
    public void GeraAcoes (){
        this.acoes.add(new Acao(Acao.TipoAcao.ofensiva,"Golpear"));
        this.acoes.add(new Acao(Acao.TipoAcao.passiva,"Magia de cura"));
        for (int i = 0; i < this.MAXINVENTARIO; i++){
            try{
                GeraAcoesItem(i,this.jogador.getInventario()[i]);
            }catch(ArrayIndexOutOfBoundsException e){
                Log.gravaLog(e);
                
                Integer[] novoInventario = new Integer[this.MAXINVENTARIO];
                System.arraycopy(this.jogador.getInventario(), 0, novoInventario, 0, 
                        this.jogador.getInventario().length);
                this.jogador.setInventario(novoInventario);
            }catch(NullPointerException e){
                Log.gravaLog(e);
                
                this.jogador.getInventario()[i] = -1;
                this.jogador.getQuantidades()[i] = 0;
            }
        }
    }
    
    public void ExecutaAcao(int index)throws RegraNegocioException{
        try{
            Acao executada = this.acoes.get(index);
            
            if(executada.getIdItem() > 0){
                int posicao = ProcuraItem(executada.getIdItem());
                Item item = this.BASEDADOS.CarregaItem(executada.getIdItem());
                if (item instanceof Arma){
                    Arma arma = (Arma)item;
                    if (arma.getTamanhoDoPente() > 0){
                        this.pente = this.jogador.getInventario()[posicao] % arma.getTamanhoDoPente();
                        if (executada.getTipoAcao() == Acao.TipoAcao.passiva){
                            
                        }else{
                            Usa(posicao, arma, executada);
                            if(this.contadorDeAcoes < arma.getUsosPorRound())
                                return;
                        }
                    }else{
                        if (executada.getTipoAcao() == Acao.TipoAcao.passiva){
                            Usa(posicao, arma, executada);
                            this.contadorDeAcoes--;
                            if(this.contadorDeAcoes < arma.getUsosPorRound())
                                return;
                        }else{
                            Usa(posicao, arma, executada);
                            if(this.contadorDeAcoes < arma.getUsosPorRound())
                                return;
                        }
                    }
                }else if(item instanceof ItemConsumivel){
                    
                }
            }else if(index == 0){
            }else if(index == 1){
            }
                
        }catch(NullPointerException e){
            Log.gravaLog(e);
            
            throw new RegraNegocioException("ERRO! CÓDIGO DE AÇÃO INVÁLIDO!");
        }catch(ArrayIndexOutOfBoundsException e){
            Log.gravaLog(e);
            
            throw new RegraNegocioException("ERRO! CÓDIGO DE ITEM INVÁLIDO!");
        }
    }
    
    //GETTERS E SETTERS

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setInimigo(Personagem inimigo) {
        this.inimigo = inimigo;
    }
    
}
