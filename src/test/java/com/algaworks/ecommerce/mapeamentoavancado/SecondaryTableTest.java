package com.algaworks.ecommerce.mapeamentoavancado;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class SecondaryTableTest extends EntityManagerTest {

    @Test
    public void salvarCliente() {

        Cliente cliente = new Cliente();
        cliente.setNome("Fernanda Morais");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.clear();

        Cliente clienteVerificacao = em.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao.getSexo());
    }

}
