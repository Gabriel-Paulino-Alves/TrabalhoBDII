CREATE DATABASE conexaoBD;

CREATE TABLE Pessoa(Id INT PRIMARY KEY AUTO_INCREMENT,
cpf CHAR(11), nome VARCHAR(50));


CREATE TABLE cartao(
idCartao INT PRIMARY KEY AUTO_INCREMENT,
dataValidade CHAR(5),
numeroCartao CHAR(4),
limiteTotal DOUBLE,
limiteDisponivel DOUBLE,
idPessoa INT,
CONSTRAINT pessoaCartao FOREIGN KEY (idPessoa) REFERENCES pessoa(Id));

CREATE TABLE cartaoAdd(
idCartaoAdd INT PRIMARY KEY AUTO_INCREMENT,
dataValidade CHAR(5),
numeroCartao CHAR(4),
limiteTotal DOUBLE,
limiteDisponivel DOUBLE,
idCartao INT,
CONSTRAINT cartaoCartao FOREIGN KEY (idCartao) REFERENCES cartao(idCartao));

CREATE TABLE transacao(
idTransacao INT PRIMARY KEY AUTO_INCREMENT,
valorTransacao DOUBLE,
comercio VARCHAR(50)
idCartao INT,
CONSTRAINT cartaoTransacao FOREIGN KEY (idCartao) REFERENCES cartao(IdCartao));