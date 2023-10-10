create database chatbot;

use chatbot;

create table usuarios
(id int primary key auto_increment,
nome varchar(255) not null,
usuario varchar(50) not null unique,
cpf varchar(14) not null unique,
senha varchar(255) not null);

create table registro_usuario
(id int primary key auto_increment,
id_usuario INT NOT NULL,
data_hora_acesso DATETIME NOT NULL,
descricao text,
FOREIGN KEY (id_usuario) REFERENCES usuarios(id) );
