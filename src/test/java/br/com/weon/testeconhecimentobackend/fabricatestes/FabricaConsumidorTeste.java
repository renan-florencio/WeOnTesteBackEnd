package br.com.weon.testeconhecimentobackend.fabricatestes;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FabricaConsumidorTeste {

	@BeforeAll
	void retornaInstanciaDeIConsumidor() {
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
		assertTrue(FabricaConsumidor.fabricarConsumidor(1).size() == 3,
				"A fabrica não retornou três instancias de IConsumidor!");
	}
	
	@Test
	void lancaInvalidParameterException() {
		assertThrows(InvalidParameterException.class, () ->{}, 
				"A fabrica não retornou lançou uma InvalidParameterException ao tentar criar 0 instancias de IConsumidor!");
	}
}
