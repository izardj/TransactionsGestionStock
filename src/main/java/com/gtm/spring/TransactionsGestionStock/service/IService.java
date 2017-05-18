package com.gtm.spring.TransactionsGestionStock.service;

import com.gtm.spring.TransactionsGestionStock.exceptions.ArticleNotFoundException;
import com.gtm.spring.TransactionsGestionStock.exceptions.NotEnoughArticleException;
import com.gtm.spring.TransactionsGestionStock.exceptions.QtyNegativeException;
import com.gtm.spring.TransactionsGestionStock.metier.Stock;

public interface IService {

	public void sortArticleDuStock(int id, int quantite) throws ArticleNotFoundException, NotEnoughArticleException, QtyNegativeException;
	
	public int getQtyEnStock(int id) throws ArticleNotFoundException;
	
	public void ajouter(Stock s);
}
