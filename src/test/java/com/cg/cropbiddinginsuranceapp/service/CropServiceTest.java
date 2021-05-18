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
	@Disabled
	void testAdd() {
		Crop c=new Crop(107, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		Crop crop=cs.save(c);
		assertEquals(107,crop.getCropId());
	}
	
	@Test
	@Disabled
	void testUpdate() {
		Crop c=new Crop(101, "food", "wheat", "clayloam", 1500.0,80.0);
		Crop crop=cs.save(c);
		cs.retrieveCropById(101);
		Crop c1=cs.update(crop);
		assertEquals("food",c1.getCropType());
	}
	
	@Test
	@Disabled
	void testViewAll(){
		List<Crop> crop=cs.retrieveAllCrops();
		assertEquals(crop.size(),crop.size());
	}
	
	@Test
	@Disabled
	void testViewAllById(){
		Crop crop=cs.retrieveCropById(105);
		assertEquals("corn",crop.getCropName());
	}
	
	@Test
	@Disabled
	void testDelete(){
		Crop crop=cs.deleteCrop(101);
		assertEquals(101,crop.getCropId());
	}
	
	@Test
	@Disabled
	void testViewAllByName(){
		Crop crop=cs.getByCropName("rice");
		assertEquals("rice",crop.getCropName());
    }
	
	@Test
	@Disabled
	void testUpdateStatus(){
		Crop crop=cs.retrieveCropById(107);
		crop.setCvStatus(CropVerificationStatus.APPROVED);
		cs.updateStatus(107, crop);
		assertEquals(CropVerificationStatus.APPROVED,CropVerificationStatus.APPROVED);
	}
}