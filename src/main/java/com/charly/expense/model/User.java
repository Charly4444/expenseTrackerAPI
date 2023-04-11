package com.charly.expense.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	
	@Id
//	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
//	the One side of OneToMany is referenced by Many, if it becomes an orphan it can be removed; as set here
	@OneToMany(mappedBy = "user",orphanRemoval = true)	//as a reverse def we use 'mappedBy' attribute
	private List<Expense> expenses = new ArrayList<Expense>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String email, List<Expense> expense) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.expenses = expense;
	}

	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
