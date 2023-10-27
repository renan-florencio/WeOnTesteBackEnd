package br.com.weon.testeconhecimentobackend.canal;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * {@summary Chat}
 * Classe que representa o canal de chat
 */

@SuppressWarnings("javadoc")

@org.hibernate.annotations.NamedQueries({
	@org.hibernate.annotations.NamedQuery(name = "obterChat", 
			query = "from Chat where id = :id")
	})

@Entity
@Table(name = "Chat")
public class Chat implements ICanal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true,nullable = false)
	private UUID id;
	private String nomeUsuarioOrigem;
	private String nomeUsuarioDestino;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dataHora;
	
	public Chat() {
		
	}
	
	public Chat(String nomeUsuarioOrigem, String nomeUsuarioDestino, LocalDateTime dataHora) {
		this.nomeUsuarioOrigem = nomeUsuarioOrigem;
		this.nomeUsuarioDestino = nomeUsuarioDestino;
		this.dataHora = dataHora;
	}
	
	public Chat(UUID id, String nomeUsuarioOrigem, String nomeUsuarioDestino, LocalDateTime dataHora) {
		this.id = id;
		this.nomeUsuarioOrigem = nomeUsuarioOrigem;
		this.nomeUsuarioDestino = nomeUsuarioDestino;
		this.dataHora = dataHora;
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getNomeUsuarioOrigem() {
		return nomeUsuarioOrigem;
	}



	public void setNomeUsuarioOrigem(String nomeUsuarioOrigem) {
		this.nomeUsuarioOrigem = nomeUsuarioOrigem;
	}



	public String getNomeUsuarioDestino() {
		return nomeUsuarioDestino;
	}



	public void setNomeUsuarioDestino(String nomeUsuarioDestino) {
		this.nomeUsuarioDestino = nomeUsuarioDestino;
	}



	public LocalDateTime getDataHora() {
		return dataHora;
	}



	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}



	@Override
	public void acessar() {
		System.out.println("Consumido: "+ this.getId() + " - " + this.getNomeUsuarioOrigem());
	}

}
