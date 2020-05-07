package br.com.acqio.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acqio.util.CardApplication;
import br.com.acqio.util.Status;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column
	private LocalDate date;

	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column
	private LocalTime time;

	@Column(precision = 18, scale = 2)
	private BigDecimal value;
	@Enumerated(EnumType.STRING)
	private CardApplication cardApplication;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public CardApplication getCardApplication() {
		return cardApplication;
	}
	public void setCardApplication(CardApplication cardApplication) {
		this.cardApplication = cardApplication;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	

}
