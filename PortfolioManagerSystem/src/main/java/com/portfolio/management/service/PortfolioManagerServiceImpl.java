package com.portfolio.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.management.model.PortfolioStock;
import com.portfolio.management.repository.PortfolioRepository;

@Service
public class PortfolioManagerServiceImpl implements PortfolioManagerService {

	@Autowired
	private PortfolioRepository  portfolioRepository;

	@Override
	public List<PortfolioStock> getAllPortfolioStocks() {
		return  portfolioRepository.findAll();
	}

	@Override
	public Optional<PortfolioStock> getTodoById(long id) {
		return portfolioRepository.findById(id);
	}



	@Override
	public void addPosition(PortfolioStock portfolioStock) {
		portfolioRepository.save(portfolioStock);
	}

	@Override
	public void deletePosition(PortfolioStock portfolioStock) {
		Optional<PortfolioStock> stock = portfolioRepository.findById(portfolioStock.getStockId());
		
			portfolioRepository.deleteById(portfolioStock.getStockId());
		
	}

	@Override
	public void savePosition(PortfolioStock portfolioStock) {
		portfolioRepository.save(portfolioStock);
	}



	@Override
	public void updatePosition(int stockId) {
		portfolioRepository.save(stockId);
		
	}

	
}