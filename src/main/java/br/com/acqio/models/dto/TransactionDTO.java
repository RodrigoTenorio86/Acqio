package br.com.acqio.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acqio.models.Transaction;
import br.com.acqio.util.CardApplication;
import br.com.acqio.util.PaymentStatus;
import lombok.Data;
@Data
public class TransactionDTO {
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime time;	
	private BigDecimal value;	
	private CardApplication cardApplication;	
	private PaymentStatus status;

	

	public Transaction transform() {

		Transaction transaction = new Transaction();

		return transaction;
	}

}
