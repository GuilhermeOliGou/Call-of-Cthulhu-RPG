CREATE TABLE `Atributos` (
	idJogador int unsigned not null,
	forca smallint unsigned not null,
	constituicao smallint unsigned not null,
	tamanho smallint unsigned not null,
	destreza smallint unsigned not null,
	aparencia smallint unsigned not null,
	inteligencia smallint unsigned not null,
	educacao smallint unsigned not null,
	poder smallint unsigned not null,

	maxHp smallint unsigned not null, 
	maxMp smallint unsigned not null,
	hpAtual smallint unsigned not null,
	mpAtual smallint unsigned not null,
	movimento smallint unsigned not null,
	bonusDeDanoCorporal smallint unsigned not null,
	build smallint unsigned not null,
	idade smallint unsigned not null,
	constraint fk_Atributos_Jogadores FOREIGN KEY (idJogador) REFERENCES Jogadores (idJogador)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_general_cs;