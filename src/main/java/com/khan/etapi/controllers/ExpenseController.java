package com.khan.etapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.etapi.entities.Expense;
import com.khan.etapi.services.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
	return expenseService.getAllExpenses();	
	}
}
