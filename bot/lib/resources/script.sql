create database chatbot;

use chatbot;

create table usuarios
(id int primary key auto_increment not null,
nome varchar(255) not null,
usuario varchar(255) not null unique,
cpf varchar(13) not null unique,
senha varchar(255) not null);

