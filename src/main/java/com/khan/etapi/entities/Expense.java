package com.khan.etapi.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "expense_name")
	@NotBlank(message = "Expense name must not be null or Blank!")
	@Size(min=3,message="Expense name must be atleast 3 characters!")
	private String name;
	
	private String description;
	
	@Column(name = "expense_amount")
	@NotBlank(message = "Expense amount must not be null or Blank!")
	private BigDecimal amount;
	
	@NotBlank(message = "Expense category must not be null or Blank!")
	private String category;
	
	@NotBlank(message = "Expense date must not be null or Blank!")
	private Date date;

	@Column(name="created_at",nullable = false, updatable=false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

}