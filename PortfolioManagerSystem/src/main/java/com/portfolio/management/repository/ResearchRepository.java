package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.model.ResearchStock;


public interface ResearchRepository extends JpaRepository<ResearchStock, Long>{
	List<ResearchStock> findByStockType(String type);
}
