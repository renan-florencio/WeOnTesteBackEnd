package br.com.weon.testeconhecimentobackend.configuracao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@summary DBConfig}
 * Classe de modelo de configuração de database
 */

@SuppressWarnings("javadoc")
public class DBConfig {
	
	@JsonProperty(value="driver")
	private String driver;
	@JsonProperty(value="url")
	private String url;
	@JsonProperty(value="hibernate_dialect")
	private String hibernateDialect;
	@JsonProperty(value="hibernate_hbm2ddl_auto")
	private String hibernateHbmToDDL;
	@JsonProperty(value="usuario")
	private String usuario;
	@JsonProperty(value="senha")
	private String senha;
	
	public DBConfig() {
	}

	public DBConfig(String driver, String url, String hibernateDialect, String hibernatHbmToDDL,String usuario, String senha) {
		this.driver = driver;
		this.url = url;
		this.hibernateDialect = hibernateDialect;
		this.hibernateHbmToDDL = hibernatHbmToDDL;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHibernateDialect() {
		return hibernateDialect;
	}
	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getHibernateHbmToDDL() {
		return hibernateHbmToDDL;
	}

	public void setHibernateHbmToDDL(String hibernateHbmToDDL) {
		this.hibernateHbmToDDL = hibernateHbmToDDL;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
