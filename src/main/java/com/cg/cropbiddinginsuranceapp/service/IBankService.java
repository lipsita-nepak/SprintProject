package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bank;



@Service
public interface IBankService {

	public Bank addBank(Bank bank);

	public Bank updateBank(long id, Bank bank);

	public Bank deleteBankById(long id);

	public List<Bank> retrieveAllBanks();

	public Bank retrieveBankById(long id);
}
