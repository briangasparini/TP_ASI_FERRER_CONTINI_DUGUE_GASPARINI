package com.sp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);
	
	@Query(value = "SELECT * FROM Card WHERE owner=:userId", nativeQuery = true)
	public List<Card> findUserCards(@Param("userId") int userId);
}
