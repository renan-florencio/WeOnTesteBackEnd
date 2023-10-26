package br.com.weon.testeconhecimentobackend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

/**
 * {@summary Chat}
 * Modelo de entidade Chat
 */

@Entity
public class Chat extends AbstractChannel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true,nullable = false)
	private UUID id;
	private String origin;
	private String destiny;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dateHour;
	
	/**
	 * {@summary Chat()}
	 * Método construtor da entidade
	 * @param origin
	 * @param destiny
	 * @param dateHour
	 */
	public Chat(String origin, String destiny, LocalDateTime dateHour) {
		this.origin = origin;
		this.destiny = destiny;
		this.dateHour = dateHour;
	}
	
	/**
	 * {@summary Chat().getId()}
	 * Getter de Id
	 * @return UUID
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * {@summary Chat().setId(UUID id)}
	 * Setter de Id
	 * @param id
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * {@summary Chat().getOrigin()}
	 * Getter de origin
	 * @return String
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * {@summary Chat().setOrigin(String origin)}
	 * Setter de origin
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * {@summary Chat().getDestiny()}
	 * Getter de destiny
	 * @return String
	 */
	public String getDestiny() {
		return destiny;
	}
	
	/**
	 * {@summary Chat().setId(String destiny)}
	 * Setter de destiny
	 * @param destiny
	 */
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
	/**
	 * {@summary Chat().getDateHour()}
	 * Getter de dateHour
	 * @return LocalDateTime
	 */
	public LocalDateTime getDateHour() {
		return dateHour;
	}
	
	/**
	 * {@summary Chat().setDateHour(LocalDateTime dateHour)}
	 * Setter de dateHour
	 * @param dateHour
	 */
	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", origin=" + origin + ", destiny=" + destiny + ", dateHour=" + dateHour + "]";
	}
	
}