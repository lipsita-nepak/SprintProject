package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;

@Service
public interface IAddressService  {

	public Address addAddress(Address  address);
	
	public Address updateAddress(Address  address);
	
	public Address deleteAddress(int id);

	public List<Address> retrieveAllAddress();

	public Address retrieveAddressById(int id);
}
