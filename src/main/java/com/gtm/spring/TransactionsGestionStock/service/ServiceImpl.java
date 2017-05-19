package com.gtm.spring.TransactionsGestionStock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtm.spring.TransactionsGestionStock.dao.StockRepository;
import com.gtm.spring.TransactionsGestionStock.exceptions.ArticleNotFoundException;
import com.gtm.spring.TransactionsGestionStock.exceptions.NotEnoughArticleException;
import com.gtm.spring.TransactionsGestionStock.exceptions.QtyNegativeException;
import com.gtm.spring.TransactionsGestionStock.metier.Stock;

@Service
//@Transactional
public class ServiceImpl implements IService {

	@Autowired
	StockRepository stockRepository;

	@Override
	public void sortArticleDuStock(int id, int quantite)
			throws ArticleNotFoundException, NotEnoughArticleException, QtyNegativeException {
		if (quantite < 0)
			throw new QtyNegativeException();
		
		if (!stockRepository.exists(id))
			throw new ArticleNotFoundException();
		
		if (getQtyEnStock(id) < quantite)		
			throw new NotEnoughArticleException();
		
		System.out.println("AVANT: " + stockRepository.findOne(id).getQuantite());
		stockRepository.sortArticleDuStock(id, quantite);
		System.out.println("APRES: " +stockRepository.findOne(id).getQuantite());
	}

	@Override
	public int getQtyEnStock(int id) throws ArticleNotFoundException {
		if (stockRepository.exists(id)) {
			return stockRepository.findOne(id).getQuantite();
		}
		throw new ArticleNotFoundException();
	}

	@Override
	public void ajouter(Stock s) {
		stockRepository.save(s);		
	}

}
