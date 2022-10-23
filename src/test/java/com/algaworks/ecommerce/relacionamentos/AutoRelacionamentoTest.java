package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){

        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        categoria.setCategoriaPai(categoriaPai);

        em.getTransaction().begin();
        em.persist(categoriaPai);
        em.persist(categoria);
        em.getTransaction().commit();

        em.clear();

        Categoria categoriaVerificacao = em.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaVerificacao.getId());

        Categoria categoriaPaiVerificacao = em.find(Categoria.class, categoriaPai.getId());
        Assert.assertFalse(categoriaPaiVerificacao.getCategorias().isEmpty());

    }

}
