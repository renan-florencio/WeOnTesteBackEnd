package br.com.weon.testeconhecimentobackend.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * Classe de configuração
 */
public class Config {
	
	/*
	 * Método estático loadProperties
	 * Responsável por carregar o arquivo application.properties
	 * 
	 * @Return Properties.class
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
