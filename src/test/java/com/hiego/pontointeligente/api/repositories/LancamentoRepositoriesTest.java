package com.hiego.pontointeligente.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hiego.pontointeligente.api.entities.Empresa;
import com.hiego.pontointeligente.api.entities.Funcionario;
import com.hiego.pontointeligente.api.entities.Lancamento;
import com.hiego.pontointeligente.api.enums.PerfilEnum;
import com.hiego.pontointeligente.api.enums.TipoEnum;
import com.hiego.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class) //
@SpringBootTest             // spring define um contexto de teste e nao de produçao real
@ActiveProfiles("test")
public class LancamentoRepositoriesTest {
	
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	
	private static final String EMAIL = "email@email.com.br";
	private static final String CPF = "24145636899";
	
	
	@Before
	public void setUp() throws Exception{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
	}
	
	@After
	public void tearDown() throws Exception {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		List<Lancamento> lancamento = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		assertEquals(2, lancamento.size());
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioIdPaginado() {
		PageRequest page = new PageRequest(0, 10); // simular consulta paginada de 0 a 10
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionario(funcionarioId, page);
		
		assertEquals(2, lancamentos.getTotalElements());
	}
	
	
	
	
	private Funcionario obterDadosFuncionario(Empresa empresa)throws NoSuchAlgorithmException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Amintas Pereira");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCryption("12345"));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
	
	
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("empresa do ramoY");
		empresa.setCnpj("516606000100");
		return empresa;
	}
	
	private Lancamento obterDadosLancamentos(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return lancamento;
		
	}

}
