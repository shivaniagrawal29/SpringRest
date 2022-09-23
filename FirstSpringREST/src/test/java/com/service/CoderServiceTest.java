package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceTest {

	@Autowired
	CoderService coderservice;
	
	@MockBean
	CoderRepository coderRepo;

	@Test
	void testGetCoders() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Shivani");
		c1.setTech("JavaFS");
		
		Coder c2 = new Coder();
		c2.setCid(2);
		c2.setCname("Pia");
		c2.setTech("Java");
		
		List<Coder> coderList = new ArrayList<>();
		coderList.add(c1);
		coderList.add(c2);
		
		Mockito.when(coderRepo.findAll()).thenReturn(coderList);
		
		assertThat(coderservice.getCoders()).isEqualTo(coderList);
	}
	
	@Test
//	@Disabled
	void testGetCoderById() throws Throwable {

		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Shivani");
		c1.setTech("JavaFS");
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(coderRepo.findById(1)).thenReturn(c2);
		
		assertThat(coderservice.getCoderById(1)).isEqualTo(c1);
	}

	@Test
	void testAddCoder() {
		
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Shivani");
		c1.setTech("JavaFS");
		
		Mockito.when(coderRepo.save(c1)).thenReturn(c1);
		
		assertThat(coderservice.addCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateCoder() throws Throwable {
		
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Shivani");
		c1.setTech("JavaFS"); 
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(coderRepo.findById(1)).thenReturn(c2);
		
		Mockito.when(coderRepo.save(c1)).thenReturn(c1);
		c1.setCname("Shiv");
		c1.setTech("ML");
		
		assertThat(coderservice.updateCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCoder() {

		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Shivani");
		c1.setTech("JavaFS");
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(coderRepo.findById(1)).thenReturn(c2);
		Mockito.when(coderRepo.existsById(c1.getCid())).thenReturn(false);
		
		assertFalse(coderRepo.existsById(c1.getCid()));
	}	

}
