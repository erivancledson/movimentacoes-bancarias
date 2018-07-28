package com.erivan.movimentacao.main;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Cliente;
import com.erivan.movimentacao.util.JPAUtil;

public class AtualizarCliente {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
	
		
		Cliente cliente = em.find(Cliente.class, 2);
		em.getTransaction().begin();
		
		 cliente.setNome("Elayne");
		 cliente.setProfissao("Estilista");
		 
		em.getTransaction().commit();
		em.close();
       
	}

}
