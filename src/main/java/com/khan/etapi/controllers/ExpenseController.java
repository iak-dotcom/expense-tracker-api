package com.khan.etapi.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.khan.etapi.entities.Expense;
import com.khan.etapi.services.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
	return expenseService.getAllExpenses(page).toList();	
	}

	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		
		return expenseService.getExpenseById(id);
	}
	@ResponseStatus(value=HttpStatus.CREATED)//this will create a 201 code
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}

	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
	return expenseService.updateExpenseDetails(id, expense);

		}
	@ResponseStatus(value=HttpStatus.NO_CONTENT)//this will create a 204 code
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam("id") Long id) {
		expenseService.deleteExpenseById(id);
	}
	
	//Filter the records by category
	@GetMapping("/expenses/category")
	public List<Expense>getExpenseByCategory(@RequestParam String category, Pageable page){
		return expenseService.readByCategory(category, page);
	}
	//Filter the records by name
	@GetMapping("/expenses/name")
	public List<Expense>getExpenseByName(@RequestParam String keyword, Pageable page){
		return expenseService.readByName(keyword, page);
		}
	@GetMapping("/expenses/date")
	public List<Expense>getExpenseByDates(@RequestParam(required=false) Date startDate,
											@RequestParam(required=false) Date endDate, Pageable page){
		
		return expenseService.readByDate(startDate, endDate, page);

}
}