package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutido extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObejetoEmbutido(){

        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("01415-000");
        endereco.setLogradouro("Rua Bela Cintra");
        endereco.setNumero("339");
        endereco.setComplemento("ap 44");
        endereco.setBairro("Jardins");
        endereco.setCidade("São Paulo");
        endereco.setEstado("São Paulo");

        Pedido pedido = new Pedido();
        //pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(endereco);

        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();

        em.clear();

        Pedido pedidoVerificacao = em.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());

    }
}
