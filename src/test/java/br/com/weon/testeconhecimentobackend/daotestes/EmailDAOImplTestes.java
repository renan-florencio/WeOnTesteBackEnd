package br.com.weon.testeconhecimentobackend.daotestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.weon.testeconhecimentobackend.canal.Email;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.dao.EmailDAOImpl;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class EmailDAOImplTestes {

	File yaml = new File(this.getClass().getResource("/config.yaml").getFile());
	Email email = new Email(UUID.randomUUID(),"teste@email.com.br","teste2@emai.com.br",LocalDateTime.now());
	static EmailDAOImpl dao;
	
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
	void criaInstanciaDeEntityManager() {
		criaConfiguracao();
		Persistencia.criar();
		assertTrue(Persistencia.obter() instanceof EntityManager);
		
		dao = new EmailDAOImpl();
	}
	
	@Test
	@Order(2)
	void salvarObjeto() {
		
		dao.salvar(email);
		
		Email dbEmail = dao.obter(email.getId());
		
		assertEquals(email.getId(),dbEmail.getId(),"O ID obtido é diferente do esperado!");
		assertEquals(email.getEmailOrigem(),dbEmail.getEmailOrigem(),
				"O email de origem obtido é diferente do esperado!");
		assertEquals(email.getEmailDestino(),dbEmail.getEmailDestino(),
				"O email de destino obtido é diferente do esperado!");
		assertEquals(email.getDataHora(),dbEmail.getDataHora(),
				"A data e hora obtida é diferente do esperado!");
	}
	
	@Test
	@Order(3)
	void obterTodosOsObjetos() {
		assertEquals(1,dao.obterTodos().size(),"O dao não retornou nenhum objeto do tipo email");
	}
	
	@Test
	void removerObjeto() {
		dao.remover(email);
		assertThrows(NoResultException.class,() -> dao.obter(email.getId()),
				"O objeto não foi removido da base de dados!");
	}
}
