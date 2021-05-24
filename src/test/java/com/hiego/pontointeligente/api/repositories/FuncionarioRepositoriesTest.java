package com.hiego.pontointeligente.api.repositories;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hiego.pontointeligente.api.entities.Empresa;
import com.hiego.pontointeligente.api.entities.Funcionario;
import com.hiego.pontointeligente.api.enums.PerfilEnum;
import com.hiego.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class) //
@SpringBootTest             // spring define um contexto de teste e nao de produçao real
@ActiveProfiles("test")
public class FuncionarioRepositoriesTest {

	@Autowired
	private FuncionarioRepositoriesTest funcionarioRepository;
	
	
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String EMAIL = "email@email.com.br";
	private static final String CPF = "24145636899";
	
	@Before
	public void setUp() throws Exception {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosEmpresa(empresa));
	}
	
	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, funcionario.getEmail());
	}
	
	@Test 
	public void testBuscarFuncionarioPorCpf() { // busca funcionario por cpf
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
		assertEquals(CPF, funcionario.getCpf()); // verifica se o cpf e o mesmo retornado
	}
	
	
	
	@Test
	public void testBuscarFuncionarioPorEmailECpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF,EMAIL);
		
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaCpfInvalido() { // buscando func pelo cpf com email invalido
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF,"email@invalid.com.br");
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() { // bucando por cpf invalido e email valido
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("24145636899",EMAIL);
		assertNotNull(funcionario);
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
	
}
