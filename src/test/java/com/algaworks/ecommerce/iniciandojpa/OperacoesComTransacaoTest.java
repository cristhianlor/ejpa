package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();

        //produto.setId(3);
        produto.setNome("Go Prod Hero 5");
        produto.setDescricao("Para capturar os seus melhores momentos.");
        produto.setPreco(new BigDecimal(5000));

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.clear();

        Produto produtoVerificacao = em.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);


    }

    @Test
    public void inserirObjetoComMerge(){
        Produto produto = new Produto();

        produto.setId(3);
        produto.setNome("Go Pro Hero 5");
        produto.setDescricao("Para capturar os seus melhores momentos.");
        produto.setPreco(new BigDecimal(5000));

        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.clear();

        Produto produtoVerificacao = em.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjetoGerenciado(){

        Produto produto = em.find(Produto.class, 2);

        produto.setId(2);
        produto.setNome("Canon Pro SX 5º Series");

        em.getTransaction().begin();

        em.merge(produto);

        em.getTransaction().commit();

        em.clear();

        Produto produtoVerificacao = em.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Canon Pro SX 5º Series", produtoVerificacao.getNome());
    }

    @Test
    public void ImpedirOperacaoComBancoDeDados(){

        Produto produto = em.find(Produto.class, 2);
        em.detach(produto);

        //produto.setId(2);
        produto.setNome("Canon Pro SX 5º Series");

        em.getTransaction().begin();
        produto.setId(2);
        em.getTransaction().commit();
        em.clear();

        Produto produtoVerificacao = em.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Canon", produtoVerificacao.getNome());
    }

    @Test
    public void atualizarObjeto(){

        Produto produto = new Produto();

        produto.setId(2);
        produto.setNome("Canon Pro SX");
        produto.setDescricao("Para capturar os seus melhores momentos.");
        produto.setPreco(new BigDecimal(6000));

        em.getTransaction().begin();

        em.merge(produto);

        em.getTransaction().commit();

        em.clear();

        Produto produtoVerificacao = em.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Canon Pro SX", produtoVerificacao.getNome());
    }

    @Test
    public void removerObjeto(){
        Produto produto = em.find(Produto.class, 2);
        produto.setId(2);

        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();

        Produto produtoVerificacao = em.find(Produto.class, 2);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void abrirEFecharAtransacao(){

        em.getTransaction().begin();

        //em.persist(produto);
        //em.merge(produto);
        //em.remove(produto);

        em.getTransaction().commit();

    }

}
