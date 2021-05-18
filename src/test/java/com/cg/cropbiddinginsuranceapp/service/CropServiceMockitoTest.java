package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.CropVerificationStatus;
import com.cg.cropbiddinginsuranceapp.entity.StorageSpace;
import com.cg.cropbiddinginsuranceapp.repository.ICropDao;

@ExtendWith(SpringExtension.class)
class CropServiceMockitoTest {

	@InjectMocks
	CropServiceImpl cs;
	
	@MockBean
	ICropDao cdao;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAdd(){
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Mockito.when(cdao.save(c)).thenReturn(c);
		Crop crop=cs.save(c);
		assertEquals(104,crop.getCropId());
	}
	
	@Test 
	void testViewAll() {
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);
		List<Crop>l=new ArrayList<>();
		l.add(c1);
		l.add(c2);
		Mockito.when(cdao.findAll()).thenReturn(l);
		List<Crop>croplist=cs.retrieveAllCrops();
		assertEquals(2,croplist.size());
	}
	
	@Test
	void testViewById() {
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Mockito.when(cdao.findById(104)).thenReturn(Optional.of(c));
		assertEquals(104,c.getCropId());
	}
	
	@Test
	void testViewByName() {
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Mockito.when(cdao.getCropByName("paddy")).thenReturn(c);
		assertEquals("paddy",c.getCropName());
	}
	
	@Test
	void testDelete() {
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Mockito.when(cdao.findById(104)).thenReturn(Optional.of(c));
		cs.deleteCrop(104);
		assertEquals(104,c.getCropId());
	}
	
	@Test
	void testUpdate() {
		Crop c=new Crop(104, "cash", "rice", "clayloam", 1800.0,50.0);
		Mockito.when(cdao.findById(104)).thenReturn(Optional.of(c));
		Mockito.when(cdao.save(c)).thenReturn(c);
		Crop crop=cs.update(c);
		assertEquals("rice",crop.getCropName());
	}
	
	@Test
	void testUpdateStatus() {
		Crop c=new Crop(104, "cash", "rice", "clayloam", 1800.0,50.0,
				StorageSpace.NO_SHED,CropVerificationStatus.PENDING);
		Mockito.when(cdao.findById(104)).thenReturn(Optional.of(c));
		c.setCvStatus(CropVerificationStatus.APPROVED);
		cs.updateStatus(104, c);
		assertEquals(CropVerificationStatus.APPROVED,CropVerificationStatus.APPROVED);
	}
}
