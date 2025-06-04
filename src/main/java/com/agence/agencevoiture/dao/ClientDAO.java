package com.agence.agencevoiture.dao;


import com.agence.agencevoiture.entity.Client;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import org.eclipse.persistence.jpa.JpaEntityManagerFactory;

import java.util.List;


public class ClientDAO {
    private static  final JpaEntityManagerFactory emf = (JpaEntityManagerFactory) Persistence.createEntityManagerFactory("pu");


    public void creerClient(Client client) {
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          em.persist(client);
          em.getTransaction().commit();
          em.close();
      }

    public Client trouverClient(String cin){
          EntityManager em = emf.createEntityManager();
          Client client = em.find(Client.class, cin);
          em.close();
          return client;
    }

    public List<Client> trouverTous(){
          EntityManager em = emf.createEntityManager();
          List<Client> clients = em.createQuery("select c from Client c",Client.class).getResultList();
          em.close();
          return clients;
    }

    public void supprimerClient(Client client){
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          client = em.merge(client);
          em.remove(client);
          em.getTransaction().commit();
          em.close();
    }

    public void miseAJour(Client client){
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          em.merge(client);
          em.getTransaction().commit();
          em.close();
    }
}




