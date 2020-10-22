CREATE TABLE departamento (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo VARCHAR(50) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	local VARCHAR(100) NOT NULL,
	cidade VARCHAR(50) NOT NULL,
	estado VARCHAR(50) NOT NULL,
	diretoria VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO departamento (	codigo, 
							nome,
							local,
							cidade,
							estado,
							diretoria )
							
				 values (	'DEP01', 
				 			'Departamento 1',
				 			'Local Teste, 40',
				 			'Embu-Guaçu',
				 			'São Paulo',
				 			'EIS');
				 			
INSERT INTO departamento (	codigo, 
							nome,
							local,
							cidade,
							estado,
							diretoria )
							
				 values (	'DEP02', 
				 			'Departamento 2',
				 			'Local Teste 2, 42',
				 			'São Paulo',
				 			'São Paulo',
				 			'RECUPERACAO');
				 			
INSERT INTO departamento (	codigo, 
							nome,
							local,
							cidade,
							estado,
							diretoria )
							
				 values (	'DEP03', 
				 			'Departamento 3',
				 			'Local Teste 3, 43',
				 			'São Paulo',
				 			'São Paulo',
				 			'NEGOCIOS');