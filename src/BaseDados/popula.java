package BaseDados;

public void populaTabelas(){
	abreConexao();
	preparaComandoSQL("insert into Jogadores(idJogador) values(1);"
		+"insert into Locais(nomeLocal) values('Sala 1');"
		+"insert into Locais(nomeLocal) values('Corredor');"
		+"insert into Locais(nomeLocal) values('Banheiro');"
		+"insert into Locais(nomeLocal) values('Sala 2');"
		+"insert into Locais(nomeLocal) values('Laboratorio');"
		+"insert into Locais(nomeLocal) values('Sala Final');"
		+"insert into Atributos(idJogador, forca, constituicao, tamanho, destreza, aparencia, inteligencia, educacao, poder, maxHp, maxMp, hpAtual, mpAtual, movimento, bonusDeDanoCorporal, build, idade) values(1,20,12,20,35,45,60,75,3,40,40,40,40,37,1,1,19);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,1,'Abrir a porta','Tentar abrir a porta',1,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,1,'olhar mesa','olhar a mesa do professor',1,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,1,'ir para o corredor','sair da sala e ir para o corredor',2,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'acender as luzes','acender as luzes do corredor',2,1,0);" 
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'voltar sala 1','voltar para a sala 1',1,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'ir para a sala 2','ir para a sala 2',4,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'ir para o banheiro','dir para o banheiro',3,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,2,'ir para o laboratorio','ir para o laboratorio',5,1,0);" 
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,4,'voltar para o corredor','voltar par o corredor',2,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,3,'voltar para o corredor','voltar para o corredor',2,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,5,'voltar para o corredor','voltar para o corredor',1,1,0);"
		+"insert into Eventos(idJogador,idLocal,nomeEvento,descricao,idLocalRetorno,eventoUnico,qntTrigger) values(1,5,'fazer o EP de COO','Terminar o EP de COO para entregar (Urgencia)',1,1,0);"
		);
	pstmt.execute();
	fechaConexao();
}