package com.agence.agencevoiture.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facture")
    private Long idFacture;

    @Column(name = "date_emission")
    @Temporal(TemporalType.DATE)
    private Date dateEmission;

    @Column(name = "montant")
    private double montant;

    @Column(name = "signature_client")
    private String signatureClient;

    @Column(name = "signature_gestionnaire")
    private String signatureGestionnaire;

    @OneToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    public Facture(Long idFacture, Date dateEmission, double montant, String signatureClient, String signatureGestionnaire, Reservation reservation) {
        this.idFacture = idFacture;
        this.dateEmission = dateEmission;
        this.montant = montant;
        this.signatureClient = signatureClient;
        this.signatureGestionnaire = signatureGestionnaire;
        this.reservation = reservation;
    }

    public Facture() {

    }



    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getSignatureClient() {
        return signatureClient;
    }

    public void setSignatureClient(String signatureClient) {
        this.signatureClient = signatureClient;
    }

    public String getSignatureGestionnaire() {
        return signatureGestionnaire;
    }

    public void setSignatureGestionnaire(String signatureGestionnaire) {
        this.signatureGestionnaire = signatureGestionnaire;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", dateEmission=" + dateEmission +
                ", montant=" + montant +
                ", signatureClient='" + signatureClient + '\'' +
                ", signatureGestionnaire='" + signatureGestionnaire + '\'' +
                ", reservation=" + reservation +
                '}';
    }
}
