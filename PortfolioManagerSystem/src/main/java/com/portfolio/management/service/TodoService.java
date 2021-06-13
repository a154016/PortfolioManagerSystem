package com.portfolio.management.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.management.model.ResearchStock;
import com.portfolio.management.model.Todo;
import com.portfolio.management.repository.ResearchRepository;
import com.portfolio.management.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private ResearchRepository researchRepository;
	

	@Override
	public List<ResearchStock> getResearchByStockType(String type) {
		return researchRepository.findByStockType(type);
	}
	
	@Override
	public List<Todo> getTodosByUser(String user) {
		return todoRepository.findByUserName(user);
	}

	@Override
	public Optional<Todo> getTodoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}

	/*@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todoRepository.save(new Todo(name, desc, targetDate, isDone));
	}*/

	@Override
	public void deleteTodo(long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if (todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
	}

	@Override
	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	@Override
	public void saveResearch(ResearchStock researchStock) {
		researchRepository.save(researchStock);
	}

	@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Todo> getAllTodo() {
		return todoRepository.findAll();
	}

	@Override
	public Optional<ResearchStock> getResearchById(long id) {
		return researchRepository.findById(id);
	}

	@Override
	public void deleteResearch(long id) {
		Optional<ResearchStock> research = researchRepository.findById(id);
		if (research.isPresent()) {
			researchRepository.delete(research.get());
		}
		
	}
}