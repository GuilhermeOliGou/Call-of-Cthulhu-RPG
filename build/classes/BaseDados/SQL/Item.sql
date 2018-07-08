use coc;

CREATE TABLE listaItem(
	itemID smallint unsigned primary key,
    itemNome varchar(75) not null,
    itemDescricao varchar(200) not null,
    itemTipo varchar(50) not null,
	itemDano smallint not null,
    itemAlcance int not null,
    itemUsos smallint not null,
    itemPreco int not null,
    itemFunc smallint not null
);

CREATE TABLE Item(
	itemRegistro int unsigned primary key,
    itemID smallint not null,
    jogadorID int not null,
    itemQntd smallint not null,
    itemFuncAtual smallint not null,
    
    constraint fk_listaItem_item foreign key (itemID) references listaItem(itemID),
    constraint fk_jogador_item foreign key (jogadorID) references jogador(jogadorID)
);