package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.*;

import javax.swing.*;

public class ConsultandoRegistrosTest {

    private static EntityManagerFactory emf;

    private EntityManager em;

    @BeforeClass
    public static void setUpBeforeClass(){
        emf = Persistence.createEntityManagerFactory("ejpa");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        emf.close();
    }

    @Before
    public void setUp(){
        em = emf.createEntityManager();
    }

    @After
    public void tearDown(){
        em.close();
    }

    @Test
    public void buscarPorIdentificador(){
        Produto produto = em.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }
}
