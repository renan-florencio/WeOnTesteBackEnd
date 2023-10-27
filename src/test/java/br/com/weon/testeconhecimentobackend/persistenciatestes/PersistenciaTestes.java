package br.com.weon.testeconhecimentobackend.persistenciatestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.EntityManager;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class PersistenciaTestes {

	File yaml = new File(this.getClass().getResource("/config.yaml").getFile());
	
	void criaConfiguracao() {
		try {
			Configuracao.configurar(yaml.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false,"Ocorreu um erro ao encontrar o arquivo ou em sua configuração!");
		}
	}
	
	@Test
	@Order(1)
	void retornaInstanciaDeEntityManager() {
		criaConfiguracao();
		Persistencia.criar();
		assertTrue(Persistencia.obter() instanceof EntityManager);
	}

}
