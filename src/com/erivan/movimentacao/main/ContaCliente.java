package com.erivan.movimentacao.main;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Cliente;
import com.erivan.movimentacao.modelo.Conta;
import com.erivan.movimentacao.util.JPAUtil;

final class ContaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		cliente.setNome("Erivan Cledson");
		cliente.setEndereco("Rua xx");
		cliente.setProfissao("Analista de sistemas");
		
		//atribuir a conta de id 2 no cliente erivan
		Conta conta = new Conta();
		//passo a conta que eu quero
		conta.setId(2);
		//pega a conta 2 e passo para o cliente
		cliente.setConta(conta);
				
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		//persiste o cliente pois o mesmo não está cadastrado
		em.persist(cliente);
		em.getTransaction().commit();
        
	}

}
