package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoPedidoComPagamentoCartao(){

      Cliente cliente = em.find(Cliente.class, 1);

      Produto produto = em.find(Produto.class, 1);

       Pedido pedido = new Pedido();
       pedido.setCliente(cliente);
       pedido.setDataPedido(LocalDateTime.now());
       pedido.setTotal(BigDecimal.TEN);
       pedido.setStatus(StatusPedido.PROCESSANDO);

       ItemPedido itemPedido = new ItemPedido();
       itemPedido.setPedido(pedido);
       itemPedido.setProduto(produto);
       itemPedido.setPrecoProduto(new BigDecimal(499.0));
       itemPedido.setQuantidade(1);

       PagamentoCartao pagamentoCartao = new PagamentoCartao();
       pagamentoCartao.setNumero("1111.2222.3333.4444");
       pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
       pagamentoCartao.setPedido(pedido);

       em.getTransaction().begin();
       em.persist(pedido);
       em.persist(itemPedido);
       em.persist(pagamentoCartao);
       em.getTransaction().commit();

       em.clear();

       Pedido pedidoVerificacao = em.find(Pedido.class, pedido.getId());
       Assert.assertNotNull(pedidoVerificacao.getPagamentoCartao());
       Assert.assertNotNull(pedidoVerificacao.getItensPedido());

    }

    @Test
    public void verificaRelacionamentoPedidoComNotaFiscal(){

        //Cliente cliente = em.find(Cliente.class, 1);

        //Produto produto = em.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        //pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setStatus(StatusPedido.PROCESSANDO);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setXml("TESTE");
        notaFiscal.setDataEmissao(new Date());

        em.getTransaction().begin();
        em.persist(pedido);
        em.persist(notaFiscal);
        em.getTransaction().commit();

        em.clear();

        Pedido pedidoVerificacao = em.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getNotaFiscal());


    }

}
