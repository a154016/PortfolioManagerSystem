package com.portfolio.management.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.portfolio.management.model.ResearchStock;
import com.portfolio.management.model.Todo;

public interface ITodoService {

	List<Todo> getTodosByUser(String user);

	Optional<Todo> getTodoById(long id);

	void updateTodo(Todo todo);

	void addTodo(String name, String desc, Date targetDate, boolean isDone);

	void deleteTodo(long id);
	
	void saveTodo(Todo todo);
	
	void saveResearch(ResearchStock researchStock);
	
	List<ResearchStock> getResearchByStockType(String type);
	/*
	 * List<ResearchStock> getSwingStocks(String type);
	 * 
	 * List<ResearchStock> getPositionalStocks(String type);
	 */

	List<Todo> getAllTodo();

	Optional<ResearchStock> getResearchById(long id);
	void deleteResearch(long id);

}