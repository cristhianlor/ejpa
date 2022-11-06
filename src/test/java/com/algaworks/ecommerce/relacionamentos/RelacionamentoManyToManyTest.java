package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.hibernate.sql.ast.tree.cte.CteColumn;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class RelacionamentoManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){

       Produto produto = em.find(Produto.class, 1);
       Categoria categoria = em.find(Categoria.class, 1);

       em.getTransaction().begin();
       //categoria.setProdutos(Arrays.asList(produto));
       produto.setCategorias(Arrays.asList(categoria));
       //em.persist();
       em.getTransaction().commit();

       em.clear();

       Categoria categoriaVerificacao = em.find(Categoria.class, categoria.getId());
       Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());

    }

}
