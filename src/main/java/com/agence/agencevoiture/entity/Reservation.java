package com.agence.agencevoiture.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;

    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "montant_total")
    private double montantTotal;

    @Column(name = "statut")
    private String statut; // Confirmée, Annulée, Terminée

    @ManyToOne
    @JoinColumn(name = "cin_client", referencedColumnName = "cin")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "immatriculation_voiture", referencedColumnName = "immatriculation")
    private Voiture voiture;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Facture facture;

    public Reservation() {

    }

    public Reservation(Long idReservation, Date dateDebut, Date dateFin, double montantTotal, String statut, Client client, Voiture voiture, Facture facture) {
        this.idReservation = idReservation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montantTotal = montantTotal;
        this.statut = statut;
        this.client = client;
        this.voiture = voiture;
        this.facture = facture;
    }

    // Getters & Setters


    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", montantTotal=" + montantTotal +
                ", statut='" + statut + '\'' +
                ", client=" + client +
                ", voiture=" + voiture +
                ", facture=" + facture +
                '}';
    }
}
