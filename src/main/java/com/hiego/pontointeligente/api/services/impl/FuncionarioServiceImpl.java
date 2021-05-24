package com.hiego.pontointeligente.api.services.impl;

import java.util.Optional;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiego.pontointeligente.api.entities.Funcionario;
import com.hiego.pontointeligente.api.repositories.FuncionarioRepository;
import com.hiego.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	private static final Logger log = LoggerFactory.getLogger(FuncionarioService.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistir funcionario: {} ", funcionario);
		return this.funcionarioRepository.save(funcionario);	
		
	}
	
	public Optional<Funcionario> buscarPorEmail(String email){
		log.info("Buscar Funcionairo pelo email {}", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}
	
	public Optional<Funcionario> buscarPorCpf(String cpf){
		log.info("Buscar Funcionairo pelo cpf {}", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}
	

	public Optional<Funcionario> buscarPorId(Long id){
		log.info("Buscar Funcionairo pelo Id {}", id);
		return Optional.ofNullable(this.funcionarioRepository.findOne(id));
	}
}
