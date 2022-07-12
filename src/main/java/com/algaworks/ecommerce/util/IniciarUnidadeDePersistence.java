package com.algaworks.ecommerce.util;

import com.algaworks.ecommerce.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class IniciarUnidadeDePersistence {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejpa");

        EntityManager em = emf.createEntityManager();

        //Faça seus testes aqui.

        Produto produto = em.find(Produto.class, 1);
        System.out.println(produto.getNome());

        em.close();
        emf.close();
    }
}
