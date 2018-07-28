package com.erivan.movimentacao.main;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import com.erivan.movimentacao.modelo.Categorias;
import com.erivan.movimentacao.modelo.Conta;
import com.erivan.movimentacao.modelo.Movimentacoes;
import com.erivan.movimentacao.modelo.TipoMovimentacao;
import com.erivan.movimentacao.util.JPAUtil;

public class CategoriaEMovimentacaoCadastro {
	
	public static void main(String[] args) {
		
		//primeiro seta a categoria
		Categorias categoria = new Categorias("Empresa");
		Categorias categoria2 = new Categorias("Viagem");
		
		
		//atribuir conta de numero 2
		Conta conta = new Conta();
		conta.setId(2);
		
		//criar a movimentação
		Movimentacoes movimentacoes = new Movimentacoes();
		movimentacoes.setData(Calendar.getInstance());
		movimentacoes.setDescricao("Viagem a orlando");
		movimentacoes.setTipo(TipoMovimentacao.SAIDA);
		movimentacoes.setValor(new BigDecimal("500.00"));
		movimentacoes.setCategorias(Arrays.asList(categoria, categoria2));
		
		//passa a conta de id 2 para a movimentacao
		movimentacoes.setConta(conta);
		
		Movimentacoes movimentacoes2 = new Movimentacoes();
		movimentacoes2.setData(Calendar.getInstance());
		movimentacoes2.setDescricao("venda de sistemas");
		movimentacoes2.setTipo(TipoMovimentacao.ENTRADA);
		movimentacoes2.setValor(new BigDecimal("2000.00"));
		movimentacoes2.setCategorias(Arrays.asList(categoria, categoria2));
		
		movimentacoes2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		//persisti a categoria
		em.persist(categoria);
		em.persist(categoria2);
		
		//persisti as movimentações
		em.persist(movimentacoes);
		em.persist(movimentacoes2);
		
		
		
		em.getTransaction().commit();
		em.close();
	
	}

}
