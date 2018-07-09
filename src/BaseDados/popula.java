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
        preparaComandoSQL("use coo_ep;\n" +
                "\n" +
                "CREATE TABLE item(\n" +
                "\tid_item INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tnome_item VARCHAR(50) NOT NULL,\n" +
                "\tdescricao_item VARCHAR(200) NOT NULL,\n" +
                "\ttipo_item VARCHAR(50) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE item_arma(\n" +
                "\tid_arma INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_item INT NOT NULL,\n" +
                "\tusos_round SMALLINT NOT NULL,\n" +
                "\ttamanho_pente SMALLINT NOT NULL,\n" +
                "\tmal_funcionamento TINYINT(1) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE item_consumivel(\n" +
                "\tid_consumivel INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_item INT NOT NULL,\n" +
                "\thp_recuperada SMALLINT NOT NULL,\n" +
                "\tmp_recuperada SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE local (\n" +
                "\tid_local INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tnome_local VARCHAR(50) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE evento (\n" +
                "\tid_evento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_local INT NOT NULL,\n" +
                "    nome_evento VARCHAR(200) NOT NULL,\n" +
                "\ttipo_evento VARCHAR(50) NOT NULL,\n" +
                "\tdescricao_evento VARCHAR(200) NOT NULL,\n" +
                "    id_local_retorno INT NOT NULL,\n" +
                "    evento_unico TINYINT(1) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE evento_avancado(\n" +
                "\tid_evento_avancado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT NOT NULL,\n" +
                "\tdescricao_falha VARCHAR(200) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE evento_luta(\n" +
                "\tid_evento_luta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT NOT NULL,\n" +
                "\tid_personagem INT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE resposta(\n" +
                "\tid_resposta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    id_evento INT NOT NULL,\n" +
                "\tsanidade_alterada SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE item_modificado(\n" +
                "\tid_item_modificado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    id_evento INT NOT NULL,\n" +
                "\tid_item INT NOT NULL,\n" +
                "\tadiciona TINYINT(1) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE item_requerido(\n" +
                "\tid_item_requerido INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    id_evento INT NOT NULL,\n" +
                "\tid_item INT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE folha_habilidades(\n" +
                "\tid_habilidade INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    id_evento INT NOT NULL,\n" +
                "\tmitos_cthulhu SMALLINT NOT NULL\n" +
                "\t);\n" +
                "\t\n" +
                "CREATE TABLE habilidades_tiro(\n" +
                "\tid_tiro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT,\n" +
                "\tid_item INT,\n" +
                "\ttiro_pistola SMALLINT NOT NULL,\n" +
                "\ttiro_rifle SMALLINT NOT NULL,\n" +
                "\ttiro_submetralhadora SMALLINT NOT NULL,\n" +
                "\tarremesso SMALLINT NOT NULL\n" +
                "\t);\n" +
                "\t\n" +
                "CREATE TABLE habilidades_luta(\n" +
                "\tid_luta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT,\n" +
                "\tid_item INT,\n" +
                "\tesquiva SMALLINT NOT NULL,\n" +
                "\tluta_machado SMALLINT NOT NULL,\n" +
                "\tluta_livre SMALLINT NOT NULL,\n" +
                "\tluta_lanca SMALLINT NOT NULL,\n" +
                "\tluta_espada SMALLINT NOT NULL,\n" +
                "\tluta_chicote SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE habilidades_resposta(\n" +
                "\tid_habilidade_resposta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    id_evento INT NOT NULL,\n" +
                "\tmitos_cthulhu SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE habilidades_tiro_resposta(\n" +
                "\tid_tiro_resposta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT NOT NULL,\n" +
                "\ttiro_pistola SMALLINT NOT NULL,\n" +
                "\ttiro_rifle SMALLINT NOT NULL,\n" +
                "\ttiro_submetralhadora SMALLINT NOT NULL,\n" +
                "\tarremesso SMALLINT NOT NULL\n" +
                "\t);\n" +
                "\t\n" +
                "CREATE TABLE habilidades_luta_resposta(\n" +
                "\tid_luta_resposta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT NOT NULL,\n" +
                "\tesquiva SMALLINT NOT NULL,\n" +
                "\tluta_machado SMALLINT NOT NULL,\n" +
                "\tluta_livre SMALLINT NOT NULL,\n" +
                "\tluta_lanca SMALLINT NOT NULL,\n" +
                "\tluta_espada SMALLINT NOT NULL,\n" +
                "\tluta_chicote SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE personagem(\n" +
                "\tid_personagem INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tnome VARCHAR(50) NOT NULL,\n" +
                "\tidade SMALLINT NOT NULL,\n" +
                "    ultimo_local INT NOT NULL\n" +
                ");\n" +
                "\t\n" +
                "CREATE TABLE folha_atributos(\n" +
                "\tid_atributos INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_personagem INT,\n" +
                "\tid_evento INT,\n" +
                "\tmax_hp SMALLINT NOT NULL,\n" +
                "\tmax_mp SMALLINT NOT NULL,\n" +
                "\thp_atual SMALLINT NOT NULL,\n" +
                "\tmp_atual SMALLINT NOT NULL,\n" +
                "\tbonus_dano SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE folha_caracteristicas(\n" +
                "\tid_caracteristicas INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_personagem INT,\n" +
                "\tid_evento INT,\n" +
                "\tforca SMALLINT NOT NULL,\n" +
                "\tconstituicao SMALLINT NOT NULL,\n" +
                "\ttamanho SMALLINT NOT NULL,\n" +
                "\tdestreza SMALLINT NOT NULL,\n" +
                "\tpoder SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE folha_caracteristicas_resposta(\n" +
                "\tid_caracteristicas_resposta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_evento INT NOT NULL,\n" +
                "\tforca SMALLINT NOT NULL,\n" +
                "\tconstituicao SMALLINT NOT NULL,\n" +
                "\ttamanho SMALLINT NOT NULL,\n" +
                "\tdestreza SMALLINT NOT NULL,\n" +
                "\tpoder SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE inventario(\n" +
                "\tid_inventario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_personagem INT NOT NULL,\n" +
                "\tid_item INT NOT NULL,\n" +
                "\tquantidade SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE evento_jogador(\n" +
                "\tid_evento_jogador INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_personagem INT NOT NULL,\n" +
                "\tid_evento INT NOT NULL,\n" +
                "\tid_local INT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE jogador(\n" +
                "\tid_jogador INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tid_personagem INT NOT NULL,\n" +
                "\tmax_sanidade SMALLINT NOT NULL,\n" +
                "\tsanidade_atual SMALLINT NOT NULL,\n" +
                "\tsorte SMALLINT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE folha_dano(\n" +
                "\tid_dano INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    id_item INT NOT NULL,\n" +
                "    adicional SMALLINT NOT NULL,\n" +
                "    atordoamento TINYINT(1) NOT NULL,\n" +
                "    rolagem_1 SMALLINT NOT NULL,\n" +
                "    rolagem_2 SMALLINT NOT NULL,\n" +
                "    rolagem_3 SMALLINT NOT NULL,\n" +
                "    rolagem_4 SMALLINT NOT NULL,\n" +
                "    rolagem_5 SMALLINT NOT NULL,\n" +
                "    rolagem_6 SMALLINT NOT NULL\n" +
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

        String texto = "INSERT INTO local (nome_local) VALUES (\"Entrada\");\n" +
                "\n" +
                "INSERT INTO local (nome_local) VALUES (\"Saguão\");\n" +
                "\n" +
                "INSERT INTO local (nome_local) VALUES (\"Antessala\");\n" +
                "\n" +
                "INSERT INTO local (nome_local) VALUES (\"Corredor\");\n" +
                "\n" +
                "INSERT INTO local (nome_local) VALUES (\"Coração do Templo\");\n" +
                "\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (1, \"Entrar no templo\", \"\", \"Evento\", 2, 0);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (2, \"Sair do templo\", \"\", \"Evento\", 1, 0);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (2, \"Olhar para as pinturas\", \"As paredes estão cobertas de rabiscos bestiais de horror indescritível.\", \"Evento\", 2, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (2, \"Investigar Altar\", \"Há uma chave largada sobre o chão de um palco.\", \"Evento\", 2, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (2, \"Investigar Porta\", \"A porta se abre liberando acesso a antessala.\", \"EventoAvancado\", 3, 0);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (3, \"Investigar Vulto Luminoso\", \"Você fez contato. Um sabre de prata se materializa diante de seus olhos.\", \"EventoAvancado\", 3, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (3, \"Tentar ler escrituras na parede\", \"Uma mente que se expande jamais volta a se tamanho original! DHO-HNA!\", \"EventoAvancado\", 3, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (3, \"Investigar Baú\", \"Algumas armas estavam dentro do baú.\", \"Evento\", 3, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (3, \"Seguir pelo Corredor\", \"\", \"Evento\", 4, 0);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (4, \"Recuar\", \"\", \"Evento\", 3, 0);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (4, \"Ir em frente\", \"O inimigo cai morto e a caminho de volta se sela.\", \"EventoLuta\", 5, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (5, \"Interagir com o Vulto Luminoso\", \"\", \"EventoAvancado\", 5, 1);\n" +
                "\n" +
                "INSERT INTO evento (id_local, nome_evento, descricao_evento, tipo_evento, id_local_retorno, evento_unico) VALUES (5, \"Interagir com Estatua\", \"Ainda não é o fim...\", \"EventoLuta\", 5, 1);\n" +
                "\n" +
                "\n" +
                "\n" +
                "INSERT INTO resposta (id_evento, sanidade_alterada) VALUES (3, -10);\n" +
                "\n" +
                "INSERT INTO resposta(id_evento, sanidade_alterada) VALUES (4, 0);\n" +
                "\n" +
                "INSERT INTO resposta(id_evento, sanidade_alterada) VALUES (6, 0);\n" +
                "\n" +
                "INSERT INTO resposta(id_evento, sanidade_alterada) VALUES (7, 0);\n" +
                "\n" +
                "INSERT INTO resposta(id_evento, sanidade_alterada) VALUES (8, 0);\n" +
                "\n" +
                "INSERT INTO resposta(id_evento, sanidade_alterada) VALUES (12, 0);\n" +
                "\n" +
                "\n" +
                "\n" +
                "INSERT INTO evento_avancado (id_evento, descricao_falha) VALUES (5, \"A porta está trancada, você precisa de uma chave.\");\n" +
                "\n" +
                "INSERT INTO evento_avancado (id_evento, descricao_falha) VALUES (6, \"O vulto se esvai sem deixar sinais de que sequer esteve lá.\");\n" +
                "\n" +
                "INSERT INTO evento_avancado (id_evento, descricao_falha) VALUES (7, \"Nada mais que rabiscos de uma mente perturbada.\");\n" +
                "\n" +
                "INSERT INTO evento_avancado (id_evento, descricao_falha) VALUES (12, \"\");\n" +
                "\n" +
                "\n" +
                "INSERT INTO evento_luta(id_evento, id_personagem) VALUES (11, 1);\n" +
                "\n" +
                "INSERT INTO evento_luta(id_evento, id_personagem) VALUES (13, 2);\n" +
                "\n" +
                "\n" +
                "INSERT INTO item_requerido(id_evento, id_item) VALUES (5, 1);\n" +
                "\n" +
                "\n" +
                "INSERT INTO folha_atributos(id_evento, max_hp, max_mp, hp_atual, mp_atual, bonus_dano) VALUES (6, -1, -1, -1, -1, -1);\n" +
                "\n" +
                "INSERT INTO folha_atributos(id_evento, max_hp, max_mp, hp_atual, mp_atual, bonus_dano) VALUES (12, -1, -1, -1, -1, -1);\n" +
                "\n" +
                "\n" +
                "INSERT INTO folha_caracteristicas(id_evento, forca, constituicao, tamanho, destreza, poder) VALUES (6, -1, -1, -1, -1, 20);\n" +
                "\n" +
                "INSERT INTO folha_caracteristicas(id_evento, forca, constituicao, tamanho, destreza, poder) VALUES (12, -1, -1, -1, -1, 30);\n" +
                "\n" +
                "\n" +
                "INSERT INTO folha_habilidades (id_evento, mitos_cthulhu) VALUES (7, 2);\n" +
                "\n" +
                "\n" +
                "INSERT INTO item_modificado (id_evento, id_item, adiciona) VALUES (4, 1, 1);\n" +
                "\n" +
                "INSERT INTO item_modificado (id_evento, id_item, adiciona) VALUES (6, 2, 1);\n" +
                "\n" +
                "INSERT INTO item_modificado (id_evento, id_item, adiciona) VALUES (8, 3, 1);\n" +
                "\n" +
                "INSERT INTO item_modificado (id_evento, id_item, adiciona) VALUES (8, 4, 1);\n" +
                "\n" +
                "INSERT INTO item_modificado (id_evento, id_item, adiciona) VALUES (8, 5, 1);\n" +
                "\n" +
                "\n" +
                "INSERT INTO folha_caracteristicas_resposta (id_evento, forca, constituicao, tamanho, destreza, poder) VALUES (7, 20, 20, 20, 20, 20);\n" +
                "\n" +
                "INSERT INTO habilidades_resposta (id_evento, mitos_cthulhu) VALUES (12, 0);\n" +
                "\n" +
                "INSERT INTO habilidades_tiro_resposta (id_evento, tiro_pistola, tiro_rifle, tiro_submetralhadora, arremesso) VALUES (12, 20, 20, 0, 20);\n" +
                "\n" +
                "INSERT INTO habilidades_luta_resposta (id_evento, luta_livre, esquiva, luta_machado, luta_espada, luta_lanca, luta_chicote) VALUES (12, 30, 30 , 30, 30, 0, 0);\n" +
                "\n" +
                "\n" +
                "INSERT INTO item (nome_item, descricao_item, tipo_item) VALUES (\"Chave enferrujada\", \"Uma chave desgastada e enferrujada pelo ar salgado do mar\", \"Item\");\n" +
                "\n" +
                "INSERT INTO item (nome_item, descricao_item, tipo_item) VALUES (\"Sabre de Prata\",\"Um sabre de prata brilhante como o luar\", \"Arma\");\n" +
                "\n" +
                "INSERT INTO item (nome_item, descricao_item, tipo_item) VALUES (\"Revolver\", \"Um revolver de 6 tiros\", \"Arma\");\n" +
                "\n" +
                "INSERT INTO item (nome_item, descricao_item, tipo_item) VALUES (\"Machadinha\", \"Um pequeno machado que pode ser atirado\", \"Arma\");\n" +
                "\n" +
                "INSERT INTO item (nome_item, descricao_item, tipo_item) VALUES (\"Escopeta\", \"Uma escopeta de cano curto e de médio alcance\", \"Arma\");\n" +
                "\n" +
                "\n" +
                "INSERT INTO item_arma (id_item, usos_round, tamanho_pente, mal_funcionamento) VALUES (2, 1, 0, 0);\n" +
                "\n" +
                "INSERT INTO item_arma (id_item, usos_round, tamanho_pente, mal_funcionamento) VALUES (3, 1, 6, 100);\n" +
                "\n" +
                "INSERT INTO item_arma (id_item, usos_round, tamanho_pente, mal_funcionamento) VALUES (4, 1, 0, 0);\n" +
                "\n" +
                "INSERT INTO item_arma (id_item, usos_round, tamanho_pente, mal_funcionamento) VALUES (5, 2, 2, 100);\n" +
                "\n" +
                "INSERT INTO habilidades_tiro (id_item, tiro_pistola, tiro_rifle, tiro_submetralhadora, arremesso) VALUES (3, 1, 0, 0, 0);\n" +
                "\n" +
                "INSERT INTO habilidades_tiro (id_item, tiro_pistola, tiro_rifle, tiro_submetralhadora, arremesso) VALUES (4, 0, 0, 0, 1);\n" +
                "\n" +
                "INSERT INTO habilidades_tiro (id_item, tiro_pistola, tiro_rifle, tiro_submetralhadora, arremesso) VALUES (5, 0, 1, 0, 0);\n" +
                "\n" +
                "INSERT INTO habilidades_luta (id_item, luta_livre, esquiva, luta_machado, luta_espada, luta_lanca, luta_chicote) VALUES (2, 0, 0, 0, 1, 0, 0);\n" +
                "\n" +
                "INSERT INTO habilidades_luta (id_item, luta_livre, esquiva, luta_machado, luta_espada, luta_lanca, luta_chicote) VALUES (4, 0, 0, 1, 0, 0, 0);\n" +
                "\n" +
                "\n" +
                "INSERT INTO folha_dano (id_item, rolagem_1, rolagem_2, rolagem_3, rolagem_4, rolagem_5, rolagem_6, adicional, atordoamento) VALUES (2, 0, 4, 0, 0, 0, 1, 0, 1);\n" +
                "\n" +
                "INSERT INTO folha_dano (id_item, rolagem_1, rolagem_2, rolagem_3, rolagem_4, rolagem_5, rolagem_6, adicional, atordoamento) VALUES (3, 1, 0, 1, 0, 0, 0, 0, 0);\n" +
                "\n" +
                "INSERT INTO folha_dano (id_item, rolagem_1, rolagem_2, rolagem_3, rolagem_4, rolagem_5, rolagem_6, adicional, atordoamento) VALUES (4, 0, 1, 0, 0, 0, 0, 0, 0);\n" +
                "\n" +
                "INSERT INTO folha_dano (id_item, rolagem_1, rolagem_2, rolagem_3, rolagem_4, rolagem_5, rolagem_6, adicional, atordoamento) VALUES (5, 0, 4, 0, 0, 0, 0, 0, 0);\n" +
                "\n" +
                "\n" +
                "INSERT INTO personagem (nome, idade, ultimo_local) VALUES (\"Cultista\", -1, -1);\n" +
                "\n" +
                "INSERT INTO personagem (nome, idade, ultimo_local) VALUES (\"Aparição Cósmica\", -1, -1);\n" +
                "\n" +
                "INSERT INTO folha_atributos (id_personagem, max_hp, max_mp, hp_atual, mp_atual, bonus_dano) VALUES (1, 9, 12, 9, 12, -1);\n" +
                " \n" +
                "INSERT INTO folha_atributos (id_personagem, max_hp, max_mp, hp_atual, mp_atual, bonus_dano) VALUES (2, 24, 24, 24, 24, 3);\n" +
                "\n" +
                "INSERT INTO folha_caracteristicas(id_personagem, forca, constituicao, tamanho, destreza, poder) VALUES (1, 50, 50, 40, 40, 60);\n" +
                "\n" +
                "INSERT INTO folha_caracteristicas(id_personagem, forca, constituicao, tamanho, destreza, poder) VALUES (2, 120, 120, 120, 120, 120);\n";
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
