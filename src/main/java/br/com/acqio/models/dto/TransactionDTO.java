package br.com.acqio.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acqio.models.Transaction;
import br.com.acqio.util.CardApplication;
import br.com.acqio.util.Status;

public class TransactionDTO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	//@JsonFormat( pattern = "HH:mm:ss")
	private String time;

	private BigDecimal value;

	private CardApplication cardApplication;

	private Status status;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
		
		Transaction transaction= new Transaction();
		transaction.setCardApplication(this.cardApplication);
		transaction.setDate(this.date);
		transaction.setStatus(this.status);
		transaction.setValue(this.value);
		//transaction.setTime( LocalDateTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss")));
		
		//String time =(String) transactionDTO.getTime();
	
		//	LocalTime timeNew = LocalTime.parse(time);
		
		//LocalTime time_= LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
		//System.out.println(time_);
		
		
		
		return transaction;
	}
	
	

}
