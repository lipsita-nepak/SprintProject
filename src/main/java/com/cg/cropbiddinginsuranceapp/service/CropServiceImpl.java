package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.repository.ICropDao;


@Service
public class CropServiceImpl implements ICropService {
	
	@Autowired
	ICropDao cdao;

	@Override
	public Crop save(Crop crop) {
		return cdao.save(crop);
	}

	@Override
	public Crop deleteCrop(int id) {
		Optional<Crop> opt=cdao.findById(id);
		if(!opt.isPresent()){
			return null;
		}
		cdao.deleteById(id);
		return opt.get();
	}

	@Override
	public List<Crop> retrieveAllCrops() {
		return cdao.findAll();
	}

	@Override
	public Crop retrieveCropById(int id) {
		Optional<Crop> opt= cdao.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	@Override
	public Crop update(Crop crop) {
		Crop c=cdao.findById(crop.getCropId()).get();
		c.setCropName(crop.getCropName());
		c.setCropType(crop.getCropType());
		c.setBasePricePerQuintal(crop.getBasePricePerQuintal());
		c.setQuantity(crop.getQuantity());
		c.setSoilType(crop.getSoilType());
		return cdao.save(c);
	}

	@Override
	public Crop updateById(int id,Crop crop) {
		Crop c=cdao.findById(id).get();
		c.setCropName(crop.getCropName());
		return cdao.save(c);
	}

	@Override
	public Crop getByCropName(String cropName) {
		Optional<Crop> opt=cdao.findByCropName(cropName);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	@Override
	public Crop updateStatus(int id,Crop crop) {
		Crop c=cdao.findById(id).get();
		c.setCvStatus(crop.getCvStatus());
		return cdao.save(c);
	}

}
