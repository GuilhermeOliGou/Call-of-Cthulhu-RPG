CREATE TABLE `coc`.`jogador` (
	nome varchar(100) not null,
    maxSanidade smallint unsigned not null,
    sanidadeAtual smallint unsigned not null,
	sorte smallint unsigned not null,
	constraint fk_jogador_personagem FOREIGN KEY (nome) REFERENCES personagem (nome)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_general_cs;
