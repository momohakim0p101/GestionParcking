package com.agence.agencevoiture.dao;

import com.agence.agencevoiture.entity.Facture;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.persistence.jpa.JpaEntityManagerFactory;

import java.util.List;


public class FactureDAO {
    private static final JpaEntityManagerFactory emf = (JpaEntityManagerFactory) Persistence.createEntityManagerFactory("pu");

    public void creerFacture(Facture facture) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(facture);
        em.getTransaction().commit();
        em.close();

    }

    public Facture trouverFacture(Long id_facture){
        EntityManager em = emf.createEntityManager();
        Facture facture = em.find(Facture.class, id_facture);
        em.close();
        return  facture;
    }

    public void supprimerFacture(Facture facture){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        facture = em.merge(facture);
        em.remove(facture);
        em.getTransaction().commit();
        em.close();
    }

    public void miseAJour(Facture facture){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(facture);
        em.getTransaction().commit();
        em.close();
    }

    public List<Facture> trouverTous(){
        EntityManager em = emf.createEntityManager();
        List<Facture> factures = em.createQuery("select f from Facture f", Facture.class).getResultList();
       em.close();
        return factures;
    }
}
