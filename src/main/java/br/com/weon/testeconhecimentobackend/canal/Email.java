package br.com.weon.testeconhecimentobackend.canal;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * {@summary Email}
 * Classe que representa o canal de email
 */

@SuppressWarnings("javadoc")
@Entity
public class Email implements ICanal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true,nullable = false)
	private UUID id;
	private String emailOrigem;
	private String emailDestino;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dataHora;

	
	public Email(UUID id, String emailOrigem, String emailDestino, LocalDateTime dataHora) {
		this.id = id;
		this.emailOrigem = emailOrigem;
		this.emailDestino = emailDestino;
		this.dataHora = dataHora;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getEmailOrigem() {
		return emailOrigem;
	}


	public void setEmailOrigem(String emailOrigem) {
		this.emailOrigem = emailOrigem;
	}


	public String getEmailDestino() {
		return emailDestino;
	}


	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}


	public LocalDateTime getDataHora() {
		return dataHora;
	}


	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}


	@Override
	public void acessar() {
		// TODO Auto-generated method stub

	}

}