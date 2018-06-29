package BaseDados;

public class popula {

    public String criaTabelas() {
        String texto = ""
                + "Create database coo_ep2_v1;"
                
                + "Create table personagem("
                + "id_personagem int not null primary key auto increment,"
                + "id_atributos int not null,"
                + "idade int not null,"
                + "id_inventario int not null,"
                + ""
                + "constraint fk_folha_atributos_personagem foreign key (id_personagem) references folhaAtributos(id_atributos),"
                + "constraint fk_inventario_personagem foreign key (id_inventario) references inventario(id_inventario)"
                + ");"
                + ""
                + "Create table folha_atributos("
                + "id_atributos int not null auto increment primary key,"
                + "	maxHp int not null,"
                + "	maxMP  int not null,"
                + "	hpAtual  int not null,"
                + "	mpAtual  int not null,"
                + "	bonusDano  int not null"
                + "	);"
                + ""
                + "Create table caracteristicas("
                + "	id_caracteristicas int not null auto increment primary key,"
                + "	forca int not null,"
                + "	constituição int not null,"
                + "	tamanho int not null,"
                + "	destreza int not null,"
                + "	poder int not null"
                + "	);"
                + ""
                + "Create table habilidades_luta("
                + "id_luta int not null auto increment primary key,"
                + "esquiva int not null,"
                + "luta_livre int not null,"
                + "luta_lanca int not null, "
                + "luta_espada int not null,"
                + "luta_chicote int not null"
                + ");"
                + ""
                + "Create table habilidades_tiro("
                + "id_tiro int not null auto increment primary key,"
                + "tiro_pistola int not null,"
                + "tiro_rifle int not null,"
                + "tiro_submetralhadora int not null,"
                + "arremesso int not null"
                + ");"
                + ""
                + "Create table item("
                + "id_item int not null auto increment primary key,"
                + "nome varchar(35) not null,"
                + "descricao varchar(100) not null"
                + ");"
                + ""
                + "Create table item_Consumivel("
                + "id_item_consumivel int not null auto increment primary key,"
                + "id_item int not null,"
                + "hp_recuperada int not null,"
                + "mp_recucuperada int not null,"
                + "quantidade int not null,"
                + ""
                + "constraint fk_item_item_consumivel foreign key (id_item) references item(id_item)"
                + ");"
                + ""
                + ""
                + "Create table arma("
                + "id_arma int not null auto increment primary key,"
                + "id_item int not null,"
                + ""
                + "id_habilidadesLuta"
                + "id_habilidadesTiro"
                + ""
                + "constraint fk_item_arma foreign key (id_item) references item(id_item)"
                + "constraint fk_habilidadetiro_arma foreign key (id_arma) references ha"
                + ""
                + ");"
                + ""
                + ""
                + "Create table folhaDano("
                + "id_folha_dano int not null auto increment primary key,"
                + "adicional int not null,"
                + "artodoamento int not null,"
                + ""
                + "	//Poe as rolagens uma por uma"//por as rolagens uma por uma
                + "	//Falta confirmar quantas são..."
                + ");"
                + ""
                + "Create table jogador("
                + "id_jogador int not null primary key,"
                + "id_personagem int not null,"
                + "id_habilidades int not null,"
                + "max_sanidade int not null,"
                + "sanidade_atual int not null,"
                + "sorte int not null,"
                + ""
                + "constraint fk_personagem_jogador foreign key (id_personagem) references personagem(id_personagem),"
                + "constraint fk_folha_habilidades_jogador foreign key (id_habilidades) references folha_habilidades(id_habilidades)"
                + "//Falta a table folha_habilidades..."
                + ");"
                + "";

        return texto;
    }

    public String populaTabelas() {

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
        return texto;
    }

}
