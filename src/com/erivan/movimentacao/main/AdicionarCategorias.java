package com.erivan.movimentacao.main;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Categorias;
import com.erivan.movimentacao.util.JPAUtil;

public class AdicionarCategorias {

	public static void main(String[] args) {
		
		Categorias categorias = new Categorias();
		categorias.setNome("Futebol");
		
		Categorias categorias1 = new Categorias();
		categorias1.setNome("Cinema");
		
		Categorias categorias2 = new Categorias();
        categorias2.setNome("futebol");
        
    	EntityManager em = new JPAUtil().getEntityManager();
    	em.getTransaction().begin();
    	
    	em.persist(categorias);
    	em.persist(categorias1);
    	em.persist(categorias2);
    	
    	em.getTransaction().commit();
    	em.close();
	}

}
