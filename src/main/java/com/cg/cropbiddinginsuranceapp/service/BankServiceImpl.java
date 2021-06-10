package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bank;

import com.cg.cropbiddinginsuranceapp.repository.IBankRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BankServiceImpl implements IBankService {

	// AutoWiring the repository class to call down the repository

	@Autowired
	IBankRepository bankRepo;

	Optional<Bank> b;

	// Adding Bank into the DATABASE

	@Override
	public Bank addBank(Bank bank) {
		log.info(" Calling save() of bankRepository");
		return bankRepo.save(bank);
	}

	// Retrieve all banks from DATABASE

	@Override
	public List<Bank> retrieveAllBanks() {
		log.info(" Calling findAll() of bankRepository");
		return bankRepo.findAll();
	}

	// Retrieve bank by id

	@Override
	public Bank retrieveBankById(long id) {
		log.info(" Calling findById() of bankRepository");
		b = bankRepo.findById(id);// Getting the bank info by id and storing in b
		if (!b.isPresent()) {// if bank is not present of given id then return null
			return null;
		}
		return b.get();// if bank of given id is present then return the bank details
	}

	// Updating the bank details

	@Override
	public Bank updateBank(long id, Bank bank) {
		log.info(" Calling findById() of bankRepository to update");
		b = bankRepo.findById(id); // Getting the bank info by id and storing in b
		if (!b.isPresent()) {
			return null;
		}
		// setting the values of each field
        b.get().setAccountNumber(bank.getAccountNumber());
		b.get().setBankName(bank.getBankName());
		b.get().setIfscCode(bank.getIfscCode());
		b.get().setAddress(bank.getAddress());
		return bankRepo.save(b.get()); // returning the updated bank details
	}

	// Delete bank by id

	@Override
	public Bank deleteBankById(long id) {
		log.info(" Calling findById() of bankRepository to delete");
		b = bankRepo.findById(id);// Getting the bank info by id and storing in b
		if (!b.isPresent()) { // if bank is not present of given id then return null
			return null;
		}
		bankRepo.deleteById(id);
		return b.get(); // if bank of given id is present then return the deleted bank details
	}

}
