package br.com.weon.testeconhecimentobackend.fabricatestes;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.weon.testeconhecimentobackend.canal.Canal;
import br.com.weon.testeconhecimentobackend.fabrica.FabricaProdutor;
import br.com.weon.testeconhecimentobackend.produtor.IProdutor;
import br.com.weon.testeconhecimentobackend.produtor.ProdutorChat;
import br.com.weon.testeconhecimentobackend.produtor.ProdutorEmail;
import br.com.weon.testeconhecimentobackend.produtor.ProdutorVoz;

class FabricaProdutorTeste {

	@BeforeAll
	static void retornaInstanciaDeIProdutor() {
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.CHAT,1).get(0) instanceof IProdutor,
				"A fabrica não retornou uma instancia de IProdutor!");
	}
	
	@Test
	void retornaUmaInstanciaDeIProdutorEspecifica() {
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.VOZ,1).get(0) instanceof ProdutorVoz,
				"A fabrica não retornou uma instancia de ProdutorVoz!");
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.EMAIL,1).get(0) instanceof ProdutorEmail,
				"A fabrica não retornou uma instancia de ProdutorEmail!");
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.CHAT,1).get(0) instanceof ProdutorChat,
				"A fabrica não retornou uma instancia de ProdutorChat!");
	}
	
	@Test
	void retornaTresInstanciasDeIProdutorEspecifica() {
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.VOZ,3).size() == 3,
				"A fabrica não retornou três instancias de ProdutorVoz!");
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.EMAIL,3).size() == 3,
				"A fabrica não retornou três instancias de ProdutorEmail!");
		assertTrue(FabricaProdutor.fabricarProdutor(Canal.CHAT,3).size() == 3,
				"A fabrica não retornou três instancias de ProdutorChat!");
	}
	
	@Test
	void lancaInvalidParameterException() {
		assertThrows(InvalidParameterException.class, () -> FabricaProdutor.fabricarProdutor(Canal.CHAT,0), 
				"A fabrica não retornou lançou uma InvalidParameterException ao tentar criar 0 instancias de IProdutor!");
	}
	
	@Test
	void validaMensagemDeExcecaoLancada() {
		Exception exception = assertThrows(InvalidParameterException.class, () -> FabricaProdutor.fabricarProdutor(Canal.VOZ,-1));
		
		String mensagemAtual = exception.getMessage();
		String mensagemEsperada = "Não é possível criar -1 instancias de IProdutor";
		
		assertEquals(mensagemAtual,mensagemEsperada);
	}
}
