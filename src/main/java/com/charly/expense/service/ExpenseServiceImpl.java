package com.charly.expense.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charly.expense.error.ExpenseNotFoundException;
import com.charly.expense.error.UserNotFoundException;
import com.charly.expense.model.Expense;
import com.charly.expense.model.User;
import com.charly.expense.repository.ExpenseRepository;
import com.charly.expense.repository.UserRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Expense> getExpense() {
		return expenseRepository.findAll();
	}

//	stressful route...	you have to type out the whole thing
	@Override
	public Expense addExpense(Expense expense) {
		Expense newExpense = new Expense();
		newExpense.setId(expense.getId());
		newExpense.setUser(expense.getUser());
		newExpense.setCategory(expense.getCategory());
		newExpense.setDescription(expense.getDescription());
		newExpense.setExpensedate(Instant.now());
		expenseRepository.save(newExpense);
		return newExpense;
	}
	
//	easy route, user is existing...
	@Override
	public Expense addExpenseByUserId(Expense expense, Long userId) throws ExpenseNotFoundException {
		if (userRepository.findById(userId).isEmpty()) {
			throw new ExpenseNotFoundException("No User By that Id !");
		}
		User user = userRepository.findById(userId).get();
		Expense newExpense = new Expense();
		
		newExpense.setUser(user);
		newExpense.setId(expense.getId());
		newExpense.setCategory(expense.getCategory());
		newExpense.setDescription(expense.getDescription());
		newExpense.setExpensedate(Instant.now());
		
		expenseRepository.save(newExpense);
		return newExpense;
	}

	@Override
	public Expense getExpenseById(Long id) throws ExpenseNotFoundException {
		if (expenseRepository.findById(id).isEmpty()) {
			throw new ExpenseNotFoundException("No Such Entry Found!!");
		}
		return expenseRepository.findById(id).get();
	}

	@Override
	public String removeExpense(Long id) throws ExpenseNotFoundException {
		if (expenseRepository.findById(id).isEmpty()) {
			throw new ExpenseNotFoundException("Expense Not Found!!");
		}
		expenseRepository.deleteById(id);
		return "expense record has been removed!";
	}

}
