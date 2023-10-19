package com.khan.etapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.khan.etapi.entities.Expense;

public interface ExpenseService {

	Page<Expense> getAllExpenses(Pageable page);

	Expense getExpenseById(Long id);
	
	void deleteExpenseById(Long id);
	
	Expense saveExpenseDetails(Expense expense);
	
	Expense updateExpenseDetails(Long id, Expense expense);
}
