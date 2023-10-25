package br.com.weon.testeconhecimentobackend.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

class ConfigTest {
	
	String getKey(String key) {
		try {
			return Config.loadProperties().getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	void configReturnPropertiesInstanceTest() {
		try {
			assertTrue(Config.loadProperties() instanceof Properties, "A config não retorno uma instancia de properties!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void configGetConsumersIntances() {
		assertEquals("3",getKey("consumers.instances"));
	}

	@Test
	void configGetVoiceIntances() {
		assertEquals("3",getKey("producers.voice.instances"));
	}
	
	@Test
	void configGetChatIntances() {
		assertEquals("3",getKey("producers.chat.instances"));
	}
	
	@Test
	void configGetEmailIntances() {
		assertEquals("3",getKey("producers.email.instances"));
	}
	
	@Test
	void configGetProducersTimeout() {
		assertEquals("5",getKey("producers.timeout"));
	}
}
