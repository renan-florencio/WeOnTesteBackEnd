package br.com.weon.testeconhecimentobackend.configuracao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@summary YAMLConfig}
 * Classe de modelo de configuração de arquivo YAML
 */

@SuppressWarnings("javadoc")
public class YAMLConfig {
	
	@JsonProperty(value="consumidores")
	private String consumidores;
	@JsonProperty(value="produtores_voz")
	private String produtoresVoz;
	@JsonProperty(value="produtores_email")
	private String produtoresEmail;
	@JsonProperty(value="produtores_chat")
	private String produtoresChat;
	@JsonProperty(value="produtores_timeout")
	private String produtoresTimeout;
	@JsonProperty(value="DB")
	private List<DBConfig> dbConfig;
	
	public YAMLConfig() {
		
	}
	
	public YAMLConfig(String consumidores, String produtoresVoz, String produtoresEmail, String produtoresChat,
			String produtoresTimeout, List<DBConfig> dbConfig) {
		this.consumidores = consumidores;
		this.produtoresVoz = produtoresVoz;
		this.produtoresEmail = produtoresEmail;
		this.produtoresChat = produtoresChat;
		this.produtoresTimeout = produtoresTimeout;
		this.dbConfig = dbConfig;
	}
	
	public String getConsumidores() {
		return consumidores;
	}
	
	public void setConsumidores(String consumidores) {
		this.consumidores = consumidores;
	}

	public String getProdutoresVoz() {
		return produtoresVoz;
	}

	public void setProdutoresVoz(String produtoresVoz) {
		this.produtoresVoz = produtoresVoz;
	}

	public String getProdutoresEmail() {
		return produtoresEmail;
	}

	public void setProdutoresEmail(String produtoresEmail) {
		this.produtoresEmail = produtoresEmail;
	}

	public String getProdutoresChat() {
		return produtoresChat;
	}

	public void setProdutoresChat(String produtoresChat) {
		this.produtoresChat = produtoresChat;
	}

	public String getProdutoresTimeout() {
		return produtoresTimeout;
	}

	public void setProdutoresTimeout(String produtoresTimeout) {
		this.produtoresTimeout = produtoresTimeout;
	}

	public List<DBConfig> getDbConfig() {
		return dbConfig;
	}

	public void setDbConfig(List<DBConfig> dbConfig) {
		this.dbConfig = dbConfig;
	}
	
	
	
}