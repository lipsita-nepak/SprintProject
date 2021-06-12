package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.controller.CropController;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.repository.ICropDao;
import com.cg.cropbiddinginsuranceapp.repository.IFarmerRepository;

@Service
public class CropServiceImpl implements ICropService {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(CropServiceImpl.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	ICropDao cdao;
	
	
	/**
	 * This function is used to create a new crop and redirects to the
	 * crop repository
	 */
	@Override
	public Crop save(Crop crop) {
		logger.info("save method");
		return cdao.save(crop);
	}

	/**
	 * This function is used to delete a crop by id and redirects to the
	 * crop repository
	 */
	@Override
	public Crop deleteCrop(int id) {
		Optional<Crop> opt = cdao.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		cdao.deleteById(id);
		logger.info("delete method");
		return opt.get();
	}

	/**
	 * This function is used to get all the crops and redirects to the
	 * crop repository
	 */
	@Override
	public List<Crop> retrieveAllCrops() {
		logger.info("view all method");
		return cdao.findAll();
	}
	
	/**
	 * This function is used to get the crop by id and redirects to the
	 * crop repository
	 */
	@Override
	public Crop retrieveCropById(int id) {
		Optional<Crop> opt = cdao.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		logger.info("view by id method");
		return opt.get();
	}

	/**
	 * This function is used to update all the crop by id and redirects to the
	 * crop repository
	 */
	@Override
	public Crop update(int id,Crop crop) {
		Crop c = cdao.findById(id).get();
		c.setCropName(crop.getCropName());
		c.setCropType(crop.getCropType());
		c.setBasePricePerQuintal(crop.getBasePricePerQuintal());
		c.setQuantity(crop.getQuantity());
		c.setSoilType(crop.getSoilType());
		logger.info("update all by id method");
		return cdao.save(c);
	}
	
	/**
	 * This function is used to update the crop by id and redirects to the
	 * crop repository
	 */
	@Override
	public Crop updateById(int id, Crop crop) {
		Crop c = cdao.findById(id).get();
		c.setCropName(crop.getCropName());
		c.setCropType(crop.getCropType());
		logger.info("update specific fields by id method");
		return cdao.save(c);
	}

	/**
	 * This function is used to get all the crop by name and redirects to the
	 * crop repository
	 */
	@Override
	public List<Crop> getByCropName(String cropName) {
		logger.info("get all by name method");
		return cdao.findAllByCropName(cropName);
	}
	
	/**
	 * This function is used to update status by id and redirects to the
	 * crop repository
	 */
	@Override
	public Crop updateStatus(int id, Crop crop) {
		Crop c = cdao.findById(id).get();
		c.setStorageSpace(crop.getStorageSpace());
		c.setCvStatus(crop.getCvStatus());
		logger.info("update status method");
		return cdao.save(c);
	}

}
