package br.com.weon.testeconhecimentobackend.canal;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * {@summary Chat}
 * Classe que representa o canal de chat
 */

@SuppressWarnings("javadoc")
@Entity
public class Chat implements ICanal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true,nullable = false)
	private UUID id;
	private String telefoneOrigem;
	private String telefoneDestino;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dataHora;
	
	
	public Chat(UUID id, String telefoneOrigem, String telefoneDestino, LocalDateTime dataHora) {
		super();
		this.id = id;
		this.telefoneOrigem = telefoneOrigem;
		this.telefoneDestino = telefoneDestino;
		this.dataHora = dataHora;
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getTelefoneOrigem() {
		return telefoneOrigem;
	}



	public void setTelefoneOrigem(String telefoneOrigem) {
		this.telefoneOrigem = telefoneOrigem;
	}



	public String getTelefoneDestino() {
		return telefoneDestino;
	}



	public void setTelefoneDestino(String telefoneDestino) {
		this.telefoneDestino = telefoneDestino;
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
