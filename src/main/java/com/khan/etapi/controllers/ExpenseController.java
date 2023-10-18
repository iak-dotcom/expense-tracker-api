package com.khan.etapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		
		return expenseService.getExpenseById(id);
	}

	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}

	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam("id") Long id) {
		expenseService.deleteExpenseById(id);
	}

}
