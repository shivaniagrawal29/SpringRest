package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Coder;

@Repository //optional, as 
public interface CoderRepository extends JpaRepository<Coder, Integer> {
	
	public Coder getCoderByCname(String cname);
	
	@Query("SELECT c FROM Coder c WHERE tech=?1 ORDER BY cname")
	public List<Coder> getCoderByTechSorted(String tech);
	
//	public Coder getCoderById(int cid); //gives exception
}
