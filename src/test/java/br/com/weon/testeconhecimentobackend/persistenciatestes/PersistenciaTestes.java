package br.com.weon.testeconhecimentobackend.persistenciatestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.weon.testeconhecimentobackend.canal.Voz;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import jakarta.persistence.NoResultException;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class PersistenciaTestes {

	File yaml = new File(this.getClass().getResource("/config.yaml").getFile());
	Voz voz = new Voz(UUID.randomUUID(),"41 9 8888-8888","41 9 999-9999",LocalDateTime.now());
	
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
	}
	
	@Test
	@Order(2)
	void persisteEntidadeEmBaseDeDados() {
		Persistencia.salvar(voz);
		
		Voz dbVoz = Persistencia.consultaNomeada("obterVoz", Voz.class)
				.setParameter("id",voz.getId()).getSingleResult();
		
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
	void atualizaObjetoNaBaseDeDados() {
		
		voz.setTelefoneOrigem("11 1 1111-1111");
		voz.setTelefoneDestino("22 2 2222-2222");

		Persistencia.salvar(voz);
		
		Voz dbVoz = Persistencia.consultaNomeada("obterVoz", Voz.class)
				.setParameter("id",voz.getId()).getSingleResult();
		
		assertEquals("11 1 1111-1111",dbVoz.getTelefoneOrigem(),
				"O telefone de origem obtido é diferente do esperado!");
		assertEquals("22 2 2222-2222",dbVoz.getTelefoneDestino(),
				"O telefone de destino obtido é diferente do esperado!");
	}
	
	@Test
	@Order(4)
	void removeObjetoDaBaseDeDados() {

		Persistencia.remover(voz);
		
		assertThrows(NoResultException.class,() -> Persistencia.consultaNomeada("obterVoz", Voz.class)
				.setParameter("id",voz.getId()).getSingleResult(),
				"O objeto não foi removido da base de dados!");
	}
	
	@AfterAll
	static void fechaConexao() {
		Persistencia.fecharConexao();
	}
}
