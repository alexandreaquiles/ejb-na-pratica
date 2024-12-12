USE livrariadb;

CREATE table livro (
	id BIGINT IDENTITY PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	preco DECIMAL(12,2) NOT NULL
);

INSERT into livro (nome, preco) values
('O Iluminado', 40.0),
('Patterns of Enterprise Application Architecture', 64.0),
('Desbravando SOLID', 39.99);

SELECT * from livro;