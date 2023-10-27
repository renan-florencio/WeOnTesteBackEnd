package br.com.weon.testeconhecimentobackend.daotestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.weon.testeconhecimentobackend.canal.Voz;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.dao.VozDAOImpl;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.NoResultException;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class VozDAOImplTestes {

	File yaml = new File(this.getClass().getResource("/config.yaml").getFile());
	Voz voz = new Voz(UUID.randomUUID(),"41 9 8888-8888","41 9 999-9999",LocalDateTime.now());
	static VozDAOImpl dao;
	
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
		
		dao = new VozDAOImpl();
	}
	
	@Test
	@Order(2)
	void salvarObjeto() {
		
		dao.salvar(voz);
		
		Voz dbVoz = dao.obter(voz.getId());
		
		assertEquals(voz.getId(),dbVoz.getId(),"O ID obtido é diferente do esperado!");
		assertEquals(voz.getTelefoneOrigem(),dbVoz.getTelefoneOrigem(),
				"O telefone de origem obtido é diferente do esperado!");
		assertEquals(voz.getTelefoneDestino(),dbVoz.getTelefoneDestino(),
				"O telefone de destino obtido é diferente do esperado!");
		assertEquals(voz.getDataHora(),dbVoz.getDataHora(),
				"A data e hora obtida é diferente do esperado!");
	}
	
	@Test
	@Order(3)
	void obterTodosOsObjetos() {
		assertEquals(1,dao.obterTodos().size(),"O dao não retornou nenhum objeto do tipo Voz");
	}
	
	@Test
	void removerObjeto() {
		dao.remover(voz);
		assertThrows(NoResultException.class,() -> dao.obter(voz.getId()),
				"O objeto não foi removido da base de dados!");
	}
}
