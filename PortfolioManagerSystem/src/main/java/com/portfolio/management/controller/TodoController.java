package com.portfolio.management.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.management.model.ResearchStock;
import com.portfolio.management.model.Todo;
import com.portfolio.management.service.ITodoService;

@Controller
public class TodoController {

	@Autowired
	private ITodoService todoService;
	
	public static String uploadDirectory="E:\\"+"/uploads";
	
	 float holdValue=0.0f;
	 float marketValue=0.0f;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
	String name = getLoggedInUserName(model);
	//List<Todo>  todos=	todoService.getTodosByUser(name);
	List<Todo>  todos=	todoService.getAllTodo();
	List<Todo>  todos2=	new ArrayList<Todo>();

	for(Todo t:todos)
	{
		byte[] encode = java.util.Base64.getEncoder().encode(t.getFiles());
		try {
			System.out.println("image data"+t.getFiles().toString());
			//model.addAttribute("files", new String(encode, "UTF-8"));
			t.setImage(new String(encode, "UTF-8"));
		
			todos2.add(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	model.put("todos", todos2);
	return "list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) throws UnsupportedEncodingException {
		Todo todo = todoService.getTodoById(id).get();
		byte[] encode = java.util.Base64.getEncoder().encode(todo.getFiles());
		model.addAttribute("files", new String(encode, "UTF-8"));
		model.put("todo", todo);
		return "todo";
	}


	@RequestMapping(value = "/updateResearch", method = RequestMethod.GET)
	public String showUpdateResearchPage(@RequestParam long id, ModelMap model) throws UnsupportedEncodingException {
		ResearchStock todo = todoService.getResearchById(id).get();
		byte[] encode = java.util.Base64.getEncoder().encode(todo.getFiles());
		model.addAttribute("files", new String(encode, "UTF-8"));
		model.put("todo", todo);
		return "todo";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}
	
	@RequestMapping(value = "/addSwingResearch", method = RequestMethod.GET)
	public String showAddSwingResearchPage(ModelMap model) {
		model.addAttribute("addResearch", new ResearchStock());
		return "addSwingResearch";
	}
	
	@RequestMapping(value = "/addPositionalResearch", method = RequestMethod.GET)
	public String showAddPositionalResearchPage(ModelMap model) {
		model.addAttribute("addResearch", new ResearchStock());
		return "addPositionalResearch";
	}
	
	@RequestMapping(value = "/addIntraResearch", method = RequestMethod.GET)
	public String showAddResearchPage(ModelMap model) {
		model.addAttribute("addResearch", new ResearchStock());
		return "addIntraResearch";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		todoService.deleteTodo(id);
		// service.deleteTodo(id);
		return "redirect:/list-todos";
	}


	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @RequestParam("files") MultipartFile files,@Valid Todo todo, BindingResult result) throws IOException {
		if(todo.getFiles()==null)
		{
			Todo todo1 = todoService.getTodoById(todo.getId()).get();
			byte[] encode = java.util.Base64.getEncoder().encode(todo1.getFiles());
			//model.addAttribute("files", new String(encode, "UTF-8"));
			todo.setFiles(todo1.getFiles());
		}

		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam("files") MultipartFile files ,Todo todo, BindingResult result) throws IOException {			
	    todo.setFiles(files.getBytes());
		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/addIntraResearch", method = RequestMethod.POST)
	public String addResearch(ModelMap model, @RequestParam("files") MultipartFile files, ResearchStock researchStock,BindingResult result) throws IOException {
		researchStock.setStockType("I");
		//researchStock.setUserName(getLoggedInUserName(model));
		researchStock.setFiles(files.getBytes());	
		todoService.saveResearch(researchStock);
		return "redirect:/listIntraday";
	}
	
	@RequestMapping(value = "/addSwingResearch", method = RequestMethod.POST)
	public String addSwingResearch(ModelMap model, @RequestParam("files") MultipartFile files ,ResearchStock researchStock, BindingResult result) throws IOException {
	researchStock.setStockType("S");
	researchStock.setFiles(files.getBytes());
		todoService.saveResearch(researchStock);
		return "redirect:/listSwing";
	}
	
	@RequestMapping(value = "/addPositionalResearch", method = RequestMethod.POST)
	public String addPositionalResearch(ModelMap model, @RequestParam("files") MultipartFile files ,ResearchStock researchStock, BindingResult result) throws IOException {
	researchStock.setStockType("P");
	researchStock.setFiles(files.getBytes());
		todoService.saveResearch(researchStock);
		return "redirect:/listPositional";
	}
	
	
	@RequestMapping(value = "/listIntraday", method = RequestMethod.GET)
	public String listIntradayResearch(ModelMap model) throws UnsupportedEncodingException {

		List<ResearchStock> researchList = todoService.getResearchByStockType("I");
		List<ResearchStock> researchList1 = new ArrayList<ResearchStock>();
		for (ResearchStock t : researchList) {

			byte[] encode = java.util.Base64.getEncoder().encode(t.getFiles());

			t.setImage(new String(encode, "UTF-8"));
			researchList1.add(t);
		}

		model.put("researchList", researchList1);

		return "listIntraday";
	}
	
	

	
	
	@RequestMapping(value = "/listSwing", method = RequestMethod.GET)
	public String listSwingResearch(ModelMap model) throws UnsupportedEncodingException {
		List<ResearchStock> researchList = todoService.getResearchByStockType("S");
		List<ResearchStock> researchList1 = new ArrayList<ResearchStock>();
		for (ResearchStock t : researchList) {

			byte[] encode = java.util.Base64.getEncoder().encode(t.getFiles());

			t.setImage(new String(encode, "UTF-8"));
			researchList1.add(t);
		}

		model.put("researchList", researchList1);
		return "listSwing";
	}
	
	
	@RequestMapping(value = "/listPositional", method = RequestMethod.GET)
	public String listPositionalResearch(ModelMap model) throws UnsupportedEncodingException {
		List<ResearchStock> researchList = todoService.getResearchByStockType("P");
		List<ResearchStock> researchList1 = new ArrayList<ResearchStock>();
		for (ResearchStock t : researchList) {

			byte[] encode = java.util.Base64.getEncoder().encode(t.getFiles());

			t.setImage(new String(encode, "UTF-8"));
			researchList1.add(t);
		}

		model.put("researchList", researchList1);
		return "listPositional";
	}
}
