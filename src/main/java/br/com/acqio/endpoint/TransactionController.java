package br.com.acqio.endpoint;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.acqio.models.Transaction;
import br.com.acqio.service.TransactionService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> register(@RequestBody @Valid Transaction transaction){
		Transaction transactionNew =  transactionService.save(transaction);
		return new ResponseEntity<>(transactionNew, HttpStatus.OK);		
	}
	

	@RequestMapping(path = "/{all}", method = RequestMethod.GET)
	public ResponseEntity<?> getAll(@PageableDefault(page = 0,size =2) Pageable pageable){
		Page<Transaction> transactions = transactionService.getAll(pageable);
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}
	
	
	@PutMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> changeTransaction(@RequestBody Transaction transaction){
		 	Transaction change = transactionService.getOne(transaction.getId());
		 	change.setCardApplication(transaction.getCardApplication());
		 	change.setDate(transaction.getDate());
		 	change.setTime(transaction.getTime());
		 	change.setStatus(transaction.getStatus());
		 	change.setValue(transaction.getValue());
		 	return new ResponseEntity<>(change,HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/{id}")
	public ResponseEntity<?>getById(@PathVariable("id") Long id){
		verifyIfTransactionExists(id);
		Transaction transaction = transactionService.getOne(id);
		return new ResponseEntity<>(transaction,HttpStatus.OK);
		
	}
	
	
	private void verifyIfTransactionExists(Long id) {
		Optional<Transaction> transactionExists = transactionService.findById(id);
		
	}
 
}
