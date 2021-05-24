package com.hiego.pontointeligente.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hiego.pontointeligente.api.entities.Empresa;

@RunWith(SpringRunner.class) //
@SpringBootTest             // spring define um contexto de teste e nao de produçao real
@ActiveProfiles("test")
public class EmpresaRepositoriesTest {

	@Autowired // injeçao de dependencia para ter acesso a classe 
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "516606000100";
	
	@Before  // executa operaçao antes da execuçao do teste
	public void setUp() { // cadastrando uma empresa como teste
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial(CNPJ);
		empresa.setCnpj(CNPJ);
		this.empresaRepository.save(empresa);
	}
	
	
	@After //executa apos a execuçao do teste
	public final void teamDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscaPorCnpj() { // fazendo teste em buscar empresa por CNPJ para teste ser valido anotaçao @Test
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		assertEquals(CNPJ, empresa.getCnpj());
	}
	
}
