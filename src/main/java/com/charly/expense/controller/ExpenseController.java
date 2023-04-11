package com.charly.expense.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charly.expense.error.ExpenseNotFoundException;
import com.charly.expense.error.UserNotFoundException;
import com.charly.expense.model.Expense;
import com.charly.expense.model.User;
import com.charly.expense.service.ExpenseService;
import com.charly.expense.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	List <User> getAll(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
//	ResponseEntity<?> getCategory(@PathVariable Long id){
//		Optional<Category> category = categoryRepository.findById(id);
//		return category.map(response -> ResponseEntity.ok().body(response))
//				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
	User getOne(@PathVariable ("id") Long id) throws UserNotFoundException {
		return userService.getAUser(id);
	}
	
	@PostMapping("/users")
	User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	String removeUser(@PathVariable ("id") Long id) throws UserNotFoundException {
		return userService.removeUser(id);
	}
	
	
//	EXPENSES
	
	@PostMapping("/users/exp/{id}")		//mention pathVariable then rename it with type
	Expense addExpId(@RequestBody Expense expense, @PathVariable ("id") Long userId) throws ExpenseNotFoundException{
		return expenseService.addExpenseByUserId(expense, userId);
	}
	
	@GetMapping("/exp")
	List <Expense> getAllExp(){
		return expenseService.getExpense();
	}
	
	@GetMapping("/exp/{id}")
	Expense getAExp(@PathVariable ("id") Long id) throws ExpenseNotFoundException{
		return expenseService.getExpenseById(id);
	}
	
	@DeleteMapping("/exp/{id}")
	String removeExp(@PathVariable ("id") Long id) throws ExpenseNotFoundException{
		return expenseService.removeExpense(id);
	}
	
}