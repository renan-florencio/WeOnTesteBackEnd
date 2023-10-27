package br.com.weon.testeconhecimentobackend.configuracaotestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.configuracao.YAMLConfig;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class ConfiguracaoTeste {
	
	File yaml = new File(this.getClass().getResource("/config.yaml").getFile());
			
	@Test
	@Order(1)
	void criaConfiguracao() {
		try {
			Configuracao.configurar(yaml.getAbsolutePath());
		} catch (IOException e) {
			assertTrue(false,"Ocorreu um erro ao encontrar o arquivo ou em sua configuração!");
			e.printStackTrace();
		}
	}
	
	@Test
	void retornaYAMLConfig() {
		assertTrue(Configuracao.obter() instanceof YAMLConfig,
				"A configuração não retornou um YAMLConfig!");
	}
	
	@Test
	void verificaSeUmConsumidorEstaDefinidoNaConfiguracao() {
		assertEquals(1,Integer.parseInt(Configuracao.obter().getConsumidores()),
				"A configuração não possui um consumidor definido!");
	}
	
	@Test
	void verificaSeDoisProdutoresVozEstaDefinidoNaConfiguracao() {
		assertEquals(2,Integer.parseInt(Configuracao.obter().getProdutoresVoz()),
				"A configuração não possui dois produtores de voz definidos!");
	}
	
	@Test
	void verificaSeTresProdutoresEmailEstaDefinidoNaConfiguracao() {
		assertEquals(3,Integer.parseInt(Configuracao.obter().getProdutoresEmail()),
				"A configuração não possui três produtores de email definidos!");
	}
	
	@Test
	void verificaSeQuatroProdutoresEmailEstaDefinidoNaConfiguracao() {
		assertEquals(4,Integer.parseInt(Configuracao.obter().getProdutoresChat()),
				"A configuração não possui quatro produtores de chat definidos!");
	}
	
	@Test
	void verificaSeDriverEstaDefinidoNaConfiguracaoDeDB() {
		assertEquals("org.h2.Driver",Configuracao.obter().getDbConfig().get(0).getDriver(),
				"A configuração não retornou o driver!");
	}
	
	@Test
	void verificaSeURLEstaDefinidaNaConfiguracaoDeDB() {
		assertEquals("jdbc:h2:mem:test",Configuracao.obter().getDbConfig().get(0).getUrl(),
				"A configuração não retornou a url!");
	}
	
	@Test
	void verificaSeHibernateDialectEstaDefinidoNaConfiguracaoDeDB() {
		assertEquals("org.hibernate.dialect.H2Dialect",Configuracao.obter().getDbConfig().get(0).getHibernateDialect(),
				"A configuração não retornou a configuração do hibernate dialect!");
	}
	
	@Test
	void verificaSeHbmToDdlEstaDefinidoNaConfiguracaoDeDB() {
		assertEquals("create-drop",Configuracao.obter().getDbConfig().get(0).getHibernateHbmToDDL(),
				"A configuração não retornou a a configuração do hbm to ddl!");
	}
	
	@Test
	void verificaSeUsuarioEstaDefinidoNaConfiguracaoDeDB() {
		assertEquals("sa",Configuracao.obter().getDbConfig().get(0).getUsuario(),
				"A configuração não retornou o usuario!");
	}
	
	@Test
	void verificaSeSenhaEstaDefinidoNaConfiguracaoDeDB() {
		assertEquals("",Configuracao.obter().getDbConfig().get(0).getSenha(),
				"A configuração não retornou a senha!");
	}
}
