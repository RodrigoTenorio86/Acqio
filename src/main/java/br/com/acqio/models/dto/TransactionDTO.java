package br.com.acqio.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acqio.models.Transaction;
import br.com.acqio.util.CardApplication;
import br.com.acqio.util.Status;

public class TransactionDTO {
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
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

	public Transaction transfomar() {

		Transaction transaction = new Transaction();
		transaction.setCardApplication(this.cardApplication);
		transaction.setDate(this.date);
		transaction.setStatus(this.status);
		transaction.setValue(this.value);
		// transaction.setTime( LocalDateTime.parse(time,
		// DateTimeFormatter.ofPattern("HH:mm:ss")));

		// String time =(String) transactionDTO.getTime();

		// LocalTime timeNew = LocalTime.parse(time);

		// LocalTime time_= LocalTime.parse(time,
		// DateTimeFormatter.ofPattern("HH:mm:ss"));
		// System.out.println(time_);

		return transaction;
	}

}
