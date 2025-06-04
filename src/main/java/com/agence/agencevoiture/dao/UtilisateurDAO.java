package com.agence.agencevoiture.dao;

import com.agence.agencevoiture.entity.Utilisateur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UtilisateurDAO {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");


    public void creerUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
        em.close();
    }

    public Utilisateur trouverUtilisateur(Long id) {
        EntityManager em = emf.createEntityManager();
        Utilisateur utilisateur = em.find(Utilisateur.class, id);
        em.close();
        return utilisateur;
    }


    public void mettreAJour(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(utilisateur);
        em.getTransaction().commit();
        em.close();
    }


    public void supprimerUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        utilisateur = em.merge(utilisateur);
        em.remove(utilisateur);
        em.getTransaction().commit();
        em.close();
    }


    public List<Utilisateur> listerTous() {
        EntityManager em = emf.createEntityManager();
        List<Utilisateur> utilisateurs = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
        em.close();
        return utilisateurs;
    }
}
