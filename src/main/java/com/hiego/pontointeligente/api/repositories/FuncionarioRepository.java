package com.hiego.pontointeligente.api.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiego.pontointeligente.api.entities.Funcionario;

@Transactional
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
    Funcionario findByCpf(String cpf);
	
	Funcionario findByEmail(String email);
	
	Funcionario findByCpfOrEmail(String cpf, String email);

	

}
