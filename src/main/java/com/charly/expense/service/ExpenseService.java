package com.charly.expense.service;

import java.util.List;

import com.charly.expense.error.ExpenseNotFoundException;
import com.charly.expense.model.Expense;

public interface ExpenseService {
	
	List<Expense> getExpense();
	
	Expense addExpense (Expense expense);
	
	Expense addExpenseByUserId(Expense expense, Long userId) throws ExpenseNotFoundException;
	
	Expense getExpenseById(Long id) throws ExpenseNotFoundException;
	
	String removeExpense(Long id) throws ExpenseNotFoundException;
	
//	i mean getting by userId
//	List<Expense> getExpenseByUser(User user);

}
