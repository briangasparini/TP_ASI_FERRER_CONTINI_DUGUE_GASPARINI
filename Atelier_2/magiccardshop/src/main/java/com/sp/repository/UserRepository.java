package com.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);
	
	@Query(value = "SELECT * FROM User WHERE login=:login AND password=:hashedPassword", nativeQuery = true)
	public Optional<User> findByLoginAndPassword(String login, String hashedPassword);
}
