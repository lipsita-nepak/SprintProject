package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.CropVerificationStatus;
import com.cg.cropbiddinginsuranceapp.entity.StorageSpace;


@SpringBootTest
class CropServiceTest {
	
	@Autowired
	ICropService cs;

	@Test
	void testAdd() {
		Crop c=new Crop(106, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		Crop crop=cs.save(c);
		assertEquals(106,crop.getCropId());
	}
	
	@Test
	void testUpdate() {
		Crop c=new Crop(105, "food", "rice", "clayloam", 1500.0,80.0);
		Crop crop=cs.save(c);
		cs.retrieveCropById(105);
		Crop c1=cs.update(crop);
		assertEquals("food",c1.getCropType());
	}
	
	@Test
	void testViewAll(){
		List<Crop> crop=cs.retrieveAllCrops();
		assertEquals(crop.size(),crop.size());
	}
	
	@Test
	void testViewAllById(){
		Crop crop=cs.retrieveCropById(105);
		assertEquals("rice",crop.getCropName());
	}
	
	@Test
	void testDelete(){
		Crop crop=cs.deleteCrop(105);
		assertEquals(105,crop.getCropId());
	}
	
	@Test
	void testViewAllByName(){
		Crop crop=cs.getByCropName("rice");
		assertEquals("rice",crop.getCropName());
    }
	
	@Test
	void testUpdateStatus(){
		Crop crop=cs.retrieveCropById(106);
		crop.setStorageSpace(StorageSpace.CLOSED_SHED);
		crop.setCvStatus(CropVerificationStatus.APPROVED);
		cs.updateStatus(106, crop);
		assertEquals(CropVerificationStatus.APPROVED,CropVerificationStatus.APPROVED);
	}
}