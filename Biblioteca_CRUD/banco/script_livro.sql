CREATE DATABASE IF NOT EXISTS cadastro_java_biblioteca;
USE cadastro_java_biblioteca;

CREATE TABLE IF NOT EXISTS Livros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(150) NOT NULL,
	genero VARCHAR(50) NOT NULL,
    idioma VARCHAR(80) NOT NULL,
    qtd INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);   

