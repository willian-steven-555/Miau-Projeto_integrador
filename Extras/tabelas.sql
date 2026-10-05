create schema EDGJ;
use EDGJ;
CREATE TABLE usuario(
    nomeUsuario CHAR(20) NOT NULL,
    senha VARCHAR(30) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    endereco varchar(150),
    administrador BOOLEAN NOT NULL,

    PRIMARY KEY(nomeUsuario)
);

CREATE TABLE animal(
    id INT AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    idade INT NOT NULL,
    especie char(10) NOT NULL,
    raca VARCHAR(40),
    genero char(5),
    porte char(10) not null,
    descricao varchar(250),
    publicador CHAR(20),
    telefoneDono VARCHAR(11) NOT NULL,
    imagem MEDIUMBLOB NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(publicador) REFERENCES usuario(nomeUsuario)
);

create table animaisRemovidos(
	id int not null,
    descricaoDeInfracao varchar(500) not null,
    foreign key (id) references animal(id)
);
create table usuariosRemovidos(
	nomeUsuario char(20) not null,
    descricaoDeInfracao varchar(500) not null,
    foreign key (nomeUsuario) references usuario(nomeUsuario)
);