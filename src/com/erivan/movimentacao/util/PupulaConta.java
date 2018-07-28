package com.erivan.movimentacao.util;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Conta;

public class PupulaConta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		Conta conta2 = new Conta();
		
		conta.setAgencia("0721-8");
		conta.setBanco("Brasil");
		conta.setNumero("65326-9");
		conta.setTitular("Erivan");
		
		conta2.setAgencia("0721-8");
		conta2.setBanco("Bradesco");
		conta2.setNumero("23212-9");
		conta2.setTitular("Cledson");
		
		manager.persist(conta);
        manager.persist(conta2);		
		
		manager.getTransaction().commit();
		manager.close();

	}

}
