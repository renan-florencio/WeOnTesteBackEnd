package br.com.weon.testeconhecimentobackend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	public Email(String origin, String destiny, LocalDateTime dateHour) {
		this.origin = origin;
		this.destiny = destiny;
		this.dateHour = dateHour;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public LocalDateTime getDateHour() {
		return dateHour;
	}
	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", origin=" + origin + ", destiny=" + destiny + ", dateHour=" + dateHour + "]";
	}
	
}