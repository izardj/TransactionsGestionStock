package com.gtm.spring.TransactionsGestionStock;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtm.spring.TransactionsGestionStock.exceptions.ArticleNotFoundException;
import com.gtm.spring.TransactionsGestionStock.exceptions.NotEnoughArticleException;
import com.gtm.spring.TransactionsGestionStock.exceptions.QtyNegativeException;
import com.gtm.spring.TransactionsGestionStock.metier.Stock;
import com.gtm.spring.TransactionsGestionStock.service.IService;

public class Lanceur {

	public static void main(String[] args) {
		// 1- Chargement du conteneur et creation des beans
				ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
						
				// 2- recuperation d'un bean
				IService service = (IService) appContext.getBean("serviceImpl");
				Stock s1 = (Stock) appContext.getBean("stock");
				Stock s2 = (Stock) appContext.getBean("stock");
				Stock s3 = (Stock) appContext.getBean("stock");
				Stock s4 = (Stock) appContext.getBean("stock");
				s1.setNom("Ordinateurs");
				s1.setQuantite(40);
				service.ajouter(s1);
				
				s2.setNom("Claviers");
				s2.setQuantite(20);
				service.ajouter(s2);
				
				s3.setNom("Souris");
				s3.setQuantite(60);
				service.ajouter(s3);

				s4.setNom("Ecrans");
				s4.setQuantite(10);
				service.ajouter(s4);
				// 3- Traitement

				try {
					service.sortArticleDuStock(2, 4);
				} catch (ArticleNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotEnoughArticleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (QtyNegativeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 4- detruire le context
				appContext.close();
	}

}
