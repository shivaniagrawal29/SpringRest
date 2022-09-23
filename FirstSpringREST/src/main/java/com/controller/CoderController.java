package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderService;
//import com.service.CoderServiceI;

@RestController
@RequestMapping("api")
public class CoderController {
	Log logger = LogFactory.getLog(CoderController.class);

	@Autowired
	CoderService coderservice;
	
//	@GetMapping("/getCoder/{cid}")
//	public Coder getCoder(@PathVariable  int cid) {
//		Coder c1 = coderservice.getCoder(cid);
//		return c1;
//	}

	@GetMapping("/getCoders") //in url try to give small letters only
	public List<Coder> getCoders() {
		List<Coder> lc1 = coderservice.getCoders();
		logger.info("Get coders successfull"); //don't so syso
		return lc1;
	}
	
	@GetMapping("getcoderbyid/{cid}")
	public Coder getCoderById(@PathVariable int cid) throws Throwable {
		Coder c = coderservice.getCoderById(cid);
		return c;
	}
	
	@PostMapping("addCoder")
	public Coder addCoder(@RequestBody Coder c) {
		Coder c2 = coderservice.addCoder(c);
		return c2;
	}
	
	@PostMapping("addCoders")
	public List<Coder> addCoders(@RequestBody List<Coder> lc) {
		List<Coder> lc2 = coderservice.addCoders(lc);
		return lc2;
	}
	
	@RequestMapping("/updateCoder") 
	public Coder updateCoder(@RequestBody Coder c) throws Throwable {
		Coder c1 = coderservice.updateCoder(c);
		return c1;
	}
	
	@RequestMapping("/deleteCoder/")
	public String deleteCoder(@RequestBody Coder c) {
		String s = coderservice.deleteCoder(c);
		return s;
	}

	@RequestMapping("/deleteCoderById/{cid}")
	public String deleteByCoderId(@PathVariable  int cid) {
		String s = coderservice.deleteCoderById(cid);
		return s;
	}
	
	@GetMapping("/getcoderbyname/{cname}")
	public Coder getCoderByCname(@PathVariable String cname) {
		Coder c2 = coderservice.getCoderByCname(cname);
		return c2;
	}
	
	@GetMapping("getcoderbytech/{tech}")
	public List<Coder> getCoderByTechSorted(@PathVariable String tech){
		List<Coder> lc = coderservice.getCoderByTechSorted(tech);
		return lc;
	}
	
}
