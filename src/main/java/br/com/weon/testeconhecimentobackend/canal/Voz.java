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
 * {@summary Voz}
 * Classe que representa o canal de voz
 */

@SuppressWarnings("javadoc")

@org.hibernate.annotations.NamedQueries({
	@org.hibernate.annotations.NamedQuery(name = "obterVoz", 
			query = "from Voz where id = :id")
	})

@Entity
@Table(name = "Voz")
public class Voz implements ICanal {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true,nullable = false)
	private UUID id;
	private String telefoneOrigem;
	private String telefoneDestino;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dataHora;
	
	public Voz() {
		
	}
	
	public Voz(String telefoneOrigem, String telefoneDestino, LocalDateTime dataHora) {
		this.telefoneOrigem = telefoneOrigem;
		this.telefoneDestino = telefoneDestino;
		this.dataHora = dataHora;
	}
	
	public Voz(UUID id, String telefoneOrigem, String telefoneDestino, LocalDateTime dataHora) {
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
		System.out.println("Objeto consumido: "+ this.getId() + "\n" 
				+ LocalDateTime.now() + " - Origem: " + this.getTelefoneOrigem());
	}

}
