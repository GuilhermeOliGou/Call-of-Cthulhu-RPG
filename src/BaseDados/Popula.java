package BaseDados;

import BaseDados.DaoJDBC.BancoDadosJdbc;
import Utilidades.Log;

import java.sql.SQLException;

public class Popula extends BancoDadosJdbc {

    public Popula() throws BaseDadosException {
        super();
    }

    public void criaTabelas() throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("CREATE TABLE item_arma(\n" +
                "\tid_arma INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_item INT NOT NULL,\n" +
                "\tusos_round SMALLINT NOT NULL,\n" +
                "\ttamanho_pente SMALLINT NOT NULL,\n" +
                "\tmal_funcionamento TINYINT(1) NOT NULL\n" +
                ");");

        try {
            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel Criar Tabelas");
        }
    }

    public void populaTabelas() throws BaseDadosException {

        String texto = ""
                + "insert into Jogadores(idJogador) values(1);"
                + "insert into Locais(nomeLocal) values('Sala 1');"
                + "insert into Locais(nomeLocal) values('Corredor');"
                + "insert into Locais(nomeLocal) values('Banheiro');"
                + "insert into Locais(nomeLocal) values('Sala 2');"
                + "insert into Locais(nomeLocal) values('Laboratorio');"
                + "insert into Locais(nomeLocal) values('Sala Final');"
                + "insert into Atributos(idJogador, forca, constituicao, tamanho, destreza, aparencia, inteligencia, educacao, poder, maxHp, maxMp, hpAtual, mpAtual, movimento, bonusDeDanoCorporal, build, idade) values(1,20,12,20,35,45,60,75,3,40,40,40,40,37,1,1,19);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,1,'Abrir a porta','Tentar abrir a porta',1,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,1,'olhar mesa','olhar a mesa do professor',1,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,1,'ir para o corredor','sair da sala e ir para o corredor',2,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'acender as luzes','acender as luzes do corredor',2,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'voltar sala 1','voltar para a sala 1',1,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'ir para a sala 2','ir para a sala 2',4,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'ir para o banheiro','dir para o banheiro',3,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'ir para o laboratorio','ir para o laboratorio',5,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,4,'voltar para o corredor','voltar par o corredor',2,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,3,'voltar para o corredor','voltar para o corredor',2,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,5,'voltar para o corredor','voltar para o corredor',1,1,0);"
                + "insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,5,'fazer o EP de COO','Terminar o EP de COO para entregar (Urgencia)',1,1,0);";

        abreConexao();
        preparaComandoSQL(texto);
        try {
            ps.execute();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel Popular Tabelas");
        }
    }

    public void esvaziaTabelas() throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE FROM item;" +
                "DELETE FROM item_arma;" +
                "DELETE FROM item_consumivel;" +
                "DELETE FROM local;" +
                "DELETE FROM evento;" +
                "DELETE FROM evento_avancado;" +
                "DELETE FROM evento_luta;" +
                "DELETE FROM resposta;" +
                "DELETE FROM item_modificado;" +
                "DELETE FROM item_requerido;" +
                "DELETE FROM folha_habilidades;" +
                "DELETE FROM habilidades_tiro;" +
                "DELETE FROM habilidades_luta;" +
                "DELETE FROM habilidades_resposta;" +
                "DELETE FROM habilidades_tiro_resposta;" +
                "DELETE FROM habiliadades_luta_resposta;" +
                "DELETE FROM personagem;" +
                "DELETE FROM folha_atributos;" +
                "DELETE FROM folha_caracteristicas;" +
                "DELETE FROM folha_caracteristicas_resposta;" +
                "DELETE FROM inventario;" +
                "DELETE FROM evento_jogador;" +
                "DELETE FROM jogador;" +
                "DELETE FROM folha_dano");
        try {
            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel Esvaziar Tabelas");
        }
    }
}
