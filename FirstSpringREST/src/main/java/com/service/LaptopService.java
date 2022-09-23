package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Laptop;
import com.repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	LaptopRepository laptopRepo;
	
	public Laptop addLaptop(Laptop l) {
		laptopRepo.save(l);
		return l;
	}
}
