DROP TABLE livros IF EXISTS;
CREATE TABLE orcamentos (
    codigo long,
    descricao VARCHAR(255),
    autor VARCHAR(255),
    ano int,
    PRIMARY KEY(codigo)
);
