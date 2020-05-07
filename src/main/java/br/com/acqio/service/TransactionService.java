package br.com.acqio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Page<Transaction> getAll(Pageable pageable) {
		Page<Transaction> page= dao.findAll(pageable);
		return page;
	}

	public Transaction getOne(Long id) {
		Transaction transaction = dao.getOne(id);
		return transaction;
	}

	public Optional<Transaction> findById(Long id) {
		Optional<Transaction> optional=  dao.findById(id);
		return optional;
	}


	
	
}