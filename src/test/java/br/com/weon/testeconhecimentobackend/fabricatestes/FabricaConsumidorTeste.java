package br.com.weon.testeconhecimentobackend.fabricatestes;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.weon.testeconhecimentobackend.consumidor.IConsumidor;
import br.com.weon.testeconhecimentobackend.fabrica.FabricaConsumidor;

class FabricaConsumidorTeste {

	@BeforeAll
	static void retornaInstanciaDeIConsumidor() {
		assertTrue(FabricaConsumidor.fabricarConsumidor(1).get(0) instanceof IConsumidor,
				"A fabrica não retornou uma instancia de IConsumidor!");
	}
	
	@Test
	void retornaUmaInstanciaDeIConsumidor() {
		assertTrue(FabricaConsumidor.fabricarConsumidor(1).get(0) instanceof IConsumidor,
				"A fabrica não retornou uma instancia de IConsumidor!");
	}
	
	@Test
	void retornaTresInstanciasDeIConsumidor() {
		assertTrue(FabricaConsumidor.fabricarConsumidor(3).size() == 3,
				"A fabrica não retornou três instancias de IConsumidor!");
	}
	
	@Test
	void lancaInvalidParameterException() {
		assertThrows(InvalidParameterException.class, () -> FabricaConsumidor.fabricarConsumidor(0), 
				"A fabrica não retornou lançou uma InvalidParameterException ao tentar criar 0 instancias de IConsumidor!");
	}
	
	@Test
	void validaMensagemDeExcecaoLancada() {
		Exception exception = assertThrows(InvalidParameterException.class, () -> FabricaConsumidor.fabricarConsumidor(-1));
		
		String mensagemAtual = exception.getMessage();
		String mensagemEsperada = "Não é possível criar -1 instancias de IConsumidor";
		
		assertEquals(mensagemAtual,mensagemEsperada);
	}
}
