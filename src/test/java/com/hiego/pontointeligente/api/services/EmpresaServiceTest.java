package com.hiego.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hiego.pontointeligente.api.entities.Empresa;
import com.hiego.pontointeligente.api.repositories.EmpresaRepository;

@RunWith(SpringRunner.class) //
@SpringBootTest             // spring define um contexto de teste e nao de produçao real
@ActiveProfiles("test")
public class EmpresaServiceTest {
	
	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaServices empresaServices;
	
	private static final String CNPJ = "51220880001003";
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
		
	}
	
	@Test
	public void testBuscaPorCnpj() { 
		Optional<Empresa> empresa = this.empresaServices.buscarPorCnpj(CNPJ);
		
		assertTrue(empresa.isPresent());
		
	}
	
	@Test
	public void testPersistirEmpresa() {
		Empresa empresa = this.empresaServices.persistir(new Empresa());
		
		assertNotNull(empresa);
	}
	
		
		
		
}				
				
				
				
				
				