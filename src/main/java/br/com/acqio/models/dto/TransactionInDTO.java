package br.com.acqio.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acqio.models.Transaction;
import br.com.acqio.util.CardApplication;
import br.com.acqio.util.Status;
import lombok.Data;
@Data
public class TransactionInDTO {
	private Long id;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime time;	
	@NotNull
	private BigDecimal value;
	private CardApplication cardApplication;
	private Status status;
	
	
	public Transaction transform() {
		return new Transaction( null, date, time, value, cardApplication, status);
	}


	public void transform(Transaction change) {
		change.setCardApplication(cardApplication);
		change.setDate(date);
		change.setStatus(status);
		change.setTime(time);
		change.setValue(value);		
	}
	
	//public Transaction 


}