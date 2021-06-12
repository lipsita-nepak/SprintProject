package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bank;



@Service
public interface IBankService {

	public Bank addBank(Bank bank);

	public Bank updateBank(int id, Bank bank);

	public Bank deleteBankById(int id);

	public List<Bank> retrieveAllBanks();

	public Bank retrieveBankById(int id);
}
