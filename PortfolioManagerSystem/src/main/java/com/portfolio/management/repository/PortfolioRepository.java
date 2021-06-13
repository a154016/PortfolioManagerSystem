package com.portfolio.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.management.model.PortfolioStock;
import com.portfolio.management.model.Todo;

public interface PortfolioRepository extends JpaRepository<PortfolioStock, Long>{
	List<PortfolioStock> findAll();

	void save(long stockId);

	//boolean isPresent();
}
