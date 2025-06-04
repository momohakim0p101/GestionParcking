package com.agence.agencevoiture.dao;


import com.agence.agencevoiture.entity.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.eclipse.persistence.jpa.JpaEntityManagerFactory;


import java.util.List;

public class ReservationDAO {

    private static final JpaEntityManagerFactory emf = (JpaEntityManagerFactory) Persistence.createEntityManagerFactory("pu");

    public void creerReservation(Reservation reservation){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();
        em.close();
    }

    public Reservation trouverReservation(Long id_reservation){
        EntityManager em = emf.createEntityManager();
        Reservation reservation = em.find(Reservation.class, id_reservation);
        em.close();
        return  reservation;
    }

    public void supprimerReservation(Reservation reservation){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        reservation = em.merge(reservation);
        em.remove(reservation);
        em.getTransaction().commit();
        em.close();

    }

    public List<Reservation> trouverTous(){
        EntityManager em = emf.createEntityManager();
        List<Reservation> reservations = em.createQuery("select r from Reservation r", Reservation.class).getResultList();
        em.close();
        return reservations;}

    public void MiseAJour(Reservation reservation) {

     EntityManager em = emf.createEntityManager();
     em.getTransaction().begin();
     em.merge(reservation);
     em.getTransaction().commit();
     em.close();
    }
}
