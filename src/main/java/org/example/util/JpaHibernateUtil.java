package org.example.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaHibernateUtil {    // Utility for EntityManagerFactory

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("my-jpa-persistence-unit");

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static void closeEMF(){
        emf.close();
    }

}
