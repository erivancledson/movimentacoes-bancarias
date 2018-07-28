package com.erivan.movimentacao.main;

import java.util.List;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Categorias;
import com.erivan.movimentacao.util.JPAUtil;

public class JPQLCategorias {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
    	em.getTransaction().begin();
    	
    	List<Categorias> categorias = em.createQuery("from Categorias where nome = 'futebol'", Categorias.class).getResultList();
    	
    	 for (Categorias categoria : categorias) {
		       
    		 System.out.println(categoria.getNome());
		}
    	
    	em.close();

	}

}
