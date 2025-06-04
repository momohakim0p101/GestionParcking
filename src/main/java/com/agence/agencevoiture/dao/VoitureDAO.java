package com.agence.agencevoiture.dao;

import com.agence.agencevoiture.entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.eclipse.persistence.jpa.JpaEntityManagerFactory;


import java.util.List;



public class VoitureDAO {

        private static final JpaEntityManagerFactory emf = (JpaEntityManagerFactory) Persistence.createEntityManagerFactory("pu");

        public void creerVoiture(Voiture voiture){
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(voiture);
            em.getTransaction().commit();
            em.close();
        }

        public Voiture trouverVoiture(String immatriculation){
            EntityManager em = emf.createEntityManager();
            Voiture voiture = em.find(Voiture.class, immatriculation);
            em.close();
            return voiture;
        }

        public List<Voiture> trouverTous(){
            EntityManager em = emf.createEntityManager();
            List<Voiture> voitures = em.createQuery("select v from Voiture v", Voiture.class).getResultList();
            em.close();
            return voitures;
        }

        public void supprimerVoiture(Voiture voiture){
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            voiture = em.merge(voiture);
            em.remove(voiture);
            em.getTransaction().commit();
            em.close();
        }

        public void miseAJour(Voiture voiture){
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(voiture);
            em.getTransaction().commit();
            em.close();
        }
}
