package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){

        Cliente cliente = em.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);

        pedido.setCliente(cliente);

        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();

        em.clear();

        Cliente clienteVerificacao = em.find(Cliente.class, cliente.getId());
        Assert.assertFalse(clienteVerificacao.getPedidos().isEmpty());


    }

}
