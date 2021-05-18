package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.exception.CropNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.ICropService;



@RestController
public class CropController {
	
	@Autowired
	ICropService cs;
	
	@PostMapping("/crop")
	public Crop addCrop(@RequestBody Crop crop)
	{
		return cs.save(crop);
	}
	
	@DeleteMapping("/delete/{id}")
	public Crop deleteCrop(@PathVariable("id")int id)
	{
		if(cs.retrieveCropById(id)==null)
		{
			throw new CropNotFoundException("Crop not found with given id: "+id);
		}
		return cs.deleteCrop(id);
	}
	
	@GetMapping("/crop")
	public List<Crop> retrieveAll()
	{
		return cs.retrieveAllCrops();
	}
	
	@GetMapping("/crop/id/{id}")
	public Crop retrieveById(@PathVariable("id")int id)
	{
		if(cs.retrieveCropById(id)==null)
		{
			throw new CropNotFoundException("Crop not found with given id: "+id);
		}
		return cs.retrieveCropById(id);
	}
	
	@PutMapping("/crop/{id}")
	public Crop updateCrop(@PathVariable("id") int id, @RequestBody Crop crop)
	{
		if(cs.retrieveCropById(id)==null)
		{
			throw new CropNotFoundException("Crop not found with given id: "+id);
		}
		return cs.update(crop);
	}
	
	@PatchMapping("/crop/{id}")
	public Crop updateCropById(@PathVariable("id") int id, @RequestBody Crop crop) {
		if(cs.retrieveCropById(id)==null)
		{
			throw new CropNotFoundException("Crop not found with given id: "+id);
		}
		return cs.updateById(id,crop);
	}
	
	@PatchMapping("/crop/status/{id}")
	public Crop updateStatusById(@PathVariable("id") int id, @RequestBody Crop crop) {
		if(cs.retrieveCropById(id)==null)
		{
			throw new CropNotFoundException("Crop not found with given id: "+id);
		}
		return cs.updateStatus(id,crop);
	}

	@GetMapping("/crop/name/{name}")
	public Crop getCropByName(@PathVariable("name") String n) {
		if(cs.getByCropName(n)==null)
		{
			throw new CropNotFoundException("Crop not found with given name: "+n);
		}
		return cs.getByCropName(n);
	}
}
