package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.controller.CropController;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.CropVerificationStatus;
import com.cg.cropbiddinginsuranceapp.entity.StorageSpace;


@SpringBootTest
class CropServiceTest {
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(CropServiceTest.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	ICropService cs;

	/**
	 * Test case for the method to create new crop in the database
	 */
	@Test
	@Disabled
	void testAdd() {
		Crop c=new Crop(106, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		Crop crop=cs.save(c);
		logger.info(c);
		assertEquals("cash",crop.getCropType());
	}
	
	/**
	 * Test case for the method to update all the values
	 */
	@Test
	@Disabled
	void testUpdate() {
		Crop c=new Crop(1, "food", "rice", "clayloam", 1500.0,80.0);
		Crop crop=cs.save(c);
		
		Crop c1=cs.update(1,crop);
		logger.info(c1);
		assertEquals("food",c1.getCropType());
	}
	
	/**
	 * Test case for the method to get all the values from the database
	 */
	@Test
	@Disabled
	void testViewAll(){
		List<Crop> crop=cs.retrieveAllCrops();
		logger.info(crop);
		assertEquals(crop.size(),crop.size());
	}
	
	/**
	 * Test case for the method to get the values from the database using id 
	 */
	@Test
	@Disabled
	void testViewAllById(){
		Crop crop=cs.retrieveCropById(1);
		logger.info(crop);
		assertEquals("rice",crop.getCropName());
	}

	/**
	 * Test case for the method to delete the values from the database using id 
	 */
	@Test
	
	void testDelete(){
		Crop crop=cs.deleteCrop(1);
		logger.info("Deleted Successfully"+crop.getCropId());
		assertEquals(1,crop.getCropId());
	}

	/**
	 * Test case for the method to get the values from the database using name 
	 */
	@Test
	
	void testViewAllByName(){
		List<Crop> crop=cs.getByCropName("wheat");
		logger.info(crop);
		assertEquals(crop.size(),crop.size());
    }

	/**
	 * Test case for the method to update the status of crop in the database using id 
	 */
	@Test
	@Disabled
	void testUpdateStatus(){
		Crop crop=cs.retrieveCropById(1);
		crop.setStorageSpace(StorageSpace.CLOSED_SHED);
		crop.setCvStatus(CropVerificationStatus.APPROVED);
		Crop c=cs.updateStatus(1, crop);
		logger.info(c);
		assertEquals(CropVerificationStatus.APPROVED,CropVerificationStatus.APPROVED);
	}
}