package com.erivan.movimentacao.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.erivan.movimentacao.modelo.Conta;
import com.erivan.movimentacao.modelo.Movimentacoes;
import com.erivan.movimentacao.modelo.TipoMovimentacao;
import com.erivan.movimentacao.util.JPAUtil;

public class JPQLMovimentacao {

	public static void main(String[] args) {
	    EntityManager manager = new JPAUtil().getEntityManager();

	    //movimentacao da conta 2, por ordem decrescente
	    
        Conta conta = new Conta();
        conta.setId(2);

        Query query = manager
                .createQuery("select m from Movimentacoes m where m.conta=:pConta "
                           + "and m.tipo = :pTipo order by m.valor desc");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        List<Movimentacoes> movimentacoes = query.getResultList();

        for (Movimentacoes m : movimentacoes) {
            System.out.println("Descricao: " + m.getDescricao());
            System.out.println("Conta.id:" + m.getValor());
            System.out.println("Tipo da motimentação: " + m.getTipo());
        }

	}

}
