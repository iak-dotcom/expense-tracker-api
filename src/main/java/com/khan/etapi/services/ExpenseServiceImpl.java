package com.khan.etapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.khan.etapi.entities.Expense;
import com.khan.etapi.repos.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		// TODO Auto-generated method stub
		return expenseRepository.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {
		// TODO Auto-generated method stub
		Optional<Expense> expense = expenseRepository.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new RuntimeException("Expense is not found for the id " + id);

	}

	@Override
	public void deleteExpenseById(Long id) {
		// TODO Auto-generated method stub
		expenseRepository.deleteById(id);
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		// TODO Auto-generated method stub
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);

existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());

existingExpense.setDescription(
				expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());

existingExpense.setCategory
				(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());

existingExpense.setAmount
				(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());

existingExpense.setDate
				(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());

		return expenseRepository.save(existingExpense);

	}



}
