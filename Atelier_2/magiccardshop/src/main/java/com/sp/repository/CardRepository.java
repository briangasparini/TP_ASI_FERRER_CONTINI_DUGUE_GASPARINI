package com.sp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);
	
	@Query(value = "UPDATE Card SET owner=:newUserId WHERE cardId=:cardId", nativeQuery = true)
	@Modifying
	public void saveNewOwner(int cardId, int newUserId);
}
