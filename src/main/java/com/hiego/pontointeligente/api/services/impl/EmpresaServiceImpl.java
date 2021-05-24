package com.hiego.pontointeligente.api.services.impl;

import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiego.pontointeligente.api.entities.Empresa;
import com.hiego.pontointeligente.api.repositories.EmpresaRepository;

import ch.qos.logback.classic.Logger;

@Service
public class EmpresaServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj){
		log.info("Buscando uma empresa para CNPJ: {} ",cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
		
	}
	
	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa : {} ", empresa);
		return this.empresaRepository.save(empresa);
	}

}
