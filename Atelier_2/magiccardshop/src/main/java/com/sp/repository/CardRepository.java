package com.sp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sp.model.Card;
import com.sp.model.User;

public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);
	
	@Modifying
	@Query(value = "UPDATE Card c SET c.owner=:newUser WHERE c.id=:cardId")
	public void saveNewOwner(@Param("newUser") User newUser, @Param("cardId") int cardId);
}
