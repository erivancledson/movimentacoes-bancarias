package com.erivan.movimentacao.main;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Cliente;
import com.erivan.movimentacao.modelo.Conta;
import com.erivan.movimentacao.util.JPAUtil;

public class AdicionarCliente {

	public static void main(String[] args) {
		
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Karla");
        cliente3.setProfissao("Engenheira");
        cliente3.setEndereco("rua y, são pedro");
        
        //seta a conta
        Conta conta = new Conta();
        conta.setId(1);
        //recebe a conta
        cliente3.setConta(conta);
		
        
    	EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
	   em.persist(cliente3);
	   
	   em.getTransaction().commit();
	   em.close();
	}

}
