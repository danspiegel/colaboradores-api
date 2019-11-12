/*Criação do banco de dados no PostgreSQL*/
create database apicolaboradores;

/*Criação da tabela de colaboradores*/
CREATE TABLE colaborador
(
  id bigint NOT NULL,
  cpf varchar(11),
  email varchar(255),
  idade integer NOT NULL,
  nome varchar(80),
  telefone varchar(9),
  setor_id bigint,
  CONSTRAINT pk_colaborador_id PRIMARY KEY (id),
  CONSTRAINT fk_colaborador_id_setor FOREIGN KEY (setor_id) REFERENCES setor (id),
  CONSTRAINT unq_colaborador_cpf UNIQUE (cpf)
)

/*Criação da tabela de setores*/
CREATE TABLE setor
(
  id bigint NOT NULL,
  descricao varchar(255),
  CONSTRAINT pk_setor_id PRIMARY KEY (id)
)

/*Criação da sequence utilizada para incrementar o ID da tabela de Colaborador*/
CREATE SEQUENCE seq_colaborador
  INCREMENT 50
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
  
/*Inserts da tabela de setor*/
INSERT INTO setor VALUES (1, 'Desenvolvimento');
INSERT INTO setor VALUES (2, 'Marketing');
INSERT INTO setor VALUES (3, 'Recursos Humanos');
