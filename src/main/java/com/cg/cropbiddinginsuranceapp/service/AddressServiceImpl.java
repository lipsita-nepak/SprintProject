package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(AddressServiceImpl.class);
	
	@Autowired
	IAddressRepository addRepo;

	@Override
	public Address addAddress(Address address) {
		logger.info("save method");
		return addRepo.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		Address add = addRepo.findById(address.getId()).get();
		add.setHouseno(address.getHouseno());
		add.setCity(address.getCity());
		add.setStreet(address.getStreet());
		add.setState(address.getState());
		add.setPincode(address.getPincode());
		logger.info("update method");
		return addRepo.save(add);
		
	}

	@Override
	public Address deleteAddress(int id) {
		Optional<Address> opt = addRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		addRepo.deleteById(id);
		logger.info("delete address by id");
		return opt.get();
	}

	@Override
	public List<Address> retrieveAllAddress() {
		logger.info("get all address");
		return addRepo.findAll();
	}

	@Override
	public Address retrieveAddressById(int id) {
		Optional<Address> opt = addRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		logger.info("get address by id");
		return opt.get();
		
	}

}
