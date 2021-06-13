package com.portfolio.management.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.management.model.PortfolioStock;

public interface PortfolioManagerService {

	List<PortfolioStock> getAllPortfolioStocks();

	Optional<PortfolioStock> getTodoById(long id);

	void updatePosition(int stockId);

	void addPosition(PortfolioStock portStock);

	void deletePosition(PortfolioStock portStock);
	
	void savePosition(PortfolioStock portStock);

}