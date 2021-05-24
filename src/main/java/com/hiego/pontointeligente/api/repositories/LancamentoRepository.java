package com.hiego.pontointeligente.api.repositories;

import java.awt.print.Pageable;
import java.util.List;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hiego.pontointeligente.api.entities.Lancamento;

@Transactional({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", 
				query = "SELECT lanc FROM lancamento WHERE lanc.funcionario.id = :funcionarioId")})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	List<Lancamento> findByFuncionario(@Param ("Funcionario") Long funcionario); //retorna todos funcionarios
	Page<Lancamento> findByFuncionario(@Param ("Funcionario") Long funcionarioId, Pageable pageable);
}//retorna todos paginados
