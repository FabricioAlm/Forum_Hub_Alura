create table topicos (

    id bigint not null auto_increment,
    titulo varchar(100) unique not null,
    mensagem varchar(400) unique not null,
    curso varchar(100) not null,
    data timestamp,

    primary key(id)
);