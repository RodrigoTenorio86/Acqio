package br.com.acqio.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acqio.util.CardApplication;
import br.com.acqio.util.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(nullable = false)
	private LocalDate date;
    @NotNull
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime time;
    @NotNull
	@Column(precision = 18, scale = 2, nullable = false)
	private BigDecimal value;
	@Enumerated(EnumType.STRING)
	private CardApplication cardApplication;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	
	

	

}
