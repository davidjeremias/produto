CREATE TABLE TB001_PRODUTO(
	CO_PRODUTO INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	NO_NOME VARCHAR(200) NOT NULL,
   	NU_ESTOQUE INT DEFAULT 0,
   	VL_PRECO DECIMAL(5,2) NOT NULL
)