package BaseDados;

import ElementosDeJogo.Sistema.Eventos.Evento;
import ElementosDeJogo.Sistema.Local;
import ElementosDeJogo.Personagens.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GerenciadorBaseDados extends ConectorBaseDados {

    private static final String PASSWORD = "gvm507713";
    private static final String USER = "voull_";
    private static final String HOST = "db4free.net:3306";
    private static final String DB_NAME = "coo_ep";

    public GerenciadorBaseDados(){
        super();
    }

    @Override
    protected String getDbHost() {
        return HOST;
    }

    @Override
    protected String getDbName() {
        return DB_NAME;
    }

    @Override
    protected String getUser() {
        return USER;
    }

    @Override
    protected String getPassword() {
        return PASSWORD;
    }
    public ResultSet carregaJogador() throws Exception {

        rs = null;
        abreConexao();
        geraComandoSQL("SELECT * FROM Jogadores LEFT JOIN Atributos USING(idJogador) LIMIT 1");
        try {
            rs = ps.executeQuery();
            if (rs == null) throw new Exception("Falha no BD");
        } catch (Exception e) {
            throw new Exception("Erro no BD");
        }
        fechaConexao();
        return rs;
    }
    /*
    //Retorna as Informações do Jogador a paritr do DB
    public Jogador carregaJogador() throws Exception {
        //Fase 1 -> Inicialização de Variáveis Locais
        Jogador jogador = new Jogador();
        //Fase 2 -> Preparação da Conexão com o DB
            //2.1 -> Conexão com o DB
        abreConexao();
            //2.2 -> Criação do Comando SQL
        geraComandoSQL("SELECT * FROM Jogadores LEFT JOIN Atributos USING(idJogador)");
        try {
            //Fase 3 -> Execução do Comando e Parsing da Resposta
                //3.1 -> Envio do Comando
            rs = ps.executeQuery();
                //3.2 -> Parsing da Resposta
            if(rs.next())
                    //3.2.1 -> Carregando Informações no Objeto Jogador
                jogador = new Jogador(rs.getShort("forca"), rs.getShort("constituicao"), rs.getShort("tamanho"),
                        rs.getShort("destreza"), rs.getShort("aparencia"), rs.getShort("inteligencia"), rs.getShort("educacao"),
                        rs.getShort("poder"), rs.getShort("idade"), rs.getString("nomeJogador"), rs.getShort("maxHP"),
                        rs.getShort("maxMP"), rs.getShort("movimento"), rs.getShort("bonusDeDanoCorporal"), rs.getShort("build"),
                        rs.getShort("sorte"), null);
                    //3.2.1.1 -> Ajusta variáveis modificadas pelo construtor
                    //(P.S. Adicionar construtor para uso mais eficiente do DB)
                jogador.setMaxSanidade(rs.getShort("maxSanidade"));
                jogador.setSanidadeAtual(rs.getShort("sanidadeAtual"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Fase 4 -> Finalização da Conexão e retorno do Método
        fechaConexao();
        return jogador;
    }
    */

    //Carrega Informações de Eventos de um dado Local no BD
    public ResultSet carregaLocal(Local local){

        return null;
    }

    //Lista os Itens de um dado Jogador no DB
    public ResultSet getLocal(int idJogador, String nomeLocal)throws Exception {
        rs = null;
        abreConexao();
        geraComandoSQL("SELECT * FROM Locais LEFT JOIN Eventos USING (idLocal) WHERE idJogador = ?, idLocal = ?");
        try {
            ps.setInt(1, idJogador);
            ps.setInt(2, getIDLocal(nomeLocal));
            ps.executeQuery();
            if (rs == null) throw new Exception("Local não existe!");
            return rs;
        } catch (Exception e) {
            throw new Exception("Erro no BD");
        }

    }

    public void salvaDados(PreparedStatement ps) throws Exception{
        abreConexao();
        /*
		geraComandoSQL("update atributos set maxSanidade = ?, sanidadeAtual = ?, sorte = ?, forca = ?, constituicao = ?," +
                " tamanho = ?, destreza = ?, aparencia = ?, inteligencia = ?, educacao = ?, poder = ?, maxHP = ?, maxMP = ?," +
                " hpAtual = ?, movimento = ?, bonusDeDanoCorporal, build = ?, idade = ? where nome = ?");
		*/
        try{
            /*
			ps.setInt(1, jogador.getMaxSanidade());
            ps.setInt(2, jogador.getSanidadeAtual());
            ps.setInt(3, jogador.getSorte());
            ps.setInt(4, jogador.getForca());
            ps.setInt(5, jogador.getConstituicao());
            ps.setInt(6, jogador.getTamanho());
            ps.setInt(7, jogador.getDestreza());
            ps.setInt(8, jogador.getAparencia());
            ps.setInt(9, jogador.getInteligencia());
            ps.setInt(10, jogador.getEducacao());
            ps.setInt(11, jogador.getPoder());
            ps.setInt(12, jogador.getMaxHp());
            ps.setInt(13, jogador.getMaxMp());
            ps.setInt(14, jogador.getHpAtual());
            ps.setInt(15, jogador.getMovimento());
            ps.setInt(16, jogador.getBonusDeDanoCorporal());
            ps.setInt(17, jogador.getBuild());
            ps.setInt(18, jogador.getIdade());
            ps.setString(19, jogador.getNome());
			*/
            ps.execute();
        }catch (Exception e ){
            System.out.println("Erro no BD");
			e.printStackTrace();
        }
    }
    private int getIDLocal(String nomeLocal) throws Exception{
        abreConexao();
        geraComandoSQL("SELECT idLocal FROM Locais WHERE nomeLocal = ?");
        try{
            ps.setString(1, nomeLocal);
            ps.executeQuery();
            if(rs == null || rs.next()) throw new Exception("Local não existe!");
            return rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro no BD");
        }
    }
}
