package com.erivan.movimentacao.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.erivan.movimentacao.modelo.Categorias;
import com.erivan.movimentacao.modelo.Movimentacoes;
import com.erivan.movimentacao.util.JPAUtil;

public class MovimantacoesPorCategoria {

	public static void main(String[] args) {
		  EntityManager manager = new JPAUtil().getEntityManager();

	        Categorias categorias = new Categorias();
	        categorias.setId(2);
                 //movimentações por categoria, passando o id da categoria
	        Query query = manager
	                .createQuery("select m from Movimentacoes m join m.categorias c where c = :pCategorias");

	        query.setParameter("pCategorias", categorias);

	        List<Movimentacoes> movimentacoes = query.getResultList();

	        for (Movimentacoes m : movimentacoes) {
	            System.out.println("\nDescricao ..: " + m.getDescricao());
	            System.out.println("Valor ......: R$ " + m.getValor());
	        }

	}

}
