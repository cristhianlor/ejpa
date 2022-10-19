package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum(){
        Cliente cliente = new Cliente();
        //cliente.setId(3);
        cliente.setNome("Lorenzo M de Assis");
        cliente.setSexo(SexoCliente.MASCULINO);

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.clear();

        Cliente clienteVerificacao = em.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);

    }
}
