package br.com.weon.testeconhecimentobackend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * {@summary Email}
 * Modelo de entidade Chat
 */

@Entity
public class Email extends AbstractChannel{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true,nullable = false)
	private UUID id;
	private String origin;
	private String destiny;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dateHour;

	/**
	 * {@summary Email()}
	 * Método construtor da entidade
	 * @param origin
	 * @param destiny
	 * @param dateHour
	 */
	public Email(String origin, String destiny, LocalDateTime dateHour) {
		this.origin = origin;
		this.destiny = destiny;
		this.dateHour = dateHour;
	}
	
	/**
	 * {@summary Email().getId()}
	 * Getter de Id
	 * @return {@link UUID}
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * {@summary Email().setId(UUID id)}
	 * Setter de Id
	 * @param id
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * {@summary Email().getOrigin()}
	 * Getter de origin
	 * @return {@link String}
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * {@summary Email().setOrigin(String origin)}
	 * Setter de origin
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * {@summary Email().getDestiny()}
	 * Getter de destiny
	 * @return {@link String}
	 */
	public String getDestiny() {
		return destiny;
	}
	
	/**
	 * {@summary Email().setId(String destiny)}
	 * Setter de destiny
	 * @param destiny
	 */
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
	/**
	 * {@summary Email().getDateHour()}
	 * Getter de dateHour
	 * @return {@link LocalDateTime}
	 */
	public LocalDateTime getDateHour() {
		return dateHour;
	}
	
	/**
	 * {@summary Email().setDateHour(LocalDateTime dateHour)}
	 * Setter de dateHour
	 * @param dateHour
	 */
	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", origin=" + origin + ", destiny=" + destiny + ", dateHour=" + dateHour + "]";
	}
	
}
