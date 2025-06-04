package com.agence.agencevoiture.dao;

import com.agence.agencevoiture.entity.Avis;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.persistence.jpa.JpaEntityManagerFactory;

import java.util.List;


public class AvisDAO {

    private static final JpaEntityManagerFactory emf = (JpaEntityManagerFactory) Persistence.createEntityManagerFactory("pu");

    public void creerAvis(Avis avis){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(avis);
        em.getTransaction().commit();
        em.close();
    }

    public Avis trouverAvis(Long idAvis){
        EntityManager em = emf.createEntityManager();
        Avis avis = em.find(Avis.class, idAvis);
        em.close();
        return avis;
    }

    public List<Avis> trouverTous(){
        EntityManager em = emf.createEntityManager();
        List<Avis> avis = em.createQuery("SELECT a FROM Avis a", Avis.class).getResultList();
        em.close();
        return avis;
    }

}
