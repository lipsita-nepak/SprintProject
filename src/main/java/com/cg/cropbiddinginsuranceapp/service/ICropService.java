package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;


@Service
public interface ICropService {
	
	Crop save(Crop crop);
	Crop deleteCrop(int id);
	List<Crop>retrieveAllCrops();
	Crop retrieveCropById(int id);
	Crop update(int id,Crop crop);
	Crop updateById(int id,Crop crop);
	List<Crop> getByCropName(String cropName);
	Crop updateStatus(int id,Crop crop);
	List<Farmer> getFarmerByCropId(int cropId);

}
