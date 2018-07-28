package com.erivan.movimentacao.main;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Categorias;
import com.erivan.movimentacao.util.JPAUtil;

public class RemoverCategorias {

	public static void main(String[] args) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		//primeiro busca a categoria
		Categorias categorias = em.find(Categorias.class, 3);
		
		em.getTransaction().begin();
		
		em.remove(categorias);
		
		em.getTransaction().commit();
		em.close();

	}

}
