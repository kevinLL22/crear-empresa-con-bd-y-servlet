package com.example.gerenciador.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEmpresa {

    private static EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("serv");

    public static EntityManager entityManager(){
        return FACTORY.createEntityManager();
    }
}
