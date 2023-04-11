package com.charly.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charly.expense.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
