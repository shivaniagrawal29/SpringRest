package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.repository.CoderRepository;

@Service
public class CoderService { //implements CoderServiceI {

	@Autowired
	CoderRepository coderRepo;
	
//	@Override
	//repeated method of getCoderById. can be removed. should handle exception
//	public Coder getCoder(int cid) {
//		Optional c = coderRepo.findById(cid);  //.orElseThrow()
//		
//		Coder c1 = (Coder) c.get();
//		return c1;
//	}

//	@Override
	public List<Coder> getCoders() {
		List<Coder> lc = coderRepo.findAll();
		return lc;
	}

//	@Override
	public Coder addCoder(Coder c) {
		coderRepo.save(c);
		return c;
	}

//	@Override
	public List<Coder> addCoders(List<Coder> lc) {
		coderRepo.saveAll(lc);
		return lc;
	}

//	@Override //exception mostly possible
	public Coder updateCoder(Coder c) throws Throwable {
		int id = c.getCid();
		Supplier s1 = ()->new ResourceNotFoundException("Coder doesn't exist in the database");
		
		Coder c1 = coderRepo.findById(id).orElseThrow(s1);
		c1.setCname(c.getCname());
		c1.setTech(c.getTech());
		
		coderRepo.save(c1);
		return c1;
	}

//	@Override //may give exception
	public String deleteCoder(Coder c) {
		coderRepo.delete(c);
		return "Deleted";
	}

//	@Override //may give exception
	public String deleteCoderById(int cid) {
		coderRepo.deleteById(cid);
		return "Deleted by id";
	}
	
	//may give exception
	public Coder getCoderByCname(String cname) {
		Coder c2 = coderRepo.getCoderByCname(cname);
		return c2;
	}
	
	//may give exception
	public List<Coder> getCoderByTechSorted(String tech){
		List<Coder> lc = coderRepo.getCoderByTechSorted(tech);
		return lc;
	}
	
	 //exception mostly possible
	public Coder getCoderById(int cid) throws Throwable {
		Supplier s1 = ()->new ResourceNotFoundException("Coder doesn't exist in the database");
		
		Coder c = coderRepo.findById(cid).orElseThrow(s1);
		return c;
	}
	

}
