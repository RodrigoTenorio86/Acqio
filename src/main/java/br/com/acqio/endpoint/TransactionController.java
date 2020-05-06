package br.com.acqio.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.acqio.models.Transaction;
import br.com.acqio.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody @Valid Transaction transaction){
		Transaction transactionNew =  transactionService.save(transaction);
		return new ResponseEntity<>(transactionNew, HttpStatus.OK);		
	}

}
