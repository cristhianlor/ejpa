package com.algaworks.ecommerce;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EntityManagerTest {

    protected static EntityManagerFactory emf;

    protected EntityManager em;

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


}
