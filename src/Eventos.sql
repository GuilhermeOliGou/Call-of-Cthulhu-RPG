CREATE TABLE Eventos(
	idEvento int unsigned not null auto_increment primary key,
	idJogador int unsigned not null,
	idLocal int unsigned not null,
	nomeEvento varchar(100) unsigned not null,
	descricao varchar(300) unsigned not null,
	idLocalRetorno int unsigned not null,
	eventoUnico tinyint unsigned not null,
	qntTrigger int unsigned not null,
	constraint fk_Eventos_Jogadores FOREIGN KEY (idJogador) REFERENCES Jogadores (idJogador),
	constraint fk_Eventos_Locais FOREIGN KEY (idLocal) REFERENCES Locais(idLocal)
);