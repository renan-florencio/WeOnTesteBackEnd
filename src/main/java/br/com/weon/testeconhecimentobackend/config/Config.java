package br.com.weon.testeconhecimentobackend.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * {@summary Config}
 * Classe de configuração
 */
public class Config {
	
	/**
	 * {@summary Config.loadProperties()}
	 * Método estático loadProperties
	 * <br>Responsável por carregar o arquivo application.properties
	 * 
	 * @return {@link Properties}
	 * @throws IOException
	 */
    public static Properties loadProperties() throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = Config.class
          .getClassLoader()
          .getResourceAsStream("application.properties");
        configuration.load(inputStream);
        inputStream.close();
        return configuration;
    }
    
}
