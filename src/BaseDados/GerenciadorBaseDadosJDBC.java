/*
package BaseDados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utilidades.Log;
import ElementosDeJogo.Personagens.Jogador;
import ElementosDeJogo.Personagens.Personagem;
import ElementosDeJogo.Sistema.Local;
import ElementosDeJogo.Sistema.Resposta;
import ElementosDeJogo.Sistema.Eventos.Evento;
import ElementosDeJogo.Sistema.Eventos.EventoAvancado;


public class GerenciadorBaseDadosJDBC extends ConectorJDBC implements
        GerenciadorBaseDados {

    private static final String PASSWORD = "123";
    private static final String USER = "postgres";
    private static final String HOST = "localhost";
    private static final String DB_NAME = "EPCOO";
    private boolean jaCriouBD;

    public GerenciadorBaseDadosJDBC() throws BaseDadosException {
        super(DB.MYSQL);
        //apos a primeira execucao do projeto, comentar a linha abaixo
        criaPovoaBanco();
    }

    protected String getUser() {
        return USER;
    }

    @Override
    protected String getPassword() {
        return PASSWORD;
    }

    @Override
    protected String getDbHost() {
        return HOST;
    }

    @Override
    protected String getDbName() {
        return jaCriouBD ? DB_NAME : "";
    }

   
    private void criaPovoaBanco() throws BaseDadosException{
        try{
            criaBancoDeDados();
            criaTabelaLocal();
            criaTabelaResposta();//terminar a tabela resposta
            criaTabelaEvento();//por enquanto só tem o evento, sem o eventoAvancado
            criaTabelaPersonagem();
            criaTabelaJogador();
            
            povoacaoTabelas();
            
        }catch(SQLException e) {//checar as exceptions desse metodo
            Log.gravaLog(e);
            throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
        }
        
    }

    //metodos de buscas
    
    //busca o local pelo nome
    public Local buscaLocal(String nome) throws BaseDadosException {
        LinkedList<Evento> eventos = new LinkedList<Evento>();
        abreConexao();
        preparaComandoSQL("select liberado from Local where nome="
                + nome);
        Local local = null;

        try {
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int localLiberado = rs.getInt(1);
                boolean liberado = false;
                if(localLiberado == 1)liberado=true;
                
                eventos = listaEventos(nome);
                local = new Local(nome,liberado,eventos);
            }
        } catch (SQLException e) {
            Log.gravaLog(e);
            throw new BaseDadosException(
                    "Problemas ao ler o resultado da consulta.");
        }

        fechaConexao();
        return local;
    }
    
    //busca evento pelo nome
    public Evento buscaEvento(String nome) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("select descricao, evento_Unico, evento_Realizado, fk_evento_local, fk_evento_resposta from evento where nome="
                + nome);
        Evento evento = null;

        try {
            rs = pstmt.executeQuery();
                
            if (rs.next()) {
                String descricao = rs.getString(1);
                int eventoUnico = rs.getInt(2);
                int eventoRealizado = rs.getInt(3);
                String local = rs.getString(4);
                int resposta = rs.getInt(5);
                
                boolean unico= false, realizado = false;
                if(eventoUnico ==1)unico=true;
                if(eventoRealizado==1)realizado=true;
                
                Local loc = buscaLocal(local);
                Resposta resp = buscaResposta(resposta);
                
                evento = new Evento(nome, descricao,loc,resp,unico,realizado);
            }
        } catch (SQLException e) {
            Log.gravaLog(e);
            throw new BaseDadosException(
                    "Problemas ao ler o resultado da consulta.");
        }

        fechaConexao();
        return evento;
    }
    
    //tem que arrumar pq nao sei o que tem em resposta
    public Resposta buscaResposta(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("select * from Respostas where codigo ="
                + codigo);
        Resposta resp = null;

        try {
            rs = pstmt.executeQuery();

            if (rs.next()) {
               
            }
        } catch (SQLException e) {
            Log.gravaLog(e);
            throw new BaseDadosException(
                    "Problemas ao ler o resultado da consulta.");
        }

        fechaConexao();
        return resp;
    }

    //metodos de listagem
    
    //lista locais onde o personagem pode entrar
    private LinkedList<Local> listaLocais() throws BaseDadosException {
        LinkedList<Local> local = new LinkedList<Local>();
        LinkedList<Evento> eventos = new LinkedList<Evento>();
        abreConexao();
        preparaComandoSQL("select nome from local where liberado=1");
        //liberado=1 -> local pode ser acessado -> true
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString(1);
                eventos = listaEventos(nome);
                Local l = new Local(nome,true,eventos);
                
                local.add(l);
            }
        } catch (SQLException e) {
            Log.gravaLog(e);
            throw new BaseDadosException(
                    "Problemas ao ler o resultado da consulta.");
        }

        fechaConexao();
        return local;
    }
    //lista eventos nao realizados do local onde o personagem esta e 
    public LinkedList<Evento> listaEventos(String local) throws BaseDadosException {
        LinkedList<Evento> eventos = new LinkedList<Evento>();
        abreConexao();
        preparaComandoSQL("select nome, descricao, evento_Unico, fk_evento_resposta from evento where evento_realizado = 0 and fk_evento_local="+local);
        //evento_realizdo=0 -> evento nao realizdo -> false

        for (Evento evento : eventos) {
            try {
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    String nome = rs.getString(1);
                    String descricao = rs.getString(2);
                    String eventoUnico = rs.getString(3);
                    int resposta = rs.getInt(6);
                    
                    boolean unico=false, realizado=false;
                    
                    if(eventoUnico.equals(1))unico=true;
                    
                    Local loc = buscaLocal(local);
                    Resposta resp = buscaResposta(resposta);
                     
                    Evento e = new Evento(nome, descricao,loc,resp,unico,realizado);
                    eventos.add(e);
                }
            } catch (SQLException e) {
                Log.gravaLog(e);
                throw new BaseDadosException(
                        "Problemas ao ler o resultado da consulta.");
            }

        }

        fechaConexao();
        return eventos;
    }

    
    
    
    //Metodos de criação do BD e suas tabelas
    private void criaBancoDeDados() throws SQLException, BaseDadosException {
        abreConexao();
        jaCriouBD = true;
        preparaComandoSQL("create database " + getDbName());
        pstmt.execute();
        fechaConexao();
    }
    //Elementos Personagens
    private void criaTabelaJogador() throws SQLException, BaseDadosException {
        abreConexao();
        preparaComandoSQL("CREATE TABLE jogador ("
                + "nome varchar(100) not null,"
                + "maxSanidade smallint unsigned not null,"
                + "sanidadeAtual smallint unsigned not null,"
                + "sorte smallint unsigned not null,"
                + "constraint fk_jogador_personagem FOREIGN KEY (nome) REFERENCES personagem (nome)"
                + ");");
        pstmt.execute();
        fechaConexao();
    }
    private void criaTabelaPersonagem() throws SQLException, BaseDadosException {
        abreConexao();
        preparaComandoSQL("CREATE TABLE personagem ("
                + "forca smallint unsigned not null,"
                + "constituicao smallint unsigned not null,"
                + "tamanho smallint unsigned not null,"
                + "destreza smallint unsigned not null,"
                + "aparencia smallint unsigned not null,"
                + "inteligencia smallint unsigned not null,"
                + "educacao smallint unsigned not null,"
                + "poder smallint unsigned not null,"
                + "maxHp smallint unsigned not null, "
                + "maxMp smallint unsigned not null,"
                + "hpAtual smallint unsigned not null,"
                + "mpAtual smallint unsigned not null,"
                + "movimento smallint unsigned not null,"
                + "bonusDeDanoCorporal smallint unsigned not null,"
                + "build smallint unsigned not null,"
                + "idade smallint unsigned not null,"
                + "nome varchar(100)  not null primary key,"
                + "constraint fk_personagem_local FOREIGN KEY (nome) REFERENCES local (nome)"
                + ");");
        pstmt.execute();
        fechaConexao();
    }
    //Elementos Sistema
    private void criaTabelaLocal() throws SQLException, BaseDadosException {
        abreConexao();
        preparaComandoSQL("CREATE TABLE local("
                + "nome varchar(100) not null primary key,"
                + "liberado int(1) not null"
                + ");");
        pstmt.execute();
        fechaConexao();
    }
    private void criaTabelaResposta() throws SQLException, BaseDadosException {
        abreConexao();
        preparaComandoSQL("CREATE TABLE resposta("
                + "codigo integer not null primary key"
                + ""
                + ");");
        pstmt.execute();
        fechaConexao();
    }
    
    //Elementos Sistema Eventos
   private void criaTabelaEvento() throws SQLException, BaseDadosException {
        abreConexao();
        preparaComandoSQL("CREATE TABLE evento("
                + "nome varchar(75) not null primary key,"
                + "descricao varchar(256) not null,"
                + "evento_unico int(1) not null,"
                + "evento_realizado int(1) not null,"
                + "constraint fk_evento_local FOREIGN KEY (nome) REFERENCES local (nome),"
                + "constraint fk_evento_resposta FOREIGN KEY (codigo) REFERENCES resposta (codigo)"
                + ");");
        pstmt.execute();
        fechaConexao();
    }
   private void criaTabelaEventoAvancado() throws SQLException, BaseDadosException {
        abreConexao();
        preparaComandoSQL("");
        pstmt.execute();
        fechaConexao();
    }

   //povoação das tabelas
    private void povoacaoTabelas() throws BaseDadosException, SQLException{
        abreConexao();
        preparaComandoSQL(""
                + "insert into local (nome, liberado) values('sala 1',1);"
                + "insert into local (nome, liberado) values('corredor',0);"
                + "insert into local (nome, liberado) values('banheiro',0);"
                + "insert into local (nome, liberado) values('sala final',0);"

                
                + "insert into resposta (codigo) values (1)"//resposta nao terminada
                
                
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('pegar o giz', 'pegar o giz do chao',1,0,'sala 1',1)"
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('abrir porta', 'tentar abrir a porta', 0,0,'sala 1',1)"
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('examinar mesa', 'olhar debaixo da mesa', 0,0,'sala 1',1)"
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('pegar chave', 'pegar a chave debaixo da mesa', 1,0,'sala 1',1)"
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('destrancar porta', 'usar a chave para abrir a porta', 1,0,'sala 1',1)"
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('ir para corredor', 'trocar o local', 0,0,'sala 1',1)"
                + "insert into evento (nome, descricao, evento_unico, evento_realizado, fk_evento_local, fk_evento_resposta) values ('acender a luz', 'acender a luz do corredor', 1,0,'corredor',1)"
               
                + "insert into personagem(forca,constituicao, tamanho, destreza, aparencia, inteligencia, educacao,poder,maxHp,maxMp,hpAtual,mpAtual,movimento,bonusDeDanoCorporal,build,idade,nome,fk_personagem_local) values(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'player 1','sala 1')"
               
                + "insert into jogador(nome,maxSanidade,sorte,fk_jogador_personagem ) valuas('jogador 1', 0, 1, 'player 1')");
        
        pstmt.execute();
        fechaConexao();
    }


}
*/