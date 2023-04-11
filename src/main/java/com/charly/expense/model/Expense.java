package com.charly.expense.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expense_table")
public class Expense {
	
	@Id
	private Long id;
	private Instant expensedate;
	private String description;
//	many expenses mapped to one user	-> the Many side is the referencing side, can be deleted at will
//	and all cascade operations chained down also
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_fk")
	private User user;
	
	private String category;
	
	
	public Expense() {
		// TODO Auto-generated constructor stub
	}
	public Expense(Long id, Instant expensedate, String description, User user, String category) {
		super();
		this.id = id;
		this.expensedate = expensedate;
		this.description = description;
		this.user = user;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Instant getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(Instant expensedate) {
		this.expensedate = expensedate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Expense [id=" + id + ", expensedate=" + expensedate + ", description=" + description + ", user=" + user
				+ ", category=" + category + "]";
	}
	
}
