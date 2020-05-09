drop table if exists enfermeiro;

create table enfermeiro(
    id bigint auto_increment,
    nome varchar(100) not null,
    idade int not null,
    local varchar(100) not null,
    primary key(id)
);