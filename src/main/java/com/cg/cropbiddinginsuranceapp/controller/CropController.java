package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.exception.CropNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.ICropService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CropController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(CropController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	ICropService cs;
	
	/**
	 * This below function is used to create a new crop and redirects to the
	 * crop service
	 */
	@PostMapping("/crop")
	public ResponseEntity<Crop> addCrop(@Valid @RequestBody Crop crop) {
		logger.info("New Crop Added");
		return new ResponseEntity<>(cs.save(crop),HttpStatus.OK);
	}
	

	/**
	 * This below function is used to delete a specific crop based on the give
	 * Id and redirects to the crop service
	 */
	@DeleteMapping("/crop/{id}")
	public ResponseEntity<Crop> deleteCrop(@PathVariable("id") int id) {
		if (cs.retrieveCropById(id) == null) {
			throw new CropNotFoundException("Crop not found with given name: " + id);
		}
		logger.info("Deleted Successfully:"+id);
		return new ResponseEntity<>(cs.deleteCrop(id),HttpStatus.OK);
	}
	

	/**
	 * This below function is used to get all the crop and redirects to the
	 * crop service
	 */
	@GetMapping("/crop/view")
	public ResponseEntity<List<Crop>> retrieveAll() {
		logger.info("View All Crops");
		return new ResponseEntity<>(cs.retrieveAllCrops(),HttpStatus.OK);
	}
	

	/**
	 * This below function is used to get a specific crop and id as parameter
	 * and redirects to the crop service
	 */
	@GetMapping("/crop/id/{id}")
	public ResponseEntity<Crop> retrieveById(@PathVariable("id") int id) {
		if (cs.retrieveCropById(id) == null) {
			throw new CropNotFoundException("Crop not found with given name: " + id);
		}
		logger.info("View Crop By Id:"+id);
		return new ResponseEntity<>(cs.retrieveCropById(id),HttpStatus.OK);
	}
	
	/**
	 * This below function is used to update all from a specific crop and id as parameter
	 * and redirects to the crop service
	 */
	@PutMapping("/crop/update/{id}")
	public ResponseEntity<Crop> updateCrop(@PathVariable("id") int id,@Valid @RequestBody Crop crop) {
		if (cs.retrieveCropById(id) == null) {
			throw new CropNotFoundException("Crop not found with given name: " + id);
		}
		logger.info("Update Crop By Id:"+id);
		return new ResponseEntity<>(cs.update(id,crop),HttpStatus.OK);
	}
	
	/**
	 * This below function is used to update a specific values in crop and id as parameter
	 * and redirects to the crop service
	 */
	@PatchMapping("/crop/{id}")
	public ResponseEntity<Crop> updateCropById(@PathVariable("id") int id, @Valid @RequestBody Crop crop) {
		if (cs.retrieveCropById(id) == null) {
			throw new CropNotFoundException("Crop not found with given name: " + id);
		}
		logger.info("Update Crop By Id:"+id);
		return new ResponseEntity<>(cs.updateById(id, crop),HttpStatus.OK);
	}
	

	/**
	 * This below function is used to update the status of a specific crop and id as parameter
	 * and redirects to the crop service
	 */
	@PatchMapping("/crop/status/{id}")
	public ResponseEntity<Crop> updateStatusById(@PathVariable("id") int id, @Valid @RequestBody Crop crop) {
		if (cs.retrieveCropById(id) == null) {
			throw new CropNotFoundException("Crop not found with given name: " + id);
		}
		logger.info("Update Status:"+id);
		return new ResponseEntity<>(cs.updateStatus(id, crop),HttpStatus.OK);
	}

	/**
	 * This below function is used to get a specific crop and name as parameter
	 * and redirects to the crop service
	 */
	@GetMapping("/crop/name/{name}")
	public ResponseEntity<Crop> getCropByName(@PathVariable("name") String n) {
		if (cs.getByCropName(n) == null) {
			throw new CropNotFoundException("Crop not found with given name: " + n);
		}
		logger.info("View All Crops By Name:"+n);
		return new ResponseEntity<>(cs.getByCropName(n),HttpStatus.OK);
	}
	
	@GetMapping("/crop/farmer/{cropId}")
	public ResponseEntity<List<Farmer>> getFarmerByCropId(@PathVariable("cropId") int cropId)
	{
		List<Farmer> farmer=cs.getFarmerByCropId(cropId);
		if(farmer==null)
		{
			throw new CropNotFoundException("Crop not found with given name: " );
		}
		return new ResponseEntity<>(cs.getFarmerByCropId(cropId),HttpStatus.OK);
	}
	
}
