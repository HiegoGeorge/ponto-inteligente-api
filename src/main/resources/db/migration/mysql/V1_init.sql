CREAT TABLE `empresa`(
	`id` bigint(20) NOT NULL,
	`razao_social` varchar(255) NOT NULL,
	`cnpj` varchar(255) NOT NULL,
	`data_criacao` datetime NOT NULL,
	`data_atualizacao` datetime NOT NULL,
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREAT TABLE `funcionario`(
	`id` bigint(20) NOT NULL,
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`senha` varchar(255) NOT NULL,
	`cpf` varchar(255) NOT NULL,
	`valor_hora` decimal(19,2) DEFAULT NULL,
	`qtd_horas_trabalhadas` float DEFAULT NULL,
	`qtd_horas_almoco` float DEFAULT NULL,
	`perfil` varchar(255) NOT NULL,
	`data_criacao` datetime NOT NULL,
	`data_atualizacao` datetime NOT NULL.
	`empresa_id` bigint(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREAT TABLE `lancamento`(
	`id` bigint(20) NOT NULL,	
	`data` datetime NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`localizacao` varchar(255) NOT NULL,
	`data_criacao` datetime NOT NULL,
	`data_atualizacao` datetime NOT NULL,
	`tipo` varchar(255) NOT NULL,
	`funcionario_id` bigint(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `empresa`
	MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `funcionario`
	MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `lancamento`
	MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;


ALTER TABLE `lancamento` ADD CONSTRAINT `lancamento_fk0` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario`(`id`);

ALTER TABLE `funcionario` ADD CONSTRAINT `funcionario_fk0` FOREIGN KEY (`empresa_id`) REFERENCES `empresa`(`id`);



