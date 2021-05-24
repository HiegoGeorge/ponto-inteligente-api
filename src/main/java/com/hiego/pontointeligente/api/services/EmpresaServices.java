package com.hiego.pontointeligente.api.services;

import java.util.Optional;

import com.hiego.pontointeligente.api.entities.Empresa;

public interface EmpresaServices {
	
	/**
	 * Retorna uma empresa dado um CNPJ
	 * 
	 * @param cnpj
	 * @return Optinal<Empresa>
	 * 
	 * */
	
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	/** 
	 * Cadastrar uma nova empresa na base de Dados
	 * 
	 * @param empresa
	 * @return Empresa
	 * */
	
	Empresa persistir(Empresa empresa);
	
	
	

}
