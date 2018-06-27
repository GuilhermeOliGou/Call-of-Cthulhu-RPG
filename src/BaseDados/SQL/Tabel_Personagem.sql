CREATE TABLE `coc`.`personagem` (
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
	nome varchar(100)  not null primary key
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_general_cs;
