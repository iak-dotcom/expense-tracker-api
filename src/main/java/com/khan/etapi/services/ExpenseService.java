package com.khan.etapi.services;

import java.util.List;

import com.khan.etapi.entities.Expense;

public interface ExpenseService {

	List<Expense> getAllExpenses();

	Expense getExpenseById(Long id);
	
	void deleteExpenseById(Long id);
	
	Expense saveExpenseDetails(Expense expense);
	
	Expense updateExpenseDetails(Long id, Expense expense);
}
