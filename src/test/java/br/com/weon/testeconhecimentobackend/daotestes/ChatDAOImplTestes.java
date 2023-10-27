package br.com.weon.testeconhecimentobackend.daotestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.weon.testeconhecimentobackend.canal.Chat;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.dao.ChatDAOImpl;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.NoResultException;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class ChatDAOImplTestes {

	File yaml = new File(this.getClass().getResource("/config.yaml").getFile());
	Chat chat = new Chat(UUID.randomUUID(),"Username1","Username2",LocalDateTime.now());
	static ChatDAOImpl dao;
	
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
	void criaInstanciaDePersistencia() {
		criaConfiguracao();
		Persistencia.criar();
		
		dao = new ChatDAOImpl();
	}
	
	@Test
	@Order(2)
	void salvarObjeto() {
		
		dao.salvar(chat);
		
		Chat dbChat = dao.obter(chat.getId());
		
		assertEquals(chat.getId(),dbChat.getId(),"O ID obtido é diferente do esperado!");
		assertEquals(chat.getNomeUsuarioOrigem(),dbChat.getNomeUsuarioOrigem(),
				"O usuario de origem obtido é diferente do esperado!");
		assertEquals(chat.getNomeUsuarioDestino(),dbChat.getNomeUsuarioDestino(),
				"O usuario de destino obtido é diferente do esperado!");
		assertEquals(chat.getDataHora(),dbChat.getDataHora(),
				"A data e hora obtida é diferente do esperado!");
	}
	
	@Test
	@Order(3)
	void obterTodosOsObjetos() {
		assertEquals(1,dao.obterTodos().size(),"O dao não retornou nenhum objeto do tipo chat");
	}
	
	@Test
	void removerObjeto() {
		dao.remover(chat);
		assertThrows(NoResultException.class,() -> dao.obter(chat.getId()),
				"O objeto não foi removido da base de dados!");
	}
}
