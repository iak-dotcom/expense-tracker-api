package com.khan.etapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.etapi.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

