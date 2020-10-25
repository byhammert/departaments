CREATE TABLE department (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	code VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(100) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	direction VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO department (	code, 
							name,
							address,
							city,
							state,
							direction )
							
				 values (	'DEP01', 
				 			'department 1',
				 			'address Teste, 40',
				 			'Embu-Guaçu',
				 			'SP',
				 			'EIS');
				 			
INSERT INTO department (	code, 
							name,
							address,
							city,
							state,
							direction )
							
				 values (	'DEP02', 
				 			'department 2',
				 			'address Teste 2, 42',
				 			'São Paulo',
				 			'BA',
				 			'RECUPERACAO');
				 			
INSERT INTO department (	code, 
							name,
							address,
							city,
							state,
							direction )
							
				 values (	'DEP03', 
				 			'department 3',
				 			'address Teste 3, 43',
				 			'São Paulo',
				 			'CE',
				 			'NEGOCIOS');