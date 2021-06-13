package com.portfolio.management.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.management.model.PortfolioStock;
import com.portfolio.management.model.Todo;
import com.portfolio.management.service.ITodoService;
import com.portfolio.management.service.PortfolioManagerService;

@Controller
public class PortfolioManagerController {

	@Autowired
	private PortfolioManagerService portfolioManagerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-portfolio", method = RequestMethod.GET)
	public String getAllPortfolioStocks(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("portfolioList", portfolioManagerService.getAllPortfolioStocks());
		// model.put("todos", service.retrieveTodos(name));
		return "portfolioList";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/addPosition", method = RequestMethod.GET)
	public String showAddPositionPage(ModelMap model) {
		model.addAttribute("portfolioStock", new PortfolioStock());
		return "portfolioStock";
	}

	@RequestMapping(value = "/deletePosition", method = RequestMethod.GET)
	public String deletePosition(@RequestBody PortfolioStock portfolioStock) {
		portfolioManagerService.deletePosition(portfolioStock);
		// service.deleteTodo(id);
		return "redirect:/portfolioList";
	}

	/*
	 * @RequestMapping(value = "/updatePosition", method = RequestMethod.GET) public
	 * String showUpdatePositionPage(@RequestParam int stockId) { Todo todo =
	 * portfolioManagerService.updatePosition(stockId); model.put("todo", todo);
	 * return "todo"; }
	 */

	/*
	 * @RequestMapping(value = "/update-todo", method = RequestMethod.POST) public
	 * String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
	 * 
	 * if (result.hasErrors()) { return "todo"; }
	 * 
	 * todo.setUserName(getLoggedInUserName(model)); todoService.updateTodo(todo);
	 * return "redirect:/list-todos"; }
	 * 
	 * @RequestMapping(value = "/add-todo", method = RequestMethod.POST) public
	 * String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
	 * 
	 * if (result.hasErrors()) { return "todo"; }
	 * 
	 * todo.setUserName(getLoggedInUserName(model)); todoService.saveTodo(todo);
	 * return "redirect:/list-todos"; }
	 */
}
