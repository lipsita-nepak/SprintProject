package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.exception.BankNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBankService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin
@RestController
@Log4j2
public class BankController {
	
	// AutoWiring the service class to call down the service

		@Autowired
		IBankService bankService; 

		// Read Operation

		// Getting all banks from database
		@GetMapping("/bank")
		public ResponseEntity<List<Bank>> retrieveAllBanks() {
			log.info("Getting all Banks from database");
			return new ResponseEntity<>(bankService.retrieveAllBanks(), HttpStatus.OK);

		}

		// Getting Bank based on given bankId
		@GetMapping("/bank/{id}")
		public ResponseEntity<Bank> retrieveBankById(@PathVariable("id") int bankId) {
			
			// If bank of given bankId is not there then it throws an Exception
			if (bankService.retrieveBankById(bankId) == null) { 
				log.error("Cannot display as Bank not found with id: " + bankId);
				throw new BankNotFoundException("Bank not found with given id: " + bankId);
			}
			log.info("Getting Bank info with id: " +bankId);
			
			// If bank of given bankId is there then it displays that bank dtls
			return new ResponseEntity<>(bankService.retrieveBankById(bankId),HttpStatus.OK);
		}

		// Write operation

		// Adding a new bank into the database
		@PostMapping("/bank")
		public ResponseEntity<Bank> addBank(@Valid @RequestBody Bank bank) {
			log.info("Adding a new Bank into database");
			return new ResponseEntity<>(bankService.addBank(bank),HttpStatus.OK);
		}

		// Update Operation

		// Updating Bank Information based on bankId and data given
		@PutMapping("/bank/{id}")
		public ResponseEntity<Bank> updateBank(@PathVariable("id") int bankId, @Valid @RequestBody Bank bank) {
			
			// If bank of given bankId is not there then it throws an Exception
			if (bankService.retrieveBankById(bankId) == null) {
				log.error("Cannot Update as Bank not found with id: " + bankId);
				throw new BankNotFoundException("Bank not found with given id: " + bankId);
			}
			log.info("Updating Bank info with id: " + bankId);
			
			// If Bank of given bankId is there then it updates that bank dtls and displays the updated bank dtls
			return new ResponseEntity<>(bankService.updateBank(bankId, bank),HttpStatus.OK);
		}

		// Delete Operation

		// Deleting a Bank of given bankId
		@DeleteMapping("/bank/{id}")
		public ResponseEntity<Bank> deleteBank(@PathVariable("id") int bankId) {
			
			// If bank of given bankId is not there then it throws an Exception
			if (bankService.retrieveBankById(bankId) == null) {
				log.error("Cannot Delete as Bank not found with id: " + bankId);
				throw new BankNotFoundException("Bank not found with given id: " + bankId);
			}
			log.info("Deleting the Bank info with id: " + bankId);
			
			// If bank of given bankId is there then it deletes that bank info and displays the deleted bank dtls
			return new ResponseEntity<>(bankService.deleteBankById(bankId),HttpStatus.OK);
		}
		
	}



