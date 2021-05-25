package com.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);
	
	public Optional<User> findByLoginAndPassword(String login, String hashedPassword);
	
	@Query(value = "UPDATE user SET wallet=:newWallet WHERE userId=:userId", nativeQuery = true)
	@Modifying
	public void saveNewBalance(int userId, int newWallet);

}
