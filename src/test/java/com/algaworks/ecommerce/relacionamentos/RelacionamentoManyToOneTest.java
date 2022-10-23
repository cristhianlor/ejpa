package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoPedidoComCliente(){

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

        Pedido pedidoVerificacao = em.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getCliente());

    }

    @Test
    public void verificaRelacionamentoPedidoComItemPedido(){

        Cliente cliente = em.find(Cliente.class, 1);
        Produto produto = em.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(1);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());

        em.getTransaction().begin();
        em.persist(pedido);
        em.persist(itemPedido);
        em.getTransaction().commit();

        em.clear();

        Pedido pedidoVerificacao = em.find(Pedido.class, pedido.getId());
        Assert.assertFalse(pedidoVerificacao.getItensPedido().isEmpty());


    }

}
