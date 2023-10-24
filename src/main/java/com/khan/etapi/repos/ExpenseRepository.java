package com.khan.etapi.repos;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.etapi.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	
	//SELECT * FROM tbl_Expenses WHERE category=?
//	Page <Expense> findByCategory(String category, Pageable page);
	Page<Expense> findByUserIdAndCategory(Long UserId, String category, Pageable page);
	
	//SELECT * FROM tbl_Expenses WHERE name LIKE `%keyword%`
	//Page <Expense>findByNameContaining(String keyword, Pageable page);
		Page<Expense> findByUserIdAndNameContaining(Long UserId, String keyword, Pageable page);
		
		//SELECT * FROM tbl_Expenses WHERE date BETWEEN 'startDate' AND 'endDate'
//		Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);

		Page<Expense> findByUserIdAndDateBetween(Long UserId, Date startDate, Date endDate, Pageable page);

		Page<Expense>findByUserId(Long UserId,Pageable page);
		
		Optional <Expense>findByUserIdAndId(Long userId, Long expenseId);
}



