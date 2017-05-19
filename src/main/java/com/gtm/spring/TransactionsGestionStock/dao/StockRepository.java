package com.gtm.spring.TransactionsGestionStock.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gtm.spring.TransactionsGestionStock.metier.Stock;

@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer> {
	@Modifying
	@Query("UPDATE Stock s SET s.quantite = s.quantite - ?2 WHERE s.id = ?1")
	public void sortArticleDuStock(int id, int quantite);
}