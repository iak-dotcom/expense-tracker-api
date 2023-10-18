package com.khan.etapi.services;

import java.util.List;

import com.khan.etapi.entities.Expense;

public interface ExpenseService {

	List<Expense> getAllExpenses();
}
