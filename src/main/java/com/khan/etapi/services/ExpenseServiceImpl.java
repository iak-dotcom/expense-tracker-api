package com.khan.etapi.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.khan.etapi.entities.Expense;
import com.khan.etapi.exceptions.ResourceNotFoundException;
import com.khan.etapi.repos.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private UserService userService;

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
//only user can see the expenses of his own id.
		return expenseRepository.findByUserId(userService.getLoggedInUser().getId(), page);
	}

//(To see all user expenses)		return expenseRepository.findAll(page);

	@Override
	public Expense getExpenseById(Long id) {
		// TODO Auto-generated method stub
		Optional<Expense> expense = expenseRepository.findByUserIdAndId(userService.getLoggedInUser().getId(), id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense is not found for the id " + id);

	}

	@Override
	public void deleteExpenseById(Long id) {
		Expense expense = getExpenseById(id);
		expenseRepository.deleteById(id);
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		// now we can save expense in database
		expense.setUser(userService.getLoggedInUser());
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);

		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());

		existingExpense.setDescription(
				expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());

		existingExpense
				.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());

		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());

		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());

		return expenseRepository.save(existingExpense);

	}

	@Override
	public List<Expense> readByCategory(String category, Pageable page) {
		return expenseRepository.findByUserIdAndCategory(userService.getLoggedInUser().getId(),category, page).toList();
	}

	@Override
	public List<Expense> readByName(String keyword, Pageable page) {
		return expenseRepository.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(),keyword, page).toList();
	}

	@Override
	public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
		if (startDate == null) {
			startDate = new Date(0);
		}
		if (endDate == null) {
			endDate = new Date(System.currentTimeMillis());
		}
		
		return expenseRepository.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(),startDate, endDate, page).toList();
	}

}
