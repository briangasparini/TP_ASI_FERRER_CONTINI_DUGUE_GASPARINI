package com.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);
	
	public Optional<User> findByLoginAndPassword(String login, String hashedPassword);
	
	@Modifying
	@Query(value = "UPDATE user u SET u.wallet=:newWallet WHERE u.id=:userId")
	public void saveNewBalance(@Param("userId") int userId, @Param("newWallet")  int newWallet);

	public Optional<User> findByLogin(String login);

}
