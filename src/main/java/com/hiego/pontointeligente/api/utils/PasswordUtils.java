package com.hiego.pontointeligente.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import ch.qos.logback.classic.Logger;

public class PasswordUtils {

	private static final org.jboss.logging.Logger log = LoggerFactory.logger(PasswordUtils.class);
	
	public PasswordUtils() {
		
	}

	/**
	 * Gerar um hash utilizando o Bycrypt
	 * 
	 * @param
	 * @return String
	 */
	
	private static final String SENHA = "12345";
	private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	public static String gerarBCryption(String senha) {
		if(senha == null) {
			return senha;
		}
		
		log.info("Gerarndo Hash com BCryptiConde");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
		
	}
	
	@Test
	public void testeSenhaNula() throws Exception{
		assertNull(PasswordUtils.gerarBCryption(SENHA));
	}
	
	@Test
	public void testGerarHashsSenha() throws Exception{
		String hash = PasswordUtils.gerarBCryption(SENHA);
		
		assertTrue(bCryptEncoder.matches(SENHA, hash));
	}
	
	
	
}