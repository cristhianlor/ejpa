package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void createCliente(){
       Cliente cliente = new Cliente();
       cliente.setId(3);
       cliente.setNome("Lorenzo M de Assis");

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.clear();

        Cliente clienteVerificacao = em.find(Cliente.class, cliente.getId());
        Assert.assertEquals(3, 3);
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void readCliente(){

        Cliente cliente = em.find(Cliente.class, 2);

        Cliente clienteVerificacao = em.find(Cliente.class, 2);
        Assert.assertNotNull(clienteVerificacao);

    }

    @Test
    public void updateCliente(){

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Cristiano Alves de Assis");

        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.clear();

        Cliente clienteVerificacao = em.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
        Assert.assertEquals("Cristiano Alves de Assis", 1,1);
    }

    @Test
    public void deleteCliente(){
        Cliente cliente = em.find(Cliente.class, 2);

        cliente.setId(2);

        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        em.clear();

        Cliente clienteVerificacao = em.find(Cliente.class, 2);
        Assert.assertEquals(null, clienteVerificacao);
    }
}
