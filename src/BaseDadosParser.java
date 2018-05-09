package RegrasDeNegocio;

import BaseDados.*;
import ElementosDeJogo.Personagens.Jogador;
import ElementosDeJogo.Sistema.Eventos.Evento;
import ElementosDeJogo.Sistema.Local;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class BaseDadosParser {
   private GerenciadorBaseDados gerenciadorBaseDados = new GerenciadorBaseDados();

    protected Jogador geraJogadorInfo(ResultSet rs)throws SQLException{
        Jogador jogador = null;
        if(rs.next()){
            //3.2.1 -> Carregando Informações no Objeto Jogador
            jogador = new Jogador(rs.getShort("forca"), rs.getShort("constituicao"), rs.getShort("tamanho"),
                    rs.getShort("destreza"), rs.getShort("aparencia"), rs.getShort("inteligencia"), rs.getShort("educacao"),
                    rs.getShort("poder"), rs.getShort("idade"), rs.getString("nomeJogador"), rs.getShort("maxHP"),
                    rs.getShort("maxMP"), rs.getShort("movimento"), rs.getShort("bonusDeDanoCorporal"), rs.getShort("build"),
                    rs.getShort("sorte"), null);
        }
        return jogador;
    }

    protected Local geraLocalInfo(ResultSet rs, String nomeLocal)throws Exception{
        Local local = null;
        LinkedList<Evento> eventos = new LinkedList<>();
        while(rs.next()){
            Evento evento = new Evento(rs.getString("nomeEvento"), rs.getString("descricao"),null ,
                    null, rs.getBoolean("eventoUnico"), rs.getInt("qntTrigger"));
            eventos.add(evento);
        }
        local = new Local(nomeLocal, eventos);
        return local;
    }
    public Jogador getJogadorInfo()throws Exception{
        ResultSet rs = gerenciadorBaseDados.carregaJogador();
        if(rs == null) throw new Exception();
        return geraJogadorInfo(rs);
    }
    public Local getLocalInfo(String nomeLocal)throws Exception{
        ResultSet rs = gerenciadorBaseDados.getLocal(nomeLocal);
        if(rs == null) throw new Exception();
        return geraLocalInfo(rs, nomeLocal);
    }
    public void salvaJogador(Jogador jogador) throws Exception {
        gerenciadorBaseDados.salvaJogador(jogador);
    }
    public void salvaLocal(Local local) throws Exception{
        gerenciadorBaseDados.salvaLocal(local);
    }
}
