package br.com.weon.testeconhecimentobackend.configuracao;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * {@summary Configuracao}
 * Classe responsável por configuração do projeto
 */
public class Configuracao {
	
	private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	private static YAMLConfig yaml;
	
	/**
	 * Método para instanciar configuração
	 * @param arquivoDeConfiguracao - Caminho onde se encontra o arquivo de configuracao
	 * @throws StreamReadException
	 * @throws DatabindException
	 * @throws IOException
	 */
	public static void configurar(String arquivoDeConfiguracao) throws StreamReadException, DatabindException, IOException {
		
		if (yaml == null) {
			yaml = mapper.readValue(new File(arquivoDeConfiguracao), YAMLConfig.class);
		}
		
	}
	
	/**
	 * Método para obter instancia de configuração
	 * @return YAMLConfig - Objeto com configuração de arquivo .yaml
	 */
	public static YAMLConfig obter() {
		return yaml;
	}
}
