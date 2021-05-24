package com.hiego.pontointeligente.api.services;

import java.util.Optional;

import com.hiego.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persistir um funcionario na base de dados
	 * 
	 *@param Funcionario
	 * @return Funcionario
	 * 
	 */
	
	Funcionario persistirFuncionario(Funcionario funcionario);
	
	/**
	 * 
	 * Buscar e retornar o funcionario dado um CPF
	 * 
	 * @param cpf
	 * @return Cpf
	 * */
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * 
	 * Buscar e retornar um funcionario dado um email
	 * 
	 * @param
	 * @return Optional<Funcionario>
	 * 
	 * */
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * 
	 * Busca e retornar um funcionario dado Email
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 * 
	 * */
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * 
	 * Buscar e retornar um funcionario por ID
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 * 
	 * */ 
	
	Optional<Funcionario> buscarPorId(Long id);

	Funcionario persistir(Funcionario funcionario);
	

}
