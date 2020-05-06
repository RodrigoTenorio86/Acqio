package br.com.acqio.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acqio.models.Transaction;
import br.com.acqio.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository dao;

	public Transaction save( Transaction transaction) {		
		return dao.save(transaction);
	}
	
	
}
