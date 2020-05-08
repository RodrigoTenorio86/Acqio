package br.com.acqio.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErroDeFormularioDTO {
	private String campo;
	private String erro;
	
	
}
