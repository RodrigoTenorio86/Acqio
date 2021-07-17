package br.com.acqio.endpoint;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.acqio.errors.ResourceNotFoundException;
import br.com.acqio.models.Transaction;
import br.com.acqio.models.dto.TransactionInDTO;
import br.com.acqio.service.TransactionService;
import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionController {
	
	private final TransactionService transactionService;

	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> register(@RequestBody @Valid  TransactionInDTO transactionInDTO) {
		Transaction transaction = transactionInDTO.transform();
		transaction= transactionService.save(transaction);		
		return  new ResponseEntity<>(transaction,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAll(@PageableDefault(page = 0, size = 2) Pageable pageable) {
		Page<Transaction> transactions = transactionService.getAll(pageable);
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@PutMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> changeTransaction(@RequestBody @Valid TransactionInDTO transactionInDTO) {
		verifyIfTransactionExists(transactionInDTO.getId());
		Transaction change = transactionService.getOne(transactionInDTO.getId());
        transactionInDTO.transform(change);
		return new ResponseEntity<>(change, HttpStatus.OK);

	}

	@GetMapping(value =  "/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		verifyIfTransactionExists(id);
		Transaction transaction = transactionService.getOne(id);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		verifyIfTransactionExists(id);
		transactionService.deleteByIf(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	private void verifyIfTransactionExists(Long id) {
		Optional<Transaction> transactionExists = transactionService.findById(id);
		if(! transactionExists.isPresent()) {
			throw new ResourceNotFoundException("Transaction not found for ID  " + id);
		}

	}

}
