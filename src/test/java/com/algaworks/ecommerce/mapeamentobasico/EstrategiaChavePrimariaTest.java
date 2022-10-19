package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void testarEstrategiaChave(){
        Categoria categoria = new Categoria();
        categoria.setNome("Eltrônicos");

        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

        em.clear();

        Categoria categoriaVerificacao = em.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaVerificacao);
    }
}
